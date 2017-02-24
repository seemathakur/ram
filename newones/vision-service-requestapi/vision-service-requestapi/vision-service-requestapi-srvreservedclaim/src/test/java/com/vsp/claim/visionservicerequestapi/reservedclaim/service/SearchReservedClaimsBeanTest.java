package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.ws.rs.BadRequestException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vsp.api.claim.model.Claims;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.Preferences;

public class SearchReservedClaimsBeanTest {
	
	private static final String CLIENT_ID = "12345678";
	private static final String DIV_ID = "0000";
	private static final String POLICY_ID = "123456789";
	private static final String CONSUMER_ID = "123456789";

	@InjectMocks
	private SearchReservedClaimsBean bean;

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
	public void testSearch() throws Exception {
		mockSearch();
		Claims claims = bean.search(CLIENT_ID, DIV_ID, POLICY_ID, CONSUMER_ID);
		assertNotNull(claims); 
	}
	
	@Test(expected=BadRequestException.class)
	public void testSearchThrowsBadRequestException() throws Exception {
		mockSearch();
		bean.search(CLIENT_ID, DIV_ID, POLICY_ID, "A12358");
	}

	private void mockSearch() throws ClaimNotFoundException,DatabaseIOException {
		when(preClaimRepository.search(any(List.class))).thenReturn(new Claims());
	}

}
