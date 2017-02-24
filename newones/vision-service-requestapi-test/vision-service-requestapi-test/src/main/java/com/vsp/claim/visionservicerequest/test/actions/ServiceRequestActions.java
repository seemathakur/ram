package com.vsp.claim.visionservicerequest.test.actions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.OutcomesTable.Outcome;
import org.jbehave.core.steps.Parameters;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.claim.model.VisionServiceRequests;
import com.vsp.api.core.Link;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityProductItems;
import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.link.builder.ClaimBenefitRequestLinkBuilder;
import com.vsp.claim.visionservicerequest.test.link.builder.VisionServiceRequestLinkBuilder;
import com.vsp.claim.visionservicerequest.test.util.DateParse;
import com.vsp.claim.visionservicerequest.test.util.ExamplesTableBuilder;
import com.vsp.claim.visionservicerequest.test.util.StoryStateHelper;
import com.vsp.il.test.jbehave.rest.actions.AfterActions;
import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.actions.ThenActions;
import com.vsp.il.test.jbehave.rest.actions.WhenActions;
import com.vsp.il.test.jbehave.rest.builders.EqualToOutcomeBuilder;
import com.vsp.il.test.jbehave.rest.builders.OutcomeBuilder;
import com.vsp.il.test.jbehave.rest.builders.OutcomesTableBuilderHelper;
import com.vsp.il.test.jbehave.rest.impl.RestActionsImpl;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vspglobal.ipa.jaxrs.oauth2.AccessTokenProvider;

public class ServiceRequestActions {
		
	private RestActionsImpl restAction;
	private GivenActions givenAction;
	private WhenActions whenAction;
	private ThenActions thenAction;
	
	private static final String REST_ACTIONS_LATEST_LINK = "latestLink";
	
	public ServiceRequestActions(GivenActions givenActionImpl, WhenActions whenActionImpl, ThenActions thenActionImpl, AfterActions afterActionImpl, RestActionsImpl restActions) {
		this.restAction =  restActions;
		this.givenAction = givenActionImpl;
		this.whenAction = whenActionImpl;
		this.thenAction = thenActionImpl;
	}
	
	public VisionServiceRequest getServiceRequestFromResponse(){
		if(restAction.getResponse() instanceof VisionServiceRequest){
			return (VisionServiceRequest) restAction.getResponse();
		}else {
			return null;
		}
		
	}
	
	public VisionServiceRequests getServiceRequestsFromResponse(){
		return (VisionServiceRequests) restAction.getResponse();
	}
	
	public void createServiceRequest() throws Exception {
		VisionServiceRequest requestBody = buildVisionServiceRequestBody(); 
		Link<VisionServiceRequest> createLink = buildCreateVisionServiceRequestLink(requestBody); 
		invokeLink(createLink, HttpMethod.POST, requestBody);
	}
	

	private Link<VisionServiceRequest> buildCreateVisionServiceRequestLink(VisionServiceRequest requestBody) {
		return VisionServiceRequestLinkBuilder.buildCreateVisionServiceRequestLink(StoryStateHelper.getClientId(), 
				StoryStateHelper.getDivision(), StoryStateHelper.getPolicyId(), 
				StoryStateHelper.getConsumerId(), StoryStateHelper.getNetworkId(), 
				StoryStateHelper.getProductPackage(), StoryStateHelper.getEffectiveDate(), requestBody); 
	}

	public void searchServiceRequests() throws Exception {
		Link<VisionServiceRequests> searchVSRsLink = buildSearchVisionServiceRequestsLink(); 
		invokeLink(searchVSRsLink, HttpMethod.GET, null); 
	}
	
	private Link<VisionServiceRequests> buildSearchVisionServiceRequestsLink() {
		return VisionServiceRequestLinkBuilder.buildSearchVisionServiceRequestsLink(StoryStateHelper.getClientId(), 
				StoryStateHelper.getDivision(), StoryStateHelper.getPolicyId(), 
				StoryStateHelper.getConsumerId());
	}

	public void deleteServiceRequest() throws Exception {
		Link<VisionServiceRequest> deleteVSRLink = buildDeleteVisionServiceRequestLink();
		invokeLink(deleteVSRLink, HttpMethod.DELETE, null);
	}
	
	private Link<VisionServiceRequest> buildDeleteVisionServiceRequestLink() {
		return VisionServiceRequestLinkBuilder.buildDeleteVisionServiceRequestLink(StoryStateHelper.getTrackingNumber()); 
	}

	public void deleteClaimBenefitRequest() throws Exception {
		ClaimKey claimKey = StoryStateHelper.getClaimKey();
		Link<Claim> deleteClaimBenefitRequestLink = buildDeleteClaimBenefitRequestLink(claimKey.getClaimNumber(), claimKey.getClaimExtNumber()); 
		invokeLink(deleteClaimBenefitRequestLink, HttpMethod.DELETE, null);
	}

	private Link<Claim> buildDeleteClaimBenefitRequestLink(String claimNumber,String claimExtNumber) {
		return ClaimBenefitRequestLinkBuilder.buildDeleteEligibilityProductItemLink(claimNumber, claimExtNumber); 
	}

	private void invokeLink(Link<?> link, HttpMethod httpMethod, Object payload) {
		AccessTokenProvider tokenProvider = getAccessTokenProvider();
		restAction.getRestClient().setTokenProvider(tokenProvider);
		restAction.setAccessTokenProvider(null);

		try {
			givenAction.initializeLink(link);
			whenAction.executeLatestLink(httpMethod, payload);
		} catch (ClassNotFoundException e) {
			System.out.println("Error intializing link: " + link.getHref() + " with operation: " + httpMethod.toString()); 
		}
		
	}
	
	private AccessTokenProvider getAccessTokenProvider(){
		AccessTokenProvider tokenProvider = restAction.getAccessTokenProvider(); 
		
		if(tokenProvider == null){
			Preferences.set("rest", "token.uri", Preferences.get("rest","token.spring"));
			givenAction.auth("preclaimapi-test");
			tokenProvider = restAction.getAccessTokenProvider(); 
		}

		System.out.println(tokenProvider.toString());
		
		return tokenProvider; 
	}
	

	public void saveServiceRequestResponse() throws IOException {
		clearServiceRequestResponsePriorToSave(); 
		VisionServiceRequest response = getServiceRequestFromResponse();
		if(response != null){
			StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.VISION_SERVICE_REQUEST.getName(), response);
			StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.TRACKING_NUMBER.getName(), response.getTrackingNumber());
			saveClaimKeyFromServiceRequestResponseTemporarily(response);
			
			if (response.getAuthorizationNumber() != null){
				StoryStateHelper.addOutstandingAuthorization(response.getAuthorizationNumber());
				StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.LEGACY_AUTH_NUMBER.getName(), response.getAuthorizationNumber());
			}
		}
	}

	private void clearServiceRequestResponsePriorToSave() {
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.VISION_SERVICE_REQUEST.getName(), null); 
	}

	private void saveClaimKeyFromServiceRequestResponseTemporarily(VisionServiceRequest response) {
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CLAIM_KEY.getName(), new ClaimKey(response.getTrackingNumber(), "00"));
	}

	public void theServiceRequestShouldBe(ExamplesTable expected) {
		Object obj = getServiceRequestFromResponse();
		OutcomesTable outcomes = new OutcomesTable();
		Parameters params = expected.getRowsAsParameters().get(0);
		for (String actualName : params.values().keySet()) {
			checkOutcomes(obj, actualName, params, actualName, outcomes);
		}
		
		thenAction.verify(outcomes);
	}
	
	public void selectedEligibleItemsWillContain(ExamplesTable expected) {
		List<Object> serviceItems = new ArrayList<Object>();
		VisionServiceRequest response = getServiceRequestFromResponse();
		serviceItems.addAll(response.getSelectedEligibleProductItems()); 
		thenAction.checkListValuesMatch(serviceItems, expected, false, false);
	}
	
	public void selectedEligibleItemsWillNotContain(ExamplesTable expected) {
		String header = expected.getHeaders().get(0);	
		List<String> eligibleItems = getValuesForHeader(header, expected);

		for(String eligibleItem: eligibleItems){
			String listName = "selectedEligibleProductItems[?(@.productCatalogKey == '"
					+ eligibleItem 
					+ "')]"; 
			List<Object> obj = thenAction.getList(listName, false);
			assertTrue(obj.isEmpty());
		}
	}
		
	private List<String> getValuesForHeader(String header, ExamplesTable tableOfValues) {
		List<String> listOfValuesForHeader = new ArrayList<String>();
		for(Parameters rowOfParameters : tableOfValues.getRowsAsParameters()) {
			String rowValueForHeader = rowOfParameters.values().get(header);
			listOfValuesForHeader.add(rowValueForHeader);
		}
		return listOfValuesForHeader;
	}	
	
	
	public void theSelectedEligibleProductItemWithMatchingProductCatalogKeyShouldContain(String productCatalogKey, ExamplesTableBuilder builder){
		String listName = "selectedEligibleProductItems[?(@.productCatalogKey == '"
				+ productCatalogKey 
				+ "')]"; 
		List<Object> obj = thenAction.getList(listName, false);
		thenAction.checkListValuesMatch(obj, builder.build(), true,  false);	
	}
	
	private OutcomesTable checkOutcomes(Object actual, String resultFieldName, Parameters params,
			String expectedFieldName, OutcomesTable outcomes) {
			OutcomesTableBuilderHelper helper = new OutcomesTableBuilderHelper();
			OutcomeBuilder outcomeBuilder = new EqualToOutcomeBuilder(); 
			Outcome<Object> columnOutcome = outcomeBuilder.buildOutcome(actual, resultFieldName, params, expectedFieldName);
			helper.addOutcomeToOutcomesTable(outcomes, columnOutcome);
			return outcomes;
		}
	
	public void theServiceRequestFieldShouldNotBeEmpty(String fieldPath) {
		Object field = getFieldFromResponse(fieldPath);
		assertTrue(field != null && !isStringEmpty(field));
	}
	
	public void theServiceRequestFieldShouldBeEmpty(String fieldPath) {
		Object field = getFieldFromResponse(fieldPath);
		assertTrue(field == null || isStringEmpty(field));
	}
	
	private Object getFieldFromResponse(String fieldPath) {
		Object response = getVisionServiceRequestResponse(); 
		OutcomesTableBuilderHelper valueHelper = new OutcomesTableBuilderHelper();
		return valueHelper.getValueFromBaseObjectByName(response, fieldPath);
	}

	private Object getVisionServiceRequestResponse() {
		if(restAction.getResponse() instanceof VisionServiceRequest){
			return restAction.getResponse();
		}else {
			return StoryStateHelper.getVisionServiceRequest();
		}
	}

	private boolean isStringEmpty(Object field) {
		boolean result = false;
		if(field instanceof String) {
			result = ((String) field).trim().isEmpty();
		}
		return result;
	}
	
	public ExamplesTableBuilder buildExamplesTableBuilderForEligibilityInterval(boolean startInterval, String tokenDate) throws Exception{
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		String date = DateParse.parse(tokenDate).toString("yyyy-MM-dd");
		
		if(startInterval){
			builder.addHeaders("eligibilityInterval.begin");
			builder.addValues("eligibilityInterval.begin", date);
		}else {
			builder.addHeaders("eligibilityInterval.end");
			builder.addValues("eligibilityInterval.end", date);
		}
		
		return builder; 
	}

	public void theEffectiveDateMatches(String tokenDate) throws Exception {
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		builder.addValue("issueDate", DateParse.parse(tokenDate).toString("yyyy-MM-dd"));
		thenAction.outcomeTableBuildEqual(builder.build());
	}

	public void theServiceRequestsListSizeShouldBe(int expected) {
		assertTrue(thenAction.getList(".", false).size() == expected);
	}
	
	public void theServiceRequestsShouldBe(ExamplesTable expected) {
		Object obj = null;
		int numClaims = 0;
		if (restAction.getResponse() instanceof List) {
			numClaims = thenAction.getList(".", false).size();
		}
		else {
			obj = restAction.getResponse();
		}
		
		for (int i = 0; i < numClaims; i++)
		{
			if (restAction.getResponse() instanceof List) {
				obj = (Object) thenAction.getList(".", false).get(i);
			}
			OutcomesTable outcomes = new OutcomesTable();
			Parameters params = expected.getRowsAsParameters().get(0);
			for (String actualName : params.values().keySet()) {
				checkOutcomes(obj, actualName, params, actualName, outcomes);
			}
			thenAction.verify(outcomes);	
		}
	}
	
	public void deleteSelectedEligibleProductItemFromReservation(String productCatalogKey){
		Link<EligibilityProductItem> deleteEligibilityProductItemLink = buildDeleteEligibleProductItemLink(productCatalogKey); 
		invokeLink(deleteEligibilityProductItemLink, HttpMethod.DELETE, null);
	}
	
	
	private Link<EligibilityProductItem> buildDeleteEligibleProductItemLink(String productCatalogKey) {
		return VisionServiceRequestLinkBuilder.buildDeleteEligibilityProductItemLink(StoryStateHelper.getTrackingNumber(), productCatalogKey);
	}

	public VisionServiceRequest buildVisionServiceRequestBody() {
		VisionServiceRequest requestBody = new VisionServiceRequest();
		
		if(hasProductCatalogKeys()) {
			requestBody.setSelectedEligibleProductItems(buildEligibleProductItems());
		}
		
		return requestBody;
	}
	
	private List<EligibilityProductItem> buildEligibleProductItems() {
		List<String> productCatalogKeys = StoryStateHelper.getProductCatalogKeyList();
		List<EligibilityProductItem> eligibleProductItems = new ArrayList<EligibilityProductItem>();
		
		for(String productCatalogKey : productCatalogKeys) {
			eligibleProductItems.add(buildEligibleProductItem(productCatalogKey));
		}
		
		return eligibleProductItems;
	}
	
	private static EligibilityProductItem buildEligibleProductItem(String productCatalogKey){
		EligibilityProductItem productItem = new EligibilityProductItem();
		productItem.setProductCatalogKey(productCatalogKey);
		return productItem;
	}
	
	private static boolean hasProductCatalogKeys(){
		return StoryStateHelper.getProductCatalogKeyList() != null;
	}

	public void saveDeleteReservedEligibleProductItemResponse() {
		if(restAction.getResponse() instanceof EligibilityProductItem){
			StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.ELIGIBLE_PRODUCT_ITEM.getName(), restAction.getResponse());
		}
	}

	public void theEligibilityProductItemShouldBe(ExamplesTable expected) {
		verifySingleEntity(StoryStateHelper.getEligibleProductItem(), expected);
	}
	
	private void verifySingleEntity(Object obj, ExamplesTable expected) {
		OutcomesTable outcomes = new OutcomesTable();
		Parameters params = expected.getRowsAsParameters().get(0);
		for (String actualName : params.values().keySet()) {
			checkOutcomes(obj, actualName, params, actualName, outcomes);
		}
		
		thenAction.verify(outcomes);
	}

	public void addEligibleProductItemsToVisionServiceRequest(ExamplesTable examplesTable) {
		EligibilityProductItems eligibilityProductItems = new EligibilityProductItems();
		
		String header = examplesTable.getHeaders().get(0);	
		
		for (String actualName : getValuesForHeader(header, examplesTable)) {
			eligibilityProductItems.add(buildEligibleProductItem(actualName));
		}
		
		Link<EligibilityProductItems> addItemsLink = buildAddSelectedEligibleProductItemsLink(eligibilityProductItems);
		invokeLink(addItemsLink, HttpMethod.POST, eligibilityProductItems);
	}

	private Link<EligibilityProductItems> buildAddSelectedEligibleProductItemsLink(EligibilityProductItems selectedEligibleProductItems) {
		return VisionServiceRequestLinkBuilder.buildAddSelectedEligibleProductItemsLinkToVisionServiceRequestLink(StoryStateHelper.getTrackingNumber(), selectedEligibleProductItems);
	}

	public void saveAddEligibleProductItemsResponse() {
		if(restAction.getResponse() instanceof EligibilityProductItems){
			StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.ELIGIBLE_PRODUCT_ITEMS.getName(), restAction.getResponse());
		}
	}

	public void theEligiblityProductItemsShouldBe(ExamplesTable expected) {
		List<Object> list = new ArrayList<Object>();
		
		for(EligibilityProductItem item: StoryStateHelper.getEligibilityProductItems()){
			list.add(item);
		}
		
		thenAction.checkListValuesMatch(list, expected, false, false);
	}
	
	
	public void retrieveServiceRequest() throws Exception {
		Link<VisionServiceRequest> retrieveVSRLink = buildRetrieveVisionServiceRequestLink(); 
		invokeLink(retrieveVSRLink, HttpMethod.GET, null);
	}

	private Link<VisionServiceRequest> buildRetrieveVisionServiceRequestLink() {
		return VisionServiceRequestLinkBuilder.buildRetrieveVisionServiceRequestLink(StoryStateHelper.getTrackingNumber()); 
	}
	
	public void followLinkInResponseByRel(HttpMethod method, String rel){
		restAction.setObjectInState(REST_ACTIONS_LATEST_LINK, createLinkFromResponseByRel(rel));
		givenAction.goHome(null);
		whenAction.executeLatestLinkClean(method.toString());
	}
	
	public void followLinkInResponseByRel(HttpMethod method, String rel, Object body){
		restAction.setObjectInState(REST_ACTIONS_LATEST_LINK, createLinkFromResponseByRel(rel));
		AccessTokenProvider tokenProvider = getAccessTokenProvider();
		restAction.getRestClient().setTokenProvider(tokenProvider);
		restAction.setAccessTokenProvider(null);
		whenAction.executeLatestLink(method, body);
	}
	
	private Link<?> createLinkFromResponseByRel(String rel) {
		Link<?> link = new Link<Object>();
		Map<String, String> linkMap = getLinkByRelFromResponse(rel);
		
		link.setHref(linkMap.get("href"));
		link.setRel(linkMap.get("rel"));
		link.setType(linkMap.get("type"));
		
		return link;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getLinkByRelFromResponse(String rel){
		return (Map<String, String>) restAction.getProperty(restAction.getResponse(), rel);
	}
}
