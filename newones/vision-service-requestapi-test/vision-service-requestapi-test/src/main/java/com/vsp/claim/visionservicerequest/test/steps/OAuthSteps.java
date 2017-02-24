package com.vsp.claim.visionservicerequest.test.steps;

import org.jbehave.core.annotations.Given;

import com.vsp.claim.visionservicerequest.test.actions.OAuthActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.impl.RestActionsImpl;

public class OAuthSteps {
	
	private OAuthActions actions; 
	
	public OAuthSteps(GivenActions givenActionImpl, RestActionsImpl restActions) {
		actions = new OAuthActions(givenActionImpl, restActions);
	}
	
	@Given("an api log on")
	public void authenticateApi() {
		actions.authenticateApiTest();
	}
	
	@Given("an eyeconic log on")
	public void authenticateEyeconic() {
		actions.authenticateEyeconic();
	}
	
	@Given("a doctor log on")
	public void givenADoctorLogOn() {
		actions.authenticateUserPasswordSpringCredentials("9498314144", "4314");
	}
	
	@Given("a log on by the only doctor associated with a service location")
	public void givenASingleDoctorLogOn() {
		actions.authenticateUserPasswordSpringCredentials("9163950673", "1967");
	}

	@Given("a Mississippi Medicaid doctor")
	public void givenANewYorkMedicadDoctorLogOn() {
		actions.authenticateUserPasswordSpringCredentials("6015452020", "0402");
	}
	
	@Given("a MetLife Vision provider log on")
	public void givenAnMLVNProviderLogOn() {
		actions.authenticateVSPRetailUserPasswordTokenProvider("13998/johnri@vsp.com", "2020"); 
	}
	
	@Given("an open access provider log on")
	public void givenAnOpenAccessProviderLogOn() {
		actions.authenticateVSPRetailUserPasswordTokenProvider("10659/johnri@vsp.com", "2020"); 
	}
	
	@Given("an alternate MetLife Vision provider log on")
	public void givenAnAlternateMLVNProviderLogOn() {
		actions.authenticateVSPRetailUserPasswordTokenProvider("13998/marthe@vsp.com", "New2020source"); 
	}

}
