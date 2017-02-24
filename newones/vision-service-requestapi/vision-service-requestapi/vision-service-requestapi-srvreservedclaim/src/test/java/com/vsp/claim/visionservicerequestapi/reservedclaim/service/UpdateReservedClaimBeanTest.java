package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.junit.MockObjectProvider;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.Preferences;

public class UpdateReservedClaimBeanTest {
	private static final MockObjectProvider objectProvider = new MockObjectProvider();
	
	static {		
		if(!Preferences.initialized()) {
			Preferences.initialize("service-requestapi-srvreservedclaim", "LOCAL", System.getProperty("user.home"));
		}		
	}
	
	@Spy
	@InjectMocks
	private UpdateReservedClaimBean bean;
	
	@Mock
	private PreClaimRepository repository;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	private static final String claimNumber = "100046580";
	private static final String claimExtNumber = "00";
	private static final int lineNumber = 1;
	
	@Test
	public void testUpdateReturnsSuccessfully() throws DatabaseIOException, ClaimNotFoundException{
		mockRepositoryRetrieve();
		mockRepositoryReturnsSuccessfully();
		Claim request = buildClaim(claimNumber, claimExtNumber);
		Claim response = bean.update(claimNumber, claimExtNumber, request);
		assertNotNull(response);
		assertNotSame(request, response);
	}
	
	@Test(expected = BadRequestException.class)
	public void testUpdatePathParamNotMatch() throws DatabaseIOException {
		Claim misMatchRequest = buildClaim("123456781", claimExtNumber);
		bean.update(claimNumber, claimExtNumber, misMatchRequest);
	}
	
	@Test(expected = NotFoundException.class)
	public void testUpdateClaimNotExisted() throws DatabaseIOException, ClaimNotFoundException {
		mockRepositoryRetrieveThrowsNotFoundException();
		bean.update(claimNumber, claimExtNumber, buildClaim(claimNumber, claimExtNumber));
	}
	
	@Test(expected=DatabaseIOException.class)
	public void testUpdateIOExceptionRetrieval() throws DatabaseIOException, ClaimNotFoundException{
		mockRepositoryRetrieveThrowsIOException(); 
		bean.update(claimNumber, claimExtNumber,  buildClaim(claimNumber, claimExtNumber));
	}
	
	@Test(expected=DatabaseIOException.class)
	public void testUpdateThrowsException() throws DatabaseIOException, ClaimNotFoundException{
		mockRepositoryRetrieve();
		mockRepositoryThrowsDatabaseIOException(); 
		bean.update(claimNumber, claimExtNumber,  buildClaim(claimNumber,claimExtNumber));
	}
	
	@Test
	public void testUpdateLineSuccessful() throws IOException, DatabaseIOException, ClaimNotFoundException {
		mockRepositoryRetrieve();
		mockRepoUpdateClaimLine();
				
		ClaimLine response = bean.updateLine(claimNumber, claimExtNumber, lineNumber, buildClaimLineFromJson());
		
		assertEquals(Integer.valueOf(lineNumber),response.getLineNumber());
		assertEquals(BigDecimal.valueOf(10.15), response.getBilledAmount());
		assertEquals("RS", response.getStatusCode());
		assertEquals("LVC", response.getClaimLineTypeCode());		
	}
	
	@Test(expected = BadRequestException.class)
	public void testUpdateLineBadRequestException() throws ClaimNotFoundException, DatabaseIOException, IOException {
		mockRepositoryRetrieve();		
		bean.updateLine(claimNumber, claimExtNumber, 2, buildClaimLineFromJson());
	}
	
	@Test(expected = NotFoundException.class)
	public void testUpdateLineClaimNotExisted() throws ClaimNotFoundException, DatabaseIOException, IOException {
		mockRepositoryRetrieveThrowsNotFoundException();		
		bean.updateLine(claimNumber, claimExtNumber, lineNumber, buildClaimLineFromJson());
	}
	
	@Test(expected = NotFoundException.class)
	public void testUpdateLineClaimLineNotExisted() throws ClaimNotFoundException, DatabaseIOException, IOException {
		mockRepositoryRetrieve();
		ClaimLine request = buildClaimLineFromJson();
		request.setLineNumber(2);
		
		bean.updateLine(claimNumber, claimExtNumber, 2, request);
	}
	
	private void mockRepositoryReturnsSuccessfully() throws DatabaseIOException{
		when(repository.update(any(Claim.class))).thenReturn(buildClaim(claimNumber, claimExtNumber)); 
	}
	
	private void mockRepositoryThrowsDatabaseIOException() throws DatabaseIOException{
		when(repository.update(any(Claim.class))).thenThrow(new DatabaseIOException("Default message"));
	}
	
	private void mockRepositoryRetrieve() throws ClaimNotFoundException, DatabaseIOException {
		when(repository.retrieve(any(ClaimKey.class))).thenReturn(buildClaim(claimNumber, claimExtNumber));
	}
	
	private void mockRepositoryRetrieveThrowsNotFoundException() throws ClaimNotFoundException, DatabaseIOException {
		when(repository.retrieve(any(ClaimKey.class))).thenThrow(new ClaimNotFoundException());
	}
	
	private void mockRepositoryRetrieveThrowsIOException() throws ClaimNotFoundException, DatabaseIOException {
		when(repository.retrieve(any(ClaimKey.class))).thenThrow(new DatabaseIOException("Default message"));
	}
	
	private ClaimKey buildClaimKey(String number, String ext) {
		ClaimKey key = new ClaimKey(number, ext);
		return key;		
	}
	
	private Claim buildClaim(String number, String ext){
		ClaimKey key = buildClaimKey(number, ext);		
		Claim claim = new Claim();		
		claim.setClaimKey(key);
		
		ClaimLine line = buildRepoClaimLine();
		claim.setClaimLines(Arrays.asList(line));		

		return claim;
	}
	
	private ClaimLine buildClaimLineFromJson() throws IOException {
		return (ClaimLine) objectProvider.mockObjectFromJson(
				"com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimLineRequest.json", ClaimLine.class);
	}
	
	private ClaimLine buildRepoClaimLine() {
		ClaimLine line = new ClaimLine();
		line.setLineNumber(lineNumber);
		line.setStatusCode("RS");
		line.setBilledAmount(BigDecimal.valueOf(10.15));
		line.setClaimLineTypeCode("LVC");
		
		return line;
	}
	
	private void mockRepoUpdateClaimLine() throws DatabaseIOException {		
		when(repository.update(any(Claim.class))).thenReturn(buildClaim(claimNumber, claimExtNumber));
	}
}
