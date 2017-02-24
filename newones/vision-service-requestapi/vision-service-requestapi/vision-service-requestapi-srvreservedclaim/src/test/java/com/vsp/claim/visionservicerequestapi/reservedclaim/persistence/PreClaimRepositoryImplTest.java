package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.Claims;
import com.vsp.claim.common.exception.BadRequestCriteriaException;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimError;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.junit.MockObjectProvider;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.NameValuePair;
import com.vsp.il.util.Preferences;

/**
 * Test Scenarios:
 *	- test happy path. Dao returns successful record. Mapper maps with no errors.
 *		- Should return a claim object.
 *	- test claim not found. Dao returns a NoResultException.
 *		- Should throw ClaimNotFoundException
 *	- test database error. Dao returns an exception talking to the database.
 *		- Should throw DatabaseIOException
 *	- test mapping error. Dao returns successful record. Mapper throws an exception. 
 *	  Mapper failed initialization?
 *		- Should throw ...
 */
public class PreClaimRepositoryImplTest {
	
	private static final MockObjectProvider objectProvider = new MockObjectProvider();

	private static final ClaimKey MOCKED_CLAIM_KEY = new ClaimKey("100046580", "00");
	
	private Claim result;
	
	@Mock
	private PreClaimDao preClaimDao;
	
	@Mock
	private ClaimKeyDao claimKeyDao; 
	
	@InjectMocks
	private PreClaimRepositoryImpl repository;

	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
		mockClaimKeyDaoResult();
	}

	private void mockClaimKeyDaoResult() {
		when(claimKeyDao.getClaimNumber()).thenReturn(new Integer(MOCKED_CLAIM_KEY.getClaimNumber())); 	
	}

	@After
	public void tearDown() throws Exception {
		result = null;
	}

	@Test
	public void testSuccesfulRetrieveByClaimKey() throws Exception {
		mockDaoRetrieveResult();
		invokeRetrieveClaim();
		ClaimKey expectedClaimKey = new ClaimKey("202132159", "00");
		assertRetrievedClaim(expectedClaimKey, result);
	}
	
	private void mockDaoRetrieveResult() throws IOException {
		PreClaim daoResult = (PreClaim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/persistence/MockPreClaim.json", PreClaim.class);
		when(preClaimDao.retrieveByClaimKey(
				(List<NameValuePair>) anyCollectionOf(NameValuePair.class))).thenReturn(daoResult);
	}
	
	private void mockDaoSearchResult(int resultCount) throws IOException {
		List<PreClaim> preClaims = new ArrayList<PreClaim>(); 
		
		PreClaim preClaim = (PreClaim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/persistence/MockPreClaim.json", PreClaim.class);
			
		for (int i=0; i < resultCount;i++){
			preClaims.add(preClaim);
		}

		when(preClaimDao.search((List<NameValuePair>) anyCollectionOf(NameValuePair.class))).thenReturn(preClaims);
	}
	
	private void mockDaoSearchThrowsException() throws IOException {
		when(preClaimDao.search((List<NameValuePair>) anyCollectionOf(NameValuePair.class))).thenThrow(BadRequestCriteriaException.class); 
	}

	private void assertRetrievedClaim(ClaimKey expectedClaimKey, Claim retrievedResult) {
		assertTrue(retrievedResult != null);
		assertTrue(retrievedResult instanceof Claim);
		assertTrue(expectedClaimKey != null);
		assertEquals(expectedClaimKey.getClaimNumber(), retrievedResult.getClaimKey().getClaimNumber());
		assertEquals(expectedClaimKey.getClaimExtNumber(), retrievedResult.getClaimKey().getClaimExtNumber());
	}

	@Test(expected = ClaimNotFoundException.class)
	public void testClaimNotFound() throws Exception {
		mockDaoRetrieveThrowsNoResultException();
		invokeRetrieveClaim();
	}
	
	private void mockDaoRetrieveThrowsNoResultException() {
		NoResultException resultException = new NoResultException("No claim found!");
		when(preClaimDao.retrieveByClaimKey(
				(List<NameValuePair>) anyCollectionOf(NameValuePair.class)))
				.thenThrow(resultException);
	}

	@Test(expected = DatabaseIOException.class)
	public void testDatabaseIOException() throws Exception {
		mockQueryTimeoutExceptionFromDao();
		invokeRetrieveClaim();	
	}
	
	private void mockQueryTimeoutExceptionFromDao() {
		QueryTimeoutException resultException = new QueryTimeoutException("The database won't talk to me...");
		when(preClaimDao.retrieveByClaimKey(
				(List<NameValuePair>) anyCollectionOf(NameValuePair.class)))
				.thenThrow(resultException);
	}
	
	@Test(expected = ClaimNotFoundException.class)
	public void testDaoRetrieveReturnsNullThrowsClaimNotFound() throws Exception {
		mockNullResponseFromDaoRetrieve();
		invokeRetrieveClaim();
	}

	private void mockNullResponseFromDaoRetrieve() {
		when(preClaimDao.retrieveByClaimKey(
				(List<NameValuePair>) anyCollectionOf(NameValuePair.class)))
				.thenReturn(null);
	}

	private void invokeRetrieveClaim() throws Exception {
		ClaimKey claimKey = new ClaimKey("202132159", "00");
		result = repository.retrieve(claimKey);	
	}

	@Test
	public void testCreateClaimSuccess() throws IOException, DatabaseIOException {
		Claim createRequest = (Claim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimRequest.json", Claim.class);
		mockMappedPreClaimIsReturnedFromDaoCreate();
		Claim actualResponse = repository.create(createRequest);
		assertTrue(actualResponse != null);
		assertTrue(actualResponse.getClaimKey() != null);
	}
		
	@Test
	public void testCreateClaimNoLines() throws IOException, DatabaseIOException {
		Claim createRequest = createClaimNoLines();
		mockMappedPreClaimIsReturnedFromDaoCreate();
		Claim actualResponse = repository.create(createRequest);
		Mockito.verify(claimKeyDao, Mockito.times(0)).getClaimNumber(); 
		assertTrue(actualResponse != null);
		assertTrue(actualResponse.getClaimKey() != null);
	}
	
	@Test
	public void testCreateClaimNoLinesNoClaimKey() throws IOException, DatabaseIOException {
		Claim createRequest = createClaimNoLines();
		createRequest.setClaimKey(null);
		mockMappedPreClaimIsReturnedFromDaoCreate();
		Claim actualResponse = repository.create(createRequest);
		Mockito.verify(claimKeyDao, Mockito.times(1)).getClaimNumber(); 
		assertTrue(actualResponse != null);
		assertTrue(actualResponse.getClaimKey() != null);
		assertEquals(MOCKED_CLAIM_KEY.getClaimNumber(), actualResponse.getClaimKey().getClaimNumber());
	}
	
	@Test
	public void testCreateClaimNoLinesEmptyClaimKey() throws IOException, DatabaseIOException {
		Claim createRequest = createClaimNoLines();
		createRequest.setClaimKey(new ClaimKey("", ""));
		mockMappedPreClaimIsReturnedFromDaoCreate();
		Claim actualResponse = repository.create(createRequest);
		Mockito.verify(claimKeyDao, Mockito.times(1)).getClaimNumber(); 
		assertTrue(actualResponse != null);
		assertTrue(actualResponse.getClaimKey() != null);
		assertEquals(MOCKED_CLAIM_KEY.getClaimNumber(), actualResponse.getClaimKey().getClaimNumber());
	}
	
	private Claim createClaimNoLines() throws JsonParseException, JsonMappingException, IOException{
		Claim createRequest = (Claim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimRequest.json", Claim.class);
		createRequest.setClaimLines(null);
		return createRequest; 
	}

	private void mockMappedPreClaimIsReturnedFromDaoCreate() throws IOException {
		PreClaim mappedDaoResponse = mockPreClaimDaoResponse();
		when(preClaimDao.create(any(PreClaim.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
	}
	
	@Test(expected = DatabaseIOException.class)
	public void testCreateThrowsPersistenceException() throws IOException, DatabaseIOException {
		Claim createRequest = (Claim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimRequest.json", Claim.class);
		mockDaoCreateThrowsLockTimeoutException();
		repository.create(createRequest);
	}

	private void mockDaoCreateThrowsLockTimeoutException() {
		when(preClaimDao.create(any(PreClaim.class))).thenThrow(new LockTimeoutException());
	}

	@Test
	public void testSetPreClaimErrorKeyOnPreClaimErrors() throws JsonParseException, JsonMappingException, IOException{
		PreClaim preClaim = mockPreClaimDaoResponse();
		preClaim = repository.setPreClaimErrorKeyOnPreClaimErrors(preClaim);
		List<PreClaimError> errors = getPreClaimErrors(preClaim);
		assertPreClaimErrorsContainClaimKey(errors);
	}
	
	@Test
	public void testSetPreClaimLineKeyOnPreClaimLines() throws JsonParseException, JsonMappingException, IOException{
		PreClaim preClaim = mockPreClaimDaoResponse();
		preClaim = repository.setPreClaimErrorKeyOnPreClaimErrors(preClaim);
		List<PreClaimLine> lines = preClaim.getClaimLines(); 
		assertPreClaimLinesContainClaimKey(lines);
	}
	
	private void assertPreClaimLinesContainClaimKey(List<PreClaimLine> lines){
		for(PreClaimLine line : lines){
			assertNotNull(line.getClaimLineKey().getClaimNumber());
			assertNotNull(line.getClaimLineKey().getClaimExtNumber());
		}
	}
	
	private void assertPreClaimErrorsContainClaimKey(List<PreClaimError> errors){
		for(PreClaimError error : errors){
			assertNotNull(error.getErrorKey().getClaimNumber());
			assertNotNull(error.getErrorKey().getClaimExtNumber());
		}
	}
	
	private List<PreClaimError> getPreClaimErrors(PreClaim preClaim){
		List<PreClaimError> errors = new ArrayList<PreClaimError>();
		errors.addAll(preClaim.getClaimErrors());
		return errors; 
	}
	
	@Test
	public void testUpdateSuccessful() throws ClaimNotFoundException, DatabaseIOException, IOException {
		Claim claimToPersist = new Claim();
		mockDaoUpdateReturnsDatabaseResponse();
		Claim persistedClaim = repository.update(claimToPersist);
		assertPersistedClaimKey(persistedClaim.getClaimKey());
	}

	private void mockDaoUpdateReturnsDatabaseResponse() throws IOException {
		PreClaim mockedDaoResponse = mockPreClaimDaoResponse();
		when(preClaimDao.update(any(PreClaim.class))).thenReturn(mockedDaoResponse);
	}
	
	@Test 
	public void testDeleteLineSuccessful() throws IOException, ClaimLineNotFoundException, ClaimNotFoundException, DatabaseIOException {
		Claim createClaimRequest = (Claim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimRequest.json", Claim.class);
		PreClaim createPreClaimRequest = mockPreClaimDaoResponse();
		when(preClaimDao.retrieveByClaimKey(anyListOf(NameValuePair.class))).thenReturn(createPreClaimRequest);
		invokeDeleteLine(createClaimRequest,MOCKED_CLAIM_KEY,1);
	}
	
	@Test (expected = ClaimLineNotFoundException.class)
	public void testDeleteNonexistentLineThrowsClaimLineNotFoundException() throws IOException, ClaimLineNotFoundException, ClaimNotFoundException, DatabaseIOException {
		Claim createClaimRequest = (Claim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimRequest.json", Claim.class);
		PreClaim createPreClaimRequest = mockPreClaimDaoResponse();
		when(preClaimDao.retrieveByClaimKey(anyListOf(NameValuePair.class))).thenReturn(createPreClaimRequest);
		invokeDeleteLine(createClaimRequest,MOCKED_CLAIM_KEY,0);
	}
	
	private void invokeDeleteLine(Claim initialClaim, ClaimKey key, Integer lineNumber) throws DatabaseIOException, ClaimNotFoundException, ClaimLineNotFoundException {
		ClaimLine alteredClaimLine = repository.deleteLine(key,lineNumber);
		assertEquals(alteredClaimLine.getLineNumber(), lineNumber);
	}

	private PreClaim mockPreClaimDaoResponse() throws IOException {
		return (PreClaim) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/persistence/MappedReservedPreClaimRequest.json", PreClaim.class);
	}

	private void assertPersistedClaimKey(ClaimKey claimKey) {
		assertEquals(MOCKED_CLAIM_KEY.getClaimNumber(), claimKey.getClaimNumber());
		assertEquals(MOCKED_CLAIM_KEY.getClaimExtNumber(), claimKey.getClaimExtNumber());		
	}
	
	@Test(expected = DatabaseIOException.class)
	public void testUpdateThrowsPersistenceException() throws DatabaseIOException {
		Claim claimToPersist = new Claim();
		mockDaoUpdateThrowsPersistenceException();
		repository.update(claimToPersist);
	}

	private void mockDaoUpdateThrowsPersistenceException() {
		mockDaoUpdateThrowsException(new QueryTimeoutException());
	}

	private void mockDaoUpdateThrowsException(Exception toThrow) {
		when(preClaimDao.update(any(PreClaim.class))).thenThrow(toThrow);
	}
	
	@Test(expected = DatabaseIOException.class)
	public void testUpdateThrowsTransactionRequiredException() throws DatabaseIOException {
		Claim claimToPersist = new Claim();
		mockDaoUpdateThrowsTransactionRequiredException();
		repository.update(claimToPersist);
	}

	private void mockDaoUpdateThrowsTransactionRequiredException() {
		mockDaoUpdateThrowsException(new TransactionRequiredException());
	}
	
	@Test(expected = DatabaseIOException.class)
	public void testUpdateThrowsIllegalArgumentException() throws DatabaseIOException {
		Claim claimToPersist = new Claim();
		mockDaoUpdateThrowsIllegalArgumentException();
		repository.update(claimToPersist);
	}

	private void mockDaoUpdateThrowsIllegalArgumentException() {
		mockDaoUpdateThrowsException(new IllegalArgumentException());
	}
	
	@Test
	public void testDelete() throws DatabaseIOException, ClaimNotFoundException, IOException {
		mockDaoRetrieveResult();
		mockDaoDelete();
		ClaimKey claimKey = new ClaimKey("202132159", "00");
		Claim deletedClaim = repository.delete(claimKey);
		assertNotNull(deletedClaim);
		assertEquals(claimKey.getClaimNumber(), deletedClaim.getClaimKey().getClaimNumber());
		assertEquals(claimKey.getClaimExtNumber(), deletedClaim.getClaimKey().getClaimExtNumber());
	}
	
	private void mockDaoDelete() {
		when(preClaimDao.delete(any(PreClaim.class))).then(AdditionalAnswers.returnsFirstArg());
	}

	@Test(expected = ClaimNotFoundException.class)
	public void testDeleteClaimDoesNotExistThrowsClaimNotFoundException() throws DatabaseIOException, ClaimNotFoundException {
		repository.delete(new ClaimKey());
	}
	
	@Test
	public void testSearchReturnsResults() throws Exception {
		int resultCount = 3;
		mockDaoSearchResult(resultCount);
		Claims claims = repository.search(new ArrayList<NameValuePair>());
		assertEquals(resultCount, claims.size());
	}
	
	@Test
	public void testSearchReturnsNoResults() throws Exception {
		int resultCount = 0;
		mockDaoSearchResult(resultCount);
		Claims claims = repository.search(new ArrayList<NameValuePair>());
		assertEquals(resultCount, claims.size());
	}
	
	@Test(expected=BadRequestCriteriaException.class)
	public void testSearchReturnsThrowsException() throws Exception {
		mockDaoSearchThrowsException();
		repository.search(new ArrayList<NameValuePair>());
	}
	

}
