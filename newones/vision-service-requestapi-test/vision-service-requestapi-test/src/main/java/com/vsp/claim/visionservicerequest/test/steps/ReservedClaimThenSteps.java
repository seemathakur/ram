package com.vsp.claim.visionservicerequest.test.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequest.test.actions.ReservedClaimActions;
import com.vsp.claim.visionservicerequest.test.util.ExamplesTableBuilder;
import com.vsp.il.test.jbehave.rest.actions.AfterActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.actions.ThenActions;
import com.vsp.il.test.jbehave.rest.actions.WhenActions;

public class ReservedClaimThenSteps {	
	ReservedClaimActions actions;
	
	public ReservedClaimThenSteps(GivenActions givenActionImpl, WhenActions whenActionImpl, ThenActions thenActionImpl, AfterActions afterActionImpl) {
		actions = new ReservedClaimActions(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl);
	}

	@Then("the $productCatalogKey reservation interval end date is $tokenDate")
	public void claimAndReservationEndDateAreThis(String productCatalogKey, String tokenDate) 
			throws Exception {
		ExamplesTableBuilder builder = actions.buildExamplesTableBuilderForReservationInterval(false,tokenDate);
		actions.theClaimLineWithMatchingProductCatalogKeyShouldContain(productCatalogKey,builder); 	
	}
	
	@Then("the $productCatalogKey reservation interval start date is $tokenDate")
	public void claimAndReservationStartDateAreThis(String productCatalogKey, String tokenDate) throws Exception {
		ExamplesTableBuilder builder = actions.buildExamplesTableBuilderForReservationInterval(true, tokenDate);
		actions.theClaimLineWithMatchingProductCatalogKeyShouldContain(productCatalogKey,builder); 
	}
	
	@Then("the reservation issue date is $tokenDate")
	public void issueDateIsThis(String tokenDate) throws Exception {

		actions.theReservationIssueDateMatchesExpected(tokenDate);
	}
	
	@Then("the claim should be: $expected")
	public void theClaimShouldBe(ExamplesTable expected) {
		actions.theClaimShouldBe(expected);
	}
		
	@Then("the claims should be: $expected")
	public void theClaimsShouldBe(ExamplesTable expected) {
		actions.theClaimsShouldBe(expected);
	}
	
	
	@Then("the claim line should be: $expected")
	public void theClaimLineShouldBe(ExamplesTable expected) {
		actions.theClaimLineShouldBe(expected);
	}
			
	@Then("the claim lines should be: $expected")
	public void theClaimLinesShouldBe(ExamplesTable expected) {
		actions.theClaimLinesShouldBe(expected);
	}
	
	@Then("the claim lines should not contain: $expected")
	public void theClaimLinesShouldNotContain(ExamplesTable expected) {
		actions.theClaimLinesShouldNotContainTheProductCatalogKey(expected);
	}

	@Then("the claim lines will contain: $expected")
	public void theClaimLinesWillContain(ExamplesTable expected) {
		actions.theClaimLinesWillContainTheProductCatalogKey(expected);
	}
	
	@Then("the claim lines list size should be $expected")
	public void theClaimLinesListSizeShouldBe(int expected){
		Claim claim = actions.getClaimFromResponse();
		List<ClaimLine> claimLines = claim.getClaimLines();
		assertTrue(claimLines.size() == expected);
	}
	
	@Then("the claim lines should not contain claim line number $lineNumber")
	public void theClaimLinesShouldNotContainLineNumber(String lineNumber) {
		actions.theClaimLinesShouldNotContainTheLine("lineNumber", lineNumber);
	}
	
	
	@Then("the claim lines should be empty")
	public void thenTheClaimLinesShouldBeEmpty() {
		Claim claim = actions.getClaimFromResponse();
		List<ClaimLine> claimLines = claim.getClaimLines();
		assertTrue(claimLines == null || claimLines.isEmpty());
	}
	
	@Then("the claim line should be empty")
	public void thenTheClaimLineShouldBeEmpty() {
		ClaimLine line = actions.getClaimLineFromResponse();
		assertTrue(line==null);
	}
	
	@Then("the claim errors should be: $expected")
	public void theClaimErrorsShouldBe(ExamplesTable expected) {
		actions.theClaimErrorsShouldBe(expected);
	}
	
	@Then("the claim field $fieldPath should not be empty")
	public void theClaimFieldShouldNotBeEmpty(String fieldPath) {
		actions.theClaimFieldShouldNotBeEmpty(fieldPath);
	}	
	
	@Then("the claim field $fieldPath should be empty")
	public void theClaimFieldShouldBeEmpty(String fieldPath) {
		actions.theClaimFieldShouldBeEmpty(fieldPath);
	}
	
	@Then("the claim timestamp should match todays date and current hour with GMT time")
	public void theClaimTimeStampShouldMatchCurrentDateAndHour() {
		actions.theClaimTimeStampShouldMatchCurrentDateAndHour();
	}
	
	@Then("the claim lines timestamps should match todays date and current hour with GMT time")
	public void theClaimLinesTimeStampsShouldMatchCurrentDateAndHour() {
		actions.theClaimLinesTimeStampsShouldMatchCurrentDateAndHour();
	}
	
	@Then("the claims list size should be $size")
	public void theClaimsListSizeShouldBe(int size) {
		actions.theClaimsListSizeShouldBe(size);
	}	
		
}
