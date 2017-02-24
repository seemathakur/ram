package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import java.util.List;

import org.joda.time.DateMidnight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.Membership;
import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.Provider;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.ClaimKeyBuilderCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.ClaimBuilderNotificationHandler;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.NotificationHandler;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.enums.ExhaustEligibilityEnum;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimStatusEnum;

public class ClaimBuilderImpl implements ClaimBuilder {
		
	private Claim claim;
	
	private VisionServiceRequestApiContext request;
	private CommandMap commandMap;
	private ProviderNetworkAccessPointBuilder providerNetworkAccessPointBuilder;
	private ProviderBuilder providerBuilder;  
	
	private static final Logger LOG = LoggerFactory.getLogger(ClaimBuilderImpl.class);
	
	public ClaimBuilderImpl(VisionServiceRequestApiContext request, CommandMap commandMap) {
		this.request = request;
		this.commandMap = commandMap;
		claim = new Claim();
	}

	@Override
	public Claim buildClaim() throws ClaimBuilderException{
		setClaimStatus(ReservedClaimStatusEnum.RESERVED);
		setClaimKey(); 
		setReservationIssueDate();
		buildProductPackageNameOnClaim();
		setExhaustEligibilityCode();
		buildNetworkIdOnClaim();
		
		if(hasInvokedRetrieveAccessPointCommand()){
			setProviderNetworkAccessPoint();
			setProvider();
		}
		
		buildSubscriberOnClaim();
		buildPatientOnClaim();
		buildClassIdOnClaim();
		buildClaimLinesOnClaim();
		handleNotifications();
		
		return claim;
	}

	private void setClaimKey() {
		ClaimKeyBuilderCommand command = getClaimKeyCommandMap();
		claim.setClaimKey(command.getReturnValue());
	}
	
	private ClaimKeyBuilderCommand getClaimKeyCommandMap(){
		return (ClaimKeyBuilderCommand) commandMap.get(CommandMap.GENERATE_TRACKING_NUMBER_COMMAND);
	}

	private void setClaimStatus(ReservedClaimStatusEnum status) {
		claim.setStatusCode(status.getStatusCode());
	}

	private void buildProductPackageNameOnClaim() {
		claim.setProductPackageName(request.getProductPackageName());
	}

	private void buildNetworkIdOnClaim(){
		ProviderNetworkAccessPoint accessPoint = new ProviderNetworkAccessPoint();
		ProviderNetworkKey providerNetworkKey = buildProviderNetworkKey();
		accessPoint.setProviderNetworkKey(providerNetworkKey);
		claim.setProviderNetworkAccessPoint(accessPoint);
	}
	
	protected ProviderNetworkAccessPoint buildProviderNetworkAccessPoint(){
		initializeProviderNetworkAccessPointBuilder();
		return providerNetworkAccessPointBuilder.buildProviderNetworkAccessPoint(); 
	}
	
	private void initializeProviderNetworkAccessPointBuilder(){
		this.providerNetworkAccessPointBuilder = new ProviderNetworkAccessPointBuilder(commandMap);
	}
	
	private ProviderNetworkKey buildProviderNetworkKey(){
		ProviderNetworkKey providerNetworkKey = new ProviderNetworkKey();
		providerNetworkKey.setNetworkId(request.getNetworkId());

		return providerNetworkKey; 
	}

	private void buildSubscriberOnClaim() {
		Membership subscriber = buildSubscriber();
		claim.setSubscriber(subscriber);
	}

	private Membership buildSubscriber() {
		return new SubscriberBuilder(commandMap).buildSubscriber();
	}

	private void buildPatientOnClaim() {
		Membership patient = buildPatient();
		claim.setPatient(patient);
		logPatient(patient); 
	}

	private void logPatient(Membership patient) {
		if (patient!=null) {
			DebugLogger.debugEnabled(LOG,"Patient set to {} ", patient.getConsumerId());
		}
	}

	private Membership buildPatient() {
		return new PatientBuilder(request, commandMap).buildPatient();
	}

	private void buildClassIdOnClaim() {
		String classId = getClassIdFromMemberPolicy();
		claim.setClassId(classId);
	}

	private String getClassIdFromMemberPolicy() {
		RetrieveMemberPoliciesCommand memberPolicyCommand = getMemberPoliciesCommandFromMap();
		MemberPolicy memberPolicy = getMemberPolicyFromCommand(memberPolicyCommand);
		return memberPolicy.getClassId();
	}

	private RetrieveMemberPoliciesCommand getMemberPoliciesCommandFromMap() {
		return (RetrieveMemberPoliciesCommand) commandMap.get(CommandMap.RETRIEVE_MEMBER_POLICY_COMMAND);
	}

	private MemberPolicy getMemberPolicyFromCommand(RetrieveMemberPoliciesCommand memberPolicyCommand) {
		MemberPolicy memberPolicy = null;
		memberPolicy = memberPolicyCommand.getReturnValue();
		return memberPolicy;
	}

	private void buildClaimLinesOnClaim() throws ClaimBuilderException {
		List<ClaimLine> claimLines = buildClaimLines();
		setClaimLines(claimLines);		
	}
	
	protected List<ClaimLine> buildClaimLines() throws ClaimBuilderException{
		ClaimLinesBuilderImpl claimLinesBuilder = initializeClaimLinesBuilder(); 
		return claimLinesBuilder.buildClaimLines(); 
	}

	private ClaimLinesBuilderImpl initializeClaimLinesBuilder() {
		return new ClaimLinesBuilderImpl(commandMap, request);
	}
	
	private void setClaimLines(List<ClaimLine> claimLines){
		claim.setClaimLines(claimLines);
	}
	
	protected void setExhaustEligibilityCode() {
		ExhaustEligibilityCodeBuilder builder = initializeExhaustEligibilityCodeBuilder(claim);
		ExhaustEligibilityEnum value = builder.buildAffectEligibilityCode();
		claim.setAffectEligibilityCode(value.getCode());
	}
	
	private ExhaustEligibilityCodeBuilder initializeExhaustEligibilityCodeBuilder(Claim reservedClaim) {
		String productPackageName = reservedClaim.getProductPackageName();
		return new ExhaustEligibilityCodeBuilder(reservedClaim, productPackageName);
	}
	
	private void setReservationIssueDate(){
		DateMidnight dateMidnightNow = DateMidnight.now();
		claim.setReservationIssueDate(dateMidnightNow);
	}
	
	
	private boolean hasInvokedRetrieveAccessPointCommand(){
		return commandMap.containsKey(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND); 
	}

	private void setProvider(){
		claim.setProvider(buildProviderWithProviderTaxId());
	}
	
	private Provider buildProviderWithProviderTaxId() {		
		initializeProviderBuilder();
		return providerBuilder.buildProvider();
	}
	
	private void initializeProviderBuilder(){
		providerBuilder = new ProviderBuilder(claim); 
	}
	
	protected void setProviderNetworkAccessPoint() {
		ProviderNetworkAccessPoint providerNetworkAccessPoint = buildProviderNetworkAccessPoint();
		claim.setProviderNetworkAccessPoint(providerNetworkAccessPoint);
	}
	
	private void handleNotifications() {
		if(request.hasNotifications()) {
			NotificationHandler notificationHandler = new ClaimBuilderNotificationHandler(request);
			notificationHandler.handleNotifications(claim);
		}
	}
}
