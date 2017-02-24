package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertServiceClientExceptionWithCause;
import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ProviderNetworkAccessPoints;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.AccessPointCommandRequest;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.client.RestLink;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		AccessPointsServiceClientImplTest.Config.class,
		AccessPointsServiceClientImpl.class
})

//EnableAsync changes SearchAccessPointsServiceClient to spin a new thread to complete "work"
public class AccessPointsServiceClientImplTest {
	
	@Configuration
	static class Config {
		{
			if(!Preferences.initialized()) {
				Preferences.initialize();
			}
		}
	}
	
	@Mock
	private RestClient<Home> mockRestClient;
	
	@Autowired @InjectMocks
	private AccessPointsServiceClient accessPointsServiceClient;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	public void testSuccessfulServiceClientCall() throws Exception {
		AccessPointCommandRequest commandRequest = buildTestCommandRequest();
		mockRestClientBehavior();
		Future<ProviderNetworkAccessPoints> retrievedResult = accessPointsServiceClient.searchAsynchronously(commandRequest);
		assertServiceClientResult(retrievedResult);
	}

	private AccessPointCommandRequest buildTestCommandRequest() {
		AccessPointCommandRequest commandRequest = new AccessPointCommandRequest();
		commandRequest.setProviderTaxId("000001234");
		commandRequest.setServiceLocationHashCode("3333");
		commandRequest.setServiceLocationSequence("1");
		return commandRequest;
	}

	private void mockRestClientBehavior() throws Exception {
		RestLink<ProviderNetworkAccessPoints> mockRestLink = mockAccessPointsRestLink();
		mockRestClientBehavior(mockRestLink);
	}
	
	@SuppressWarnings("unchecked")
	private void mockRestClientGoHomeThrowsException() throws Exception{
		when(mockRestClient.home()).thenThrow(Exception.class);
	}
	
	@SuppressWarnings("unchecked")
	private void mockRestClientBehavior(RestLink<ProviderNetworkAccessPoints> mockRestLink) throws Exception {
		Link<ProviderNetworkAccessPoints> mockAccessPointsLink = mockAccessPointsLink();
		Home mockHome = mockHomeResource(mockAccessPointsLink);
		when(mockRestClient.home()).thenReturn(mockHome);
		when(mockRestClient.link(any(Link.class))).thenReturn(mockRestLink);
	}

	@SuppressWarnings("unchecked")
	private Link<ProviderNetworkAccessPoints> mockAccessPointsLink() {
		return mock(Link.class);
	}

	private Home mockHomeResource(Link<ProviderNetworkAccessPoints> mockAccessPointsLink) {
		Home mockHome = mock(Home.class);
		when(mockHome.getAccesspoints()).thenReturn(mockAccessPointsLink);
		return mockHome;
	}
	
	private ProviderNetworkAccessPoint buildProviderNetworkAccessPoint() {
		ProviderNetworkAccessPoint accessPoint = new ProviderNetworkAccessPoint();
		accessPoint.setProviderNetworkKey(new ProviderNetworkKey("1000"));
		accessPoint.setAccessPointEffectiveDate(new DateMidnight(2016,1,1));
		accessPoint.setNetworkDoctorListEffectiveDate(new DateMidnight(2000,1,1));
		return accessPoint;
	}

	@SuppressWarnings("unchecked")
	private RestLink<ProviderNetworkAccessPoints> mockAccessPointsRestLink() {
		RestLink<ProviderNetworkAccessPoints> mockRestLink = mock(RestLink.class);
		when(mockRestLink.param(anyString(), anyString())).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
        when(mockRestLink.follow()).thenAnswer(new Answer<ProviderNetworkAccessPoints>() {
            @Override
            public ProviderNetworkAccessPoints answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                ProviderNetworkAccessPoints accessPoints = new ProviderNetworkAccessPoints();
                accessPoints.add(buildProviderNetworkAccessPoint());
                return accessPoints;
            }
        });
		return mockRestLink;
	}

	private void assertServiceClientResult(Future<ProviderNetworkAccessPoints> retrievedResult) 
			throws InterruptedException, ExecutionException {
		assertNotNull(retrievedResult);
		ProviderNetworkAccessPoints accessPoints = retrievedResult.get();
		
		String networkId = accessPoints.getAccessPoints().get(0).getProviderNetworkKey().getNetworkId();
		assertTrue(networkId.equals("1000"));
		
		DateMidnight accessPointEffectiveDate = accessPoints.getAccessPoints().get(0).getAccessPointEffectiveDate();
		assertTrue(accessPointEffectiveDate.equals(new DateMidnight(2016,1,1)));
		
		DateMidnight networkDoctorListEffectiveDate = accessPoints.getAccessPoints().get(0).getNetworkDoctorListEffectiveDate();
		assertTrue(networkDoctorListEffectiveDate.equals(new DateMidnight(2000,1,1)));
	}
	
	@Test
	public void testExecutionExceptionWrapsWebApp500Thrown() throws Throwable {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		AccessPointCommandRequest commandRequest = buildTestCommandRequest();
		mockRestClientCallThrowsInternalServerError();
		Future<ProviderNetworkAccessPoints> futureAccessPoints = accessPointsServiceClient.searchAsynchronously(commandRequest);
		futureAccessPoints.get();
	}
	
	@Test
	public void testExecutionExceptionWrapsServiceClientExceptionThrownByRestClientCannotGoHome() throws Throwable {
		createRuleAssertServiceClientExceptionWithCause(thrown, Exception.class);
		AccessPointCommandRequest commandRequest = buildTestCommandRequest();
		mockRestClientGoHomeThrowsException();
		Future<ProviderNetworkAccessPoints> futureAccessPoints = accessPointsServiceClient.searchAsynchronously(commandRequest);
		futureAccessPoints.get();
	}

	private void mockRestClientCallThrowsInternalServerError() throws Exception {
		RestLink<ProviderNetworkAccessPoints> mockRestLink = mockAccessPointsRestLinkThatThrowInternalServerError();
		mockRestClientBehavior(mockRestLink);
	}

	@SuppressWarnings("unchecked")
	private RestLink<ProviderNetworkAccessPoints> mockAccessPointsRestLinkThatThrowInternalServerError() {
		RestLink<ProviderNetworkAccessPoints> mockRestLink = mock(RestLink.class);
		when(mockRestLink.param(anyString(), anyString())).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
		when(mockRestLink.follow()).thenThrow(new WebApplicationException(500));
		return mockRestLink;
	}

}
