package com.vsp.claim.visionservicerequestapi.reservedclaim.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.Preferences;

public class DeleteReservedClaimsBeanTest {
	static {		
		if(!Preferences.initialized()) {
			Preferences.initialize("service-requestapi-srvreservedclaim", "LOCAL", System.getProperty("user.home"));
		}		
	}
	
	@InjectMocks
	@Spy
	private DeleteReservedClaimsBean bean;
	
	@Mock
	private PreClaimRepository repository;
	
	@Mock
	private ApiContext apiContext;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	private static String claimNumber = "123456789";
	private static String claimExtNumber = "00"; 
	private static Integer lineNumber = 1; 
	
	
	@Test
	public void testDeleteReturnSuccess() throws ClaimNotFoundException, DatabaseIOException {
		mockPreClaimRepoRetrieve(claimNumber, claimExtNumber);
		mockPreClaimRepoDeleteClaim(claimNumber, claimExtNumber);
		Claim deletedClaim = bean.delete(claimNumber, claimExtNumber);		
		ClaimKey key = deletedClaim.getClaimKey();
		
		assertEquals(claimNumber, key.getClaimNumber());
		assertEquals(claimExtNumber, key.getClaimExtNumber());
	}
	
	@Test (expected = DatabaseIOException.class)
	public void testDeleteClaimRetrieveIOException() throws ClaimNotFoundException, DatabaseIOException {
		mockPreClaimRepoRetrieveIOError();
		bean.delete(claimNumber, claimExtNumber);		
	}
	
	@Test (expected = DatabaseIOException.class)
	public void testDeleteClaimUpdateIOException() throws ClaimNotFoundException, DatabaseIOException {
		mockPreClaimRepoRetrieve(claimNumber, claimExtNumber);
		mockPreClaimRepoReturnIOError();
		bean.delete(claimNumber, claimExtNumber);		
	}
	
	@Test (expected = ForbiddenException.class)
	public void testDeleteWithForbiddenException() throws Exception{
		mockPreClaimRepoRetrieve(claimNumber, claimExtNumber);
		mockPreClaimRepoDeleteClaim(claimNumber, claimExtNumber);
		mockServiceLocationConstraintValidationFails();
		bean.delete(claimNumber, claimExtNumber);		
	}
	
	@Test (expected = NotFoundException.class)
	public void testDeleteClaimNotFound() throws ClaimNotFoundException, DatabaseIOException {		
		mockPreClaimRepoRetrieveNotFound();
		bean.delete(claimNumber, claimExtNumber);		
	}
	
	@Test
	public void testDeleteLineReturnSuccess() throws ClaimNotFoundException, ClaimLineNotFoundException, DatabaseIOException {
		mockPreClaimRepoRetrieve(claimNumber, claimExtNumber);
		mockPreClaimRepoDeleteLine(claimNumber, claimExtNumber, lineNumber);
		ClaimLine modifiedClaimLine = bean.deleteLine(claimNumber, claimExtNumber, lineNumber);		
		assertEquals(modifiedClaimLine.getLineNumber(), lineNumber);
	}
	
	@Test (expected = NotFoundException.class)
	public void testDeleteLineClaimNotFound() throws ClaimNotFoundException, ClaimLineNotFoundException, DatabaseIOException {		
		mockPreClaimRepoRetrieveNotFound();
		bean.deleteLine(claimNumber, claimExtNumber, lineNumber);		
	}
	
	@Test (expected = NotFoundException.class)
	public void testDeleteLineClaimLineNotFound() throws ClaimNotFoundException, ClaimLineNotFoundException, DatabaseIOException {		
		mockPreClaimRepoRetrieve(claimNumber, claimExtNumber);
		mockPreClaimRepoDeleteLineNotFound(); 
		bean.deleteLine(claimNumber, claimExtNumber, lineNumber);		
	}
	
	@Test (expected = DatabaseIOException.class)
	public void testDeleteLineClaimLineIOException() throws ClaimNotFoundException, ClaimLineNotFoundException, DatabaseIOException {		
		mockPreClaimRepoRetrieve(claimNumber, claimExtNumber);
		mockPreClaimRepoDeleteLineIOError();
		bean.deleteLine(claimNumber, claimExtNumber, lineNumber);		
	}
	
	@Test (expected = ForbiddenException.class)
	public void testDeleteLineWithForbiddenException() throws Exception{
		mockPreClaimRepoRetrieve(claimNumber, claimExtNumber);
		mockServiceLocationConstraintValidationFails();
		bean.deleteLine(claimNumber, claimExtNumber,0);		
	}
	
	private void mockPreClaimRepoRetrieve(String clmNumber, String extNumber) throws ClaimNotFoundException, DatabaseIOException {
		when(repository.retrieve(any(ClaimKey.class))).thenReturn(buildClaim(buildClaimKey(clmNumber, extNumber), "RS"));
	}	
	
	private void mockPreClaimRepoDeleteClaim(String clmNumber, String extNumber) throws ClaimNotFoundException, DatabaseIOException {
		when(repository.delete(any(ClaimKey.class))).thenReturn(buildClaim(buildClaimKey(clmNumber, extNumber), "DE"));
	}
	             	
	private void mockPreClaimRepoDeleteLine(String clmNumber, String extNumber, int lineNumber) throws ClaimNotFoundException, DatabaseIOException, ClaimLineNotFoundException{
		when(repository.deleteLine(any(ClaimKey.class), any(Integer.class))).thenReturn(buildClaimLine(lineNumber));
	}
		
	private void mockPreClaimRepoDeleteLineNotFound() throws ClaimNotFoundException, DatabaseIOException, ClaimLineNotFoundException{
		when(repository.deleteLine(any(ClaimKey.class), any(Integer.class))).thenThrow(new ClaimLineNotFoundException("Claim line doesn't exist"));
	}
		
	private void mockPreClaimRepoDeleteLineIOError() throws ClaimNotFoundException, DatabaseIOException, ClaimLineNotFoundException{
		when(repository.deleteLine(any(ClaimKey.class), any(Integer.class))).thenThrow(new DatabaseIOException("Error Connecting to Database"));
	}
		
	private void mockPreClaimRepoRetrieveNotFound() throws ClaimNotFoundException, DatabaseIOException {
		when(repository.retrieve(any(ClaimKey.class))).thenThrow(new ClaimNotFoundException("Claim doesn't exist"));
	}
	
	private void mockPreClaimRepoRetrieveIOError() throws ClaimNotFoundException, DatabaseIOException {
		when(repository.retrieve(any(ClaimKey.class))).thenThrow(new DatabaseIOException("Error Connecting to Database"));
	}
	
	private void mockPreClaimRepoReturnIOError() throws ClaimNotFoundException, DatabaseIOException {
		when(repository.delete(any(ClaimKey.class))).thenThrow(new DatabaseIOException("Error Connecting to Database"));
	}
	
	private ClaimKey buildClaimKey(String clmNumber, String extNumber) {
		ClaimKey key = new ClaimKey(clmNumber, extNumber);
		return key;
	}
	
	private ClaimLine buildClaimLine(int lineNumber) {
		ClaimLine claimLine = new ClaimLine();
		claimLine.setLineNumber(lineNumber);
		return claimLine;
	}	

	private Claim buildClaim(ClaimKey key, String status) {
		Claim claim = new Claim();
		claim.setClaimKey(key);
		claim.setStatusCode(status);
		List<ClaimLine> claimLines = new ArrayList<ClaimLine>();
		claimLines.add(buildClaimLine(1));
		claim.setClaimLines(claimLines);
		return claim;
	}
	
	private void mockServiceLocationConstraintValidationFails() {
		doReturn(false).when(bean).isServiceLocationConstraintValid(Matchers.any(ReservedClaimRequestContext.class));
	}
	
}
