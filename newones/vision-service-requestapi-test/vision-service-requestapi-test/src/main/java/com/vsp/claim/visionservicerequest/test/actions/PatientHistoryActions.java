package com.vsp.claim.visionservicerequest.test.actions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.OutcomesTable.Outcome;
import org.jbehave.core.steps.Parameters;
import org.junit.Assert;

import com.vsp.api.core.Link;
import com.vsp.api.eligibility.model.PatientHistories;
import com.vsp.api.eligibility.model.PatientHistory;
import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
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
import com.vsp.jaxrs.client.HttpMethod;

public class PatientHistoryActions {
	
	private RestActionsImpl restAction;
	private GivenActions givenAction;
	private WhenActions whenAction;
	private ThenActions thenAction;
	private AfterActions afterAction;
	
	private static final String PATIENT_HISTORY_CONTEXT = "eligibility-web";
	private static final int CLIENT_ID_INDEX = 0;
	private static final int POLICY_ID_INDEX = 2;
	private static final String PATIENT_HISTORIES_TYPE = "com.vsp.api.eligibility.model.PatientHistories"; 
	
	public PatientHistoryActions(GivenActions givenAction, WhenActions whenAction, ThenActions thenAction, AfterActions afterAction){
		this.restAction = new RestActionsImpl();
		this.givenAction = givenAction;
		this.whenAction = whenAction;
		this.thenAction = thenAction;
		this.afterAction = afterAction;
	}
	
	public ExamplesTableBuilder buildEffectiveIntervalIntervalEndDate(String tokenDate) throws Exception{
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		String date = DateParse.parse(tokenDate).toString("yyyy-MM-dd");
		builder.addHeaders("effectiveInterval.end");
		builder.addValues("effectiveInterval.end", date);
		return builder; 
	}
	
	public void thePatientHistoryShouldBe(ExamplesTable expected) {
		verifySingleEntityForPatientHistory(expected);
	}
	
	private void verifySingleEntityForPatientHistory(ExamplesTable expected) {
		Object obj = null;		
		if (restAction.getResponse() instanceof List) {
			List<PatientHistory> patientHistoryList = (List<PatientHistory>)(List<?>)thenAction.getList(".", false);
			
			for(PatientHistory patientHistory: patientHistoryList)
			{
				String authNumberFromPatientHist = patientHistory.getAuthorizationNumber();
				if (StringUtils.equals(authNumberFromPatientHist, getAuthNumber()))
				{
					obj = patientHistory;
					break;
				}
			}		
		} else {
			obj = (Object) restAction.getProperty(restAction.getResponse(), "");
		}

		OutcomesTable outcomes = new OutcomesTable();
		Parameters params = expected.getRowsAsParameters(true).get(0);
		for (String actualName : params.values().keySet()) {
			checkOutcomes(obj, actualName, params, actualName, outcomes);
		}
		
		thenAction.verify(outcomes);
	}
	
	private String getAuthNumber() {
		return (String) StoryStateHelper.getKey(StoryStateSingletonEnum.LEGACY_AUTH_NUMBER.getName(), String.class);
	}
	
	private OutcomesTable checkOutcomes(Object actual, String resultFieldName, Parameters params,
			String expectedFieldName, OutcomesTable outcomes) {
			OutcomesTableBuilderHelper helper = new OutcomesTableBuilderHelper();
			OutcomeBuilder outcomeBuilder = new EqualToOutcomeBuilder(); 
			Outcome<Object> columnOutcome = outcomeBuilder.buildOutcome(actual, resultFieldName, params, expectedFieldName);
			helper.addOutcomeToOutcomesTable(outcomes, columnOutcome);
			return outcomes;
		}
	
	public void retrievePatientHistoryForLegacyAuthorizationNumberOnClaim(){
		String memberPolicyKey = getMemberPolicyKey();
		String clientId = getClientIdFromMemberPolicyKey(memberPolicyKey);
		String policyId = getPolicyIdFromMemberPolicyKey(memberPolicyKey);
		executePatientHistoriesLink(clientId, policyId);
		saveResponseInStoryState();
	}
	
	private void saveResponseInStoryState() {
		String authorizationNumber = getLegacyAuthorizationNumberFromClaim(); 
		PatientHistory patientHistory = getPatientHistoryByAuthorizationNumber(authorizationNumber);
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.LEGACY_AUTH_PATIENT_HISTORY.getName(), patientHistory);
	}

	private PatientHistory getPatientHistoryByAuthorizationNumber(String authorizationNumber) {
		PatientHistories histories = (PatientHistories)restAction.getResponse();
		if(histories != null){
			for(PatientHistory history: histories){
				if(history.getAuthorizationNumber().equals(authorizationNumber)){
					return history;
				}
			}
		}
		return null;
	}

	private String getLegacyAuthorizationNumberFromClaim() {
		return (String) StoryStateHelper.getKey(StoryStateSingletonEnum.LEGACY_AUTH_NUMBER.getName(), String.class);
	}

	private void executePatientHistoriesLink(String clientId, String policyId){
		Link<PatientHistories> patientHistoriesLink = buildPatientHistoriesLink(clientId, policyId);
		executeLink(patientHistoriesLink, HttpMethod.GET, null);
	}
	
	public void saveAuthorizationNumberFromResponse(){
		String number = (String) getFieldFromResponse("authorizationNumber");
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.LEGACY_AUTH_NUMBER.getName(), number);
		
	}
	
	private Object getFieldFromResponse(String fieldPath) {
		OutcomesTableBuilderHelper valueHelper = new OutcomesTableBuilderHelper();
		return valueHelper.getValueFromBaseObjectByName(restAction.getResponse(), fieldPath);
	}
	
	private Link<PatientHistories> buildPatientHistoriesLink(String clientId, String policyId) {
		Link<PatientHistories> link = new Link<PatientHistories>();
		
		String patientHistoriesHref = buildPatientHistoryHref(clientId, policyId);
		link.setHref(patientHistoriesHref);
		link.setType(PATIENT_HISTORIES_TYPE);
		
		return link;
	}

	private String getPolicyIdFromMemberPolicyKey(String memberPolicyKey) {
		String[] memberPolicyKeyComponents = memberPolicyKey.split("-");
		return memberPolicyKeyComponents[POLICY_ID_INDEX];
	}

	private String getClientIdFromMemberPolicyKey(String memberPolicyKey) {
		String[] memberPolicyKeyComponents = memberPolicyKey.split("-");
		return memberPolicyKeyComponents[CLIENT_ID_INDEX];
	}

	private String getMemberPolicyKey() {
		return (String) StoryStateHelper.getKey(StoryStateSingletonEnum.MEMBER_POLICY_KEY.getName(), String.class);
	}

	private String buildPatientHistoryHref(String clientId, String policyId){
		StringBuffer builder = new StringBuffer();
		
		builder.append(PATIENT_HISTORY_CONTEXT);
		builder.append("/");
		builder.append("patientHistories");
		builder.append("/");
		builder.append(clientId);
		builder.append("-");
		builder.append(policyId);
		
		return builder.toString();
	}
	
	private void executeLink(Link<?> link, HttpMethod method, Object payload)  {
		try {
			givenAction.goHome(null);
			givenAction.initializeLink(link);
			whenAction.executeLatestLinkCleanPayload(method.toString(), payload);
		} catch (ClassNotFoundException e) {			
			throw new RuntimeException(e);
		}
	}
	
	public void serviceItemsWillContain(ExamplesTable expected) {
		List<Object> serviceItems = new ArrayList<Object>();
		PatientHistory history = getLegacyAuthorizationPatientHistory(); 
		serviceItems.addAll(history.getServiceItems()); 
		thenAction.checkListValuesMatch(serviceItems, expected, false, false);
	}
	
	private PatientHistory getLegacyAuthorizationPatientHistory() {
		return (PatientHistory) StoryStateHelper.getKey(StoryStateSingletonEnum.LEGACY_AUTH_PATIENT_HISTORY.getName(), PatientHistory.class);
	}

	
	public void theServiceItemsShouldNotContainTheProductCatalogKeyName(ExamplesTable expected) {
		for (Parameters params : expected.getRowsAsParameters()) {
			String productCatalogKeyName = getProductCatalogKeyNameFromExamplesTableParameters(params); 
			Object result = searchServiceItemsByProductCatalogKeyName(getLegacyAuthorizationPatientHistory(), productCatalogKeyName); 
			assertServiceItemNotFound(result);
		}
	}

	private String getProductCatalogKeyNameFromExamplesTableParameters(Parameters params) {
		String productCatalogKeyName = params.values().get("productCatalogKey.name");
		
		if (productCatalogKeyName == null || productCatalogKeyName.trim().isEmpty()){
			throw new RuntimeException("The 'productCatalogKey.name' column must contain a product catalog key name");
		}
		
		return productCatalogKeyName;
	}

	private void assertServiceItemNotFound(Object result) {
		if(result instanceof List){
			assertTrue(((List)result).isEmpty());
		}else {
			Assert.fail();
		}
	}

	private Object searchServiceItemsByProductCatalogKeyName(PatientHistory patientHistory, String productCatalogKeyName) {
		return restAction.getProperty(patientHistory, "serviceItems[?(@.productCatalogKey.name =='" + productCatalogKeyName + "')]");
	}
	

}
