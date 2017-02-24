package com.vsp.claim.visionservicerequest.test.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.claim.model.VisionServiceRequests;
import com.vsp.api.core.Link;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityProductItems;
import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.actions.ServiceRequestActions;
import com.vsp.claim.visionservicerequest.test.util.ExamplesTableBuilder;
import com.vsp.claim.visionservicerequest.test.util.StoryStateHelper;
import com.vsp.il.test.jbehave.rest.actions.AfterActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.actions.ThenActions;
import com.vsp.il.test.jbehave.rest.actions.WhenActions;
import com.vsp.il.test.jbehave.rest.impl.RestActionsImpl;
import com.vsp.jaxrs.client.HttpMethod;

public class VisionServiceRequestSteps {
	private ServiceRequestActions actions; 
	
	public VisionServiceRequestSteps(GivenActions givenActionImpl, WhenActions whenActionImpl, ThenActions thenActionImpl, AfterActions afterActionImpl, RestActionsImpl restActions) {
		actions = new ServiceRequestActions(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl, restActions);
	}
	
	@Given("a service request that does not have legacy authorization")
	public void givenAServiceRequestThatDoesNotHaveALegacyAuthorization(){
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.TRACKING_NUMBER.getName(), "100034766");
	}
	
	@Given("a service request that does not exist")
	public void givenAServiceRequestThatDoesNotExist(){
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.TRACKING_NUMBER.getName(), "999999999");
	}
	
	@When("I create the service request")
	@Alias("I create the vision service request")
	public void createTheServiceRequest() throws Exception {
		actions.createServiceRequest();
		actions.saveServiceRequestResponse();
	}
	
	@When("I delete the legacy authorization for the service request")
	public void deleteLegacyAuthorization() throws Exception {
		actions.deleteClaimBenefitRequest();
	}
	
	@When("I save the service request")
	public void saveTheServiceRequest() throws IOException{
		actions.saveServiceRequestResponse();
	}
	
	@When("I search the service requests")
	public void searchServiceRequests() throws Exception {
		actions.searchServiceRequests();
	}
	
	@When("I delete the service request")
	public void deleteServiceRequest() throws Exception {
		actions.deleteServiceRequest();
		actions.saveServiceRequestResponse();
	}
	
	@Then("the service request should be: $expected")
	public void theServiceRequestShouldBe(ExamplesTable examplesTable) throws Exception {
		actions.theServiceRequestShouldBe(examplesTable);
	}
	
	@Then("the service request field $fieldPath should not be empty")
	public void theServiceRequestFieldShouldNotBeEmpty(String jsonFieldPath) {
		actions.theServiceRequestFieldShouldNotBeEmpty(jsonFieldPath);
	}	
	
	@Then("the service request field $fieldPath should be empty")
	public void theServiceRequestFieldShouldBeEmpty(String jsonFieldPath) {
		actions.theServiceRequestFieldShouldBeEmpty(jsonFieldPath);
	}
	
	@Then("the $productCatalogKey eligibility interval start date is $tokenDate")
	public void selectedProductItemEligIntervalStartDateIsThis(String productCatalogKey, String tokenDate) throws Exception {
		ExamplesTableBuilder expectedOutcomeBuilder = actions.buildExamplesTableBuilderForEligibilityInterval(true, tokenDate);
		actions.theSelectedEligibleProductItemWithMatchingProductCatalogKeyShouldContain(productCatalogKey,expectedOutcomeBuilder); 
	}
	
	
	@Then("the $productCatalogKey eligibility interval end date is $tokenDate")
	public void selectedProductItemEligIntervalEndDateIsThis(String productCatalogKey, String tokenDate) throws Exception {
		ExamplesTableBuilder expectedOutcomeBuilder = actions.buildExamplesTableBuilderForEligibilityInterval(false, tokenDate);
		actions.theSelectedEligibleProductItemWithMatchingProductCatalogKeyShouldContain(productCatalogKey,expectedOutcomeBuilder); 
	}
	
	@Then("the issue date is $tokenDate")
	public void issueDateIsThis(String tokenDate) throws Exception {
		actions.theEffectiveDateMatches(tokenDate);
	}
	
	@Then("the service requests list size should be $size")
	public void theServiceRequestsListSizeShouldBe(int size) {
		actions.theServiceRequestsListSizeShouldBe(size);
	}
	
	@Then("the service requests should be: $expected")
	public void theServiceRequestsShouldBe(ExamplesTable expected) {
		actions.theServiceRequestsShouldBe(expected);
	}
	
	@Then("the search results have a self link populated on each result")
	public void checkSelfLinkOnSearchResults() {
		VisionServiceRequests actuals = actions.getServiceRequestsFromResponse();
		for(VisionServiceRequest actual: actuals){
			Link<VisionServiceRequest> actualLink = actual.getSelf(); 
			String expectedHrefPattern = ".*/vision-service-requestapi-web/visionservicerequests/\\d{8,10}";
			assertTrue(actualLink.getHref().matches(expectedHrefPattern));
		}
	}
	
	@Then("the search results have a selectedEligibleProductItems self link populated on each result")
	public void checkSEPILinkOnSearchResults() {
		VisionServiceRequests actuals = actions.getServiceRequestsFromResponse();
		for(VisionServiceRequest actual: actuals){
			List<EligibilityProductItem> EPIlist = actual.getSelectedEligibleProductItems();

			if (EPIlist != null) {
				EligibilityProductItem item = EPIlist.get(0);

				if (item != null) {
					Link<EligibilityProductItem> self = item.getSelf();

					String expectedHrefPattern = ".*/vision-service-requestapi-web/visionservicerequests/\\d{8,10}/selectedeligibleproductitems";
					assertTrue(StringUtils.substringBeforeLast(self.getHref(), "/").matches(expectedHrefPattern));
					assertTrue(self.getType().matches("application/vnd.vsp.eligibilityproductitem"));
					assertTrue(self.getRel().matches("self"));
				}
			}
		}
	}
	
	@Then("the search results have a addSelectedEligibleProductItems link populated on each result")
	public void checkAddSEPILinkOnSearchResults() {
		VisionServiceRequests actuals = actions.getServiceRequestsFromResponse();
		for(VisionServiceRequest actual: actuals){
			Link<EligibilityProductItems> actualLink = actual.getAddSelectedEligibleProductItems(); 
			String expectedHrefPattern = ".*/vision-service-requestapi-web/visionservicerequests/\\d{8,10}/selectedeligibleproductitems";
			assertTrue(actualLink.getHref().matches(expectedHrefPattern));
			assertTrue(actualLink.getType().matches("application/vnd.vsp.eligibilityproductitems"));
			assertTrue(actualLink.getRel().matches("urn://vnd.vsp.rels/addselectedeligibleproductitems"));
		}
	}
	
	@Then("the selected eligible product items should be: $examplesTable")
	public void theSelectedEligibleProductItemsShouldBe(ExamplesTable examplesTable){
		actions.selectedEligibleItemsWillContain(examplesTable);
	}
	
	@Then("the selected eligible product items should not contain: $examplesTable")
	public void theSelectedEligibleProductItemsShouldNotBe(ExamplesTable examplesTable){
		actions.selectedEligibleItemsWillNotContain(examplesTable);
	}
	
	@Then("the delete eligibility product item response should be: $expected")
	public void theEligibilityProductItemShouldBe(ExamplesTable expected) {
		actions.theEligibilityProductItemShouldBe(expected);
	}
	
	@Then("the add eligibility product items response should be: $expected")
	public void theEligibilityProductItemsShouldBe(ExamplesTable expected) {
		actions.theEligiblityProductItemsShouldBe(expected);
	}
	
	@When("I delete the selected eligible product item $productCatalogKey from the vision service request")
	public void deleteEligibleProductItemFromVisionServiceRequest(String productCatalogKey) throws Exception {
		actions.deleteSelectedEligibleProductItemFromReservation(productCatalogKey);
		actions.saveDeleteReservedEligibleProductItemResponse(); 
	}
	
	@When("I add the selected eligible product items to the vision service request: $examplesTable")
	public void addEligibleProductItemsToVisionServiceRequest(ExamplesTable examplesTable){
		actions.addEligibleProductItemsToVisionServiceRequest(examplesTable);
		actions.saveAddEligibleProductItemsResponse(); 
	}
	
	@When("I retrieve the vision service request")
	public void whenTheVisionServiceRequestIsRetrieved() throws Exception {
		actions.retrieveServiceRequest();
	}
	
	@When("the link $linkPath is followed to create the vision service request")
	public void whenTheLinkIsFollowedToCreateTheVSR(String linkPath) throws IOException{
		VisionServiceRequest requestBody = actions.buildVisionServiceRequestBody();
		actions.followLinkInResponseByRel(HttpMethod.POST, linkPath, requestBody);
		actions.saveServiceRequestResponse();
	}
}
