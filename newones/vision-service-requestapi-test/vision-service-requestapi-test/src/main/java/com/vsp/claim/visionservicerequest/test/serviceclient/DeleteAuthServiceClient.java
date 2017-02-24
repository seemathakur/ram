package com.vsp.claim.visionservicerequest.test.serviceclient;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.vsp.bl.claim.service.authorization.Authorization;
import com.vsp.bl.claim.service.authorization.AuthorizationServiceLocator;
import com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest;
import com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse;
import com.vsp.bl.service.helper.v001.ServiceMessage;

public class DeleteAuthServiceClient {
	private static AuthorizationServiceLocator serviceLocator = new AuthorizationServiceLocator();
	private Authorization service;
	
	private DeleteAuthorizationRequest request; 
	
	public DeleteAuthServiceClient(DeleteAuthorizationRequest request) throws Exception{
		try {
			service = serviceLocator.getAuthorization();
			this.request = request;
		} catch (ServiceException e) {
			throw new Exception("Failed to get Authorization stub.");
		}
	}
	
	public void deleteAuthorization() throws Exception{
		DeleteAuthorizationResponse response = callDeleteAuthorization() ; 
		validateServiceResponse(response); 
	}
	
	private DeleteAuthorizationResponse callDeleteAuthorization() throws Exception {
		DeleteAuthorizationResponse response = new DeleteAuthorizationResponse();
		try {
			response = service.deleteAuthorization(request);
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new Exception("Error calling authorization service at url: " 
					+ serviceLocator.getAuthorizationAddress(), e);
		}
		return response;
	}
	
	private void validateServiceResponse(DeleteAuthorizationResponse response) throws Exception{
		if(response == null) {
			throw new Exception("Authorization service returned a null response for request: '" 
					+ request.getBusinessTransactionId() 
					+ "' hitting url: " 
					+ serviceLocator.getAuthorizationAddress());
		}
		if(response.getErrorCount() > 0) {
			ServiceMessage[] errors = response.getErrorMessageList();
			String errorMessage = "Errors were returned from Authorization service for request: '"
					+ request.getBusinessTransactionId()
					+ "' hitting url: "
					+ serviceLocator.getAuthorizationAddress()
					+ "\n";
			for(ServiceMessage error : errors) {
				errorMessage = errorMessage + makeMessage(error);
			}
			throw new Exception(errorMessage);
		}
	}
	
	private String makeMessage(ServiceMessage message) {
		String toReturn = "";
		toReturn = message.getId() 
				+ ": " 
				+ message.getDetail() 
				+ ": " 
				+ message.getDescription() 
				+ "\n";
		return toReturn;
	}
}
