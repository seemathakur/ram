package com.vsp.claim.visionservicerequest.test.steps;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.actions.OAuthActions;
import com.vsp.claim.visionservicerequest.test.actions.ReservedClaimActions;
import com.vsp.claim.visionservicerequest.test.actions.ServiceRequestActions;
import com.vsp.claim.visionservicerequest.test.util.StoryStateHelper;
import com.vsp.il.test.jbehave.rest.actions.AfterActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.actions.ThenActions;
import com.vsp.il.test.jbehave.rest.actions.WhenActions;
import com.vsp.il.test.jbehave.rest.impl.RestActionsImpl;

public class ClaimBuilderSteps{
	
	private ReservedClaimActions claimActions;
	private OAuthActions oAuthActions;
	private ServiceRequestActions serviceRequestActions;

	
	public ClaimBuilderSteps(GivenActions givenActionImpl, WhenActions whenActionImpl, ThenActions thenActionImpl, AfterActions afterActionImpl, RestActionsImpl restActions) {
		claimActions = new ReservedClaimActions(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl);
		serviceRequestActions = new ServiceRequestActions(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl, restActions);
		oAuthActions = new OAuthActions(givenActionImpl, restActions);
	}
	
	
	@Given("a claim with no service location info")
	@Alias("a vision service request with no service location info")
	public void createClaimWithNoServiceLocation() throws Exception {
		oAuthActions.authenticateApiTest();
		createHardcodedClaimAfterLogIn();
	}
	
	@Given("a claim with a list of three claim lines")
	public void createClaimWithClaimLines() throws Exception {
		oAuthActions.authenticateApiTest();
		createHardCodedClaimWithExamLensFrame();
	}
	
	@Given("a claim with an existing legacy authorization issued for all services")
	public void createClaimWithALegacyAuthorization() throws Exception {
		oAuthActions.authenticateApiTest();
		createClaimFromStoryStateWithAllServices();	
	}
	
	@Given("a claim with an existing legacy authorization issued for services: $table")
	public void createClaimWithALegacyAuthorizationIssuedForServices(ExamplesTable table) throws Exception {
		oAuthActions.authenticateApiTest();
		List<String> services = getServicesFromExamplesTable(table);
		createClaimFromStoryStateWithServices(services.toArray(new String[0]));
	}
	

	private List<String> getServicesFromExamplesTable(ExamplesTable table) {
		List<String> services = new ArrayList<String>(); 
		for (Parameters params : table.getRowsAsParameters()) {
			String service = params.values().get("productCatalogKey.name");
			services.add(service);
		}
		return services; 
	}


	private void createHardcodedClaimAfterLogIn() throws Exception {
		saveHardCodedClaimBuilderData("GenExam", "Frame");
		createClaimAndSaveResponse();
	}
	
	
	private void createClaimAndSaveResponse() throws Exception {
		serviceRequestActions.createServiceRequest();
		serviceRequestActions.saveServiceRequestResponse();
		claimActions.retrieveTheClaim();
		claimActions.saveClaimResponse();
	}
	
	private void createHardCodedClaimWithExamLensFrame() throws Exception {
		saveHardCodedClaimBuilderData("GenExam", "Lens", "Frame");
		createClaimAndSaveResponse();
	}
	
	private void createClaimFromStoryStateWithAllServices() throws Exception {
		setServices("GenExam", "Lens", "Frame", "ContactLens", "ContactLensService");
		createClaimAndSaveResponse();
	}
	
	private void createClaimFromStoryStateWithServices(String ... services) throws Exception {
		setServices(services);
		createClaimAndSaveResponse();
	}
	
	private void setServices(String...productCatalogKeys){
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.PRODUCT_CATALOG_KEYS.getName(), buildProductCatalogKeyList(productCatalogKeys));
	}
	
	private void saveHardCodedClaimBuilderData(String...productCatalogKeys) {
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CLIENT_ID.getName(), "30021299");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.DIVISION_ID.getName(), "0001");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.POLICY_ID.getName(), "858047868");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CONSUMER_ID.getName(), "2289778");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.NETWORK_ID.getName(), "2000");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.PRODUCT_PACKAGE_NAME.getName(), "SignatureChoice");
		setServices(productCatalogKeys);
	}
	
	
	private List<String> buildProductCatalogKeyList(String... productCatalogKeys) {
		List<String> productCatalogKeyList = new ArrayList<>();
		
		for(String productCatalogKey : productCatalogKeys){
			productCatalogKeyList.add(productCatalogKey);
		}
		
		return productCatalogKeyList;
	}

	@Given("a claim with an alternative service location")
	@Alias("a vision service request with an alternative service location")
	public void createClaimWithAlternativeServiceLocation() throws Exception {
		oAuthActions.authenticateUserPasswordSpringCredentials("4158631818", "1681");
		createHardcodedClaimAfterLogIn();
	}
	
	@Given("a claim issued to the provider")
	public void createClaim() throws Exception {
		oAuthActions.authenticateUserPasswordSpringCredentials("9498314144", "4314");
		createHardcodedClaimAfterLogIn();
	}
	
	@Given("a vision service request issued to the member created by a MetLife Vision provider")
	public void createClaimIssuedByMetLifeVisionProvider() throws Exception {
		oAuthActions.authenticateVSPRetailUserPasswordTokenProvider("13998/johnri@vsp.com", "2020"); 
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CLIENT_ID.getName(), "30036084");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.DIVISION_ID.getName(), "0006");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.POLICY_ID.getName(), "851505036");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CONSUMER_ID.getName(), "306128340");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.NETWORK_ID.getName(), "MLVN");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.PRODUCT_PACKAGE_NAME.getName(), "SignatureChoice");
		setServices("GenExam", "Frame");
		createClaimAndSaveResponse();
	}
	


}
