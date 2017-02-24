package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.startServiceInvocationLogEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.stopServiceInvocationLogEvent;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.api.provider.ProviderNetworkAccessPointResource;
import com.vsp.api.provider.model.ProviderNetworkAccessPoints;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.AccessPointCommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEvent;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;

@Service("AccessPointsServiceClient")
@Scope("prototype")
public class AccessPointsServiceClientImpl implements AccessPointsServiceClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccessPointsServiceClientImpl.class);
	private RestClient<Home> restClient;
	private AccessPointCommandRequest commandRequest;
	
	
	@Async
	@Override
    public Future<ProviderNetworkAccessPoints> searchAsynchronously(AccessPointCommandRequest commandRequest) throws ServiceClientException { 
		this.commandRequest = commandRequest;
		ProviderNetworkAccessPoints accessPoints = invokeProviderNetworkResourceWithUncaughtException();
		return new AsyncResult<ProviderNetworkAccessPoints>(accessPoints);
	}
		
	private ProviderNetworkAccessPoints invokeProviderNetworkResourceWithUncaughtException() throws ServiceClientException {
		ServiceInvocationEvent timerEvent = startServiceInvocationLogEvent(ProviderNetworkAccessPointResource.class.getSimpleName(), HttpMethod.GET, LOG);
		Link<ProviderNetworkAccessPoints> accessPointsLink = getAccessPointsLinkFromHome();
		ProviderNetworkAccessPoints accessPoints = followAccessPointsLink(accessPointsLink);
		stopServiceInvocationLogEvent(LOG, timerEvent);
		return accessPoints;
	}

	private ProviderNetworkAccessPoints followAccessPointsLink(Link<ProviderNetworkAccessPoints> accessPointsLink) {
		return restClient.link(accessPointsLink)
		.param("providertaxid", commandRequest.getProviderTaxId())
		.param("servicelocationhashcode", commandRequest.getServiceLocationHashCode())
		.param("servicelocationsequence", commandRequest.getServiceLocationSequence())			
		.param("networkid", commandRequest.getNetworkId())			
		.method(HttpMethod.GET)
		.follow();
	}

	private Link<ProviderNetworkAccessPoints> getAccessPointsLinkFromHome() throws ServiceClientException {
		try {
			return restClient.home().getAccesspoints();
		}catch (Exception e) {
			throw new ServiceClientException("Exception calling restClient.home() to retrieve accesspoints link", e);
		}
	}

	@Override
	public RestClient<Home> getRestClient() {
		return restClient;
	}

	@Override
	public void setRestClient(RestClient<Home> restClient) {
		this.restClient = restClient;
	}

}
