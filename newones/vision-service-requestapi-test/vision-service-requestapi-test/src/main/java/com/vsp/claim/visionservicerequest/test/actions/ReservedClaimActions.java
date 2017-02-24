package com.vsp.claim.visionservicerequest.test.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.OutcomesTable.Outcome;
import org.jbehave.core.steps.Parameters;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.core.Link;
import com.vsp.api.util.DateInterval;
import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.request.ReservedClaimsLinkBuilder;
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
import com.vsp.jaxrs.provider.VspObjectMapperFactory;
import com.vspglobal.ipa.jaxrs.oauth2.AccessTokenProvider;

public class ReservedClaimActions {
	private static final ObjectMapper OBJECTMAPPER = VspObjectMapperFactory.buildJsonMapper();	
	private static final String CLAIM_ERRORS_JSON_PATH = "claimErrors[*]";
	private static final String CLAIM_TYPE = "com.vsp.api.claim.model.Claim";
	private static final String CLAIM_LINE_TYPE = "com.vsp.api.claim.model.ClaimLine";
	private static final String CLAIM_LINES_TYPE = "com.vsp.api.claim.model.ClaimLines";
	private static final String RESERVED_CLAIM_CONTEXT = "vision-service-requestapi-web/reservedClaims";
	private static final String REST_ACTIONS_LATEST_LINK = "latestLink";
	
	private RestActionsImpl restAction;
	private GivenActions givenAction;
	private WhenActions whenAction;
	private ThenActions thenAction;
	private AfterActions afterAction;
	
	public ReservedClaimActions(GivenActions givenActionImpl, WhenActions whenActionImpl, ThenActions thenActionImpl, AfterActions afterActionImpl) {
		this.restAction = new RestActionsImpl();
		this.givenAction = givenActionImpl;
		this.whenAction = whenActionImpl;
		this.thenAction = thenActionImpl;
		this.afterAction = afterActionImpl;
	}
	
	public Claim getClaimFromResponse() {
		return (Claim) restAction.getResponse();
	}
	
	public ClaimLine getClaimLineFromResponse(){
		return (ClaimLine) restAction.getResponse();
	}
	
	public List<Link<?>> getValidClaimOperationsFromResponse() {
		Claim claim = getClaimFromResponse(); 
		return claim.getValidClaimOperations();
	}	
		
	public void followLink(String linkRel) {
		whenAction.mapAddParameter(linkRel, null);
	}
	
	public void theClaimShouldBe(ExamplesTable expected) {
		verifySingleEntity(expected);
	}
	
	public void searchReservedClaims() throws Exception {
		ExamplesTable reservedClaimsLinkAsExamplesTable = ReservedClaimsLinkBuilder.buildReservedClaimsLinkAsTable();
		invokeReservedClaimsLink(reservedClaimsLinkAsExamplesTable);
	}
	
	private void invokeReservedClaimsLink(ExamplesTable reservedClaimsLinkAsExamplesTable) throws ClassNotFoundException {
		AccessTokenProvider tokenProvider = getAccessTokenProvider();
		restAction.getRestClient().setTokenProvider(tokenProvider);
		givenAction.initializeLink(reservedClaimsLinkAsExamplesTable);
		whenAction.executeLatestLink(HttpMethod.GET, null);
	}
	
	public void theClaimsShouldBe(ExamplesTable expected) {
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
	
	
	public void theEligibilityProductItemShouldBe(ExamplesTable expected) {
		verifySingleEntity(expected);
	}
		
	public void theClaimLineShouldBe(ExamplesTable expected) {
		verifySingleEntity(expected);
	}
	
	private void verifySingleEntity(ExamplesTable expected) {
		Object obj;
		if (restAction.getResponse() instanceof List) {
			obj = (Object) thenAction.getList(".", false).get(0);
		} else {
			obj = restAction.getResponse();
		}

		OutcomesTable outcomes = new OutcomesTable();
		Parameters params = expected.getRowsAsParameters().get(0);
		for (String actualName : params.values().keySet()) {
			checkOutcomes(obj, actualName, params, actualName, outcomes);
		}
		
		thenAction.verify(outcomes);
	}
	
	public void theClaimLinesShouldBe(ExamplesTable expected) {
		Object obj;
		OutcomesTable outcomes = new OutcomesTable();
		
		Object object = restAction.getResponse(); 
		
		for (Parameters params : expected.getRowsAsParameters()) {
			String lineNumber = params.values().get("lineNumber");
			if (lineNumber == null || lineNumber.trim().isEmpty())
				throw new RuntimeException("The 'lineNumber' column must contain a number");
			
			if(restAction.getResponse() instanceof ClaimLines){
				obj = thenAction.getList("[?(@.lineNumber=='" + lineNumber + "')]", false)
						.get(0);
			}
			else if (restAction.getResponse() instanceof List) {
				obj = thenAction.getList("[0].claimLines[?(@.lineNumber=='" + lineNumber + "')]", false)
						.get(0);
			} else {
				obj = thenAction.getList("claimLines[?(@.lineNumber=='" + lineNumber + "')]", false)
						.get(0);
			}

			for (String actualName : params.values().keySet()) {
				checkOutcomes(obj, actualName, params, actualName, outcomes);
			}
		}
		thenAction.verify(outcomes);
	}
	
	public void theClaimLinesListSizeShouldBe(int expected){
		Claim claim = (Claim) restAction.getResponse();
		List<ClaimLine> lines = claim.getClaimLines();
		assertEquals(lines.size(),expected);
	}
	
	public ClaimLine getClaimLineByProductCatalogKey(String productCatalogKey){
		ClaimLine defaultLine = new ClaimLine();
		
		Claim claim = getClaim();
		List<ClaimLine> claimLines = claim.getClaimLines();
		for(ClaimLine claimLine:claimLines){
			if(claimLine.getProductCatalogKey().equalsIgnoreCase(productCatalogKey)){
				return claimLine; 
			}
		}
		return defaultLine;	
	}

	public void theClaimLinesShouldNotContainTheProductCatalogKey(ExamplesTable expected) {
		for (Parameters params : expected.getRowsAsParameters()) {
			String productCatalogKey = params.values().get("productCatalogKey");
			if (productCatalogKey == null || productCatalogKey.trim().isEmpty())
				throw new RuntimeException("The 'productCatalogKey' column must contain a product catalog key");
			if (restAction.getResponse() instanceof List) {
				assertTrue(thenAction.getList("[0].claimLines[?(@.productCatalogKey =='" + productCatalogKey + "')]", false).isEmpty());
			} else {
				assertTrue(thenAction.getList("claimLines[?(@.productCatalogKey =='" + productCatalogKey + "')]", false).isEmpty());
			}
		}
	}
	
	public void theClaimLinesShouldNotContainTheLine(String identifier, String identifierValue) {
		if (restAction.getResponse() instanceof List) {
			assertTrue(thenAction.getList("[0].claimLines[?(@." + identifier + "=='" + identifierValue + "')]", false).isEmpty());
		} else {
			assertTrue(thenAction.getList("claimLines[?(@." + identifier + "=='" + identifierValue + "')]", false).isEmpty());
		}
	}
	
	private OutcomesTable checkOutcomes(Object actual, String resultFieldName, Parameters params,
		String expectedFieldName, OutcomesTable outcomes) {
		OutcomesTableBuilderHelper helper = new OutcomesTableBuilderHelper();
		OutcomeBuilder outcomeBuilder = new EqualToOutcomeBuilder(); 
		Outcome<Object> columnOutcome = outcomeBuilder.buildOutcome(actual, resultFieldName, params, expectedFieldName);
		helper.addOutcomeToOutcomesTable(outcomes, columnOutcome);
		return outcomes;
	}
		
	public void createClaim() throws InterruptedException, IOException {
		Claim claim = getClaim();
		Link<Claim> postLink = buildPreclaimLink();
		executeLink(postLink, HttpMethod.POST, claim);
		saveClaimResponse();
	}
	
	public void createClaim(String jsonFile) throws InterruptedException {
		Claim claim = getClaimFromFile(jsonFile);
		Link<Claim> postLink = buildPreclaimLink();
		executeLink(postLink, HttpMethod.POST, claim);
	}
	
	public void updateClaim() {
		ClaimKey key = getClaimKey();
		Link<Claim> putLink = buildClaimLink(key);
		Claim claim = getClaim();
		executeLink(putLink, HttpMethod.PUT, claim);
	}
	
	public void updateClaim(String jsonFile) throws InterruptedException {
		ClaimKey key = getClaimKey();
		Link<Claim> putLink = buildClaimLink(key);
		Claim claim = getClaimFromFile(jsonFile);
		executeLink(putLink, HttpMethod.PUT, claim);
	}
	
	public void updateClaimWithUpdatedClaimNumber(Claim claim) throws InterruptedException {
		ClaimKey key = getClaimKey();
		Link<Claim> putLink = buildClaimLink(key);
		executeLink(putLink, HttpMethod.PUT, claim);
	}

	public void updateClaimLine() throws InterruptedException {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> putLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), getLineNumber(), true);
		putLink.setType(CLAIM_LINE_TYPE);
		ClaimLine line = getClaimLine();
		executeLink(putLink, HttpMethod.PUT, line);
	}
	
	public void updateClaimLine(String jsonFile) throws InterruptedException {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> putLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), getLineNumber(), true);
		putLink.setType(CLAIM_LINE_TYPE);
		ClaimLine line = getClaimLineFromFile(jsonFile);
		executeLink(putLink, HttpMethod.PUT, line);
	}
	
	public void updateClaimLine(int lineNumber, String jsonFile) throws InterruptedException {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> putLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), lineNumber, true);
		putLink.setType(CLAIM_LINE_TYPE);
		ClaimLine line = getClaimLineFromFile(jsonFile);
		executeLink(putLink, HttpMethod.PUT, line);
	}
		
	public void createClaimLine() throws InterruptedException {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> postLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), 0,  false);
		postLink.setType(CLAIM_LINES_TYPE);
		ClaimLine line = getClaimLine();
		executeLink(postLink, HttpMethod.POST, line);
	}
	
	public void createClaimLine(String jsonFile) throws InterruptedException {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> postLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), 0,  false);
		postLink.setType(CLAIM_LINES_TYPE);
		ClaimLine line = getClaimLineFromFile(jsonFile);
		ClaimLines lines = new ClaimLines(); 
		lines.add(line);
		executeLink(postLink, HttpMethod.POST, lines);
	}
	
	public void createClaimLines(String jsonFile) throws InterruptedException {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> postLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), 0,  false);
		postLink.setType(CLAIM_LINES_TYPE);
		ClaimLines lines = getClaimLinesFromFile(jsonFile);
		executeLink(postLink, HttpMethod.POST, lines);
	}
	
	public void createClaimLines(ExamplesTable table) throws Exception {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> postLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), 0,  false);
		postLink.setType(CLAIM_LINES_TYPE);
		ClaimLines lines = createLinesFromTableAndStoryState(table);
		executeLink(postLink, HttpMethod.POST, lines);
	}
			
	private ClaimLines createLinesFromTableAndStoryState(ExamplesTable table) throws Exception {
		ClaimLines claimLines = new ClaimLines();
		for(Parameters rowOfParameters : table.getRowsAsParameters()) {
			String productCatalogKey = rowOfParameters.values().get("productCatalogKey");
			ClaimLine line = createClaimLineByProductCatalogKey(productCatalogKey);
			claimLines.add(line);
		}
		
		return claimLines;
	}

	private ClaimLine createClaimLineByProductCatalogKey(String productCatalogKey) throws Exception {
		ClaimLine line = new ClaimLine();
		line.setProductCatalogKey(productCatalogKey);
		DateInterval interval = new DateInterval();
		interval.setBegin(getEffectiveDate());
		line.setReservationInterval(interval);
		line.setProductPackageName(getProductPackageName());;
		return line;
	}
	
	private String getProductPackageName(){
		return (String) StoryStateHelper.getKey(StoryStateSingletonEnum.PRODUCT_PACKAGE_NAME.getName(), String.class);
	}

	private DateMidnight getEffectiveDate() throws Exception {
		String effDate = (String)StoryStateHelper.getKey(StoryStateSingletonEnum.EFFECTIVE_DATE.getName(), String.class); 
		return DateParse.parse(effDate);
	}

	public void retrieveTheClaimLine() throws ClassNotFoundException {
		ClaimKey claimKey = getClaimKey();
		int lineNumber = getLineNumber();
		Link<ClaimLine> linkToRetrieveClaimLine = buildClaimLineLinkWithHref(claimKey.getClaimNumber(),claimKey.getClaimExtNumber(),lineNumber,true);
		linkToRetrieveClaimLine.setType(CLAIM_LINE_TYPE);
		executeLink(linkToRetrieveClaimLine, HttpMethod.GET, null);
	}
	
	private void executeLink(Link<?> link, HttpMethod method, Object payload)   {
		try {
			AccessTokenProvider tokenProvider = getAccessTokenProvider();
			restAction.getRestClient().setTokenProvider(tokenProvider);
			givenAction.initializeLink(link);
			whenAction.executeLatestLinkCleanPayload(method.toString(), payload);
		} catch (ClassNotFoundException e) {			
			throw new RuntimeException(e);
		}
	}
	
	private AccessTokenProvider getAccessTokenProvider(){
		AccessTokenProvider tokenProvider = restAction.getAccessTokenProvider(); 
		if(tokenProvider == null){
			Preferences.set("rest", "token.uri", Preferences.get("rest","token.spring"));
			givenAction.auth("preclaimapi-test");
			tokenProvider = restAction.getAccessTokenProvider(); 
		}
		return tokenProvider; 
	}
	
	public void theClaimErrorsShouldBe(ExamplesTable expected) {
		List<Object> claimErrors = thenAction.getList(CLAIM_ERRORS_JSON_PATH, Boolean.FALSE);
		thenAction.checkList(claimErrors, expected, false, false);
	}

	public void theClaimFieldShouldNotBeEmpty(String fieldPath) {
		Object field = getFieldFromResponse(fieldPath);
		assertTrue(field != null && !isStringEmpty(field));
	}
	public void theClaimFieldShouldBeEmpty(String fieldPath) {
		Object field = getFieldFromResponse(fieldPath);
		assertTrue(field == null || isStringEmpty(field));
	}
	
	public void theClaimTimeStampShouldMatchCurrentDateAndHour() {
		Claim claim = getClaimResponse();
		DateTime timestamp = claim.getIsdLastUpdateTs();
		assertMarchCurrentDateAndHour(timestamp);
	}
	
	public void theClaimLinesTimeStampsShouldMatchCurrentDateAndHour()  {
		List<ClaimLine> claimLines = StoryStateHelper.getClaim().getClaimLines();
		for (ClaimLine line : claimLines) {
			DateTime timestamp = line.getIsdLastUpdateTs();
			assertMarchCurrentDateAndHour(timestamp);
		}
	}
	
	private void assertMarchCurrentDateAndHour(DateTime timestamp) {
		DateTime now = DateTime.now(DateTimeZone.UTC);
		assertEquals(timestamp.getYear(),now.getYear());
		assertEquals(timestamp.getMonthOfYear(),now.getMonthOfYear());
		assertEquals(timestamp.getDayOfMonth(),now.getDayOfMonth());
		assertEquals(timestamp.hourOfDay(),now.hourOfDay());
	}

	private Object getFieldFromResponse(String fieldPath) {
		OutcomesTableBuilderHelper valueHelper = new OutcomesTableBuilderHelper();
		return valueHelper.getValueFromBaseObjectByName(restAction.getResponse(), fieldPath);
	}

	private boolean isStringEmpty(Object field) {
		boolean result = false;
		if(field instanceof String) {
			result = ((String) field).trim().isEmpty();
		}
		return result;
	}

	public void retrieveTheClaim() throws ClassNotFoundException {
		ClaimKey claimKey = getClaimKey();
		Link<Claim> linkToRetrieveClaim = buildClaimLink(claimKey);
		executeLink(linkToRetrieveClaim, HttpMethod.GET, null);
	}
		
	public void saveClaimResponse() throws IOException {
		Claim claimResponse = getClaimResponse();
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CLAIM.getName(), claimResponse);
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CLAIM_KEY.getName(), claimResponse.getClaimKey());
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.TRACKING_NUMBER.getName(), claimResponse.getClaimKey().getClaimNumber());
		if (claimResponse.getAuthorizationNumber() != null){
			StoryStateHelper.addOutstandingAuthorization(claimResponse.getAuthorizationNumber());
		}
	}
	
	private Claim getClaimResponse() {		 
		return (Claim) restAction.getResponse();
	}

	private Link<Claim> buildPreclaimLink(){
		Link<Claim> link = new Link<Claim>(); 
		link.setHref(RESERVED_CLAIM_CONTEXT);
		link.setType("com.vsp.api.claim.model.Claim");
		return link; 
	}

	private Link<Claim> buildClaimLink(ClaimKey claimKey) {
		Link<Claim> retrieveClaimLink = new Link<Claim>();
		retrieveClaimLink.setHref(buildClaimHref(claimKey.getClaimNumber(), claimKey.getClaimExtNumber()));
		retrieveClaimLink.setType(CLAIM_TYPE);
		return retrieveClaimLink;
	}
	
	private String buildClaimHref(String claimNumber, String claimExtNumber) {
		StringBuilder href = new StringBuilder();
		href.append(RESERVED_CLAIM_CONTEXT)
			.append("/")
			.append(claimNumber)
			.append("-")
			.append(claimExtNumber);			
		return href.toString();
	}
	
	private Link<ClaimLine> buildClaimLineLinkWithHref(String claimNumber, String claimExtNumber, int lineNumber, boolean islineNumberIncluded){
		Link<ClaimLine> link = new Link<ClaimLine>(); 
		link.setHref(buildClaimLineHref(claimNumber,claimExtNumber,lineNumber, islineNumberIncluded));
		return link; 
	}
	
	private String buildClaimLineHref(String claimNumber, String claimExtNumber, int lineNumber, boolean islineNumberIncluded) {
		StringBuilder href = new StringBuilder();
		href.append(RESERVED_CLAIM_CONTEXT)
			.append("/")
			.append(claimNumber)
			.append("-")
			.append(claimExtNumber)
			.append("/")
			.append("lines");
		
		if (islineNumberIncluded) {	
			href.append("/")
			.append(lineNumber);
		}
		
		return href.toString();
	} 
		
	private Claim getClaim() {
		return StoryStateHelper.getClaim();
	}
	
	private Claim getClaimFromFile(String jsonFile) {
		Claim claim;
		try {
			claim = (Claim) mockObjectFromJson(jsonFile, Claim.class);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
		return claim;
	}
	
	private ClaimLine getClaimLine() {
		return StoryStateHelper.getClaimLine();
	}
	
	private ClaimLine getClaimLineFromFile(String jsonFile) {
		ClaimLine line;
		try {
			line = (ClaimLine) mockObjectFromJson(jsonFile, ClaimLine.class);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
		return line;
	}
	
	private ClaimLines getClaimLinesFromFile(String jsonFile) {
		ClaimLines lines;
		try {
			lines = (ClaimLines) mockObjectFromJson(jsonFile, ClaimLines.class);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
		return lines;
	}

	private ClaimKey getClaimKey() {
		return StoryStateHelper.getClaimKey();
	}
	
	private int getLineNumber() {
		return StoryStateHelper.getClaimLineNumber();
	}

	/*
	 * Deletes the preclaim by executing the DELETE operation on the self link
	 */
	public void executeDeleteOperationOnReservedClaimSelfLink() throws ClassNotFoundException, InterruptedException{
		followLinkInResponseByRel(HttpMethod.DELETE, "self");
	}
	
	public void followLinkInResponseByRel(HttpMethod method, String rel){
		restAction.setObjectInState(REST_ACTIONS_LATEST_LINK, createLinkFromResponseByRel(rel));
		givenAction.goHome(null);
		whenAction.executeLatestLinkClean(method.toString());
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

	public void deleteReservedClaim() throws ClassNotFoundException, InterruptedException{
		Link<Claim> link = buildClaimLink(StoryStateHelper.getClaimKey());
		executeLink(link, HttpMethod.DELETE, null); 		
	}
	
	public void theClaimNumberIsNotEmpty() {
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		builder.addHeaders("claimKey", "claimKey.claimNumber", "claimKey.claimExtNumber");
		thenAction.outcomeTableBuildNotNull(builder.build());
	}
	
	public void theClaimLineWithMatchingProductCatalogKeyShouldContain(String productCatalogKey, ExamplesTableBuilder builder){
		if(restAction.getResponse() instanceof ClaimLines){
			String listName = "[?(@.productCatalogKey == '" + productCatalogKey	+ "')]"; 
			thenAction.checkListValuesMatch(thenAction.getList(listName, false), builder.build(), true,  false);
		}
		else {
		String listName = "claimLines[?(@.productCatalogKey == '"
				+ productCatalogKey 
				+ "')]"; 
		thenAction.checkListValuesMatch(thenAction.getList(listName, false), builder.build(), true,  false);	
		}
	}

	public void theReservationIssueDateMatchesExpected(String tokenDate) throws Exception {
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		builder.addValue("reservationIssueDate", DateParse.parse(tokenDate).toString("yyyy-MM-dd"));
		thenAction.outcomeTableBuildEqual(builder.build());
	}
	
	public GivenActions getGivenActions(){
		return givenAction;
	}
	
	public Claim modifyJsonClaimNumber(String filename) throws IOException {
		Claim claim = getClaimFromFile(filename);
		claim.setClaimKey(getClaimKey());
		claim.setAuthorizationNumber(getAuthNumber());
		return claim;
	}
	
	private String getAuthNumber() {
		return (String) StoryStateHelper.getKey(StoryStateSingletonEnum.LEGACY_AUTH_NUMBER.getName(), String.class);
	}

	private <T> Object mockObjectFromJson(String fileName, Class<T> classType) throws JsonParseException, JsonMappingException, IOException {
		InputStream jsonData = this.getClass().getClassLoader().getResourceAsStream(fileName);
		return mockObjectFromJson(jsonData, classType);
	}
		
	private <T> Object mockObjectFromJson(InputStream source, Class<T> classType) throws JsonParseException, JsonMappingException, IOException {
		return OBJECTMAPPER.readValue(source, classType);
	}

	public void deleteClaimLine() throws InterruptedException {
		ClaimKey key = getClaimKey();		
		Link<ClaimLine> deleteLink = buildClaimLineLinkWithHref(key.getClaimNumber(), key.getClaimExtNumber(), getLineNumber(), true);
		deleteLink.setType(CLAIM_LINE_TYPE);
		executeLink(deleteLink, HttpMethod.DELETE, null);
	}
	
	public void deleteClaimLine(int lineNumber) throws InterruptedException {
		StoryStateHelper.setClaimLineNumber(lineNumber);
		deleteClaimLine();
	}
	
	public ExamplesTableBuilder buildExamplesTableBuilderForReservationInterval(boolean startInterval, String tokenDate) throws Exception{
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		String date = DateParse.parse(tokenDate).toString("yyyy-MM-dd");
		
		if(startInterval){
			builder.addHeaders("reservationInterval.begin");
			builder.addValues("reservationInterval.begin", date);
		}else {
			builder.addHeaders("reservationInterval.end");
			builder.addValues("reservationInterval.end", date);
		}
		
		return builder; 
	}

	public void theClaimsListSizeShouldBe(int expected) {
		assertTrue(thenAction.getList(".", false).size() == expected);
	}	
	
	public void saveMemberPolicyKey(String value) {
		StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.MEMBER_POLICY_KEY.getName(), value);
		saveMemberPolicyKeyAsIndividualKeyValues(value); 
	}

	private void saveMemberPolicyKeyAsIndividualKeyValues(String value) {
		if(value != null){
			String[] memberPolicyArr = value.split("-");
			StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.CLIENT_ID.getName(), memberPolicyArr[0]);
			StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.DIVISION_ID.getName(), memberPolicyArr[1]);
			StoryStateHelper.saveKeyValue(StoryStateSingletonEnum.POLICY_ID.getName(), memberPolicyArr[2]);
		}
	}

	public void theClaimLinesWillContainTheProductCatalogKey(ExamplesTable expected) {
		for (Parameters params : expected.getRowsAsParameters()) {
			String productCatalogKey = params.values().get("productCatalogKey");
			if (productCatalogKey == null || productCatalogKey.trim().isEmpty())
				throw new RuntimeException("The 'productCatalogKey' column must contain a product catalog key");
			if (restAction.getResponse() instanceof List) {
				assertFalse(thenAction.getList("[0].claimLines[?(@.productCatalogKey =='" + productCatalogKey + "')]", false).isEmpty());
			} else {
				assertFalse(thenAction.getList("claimLines[?(@.productCatalogKey =='" + productCatalogKey + "')]", false).isEmpty());
			}
		}
	}
}
