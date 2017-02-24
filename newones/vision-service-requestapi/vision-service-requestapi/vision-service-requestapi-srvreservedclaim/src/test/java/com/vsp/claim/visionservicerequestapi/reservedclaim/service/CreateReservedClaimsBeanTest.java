package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.junit.After;
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
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.util.ClaimFactory;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.Preferences;

public class CreateReservedClaimsBeanTest {
	
	@InjectMocks @Spy private CreateReservedClaimsBean bean; 
	@Mock private ApiContext apiContext;
	@Mock private PreClaimRepository preClaimRepository;
	
	private static final String CLAIM_NUMBER = "10000000";
	private static final String CLAIM_EXT_NUMBER = "00";
	private static final String CLIENT_ID = "12345678";
	private static final String DIV_ID = "0001";
	private static final String POLICY_ID = "123456789";
	private static final String CONSUMER_ID = "1234567890";
	private static final String NETWORK_ID = "1000"; 

	
	@Before
	public void setup() {
		initPreferences();
		MockitoAnnotations.initMocks(this);
	}
	
	private void initPreferences() {
		if(!Preferences.initialized()) {
			Preferences.initialize("service-requestapi-srvreservedclaim", "LOCAL", System.getProperty("user.home"));
		}
	}
	
	@After
	public void tearDown() {
		reset(bean, preClaimRepository);
	}

	
	@Test
	public void testGetRequestContext(){
		Claim claim = getClaim();
		ReservedClaimRequestContext context = bean.getRequestContext(claim);
		assertFalse(context.getClaim() == claim); 
	}
	
	private Claim getClaim(){
		Claim claim = new Claim();
		ClaimKey key = new ClaimKey(CLAIM_NUMBER, CLAIM_EXT_NUMBER); 
		claim.setClaimKey(key);
		
		claim.setClaimLines(new ArrayList<ClaimLine>());
		claim.getClaimLines().add(new ClaimLine());
		
		return claim;
	}
	
	@Test(expected = NotFoundException.class)
	public void testAddLineToClaimNotFound() throws DatabaseIOException, ClaimNotFoundException {
		mockRepositoryRetrieveThrowsNotFoundException();
		bean.createLines(CLAIM_NUMBER, CLAIM_EXT_NUMBER, buildClaimLines(1));
	}
	
	
	@Test (expected = ForbiddenException.class)
	public void testCreateLinesWithForbiddenException() throws DatabaseIOException, ClaimNotFoundException {
		int numOfLines = 2;
		mockServiceLocationConstraintValidationFails();
		mockRepositoryRetrieve(buildClaimWithNumberOfLines(numOfLines));
		ClaimLines linesToAdd = buildClaimLines(2);
		bean.createLines(CLAIM_NUMBER, CLAIM_EXT_NUMBER,linesToAdd);		
	}
	
	private void mockServiceLocationConstraintValidationFails() {
		doReturn(false).when(bean).isServiceLocationConstraintValid(Matchers.any(ReservedClaimRequestContext.class));
	}
				
	private Claim buildClaim() {
		ClaimFactory factory = new ClaimFactory();
		factory.setClaimNumber(CLAIM_NUMBER);
		factory.setClaimExtNumber(CLAIM_EXT_NUMBER);
		factory.setClientId(CLIENT_ID);
		factory.setConsumerId(CONSUMER_ID);
		factory.setDivisionId(DIV_ID);
		factory.setNetworkId(NETWORK_ID);
		factory.setPolicyId(POLICY_ID);
		return factory.buildClaim(); 
	}

	private Claim buildClaimWithNumberOfLines(int numOfLines) {
		Claim claim = buildClaim();
		List<ClaimLine> claimLines = buildClaimLines(numOfLines); 
		claim.setClaimLines(claimLines);
		return claim;
	}

	private ClaimLines buildClaimLines(int numOfLines) {
		ClaimLines claimLines = new ClaimLines(); 
		for(int i=1; i <= numOfLines; i++){
			ClaimLine line = new ClaimLine();
			line.setLineNumber(i);
			line.setProductCatalogKey("dsdslkfdlks");
			claimLines.add(line);
		}
		return claimLines;
	}
	
	private void mockRepositoryRetrieveThrowsNotFoundException() throws ClaimNotFoundException, DatabaseIOException {
		when(preClaimRepository.retrieve(any(ClaimKey.class))).thenThrow(new ClaimNotFoundException());
	}
	
	private void mockRepositoryRetrieve(Claim mockClaim) throws ClaimNotFoundException, DatabaseIOException {
		when(preClaimRepository.retrieve(any(ClaimKey.class))).thenReturn(mockClaim);
	}
	
}
