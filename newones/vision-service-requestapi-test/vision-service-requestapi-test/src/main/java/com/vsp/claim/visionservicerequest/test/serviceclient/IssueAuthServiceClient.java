package com.vsp.claim.visionservicerequest.test.serviceclient;

import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey;
import com.vsp.bl.claim.service.authorization.Authorization;
import com.vsp.bl.claim.service.authorization.AuthorizationServiceLocator;
import com.vsp.bl.claim.service.authorization.IssueAuthorizationRequest;
import com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse;
import com.vsp.bl.service.helper.v001.ServiceMessage;

public class IssueAuthServiceClient {
	
	private static AuthorizationServiceLocator serviceLocator = new AuthorizationServiceLocator();
	private Authorization service;
	
	private IssueAuthorizationRequest request;
	
	public IssueAuthServiceClient(IssueAuthorizationRequest request) throws Exception {
		try {
			service = serviceLocator.getAuthorization(new URL("http://wasacpt.vsp.com/eligibility.auth_8.0/services/Authorization"));
			this.request = request;
		} catch (ServiceException e) {
			throw new Exception("Failed to get Authorization stub.");
		}
	}
	
	public AuthorizationKey issueAuthorization() 
			throws Exception {
		AuthorizationKey authKey = new AuthorizationKey();
		IssueAuthorizationResponse response = callIssueAuthorization();
		authKey = extractAuthKey(response);
		return authKey;
	}
	
	private IssueAuthorizationResponse callIssueAuthorization() throws Exception {
		IssueAuthorizationResponse response = new IssueAuthorizationResponse();
		try {
			response = service.issueAuthorization(request);
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new Exception("Error calling authorization service at url: " 
					+ serviceLocator.getAuthorizationAddress(), e);
		}
		return response;
	}

	private AuthorizationKey extractAuthKey(IssueAuthorizationResponse response) throws Exception {
		AuthorizationKey authKey = new AuthorizationKey();
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
		authKey = response.getAuthorizationKey();
		return authKey;
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
