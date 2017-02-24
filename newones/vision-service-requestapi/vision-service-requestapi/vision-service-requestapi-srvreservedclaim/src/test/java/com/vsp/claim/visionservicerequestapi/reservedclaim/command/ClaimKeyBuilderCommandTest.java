package com.vsp.claim.visionservicerequestapi.reservedclaim.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vsp.api.claim.model.ClaimKey;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.ClaimKeyBuilderCommand;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.ClaimKeyDao;
import com.vsp.il.util.Preferences;

public class ClaimKeyBuilderCommandTest {
	
	@Mock
	private ClaimKeyDao mockClaimKeyDao; 
	
	@InjectMocks
	private ClaimKeyBuilderCommand command;
	
	private static String INTIAL_CLAIM_EXTENSION = "00";
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createClaimKeySuccessfully(){
		mockClaimKeyDao(); 
		runCommand();
		assertClaimKeyBuiltWithClaimNumberAndInitialExtension(); 
	}
	
	@Test(expected = WebApplicationException.class)
	public void claimKeyBuilderCommandFails() {
		mockExceptionFromClaimKeyDao();
		runCommand();
	}
	
	
	private void runCommand() {
		command.run();
	}
	
	private void assertClaimKeyBuiltWithClaimNumberAndInitialExtension(){
		try {
			ClaimKey key = command.getReturnValue();
			assertEquals("The claim key does not have the intial extension", INTIAL_CLAIM_EXTENSION, key.getClaimExtNumber()); 
			assertTrue("The claim key does not have a valid claim number", assertClaimNumberIsNotEmpty(key.getClaimNumber()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("You caused the impossible exception!");
		}
	}
	
	private boolean assertClaimNumberIsNotEmpty(String claimNumber){
		return claimNumber != null && !claimNumber.equals("");
	}
	
	private void mockClaimKeyDao() {
		when(mockClaimKeyDao.getClaimNumber())
			.thenReturn(Integer.valueOf(100011988));
	}
	
	private void mockExceptionFromClaimKeyDao() {
		when(mockClaimKeyDao.getClaimNumber())
			.thenThrow(new RuntimeException("Unable to generate claim number"));
	}

}
