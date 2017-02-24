package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

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
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.Preferences;

public class RetrieveReservedClaimsBeanTest {
	
	private final static String CLAIM_NUMBER = "10000000";
	private final static String CLAIM_EXT_NUMBER = "00";

	@InjectMocks
	@Spy
	private RetrieveReservedClaimsBean bean;

	@Mock
	private ApiContext apiContext;

	@Mock
	private PreClaimRepository preClaimRepository;

	@Before
	public void setUp() throws Exception {
		if (!Preferences.initialized()) {
			Preferences.initialize("service-requestapi-srvreservedclaim",
					"LOCAL", System.getProperty("user.home"));
		}
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieve() throws Exception {
		mockRetrieveFromDatabase();
		mockServiceLocationConstraintValidation();
		Claim claim = bean.retrieve(CLAIM_NUMBER, CLAIM_EXT_NUMBER);
		assertNotNull(claim);
		assertNotNull(claim.getSelf());
		assertNotNull(claim.getValidClaimOperations());
		assertClaimLineLinksNotNull(claim.getClaimLines());
	}

	private void assertClaimLineLinksNotNull(List<ClaimLine> claimLines) {
		for(ClaimLine claimLine : claimLines){
			assertNotNull(claimLine.getSelfLink());
		}
	}

	@Test(expected = NotFoundException.class)
	public void testRetrieveWithException() throws Exception {
		mockRetrieveFromDatabaseWithException();
		bean.retrieve(CLAIM_NUMBER, CLAIM_EXT_NUMBER);
	}

	@Test
	public void testRetrieveWithForbiddenException() throws Exception {
		mockRetrieveFromDatabase();
		mockServiceLocationConstraintValidationFails();
		try {
			bean.retrieve(CLAIM_NUMBER, CLAIM_EXT_NUMBER);
			fail();
		} catch (ForbiddenException wae) {
			assertEquals(Response.Status.FORBIDDEN.getStatusCode(), wae
					.getResponse().getStatus());
		}
	}

	private void mockServiceLocationConstraintValidationFails() {
		doReturn(false).when(bean).isServiceLocationConstraintValid(
				Matchers.any(ReservedClaimRequestContext.class));
	}

	private void mockServiceLocationConstraintValidation() {
		doReturn(true).when(bean).isServiceLocationConstraintValid(
				Matchers.any(ReservedClaimRequestContext.class));
	}

	private void mockRetrieveFromDatabase() throws ClaimNotFoundException,
			DatabaseIOException {
		Claim claim = new Claim();
		ClaimKey key = new ClaimKey(CLAIM_NUMBER, CLAIM_EXT_NUMBER);
		claim.setClaimKey(key);
		claim.setClaimLines(buildClaimLines(1, 2, 3));
		when(preClaimRepository.retrieve(any(ClaimKey.class)))
				.thenReturn(claim);
	}

	private List<ClaimLine> buildClaimLines(int... lineNumbers) {
		List<ClaimLine> lines = new ArrayList<ClaimLine>();
		for (int lineNumber : lineNumbers) {
			ClaimLine claimLine = new ClaimLine();
			claimLine.setLineNumber(lineNumber);
			lines.add(claimLine);
		}

		return lines;
	}

	private void mockRetrieveFromDatabaseWithException()
			throws ClaimNotFoundException, DatabaseIOException,
			NotFoundException {
		when(preClaimRepository.retrieve(any(ClaimKey.class))).thenThrow(
				new ClaimNotFoundException());
	}

}
