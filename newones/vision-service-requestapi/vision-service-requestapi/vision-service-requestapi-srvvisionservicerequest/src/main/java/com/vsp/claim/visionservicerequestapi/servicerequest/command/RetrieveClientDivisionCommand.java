package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.client.model.ClientDivision;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveClientDivisionCommandRequestBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.ClientDivisionServiceClient;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.RetrieveCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.UncheckedExceptionCommand;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;
import com.vsp.jaxrs.client.RestClient;

public class RetrieveClientDivisionCommand extends RetrieveCommand implements UncheckedExceptionCommand<ClientDivision>, RestCommand, Requestable {

	private static final Logger LOG = LoggerFactory.getLogger(RetrieveClientDivisionCommand.class);	

	@Autowired
	private ClientDivisionServiceClient clientDivisionServiceClient;

	private Future<ClientDivision> returnValue;

	public RetrieveClientDivisionCommand() {
		super(CommandMap.RETRIEVE_CLIENT_DIVISION_COMMAND, "Retrieve client division");
	}

	@Override
	public void run() {
		validateRequestIsNotNull();	
		retrieveClient();
	}

	private void retrieveClient() {
		returnValue = clientDivisionServiceClient.retrieveClientDivision(getRequest());
	}

	@Override
	public ClientDivision getReturnValue() {
		return getValidatedResponse();	
	}

	private ClientDivision getValidatedResponse() {
		ClientDivision serviceClientResponse = null;
		try {
			serviceClientResponse = returnValue.get();
			DebugLogger.debugEnabled(LOG, "Future returns after get(): Before validateResponseIsNotNull()");
		} catch (InterruptedException | ExecutionException e) {
			handleException(e);
		}
		validateResponseIsNotNull(serviceClientResponse);
		return serviceClientResponse;
	}
	
	@Override
	public void buildRequest(VisionServiceRequestApiContext context) {
		setRequest(RetrieveClientDivisionCommandRequestBuilder.buildRequest(context));
	}

	@Override
	public String toString() {
		return getCommandMapName();
	}

	@Override
	public void initializeServiceClient(RestClient<Home> restClient) {
		clientDivisionServiceClient.setRestClient(restClient);
	}

	@Override
	public RestServiceClient getServiceClient() {
		return clientDivisionServiceClient;
	}
}
