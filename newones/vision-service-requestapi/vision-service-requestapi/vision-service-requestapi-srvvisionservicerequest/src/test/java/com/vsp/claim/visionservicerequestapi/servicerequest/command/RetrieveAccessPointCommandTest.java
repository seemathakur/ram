package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.scheduling.annotation.AsyncResult;

import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.Doctor;
import com.vsp.api.provider.model.DoctorKey;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ProviderNetworkAccessPoints;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.AccessPointCommandRequest;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.AccessPointCommandRequestBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.AccessPointsServiceClientImpl;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.AccessToken;
import com.vsp.oauth.ServiceLocationConstraint;

public class RetrieveAccessPointCommandTest {
	
	private static final ProviderNetworkKey VSP_NETWORK = new ProviderNetworkKey("1000");
	private static final String VSP_STREET_NUMBER = "3333";
	private static final String TEST_PROVIDER_TAX_ID = "5555551235";
	private static final String SEQUENCE_ONE = "1";
	private static final String TEST_PHONE_NUMBER = "0123456789";
	private static final String NATIONAL_PROVIDER_ID_ONES = "1111111111";
	private static final String NATIONAL_PROVIDER_ID_TWOS = "2222222222";
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Mock
	private AccessPointsServiceClientImpl serviceClient;
	@Mock
	private AccessPointCommandRequestBuilder requestBuilder;
	
	@InjectMocks
	private RetrieveAccessPointCommand command;
	
	@Before
	public void setUp() {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		initMocks(this);
	}
	
	@Test
	public void testSuccessfulCommandOneDoctor() throws Exception {
		VisionServiceRequestApiContext testContext = buildTestRequestContext();
		mockServiceClient(1);
		ProviderNetworkAccessPoint accessPointResult = getAccessPointFromCommand(testContext);
		assertAccessPointResult(accessPointResult);
	}
	
	@Test
	public void testSuccessfulCommandTwoDoctors() throws Exception {
		VisionServiceRequestApiContext testContext = buildTestRequestContext();
		mockServiceClient(2);
		ProviderNetworkAccessPoint accessPointResult = getAccessPointFromCommand(testContext);
		assertAccessPointResult(accessPointResult);
	}

	private VisionServiceRequestApiContext buildTestRequestContext() {
		ApiContext mockContext = mockServiceLocationContext();
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(mockContext);
		return context;
	}

	private ApiContext mockServiceLocationContext() {
		AccessToken serviceLocationAccessToken = buildServiceLocationAccessToken();
		ApiContext mockApiContext = mock(ApiContext.class);
		when(mockApiContext.getAccessToken()).thenReturn(serviceLocationAccessToken);
		return mockApiContext;
	}

	private AccessToken buildServiceLocationAccessToken() {
		ServiceLocationConstraint constraint = buildServiceLocationConstraint();
		AccessToken mockToken = mock(AccessToken.class);
		when(mockToken.getService_location_constraint()).thenReturn(constraint);
		return mockToken;
	}

	private ServiceLocationConstraint buildServiceLocationConstraint() {
		MockServiceLocationConstraint constraint = new MockServiceLocationConstraint();
		constraint.setService_location_hash_code(VSP_STREET_NUMBER);
		constraint.setProviderTaxId(TEST_PROVIDER_TAX_ID);
		constraint.setService_location_sequence(SEQUENCE_ONE);
		return constraint;
	}

	private void mockServiceClient(int numberOfDoctors) throws Exception {
		ProviderNetworkAccessPoints testAccessPointsResult = buildTestAccessPoints(numberOfDoctors);
		when(serviceClient.searchAsynchronously(any(AccessPointCommandRequest.class)))
			.thenReturn(new AsyncResult<ProviderNetworkAccessPoints>(testAccessPointsResult));
	}

	private void mockServiceClientAccessPointNotFound() throws Exception {
		ProviderNetworkAccessPoints testAccessPointsResult = new ProviderNetworkAccessPoints();
		when(serviceClient.searchAsynchronously(any(AccessPointCommandRequest.class)))
			.thenReturn(new AsyncResult<ProviderNetworkAccessPoints>(testAccessPointsResult));
	}

	private ProviderNetworkAccessPoints buildTestAccessPoints(int numberOfDoctors) {
		ProviderNetworkAccessPoints testResult = new ProviderNetworkAccessPoints();
		testResult.add(buildAccessPoint(NATIONAL_PROVIDER_ID_ONES));
		if(numberOfDoctors == 2) {
			testResult.add(buildAccessPoint(NATIONAL_PROVIDER_ID_TWOS));
		}
		return testResult;
	}

	private ProviderNetworkAccessPoint buildAccessPoint(String nationalProviderId) {
		ProviderNetworkAccessPoint accessPoint = new ProviderNetworkAccessPoint();
		accessPoint.setServiceLocation(new ServiceLocation());
		accessPoint.setDoctor(buildTestDoctor(nationalProviderId));
		accessPoint.setProviderNetworkKey(VSP_NETWORK);
		return accessPoint;
	}

	private Doctor buildTestDoctor(String nationalProviderId) {
		Doctor doctor = new Doctor();
		doctor.setPhone(TEST_PHONE_NUMBER);
		doctor.setNationalProviderId(nationalProviderId);
		doctor.setKey(new DoctorKey());
		return doctor;
	}

	private ProviderNetworkAccessPoint getAccessPointFromCommand(VisionServiceRequestApiContext testContext) 
			throws Exception {
		command.buildRequest(testContext);
		command.run();
		return command.getReturnValue();
	}

	private void assertAccessPointResult(ProviderNetworkAccessPoint accessPointResult) {
		assertNotNull(accessPointResult);
		assertNotNull(accessPointResult.getServiceLocation());
		assertEquals(VSP_NETWORK, accessPointResult.getProviderNetworkKey());
		Doctor expectedDoctor = buildExpectedDoctor();
		assertEquals(expectedDoctor.getPhone(), accessPointResult.getDoctor().getPhone());
		assertNull(expectedDoctor.getKey());
		assertNull(expectedDoctor.getNationalProviderId());
	}
	
	private Doctor buildExpectedDoctor() {
		Doctor doctor = new Doctor();
		doctor.setPhone(TEST_PHONE_NUMBER);
		return doctor;
	}
	
	@Test
	public void testNoServiceLocationThrowsHTTP404() throws Exception {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.NOT_FOUND.getStatusCode());
		VisionServiceRequestApiContext testContext = buildTestRequestContext();
		mockServiceClientAccessPointNotFound();
		getAccessPointFromCommand(testContext);
	}
	
	@Test
	public void testBubblesUpWebApplicationException() throws Exception {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		VisionServiceRequestApiContext testContext = buildTestRequestContext();
		mockServiceClientThrowsWebApplicationExceptionWrappedInExecutionException(testContext);
		ProviderNetworkAccessPoint accessPointResult = getAccessPointFromCommand(testContext);
		assertAccessPointResult(accessPointResult);
	}
	
	@Test
	public void testServiceClientExceptionTransformsToWebAppException() throws Exception {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		VisionServiceRequestApiContext testContext = buildTestRequestContext();
		mockServiceClientThrowsServiceClientException(testContext);
		ProviderNetworkAccessPoint accessPointResult = getAccessPointFromCommand(testContext);
		assertAccessPointResult(accessPointResult);

	}

	@SuppressWarnings("unchecked")
	private void mockServiceClientThrowsWebApplicationExceptionWrappedInExecutionException(VisionServiceRequestApiContext requestContext) throws Exception {
		Future<ProviderNetworkAccessPoints> result = mock(Future.class);
		AccessPointCommandRequest request = new AccessPointCommandRequest();
		when(result.get()).thenThrow(new ExecutionException(new InternalServerErrorException()));
		when(serviceClient.searchAsynchronously(any(AccessPointCommandRequest.class))).thenReturn(result);
	}

	@SuppressWarnings("unchecked")
	private void mockServiceClientThrowsServiceClientException(VisionServiceRequestApiContext requestContext) throws Exception {
		Future<ProviderNetworkAccessPoints> result = mock(Future.class);
		AccessPointCommandRequest request = new AccessPointCommandRequest();
		when(serviceClient.searchAsynchronously(any(AccessPointCommandRequest.class))).thenThrow(new ServiceClientException("", request, new InternalServerErrorException()));
	}
}
