package com.vsp.claim.visionservicerequestapi.servicerequest.helper;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateMidnight;
import org.mockito.Mockito;

import com.vsp.api.claim.ClaimsResource;
import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.claim.model.Claims;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.consumer.model.Membership;
import com.vsp.api.core.Link;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.api.provider.model.ServiceLocationKey;
import com.vsp.api.util.ApiContext;
import com.vsp.api.util.DateInterval;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.ClaimKeyBuilderCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveAccessPointCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.jaxrs.link.LinkBuilder;
import com.vsp.jaxrs.provider.VspMediaTypeRegistry;
import com.vsp.oauth.AccessToken;
import com.vsp.oauth.ServiceLocationConstraint;

public class MockHelper {
	
	public static final String CLAIM_NUMBER = "123456789";
	public static final String CLAIM_EXT_NUMBER  = "00";
	public static final String TRACKING_NUMBER = CLAIM_NUMBER;
	public static final String CLIENT_ID = "12345678";
	public static final String DIV_ID = "0001";
	public static final String POLICY_ID = "4444445555";
	public static final String CONSUMER_ID = "123456";
	public static final String NETWORK_ID = "1000";
	public static final String PRODUCT_PACKAGE = "Signature"; 
	public static final String PRODUCT_CATALOG_KEY = "GenExam"; 
	public static final String CLASS_ID = "0004";
	public static final DateMidnight EFFECTIVE_DATE = new DateMidnight(2016,10,15);
	public static final String TAX_ID = "123456789";
	
	
	public static VisionServiceRequestApiContext buildVisionServiceRequestApiContext(String ... selectedItems){
		return new VisionServiceRequestApiContext(buildPolicyKey(), 
				CONSUMER_ID, NETWORK_ID, PRODUCT_PACKAGE, null,
				buildVisionServiceRequest(selectedItems));
	}
	
	public static VisionServiceRequestApiContext buildVisionServiceRequestApiContext(DateMidnight effectiveDate, String ... selectedItems){
		return new VisionServiceRequestApiContext(buildPolicyKey(), 
				CONSUMER_ID, NETWORK_ID, PRODUCT_PACKAGE, effectiveDate.toString("yyyy-MM-dd"),
				buildVisionServiceRequest(selectedItems));
	}
	
	public static VisionServiceRequest buildVisionServiceRequest(String ... selectedItems){
		VisionServiceRequest visionServiceRequest = new VisionServiceRequest();
		visionServiceRequest.setSelectedEligibleProductItems(buildSelectedEligibleProductItems(selectedItems));
		return visionServiceRequest; 
	}
	
	public static List<EligibilityProductItem> buildSelectedEligibleProductItems(String ... selectedItems){
		List<EligibilityProductItem> epis = new ArrayList<EligibilityProductItem>();
		for(String selectedItem:selectedItems){
			EligibilityProductItem epi = new EligibilityProductItem();
			epi.setProductCatalogKey(selectedItem);
			epis.add(epi);
		}
		return epis;
	}
	
	public static CommandMap buildCommandMap(){
		CommandMap commandMap = new CommandMap(); 
		commandMap.put(CommandMap.RETRIEVE_MEMBER_POLICY_COMMAND, buildMemberPolicyCommand()); 
		commandMap.put(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND, buildAccessPointCommand()); 
		commandMap.put(CommandMap.GENERATE_TRACKING_NUMBER_COMMAND, buildClaimKeyCommand());
		return commandMap; 
	}
	
	private static ClaimKeyBuilderCommand buildClaimKeyCommand(){
		ClaimKeyBuilderCommand command = Mockito.mock(ClaimKeyBuilderCommand.class);
		Mockito.when(command.getReturnValue()).thenReturn(new ClaimKey(CLAIM_NUMBER,CLAIM_EXT_NUMBER));
		return command;
	}
	
	private static RetrieveAccessPointCommand buildAccessPointCommand() {
		RetrieveAccessPointCommand command = Mockito.mock(RetrieveAccessPointCommand.class);
		Mockito.when(command.getReturnValue()).thenReturn(createProviderNetworkAccessPoint());
		return command;
	}
	
	private static ProviderNetworkAccessPoint createProviderNetworkAccessPoint(){
		ProviderNetworkAccessPoint ap = new ProviderNetworkAccessPoint();
		ProviderNetworkKey key = new ProviderNetworkKey();
		key.setNetworkId("1000");
		ap.setProviderNetworkKey(key);
		ap.setServiceLocation(buildServiceLocation());
		return ap;
	}
	
	private static ServiceLocation buildServiceLocation(){
		ServiceLocation serviceLocation = new ServiceLocation();
		serviceLocation.setKey(buildServiceLocationKey());
		return serviceLocation; 
	}
	
	private static ServiceLocationKey buildServiceLocationKey(){
		ServiceLocationKey serviceLocationKey = new ServiceLocationKey();
		serviceLocationKey.setProviderTaxId(TAX_ID);
		return serviceLocationKey;
	}

	private static RetrieveMemberPoliciesCommand buildMemberPolicyCommand() {
		RetrieveMemberPoliciesCommand command = Mockito.mock(RetrieveMemberPoliciesCommand.class); 
		Mockito.when(command.getReturnValue()).thenReturn(buildMemberPolicy());
		return command;
	}

	public static MemberPolicy buildMemberPolicy() {
		MemberPolicy policy = new MemberPolicy();
		policy.setMemberships(buildMemberships());
		policy.setPolicyKey(buildPolicyKey());
		policy.setClassId(CLASS_ID);
		return policy;
	}
	
	public static Membership[] buildMemberships() {
		Membership[] memberships = new Membership[1];
		memberships[0] = buildMembership();
		return memberships;
	}
	
	public static Membership buildMembership() {
		Membership membership = new Membership();
		membership.setRelationToSubscriber(MemberRelationEnum.Member);
		membership.setConsumerId(CONSUMER_ID);
		return membership;
	}
	
	public static MemberPolicyKey buildPolicyKey() {
		MemberPolicyKey policyKey = new MemberPolicyKey();
		policyKey.setClientId(CLIENT_ID);
		policyKey.setDivisionId(DIV_ID);
		policyKey.setPolicyId(POLICY_ID);
		return policyKey;
	}
	
	public static Claim buildMockClaim() {
		Claim claim = new Claim();
		claim.setClaimKey(new ClaimKey(CLAIM_NUMBER, CLAIM_EXT_NUMBER));
		claim.setClaimLines(new ArrayList<ClaimLine>());
		
		Membership member = new Membership();
		member.setMemberPolicyKey(buildPolicyKey());
		claim.setSubscriber(member);
		claim.setPatient(buildMembership());
		
		claim.setProviderNetworkAccessPoint(buildProviderNetworkAccessPoint());
		claim.setValidClaimOperations(buildValidOperations());
		claim.setSelf(buildLink());
		claim.setProductPackageName(PRODUCT_PACKAGE);
		
		for(int i=0;i<3; i++){
			claim.getClaimLines().add(buildClaimLine(i));
		}
		return claim;
	}
	
	public static ProviderNetworkAccessPoint buildProviderNetworkAccessPoint() {
		ProviderNetworkAccessPoint ap = new ProviderNetworkAccessPoint();
		ProviderNetworkKey netKey = new ProviderNetworkKey();
		netKey.setNetworkId("1000");
		ap.setProviderNetworkKey(netKey);
		return ap;
	}
	
	public static ClaimLine buildClaimLine(int i) {
		ClaimLine line = new ClaimLine();
		line.setLineNumber(i+1);
		
		if(i%2 == 0){
			line.setProductCatalogKey(PRODUCT_CATALOG_KEY);
		}else {
			line.setProductCatalogKey("otherPck");
		}
		line.setReservationInterval(buildReservationInterval());
		return line;
		
	}
	
	public static Link<Claim> buildLink() {
		Link<Claim> selfLink = buildSelfLink();
		LinkBuilder.resource(ClaimsResource.class)
			.link(selfLink)
			.retrieve(CLAIM_NUMBER,CLAIM_EXT_NUMBER);
		return selfLink;
	}
	
	public static Link<Claim> buildSelfLink() {
		Link<Claim> claimLink = new Link<Claim>();
		claimLink.setRel("self");
		claimLink.setType(VspMediaTypeRegistry.getInstance().getMediaType(Claim.class).toString());
		return claimLink;
	}
	
	public static ClaimLines buildClaimLines() {
		ClaimLines lines = new ClaimLines();
		lines.add(buildClaimLine("GenExam"));
		lines.add(buildClaimLine("Frame"));
		lines.add(buildClaimLine("Lens"));
		return lines;
	}
	
	public static ClaimLine buildClaimLine(String productCatalogKey) {
		ClaimLine line = new ClaimLine();
		line.setProductCatalogKey(productCatalogKey);
		line.setReservationInterval(buildReservationInterval());
		return line;
	}
	
	public static DateInterval buildReservationInterval() {
		DateInterval reservationInterval = new DateInterval();
		reservationInterval.setBegin(new DateMidnight(2016,1,1));
		return reservationInterval;
	}
	
	public static List<Link<?>> buildValidOperations() {
		List<Link<?>> links = new ArrayList<Link<?>>();
		Link<?> link = new Link<ClaimLines>();
		link.setRel("createLines");
		links.add(link);
		return links;
	}
	
	public static Claims buildClaims() {
		Claims claims = new Claims();
		claims.add(buildMockClaim());
		return claims;
	}
	
	public static AccessToken mockAccessToken(String taxId, String hashCode, String sequence){
		AccessToken accessToken = Mockito.mock(AccessToken.class);
		ServiceLocationConstraint constraint = createServiceLocationConstraint(taxId, hashCode, sequence); 
		Mockito.when(accessToken.getService_location_constraint()).thenReturn(constraint);
		return accessToken;
	}
	
	public static ServiceLocationConstraint createServiceLocationConstraint(String taxId, String hashCode, String sequence) {
		return ServiceLocationConstraintFactory.buildServiceLocationConstraint(hashCode, sequence, taxId);
	}
	
	public static ApiContext mockApiContextWithAccessToken(AccessToken accessToken){
		ApiContext apiContext = Mockito.mock(ApiContext.class);
		Mockito.when(apiContext.getAccessToken()).thenReturn(accessToken);
		return apiContext;
	}


}
