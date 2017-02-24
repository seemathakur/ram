package com.vsp.claim.visionservicerequest.test.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequest.test.actions.ReservedClaimActions;
import com.vsp.il.test.jbehave.rest.actions.AfterActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.actions.ThenActions;
import com.vsp.il.test.jbehave.rest.actions.WhenActions;

public class ReservedClaimWhenSteps {
	ReservedClaimActions actions;

	public ReservedClaimWhenSteps(GivenActions givenActionImpl, WhenActions whenActionImpl, ThenActions thenActionImpl, AfterActions afterActionImpl) {
		actions = new ReservedClaimActions(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl);
	}

	@When("I create a reserved claim")
	public void reserveThePreclaim() throws InterruptedException, IOException {
		actions.createClaim();
	}
	
	@When("I update the reserved claim line")
	public void updateTheClaimLine() throws InterruptedException{		
		actions.updateClaimLine();
	}
	
	@When("I update the reserved claim line with content in $filename")
	public void updateTheClaimLine(String filename) throws InterruptedException{
		actions.updateClaimLine(filename);
	}
	
	@When("I create a reserved claim line")
	public void createTheClaimLine() throws Exception{
		actions.createClaimLine();
	}	
	
	@When("I create a reserved claim line with content in $filename")
	public void createTheClaimLine(String filename) throws Exception{
		actions.createClaimLine(filename);
	}
	
	@When("I create reserved claim lines with content in $filename")
	public void createClaimLines(String filename) throws Exception{
		actions.createClaimLines(filename);
	}
	
	@When("I create reserved claim lines: $table")
	public void createClaimLinesByProductCatalogKeys(ExamplesTable table) throws Exception{
		actions.createClaimLines(table);
	}
	
	@When("I update the reserved claim with content in $filename")
	public void updateTheClaim(String filename) throws IOException, InterruptedException {
		actions.updateClaim(filename);
	}
	
	@When("I update the reserved claim with content in $filename and the issued claim number") 
	public void updateTheClaimWithUpdatedClaimNumber(String filename) throws IOException, InterruptedException {
		actions.updateClaimWithUpdatedClaimNumber(actions.modifyJsonClaimNumber(filename));
	}	
	
	@When("I delete the $productCatalogKey claim line")
	public void deleteTheClaimLineByProductCatalogKey(String productCatalogKey) throws InterruptedException{
		ClaimLine claimLine = actions.getClaimLineByProductCatalogKey(productCatalogKey);
		actions.deleteClaimLine(claimLine.getLineNumber());
	}
	
	@When("I update the claim line having the product catalog key $productCatalogKey with content in $filename")
	public void updateTheClaimLineByProductCatalogKey(String productCatalogKey, String filename) throws InterruptedException{
		ClaimLine claimLine = actions.getClaimLineByProductCatalogKey(productCatalogKey);
		actions.updateClaimLine(claimLine.getLineNumber(), filename);
	}
	
	@When("I delete the claim line")
	public void deleteTheClaimLine() throws InterruptedException{
		actions.deleteClaimLine();
	}
	
	@When("I delete claim line $lineNumber")
	public void deleteTheClaimLineByLineNumber(int lineNumber) throws InterruptedException{
		actions.deleteClaimLine(lineNumber);
	}

	@When("I wait $seconds seconds")
	public void waitForSecond(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// The wait time is only approximate, so we perhaps don't care if
			// this thread is waken up earlier
		}
	}
	
	@When("the reserved claim is deleted by following the self link on the claim")
	public void deleteReservedClaimByFollowingSelfLink() throws ClassNotFoundException, InterruptedException{
		actions.executeDeleteOperationOnReservedClaimSelfLink();
	}

	@When("the reserved claim is deleted")
	public void theReservedClaimIsDeleted() throws ClassNotFoundException, InterruptedException{
		actions.deleteReservedClaim();
	}
	
	@When("the reserved claim is retrieved")
	public void whenTheReservedClaimIsRetrieved() throws ClassNotFoundException {
		actions.retrieveTheClaim();
	}
	
	@When("the reserved claim line is retrieved")
	public void whenTheReservedClaimLineIsRetrieved() throws ClassNotFoundException {
		actions.retrieveTheClaimLine();
	}
	
	@When("I search the reserved claims")
	public void searchReservedClaims() throws Exception {
		actions.searchReservedClaims();
	}
}
