package com.vsp.claim.visionservicerequest.test.steps;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;
import org.joda.time.DateMidnight;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.Membership;
import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.util.DateInterval;
import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.actions.ReservedClaimActions;
import com.vsp.claim.visionservicerequest.test.command.RetrieveMemberPolicyCommand;
import com.vsp.claim.visionservicerequest.test.util.DateParse;
import com.vsp.claim.visionservicerequest.test.util.MembershipHelper;
import com.vsp.claim.visionservicerequest.test.util.StoryStateHelper;
import com.vsp.il.test.jbehave.rest.actions.AfterActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.actions.ThenActions;
import com.vsp.il.test.jbehave.rest.actions.WhenActions;


public class ReservedClaimGivenSteps {
	ReservedClaimActions actions;

	public ReservedClaimGivenSteps(GivenActions givenActionImpl, WhenActions whenActionImpl, ThenActions thenActionImpl, AfterActions afterActionImpl) {
		actions = new ReservedClaimActions(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl);
	}
	
	/**
	 * This step gets a patient membership information and attaches it to a claim.
	 * It also creates the claim object and stores it for later use.
	 * @param patientNum
	 * @param consumer
	 */
	@Given("a patient with policy id $patientNum and consumer id $consumer")
	public void loadPatientAndSubscriber(String patientNum, String consumer) {
		Claim claim = new Claim();
		claim.setReservationSourceCode("E");
		
		MemberPolicy memberPolicy = RetrieveMemberPolicyCommand.getMemberPolicy(patientNum);
		
		Membership patient = MembershipHelper.extractMembershipByConsumerId(memberPolicy, consumer);
		Membership subscriber = MembershipHelper.extractMembershipForSubscriber(memberPolicy); 
		
		claim.setPatient(patient);
		claim.setSubscriber(subscriber);
		claim.setClassId(memberPolicy.getClassId());
		
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CLAIM.getName(), claim);
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.PATIENT_KEY.getName(), patient);
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.MEMBER_POLICY.getName(), memberPolicy);
	}
		
	@Given("a reservation interval start date of $tokenDate")
	public void reservationStartIntervalDate(String tokenDate) throws Exception {
		Claim claim = StoryStateHelper.getClaim(); 

		List<ClaimLine> claimLines = claim.getClaimLines();
		
		if (claimLines == null) {
			throw new NullPointerException("Cannot set reservation interval start date when "
					+ "claim items do not exist.");
		}
		
		DateMidnight startDate = DateParse.parse(tokenDate);
		
		if (startDate == null) {
			fail("Non-token dates or date token not yet supported " + tokenDate);
		}

		
		for (ClaimLine lineItem : claimLines) {
			DateInterval reservationInterval = new DateInterval(startDate, null);
			lineItem.setReservationInterval(reservationInterval);
		}
	}
	
	@Given("a claim line of $claimType")
	public void givenClaimLineOfType(String claimType) {
		Claim claim = StoryStateHelper.getClaim();
		
		List<ClaimLine> claims = claim.getClaimLines();
		
		if (claims == null) {
			claims = new ArrayList<ClaimLine>();
			claim.setClaimLines(claims);
		}
		
		ClaimLine lineItem = new ClaimLine();
		lineItem.setProductCatalogKey(claimType);
		
		claims.add(lineItem);
	}
	
	@Given("a product package name of $ppn")
	public void givenProductPackNameOfType(String ppn) {
		Claim claim =StoryStateHelper.getClaim();
		claim.setProductPackageName(ppn);
	}

	@Given("a provider network of $providerNetwork")
	public void givenAProviderNetworkNum(String network) {
		Claim claim = StoryStateHelper.getClaim();
		ProviderNetworkAccessPoint accessPoint = new ProviderNetworkAccessPoint();
		accessPoint.setProviderNetworkKey(new ProviderNetworkKey(network));
		claim.setProviderNetworkAccessPoint(accessPoint);
	}
	
	@Given("{a|an} key $key of $value")
	public void saveKeyStringValue(String key, String value) throws Exception {
		if(key.equals(StoryStateSingletonEnum.MEMBER_POLICY_KEY.getName())){
			actions.saveMemberPolicyKey(value);
		}else if (key.equals(StoryStateSingletonEnum.EFFECTIVE_DATE.getName())){
			StoryStateHelper.saveKeyValue(key, DateParse.parse(value));
		}else {
			StoryStateHelper.saveKeyValue(key, value);
		}
	}
	
	@Given("a list $values")
	public void saveListOfKeyValues(ExamplesTable tableOfValues) {
		for(String header : tableOfValues.getHeaders()) {
			List<String> listOfValuesForHeader = getValuesForHeader(header, tableOfValues);
			StoryStateHelper.saveKeyValue(header, listOfValuesForHeader);
		}
	}
	
	@Given("the claim key $claimNbr-$claimExtNbr")
	public void givenTheClaimKey(String claimNbr, String claimExtNbr) {
		StoryStateHelper.setClaimKey(new ClaimKey(claimNbr, claimExtNbr));
	}
	
	@Given("the claim line number $claimLineNumber")
	public void givenTheClaimLineNumber(int claimLineNumber) {
		StoryStateHelper.setClaimLineNumber(claimLineNumber);
	}
	
	@Given("{a|the} claim line body in $filename")
	@Alias("{a|the} claim body in $filename")
	public void givenAJsonFilePath(String filename){
		actions.getGivenActions().setFileName(filename);
	}
		
	private List<String> getValuesForHeader(String header, ExamplesTable tableOfValues) {
		List<String> listOfValuesForHeader = new ArrayList<String>();
		for(Parameters rowOfParameters : tableOfValues.getRowsAsParameters()) {
			String rowValueForHeader = rowOfParameters.values().get(header);
			listOfValuesForHeader.add(rowValueForHeader);
		}
		return listOfValuesForHeader;
	}

}
