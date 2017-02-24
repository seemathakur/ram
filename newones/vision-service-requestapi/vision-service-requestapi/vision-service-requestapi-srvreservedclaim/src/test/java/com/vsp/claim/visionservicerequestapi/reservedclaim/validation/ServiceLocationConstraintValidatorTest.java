package com.vsp.claim.visionservicerequestapi.reservedclaim.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.ReservedClaimRequestContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.util.ClaimFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.util.ReservedClaimRequestContextFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.util.ServiceLocationConstraintFactory;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.AccessToken;
import com.vsp.oauth.ServiceLocationConstraint;

public class ServiceLocationConstraintValidatorTest {
	
	private ServiceLocationConstraintValidator validator; 
	
	private ReservedClaimRequestContext requestContext; 

	@Mock
	private AccessToken accessToken; 
	@Mock
	private ApiContext apiContext;
		
	public static final String PROVIDER_TAX_ID = "987456123";
	public static final String SERVICE_LOCATION_HASH_CODE = "23";
	public static final String SERVICE_LOCATION_SEQUENCE = "0";
	public static final String EMPTY_STRING = ""; 
	
	@Before
	public void setup() {
		initPreferences();
		MockitoAnnotations.initMocks(this);
		mockAccessToken(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
		mockApiContextWithAccessToken();
	}
	
	
	private void initPreferences() {
		if(!Preferences.initialized()) {
			Preferences.initialize("service-requestapi-srvreservedclaim", "LOCAL", System.getProperty("user.home"));
		}
	}


	@Test
	public void testSuccessWhenServiceLocationConstraintMatchesServiceLocationOnClaim(){
		setupServiceLocationConstraintMatchesClaim();
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertTrue(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullSequence(){
		Claim claim = buildClaim(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, null);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullHash(){
		Claim claim = buildClaim(PROVIDER_TAX_ID, null, SERVICE_LOCATION_SEQUENCE);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullTaxId(){
		Claim claim = buildClaim(null, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullProviderKey(){
		Claim claim = buildClaim(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
		claim.getProvider().setKey(null);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullServiceLocationKey(){
		Claim claim = buildClaim(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
		claim.getProviderNetworkAccessPoint().getServiceLocation().setKey(null);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullServiceLocation(){
		Claim claim = buildClaim(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
		claim.getProviderNetworkAccessPoint().setServiceLocation(null);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullProviderNetworkAccessPoint(){
		Claim claim = buildClaim(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
		claim.setProviderNetworkAccessPoint(null);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testFailWhenClaimHasNullProvider(){
		Claim claim = buildClaim(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
		claim.setProvider(null);
		setupNullClaimFields(claim);
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid()); 
	}
	
	@Test
	public void testSuccessWhenNoServiceLocationConstraintAndServiceLocationOnClaim(){
		setupNoRequestContextServiceLocationConstraintMatchesClaim();
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertTrue(validator.isValid()); 
	}
	
	@Test
	public void testSuccessWhenServiceLocationConstraintExistsNoServiceLocationOnClaim(){
		setupServiceLocationConstraintAndNoServiceLocationOnClaim();
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertTrue(validator.isValid()); 
	}
	
	@Test
	public void testFailureWhenServiceLocationConstraintExistsDoesNotMatchServiceLocationOnClaim(){
		setupServiceLocationConstraintDoesNotMatchClaim();
		validator = new ServiceLocationConstraintValidator(getRequestContext()); 
		
		assertFalse(validator.isValid());
	}
	
	@Test
	public void testGetErrorCode(){
		setupServiceLocationConstraintMatchesClaim();
		validator = new ServiceLocationConstraintValidator(getRequestContext());
		assertEquals(validator.getErrorCode(), Integer.toString(Response.Status.FORBIDDEN.getStatusCode()));
	}
	
	@Test
	public void testGetErrorMessage(){
		setupServiceLocationConstraintMatchesClaim();
		validator = new ServiceLocationConstraintValidator(getRequestContext());
		assertEquals(validator.getErrorMessage(), Response.Status.FORBIDDEN.getReasonPhrase());
	}
	
	public void setupServiceLocationConstraintMatchesClaim(){		
		buildReservedClaimRequestContext(buildClaimWithServiceLocationMatchesConstraint());
	}
	
	public void setupNullClaimFields(Claim claimWithNullFields){		
		buildReservedClaimRequestContext(claimWithNullFields);
	}
	
	public void setupServiceLocationConstraintAndNoServiceLocationOnClaim(){
		buildReservedClaimRequestContext(buildClaimWithNoServiceLocation()); 
	}
	
	public void setupNoRequestContextServiceLocationConstraintMatchesClaim(){		
		Mockito.when(accessToken.getService_location_constraint()).thenReturn(null);
		buildReservedClaimRequestContext(buildClaimWithServiceLocationMatchesConstraint());
	}
	
	public void setupServiceLocationConstraintDoesNotMatchClaim(){
		buildReservedClaimRequestContext(buildClaimServiceLocationNotMatchConstraint());
	}
	
	public Claim buildClaimServiceLocationNotMatchConstraint(){
		return buildClaim("123456789", SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE); 
	}
	
	public Claim buildClaimWithNoServiceLocation() {
		return buildClaim(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING);
	}
	
	public Claim buildClaimWithServiceLocationMatchesConstraint(){
		return buildClaim(PROVIDER_TAX_ID, SERVICE_LOCATION_HASH_CODE, SERVICE_LOCATION_SEQUENCE);
	}
	
	public Claim buildClaim(String providerTaxId, String hashCode, String serviceLocationSequence) {
		ClaimFactory factory = new ClaimFactory();
		
		factory.setHashCode(hashCode);
		factory.setLocationSequence(serviceLocationSequence);
		factory.setTaxId(providerTaxId);
		
		return factory.buildClaim();
	}
	
	public void buildReservedClaimRequestContext(Claim claim){
		requestContext = ReservedClaimRequestContextFactory.buildRequestContext(apiContext, claim);
	}

	public ReservedClaimRequestContext getRequestContext() {
		return requestContext;
	}
	
	public ApiContext getApiContext(){
		return apiContext;
	}
	
	private void mockAccessToken(String taxId, String hashCode, String sequence){
		ServiceLocationConstraint constraint = createServiceLocationConstraint(taxId, hashCode, sequence); 
		Mockito.when(accessToken.getService_location_constraint()).thenReturn(constraint);
	}
	
	private ServiceLocationConstraint createServiceLocationConstraint(String taxId, String hashCode, String sequence) {
		return ServiceLocationConstraintFactory.buildServiceLocationConstraint(hashCode, sequence, taxId);
	}
	
	private void mockApiContextWithAccessToken(){
		Mockito.when(apiContext.getAccessToken()).thenReturn(accessToken);
	}

}
