package com.vsp.claim.visionservicerequest.test.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import com.vsp.claim.visionservicerequest.test.actions.PatientHistoryActions;
import com.vsp.claim.visionservicerequest.test.util.ExamplesTableBuilder;
import com.vsp.il.test.jbehave.rest.actions.AfterActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.actions.ThenActions;
import com.vsp.il.test.jbehave.rest.actions.WhenActions;

public class PatientHistorySteps {
	
	private PatientHistoryActions patientHistoryActions;
	
	public PatientHistorySteps(GivenActions givenAction, WhenActions whenAction, ThenActions thenAction, AfterActions afterAction){
		patientHistoryActions = new PatientHistoryActions(givenAction, whenAction, thenAction, afterAction); 
	}
	
	@When("I retrieve the patient history for the legacy authorization")
	public void whenIRetrieveThePatientHistory(){
		patientHistoryActions.retrievePatientHistoryForLegacyAuthorizationNumberOnClaim();
	}
	
	@When("I save the authorization number")
	public void saveAuthorizationNumberFromClaimResponse() {
		patientHistoryActions.saveAuthorizationNumberFromResponse();
	}
	
	@Then("the patient history service items will contain: $expected")
	public void thenThenPatientHistoryServiceItemsWillContain(ExamplesTable expected){
		patientHistoryActions.serviceItemsWillContain(expected);
	}
	
	@Then("the patient history service items will not contain the product catalog keys: $expected")
	public void thenThenPatientHistoryServiceItemsWillNotContain(ExamplesTable expected){
		patientHistoryActions.theServiceItemsShouldNotContainTheProductCatalogKeyName(expected);
	}
	
	@Then("the patient history effective interval end date is $tokenDate")
	public void patientHistoryIntervalEndDateAreThis(String tokenDate) throws Exception {
		ExamplesTableBuilder builder = patientHistoryActions.buildEffectiveIntervalIntervalEndDate(tokenDate);
		patientHistoryActions.thePatientHistoryShouldBe(builder.build()); 	
	}
	
	@Then("the patient history should be: $expected")
	public void thePatientHistoryShouldBe(ExamplesTable expected) {
		patientHistoryActions.thePatientHistoryShouldBe(expected);
	}

}
