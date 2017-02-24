package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.home.model.Home;
import com.vsp.api.provider.model.Doctor;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ProviderNetworkAccessPoints;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.AccessPointCommandRequest;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.AccessPointCommandRequestBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.AccessPointsServiceClient;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.RetrieveCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.UncheckedExceptionCommand;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;
import com.vsp.jaxrs.client.RestClient;

public class RetrieveAccessPointCommand extends RetrieveCommand implements UncheckedExceptionCommand<ProviderNetworkAccessPoint>, RestCommand, Requestable {
	
	private static final Logger LOG = LoggerFactory.getLogger(RetrieveAccessPointCommand.class);
	
	@Autowired
	private AccessPointsServiceClient serviceClient;
	
	private Future<ProviderNetworkAccessPoints> returnValue;
	
	public RetrieveAccessPointCommand() {
		super(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND, "Retrieve access point");
	}
	
	@Override
	public void run() {
		if(isServiceLocationKeyOnCommandRequest()) {
			searchAccessPoints((AccessPointCommandRequest)getRequest()); 
		}
	}

	private void searchAccessPoints(AccessPointCommandRequest request) {
		try {
			returnValue = serviceClient.searchAsynchronously(request);
		} catch (ServiceClientException e) {
			setSynchronousException(e);
		}
	}

	private boolean isServiceLocationKeyOnCommandRequest() {
		AccessPointCommandRequest request = (AccessPointCommandRequest) getRequest();
		return request.getProviderTaxId() != null 
				|| request.getServiceLocationHashCode() != null
				|| request.getServiceLocationSequence() != null;
	}

	@Override
	public ProviderNetworkAccessPoint getReturnValue(){
		ProviderNetworkAccessPoints accessPoints = getReturnValueFromFuture();
		checkReturnValue(accessPoints);
		
		ProviderNetworkAccessPoint accessPoint = getAccessPointToReturn(accessPoints);
		
		if(isMultipleDoctorOffice(accessPoints)) {
			LOG.info("Retrieved multiple offices remove all doctor info except phone number");
			removeAllDoctorInfoExceptPhoneNumber(accessPoint);
		}
		return accessPoint;
	}
	

	private boolean isMultipleDoctorOffice(ProviderNetworkAccessPoints accessPoints) {
		return accessPoints.getAccessPoints().size() > 1;
	}

	private void checkReturnValue(ProviderNetworkAccessPoints accessPoints) {
		AccessPointCommandRequest request = (AccessPointCommandRequest) getRequest();
		if(accessPoints.getAccessPoints().size() == 0) {
			String errorMessage = "No ProviderNetworkAccessPoint for request " + request.toString();
			LOG.error(errorMessage);
			throw new NotFoundException(new Throwable(errorMessage));
		}				
	}

	private ProviderNetworkAccessPoints getReturnValueFromFuture() {
		ProviderNetworkAccessPoints accessPoints = null;
		try {
			throwAnySynchronousException();
			accessPoints = returnValue.get();
		}catch(ExecutionException | ServiceClientException | InterruptedException exception) {
			handleException(exception);
		}
		
		return accessPoints;
	}

	private ProviderNetworkAccessPoint getAccessPointToReturn(ProviderNetworkAccessPoints accessPoints) {
		ProviderNetworkAccessPoint accessPointToReturn = null;
		if(accessPoints.getAccessPoints().size() > 0){
			accessPointToReturn = accessPoints.getAccessPoints().get(0);
		}
		
		return accessPointToReturn;
	}

	private void removeAllDoctorInfoExceptPhoneNumber(ProviderNetworkAccessPoint accessPoint) {
		Doctor newDoctorObject = new Doctor();
		Doctor accessPointDoctor = accessPoint.getDoctor();
		if(accessPointDoctor != null) {
			newDoctorObject.setPhone(accessPointDoctor.getPhone());
		}
		accessPoint.setDoctor(newDoctorObject);
	}

	@Override
	public void buildRequest(VisionServiceRequestApiContext context) {
		setRequest(new AccessPointCommandRequestBuilder().buildRequest(context));
	}

	@Override
	public void initializeServiceClient(RestClient<Home> restClient) {
		serviceClient.setRestClient(restClient);
	}

	@Override
	public RestServiceClient getServiceClient() {
		return serviceClient;
	}
	
	@Override
	public String toString(){
		return CommandMap.RETRIEVE_ACCESS_POINT_COMMAND; 
	}

}
