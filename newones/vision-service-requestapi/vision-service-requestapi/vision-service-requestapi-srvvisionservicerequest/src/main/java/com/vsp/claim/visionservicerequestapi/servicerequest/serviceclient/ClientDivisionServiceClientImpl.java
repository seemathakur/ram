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

import com.vsp.api.client.ClientDivisionResource;
import com.vsp.api.client.model.ClientDivision;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveClientDivisionCommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEvent;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.link.LinkBuilder;
import com.vsp.oauth.AccessToken;

@Service("clientDivisionServiceClient")
@Scope("prototype")
public class ClientDivisionServiceClientImpl implements ClientDivisionServiceClient {

	private RestClient<Home> restClient;
	private static final Logger LOG = LoggerFactory.getLogger(ClientDivisionServiceClientImpl.class);
	
	public ClientDivisionServiceClientImpl() {
	}

	@Async
	@Override
	public Future<ClientDivision> retrieveClientDivision(CommandRequest request) {
		ClientDivision clientDivision = new ClientDivision();
		RetrieveClientDivisionCommandRequest divClassReq = (RetrieveClientDivisionCommandRequest)request; 
		Link<ClientDivision> clientDivisionLink = buildClientDivisionLink(divClassReq);
		clientDivision = retrieveClientDivision(clientDivisionLink, request);
		return new AsyncResult<ClientDivision>(clientDivision);
	}

	protected Link<ClientDivision> buildClientDivisionLink(CommandRequest request) {
		RetrieveClientDivisionCommandRequest clientRequest = (RetrieveClientDivisionCommandRequest)request; 
		LinkBuilder.resource(ClientDivisionResource.class)
			.link(clientRequest, "retrieveClientDivision")
			.retrieveClientDivision(clientRequest.getClientId(), 
					clientRequest.getDivisionId(), 
					clientRequest.getAsOfDate(),
					null);
		return clientRequest.getRetrieveClientDivision();
	}
	
	protected ClientDivision retrieveClientDivision(Link<ClientDivision> clientDivisionLink, CommandRequest request) {
		ServiceInvocationEvent timerEvent = startServiceInvocationLogEvent(ClientDivisionResource.class.getSimpleName(), HttpMethod.GET, LOG);
		ClientDivision clientDivision = callClientDivisionResource(clientDivisionLink, request);
		stopServiceInvocationLogEvent(LOG, timerEvent);
		return clientDivision;
	}
	
	protected ClientDivision callClientDivisionResource(Link<ClientDivision> clientDivisionLink, CommandRequest request) {
		AccessToken clientToken = ((RetrieveClientDivisionCommandRequest) request).getAccessToken();		
		return restClient.link(clientDivisionLink)
				.type(ClientDivision.class)
				.runas(clientToken)
				.method(HttpMethod.GET)
				.follow();
	}

	@Override
	public void setRestClient(RestClient<Home> restClient) {
		this.restClient = restClient; 
	}

	@Override
	public RestClient<Home> getRestClient() {
		return restClient; 
	}
	
}
