package com.vsp.claim.visionservicerequest.test.actions;

import org.joda.time.DateMidnight;

import com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey;
import com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest;
import com.vsp.bl.claim.service.authorization.IssueAuthorizationRequest;
import com.vsp.bl.consumer.dto.member.v001.SubscriberKey;
import com.vsp.claim.visionservicerequest.test.request.CreateHistoryRequest;
import com.vsp.claim.visionservicerequest.test.request.CreateHistoryRequestBuilder;
import com.vsp.claim.visionservicerequest.test.request.DeleteAuthorizationRequestBuilder;
import com.vsp.claim.visionservicerequest.test.serviceclient.DeleteAuthServiceClient;
import com.vsp.claim.visionservicerequest.test.serviceclient.IssueAuthServiceClient;
import com.vsp.claim.visionservicerequest.test.serviceclient.IssueAuthorizationRequestBuilder;
import com.vsp.claim.visionservicerequest.test.util.DateParse;


public class AuthorizationActions {
	
	private static final String EMPTY_STRING = "";


	public AuthorizationActions() {
	}
	
	public String issueAuthForPatient(String benefitType, String services, String dateToken) throws Exception {
		String authorizationNumber = EMPTY_STRING;
		DateMidnight asOfDate = DateParse.parse(dateToken);
		
		CreateHistoryRequest request = CreateHistoryRequestBuilder.buildCreateHistoryRequest(benefitType, services, asOfDate); 
		IssueAuthorizationRequest soapRequest = new IssueAuthorizationRequestBuilder().buildIssueAuthorizationRequest(request);
		AuthorizationKey authKey = new IssueAuthServiceClient(soapRequest).issueAuthorization();
		logRequestAndResponse(authKey, soapRequest);
		
		return authorizationNumber;
	}
	
	
	private void logRequestAndResponse(AuthorizationKey authKey, IssueAuthorizationRequest soapRequest) {
		String authorizationNumber = EMPTY_STRING;
		
		String patientName = soapRequest.getMemberName().getFirstName() + " " + soapRequest.getMemberName().getLastName(); 
		SubscriberKey key = soapRequest.getMemberKey().getSubscriberKey();
		String subscriberKey = key.getClientId() + "-" + key.getDivisionId() + "-" + key.getSubscriberId();
		
		authorizationNumber = authKey.getAuthorizationKey().toString();
		
		System.out.println("claim-preclaimapi-test issued legacy authorization #" + authorizationNumber + " for " + patientName + " key:" + subscriberKey); 
		
		
	}

	public void deleteAuthorization(String authorizationNumber) throws Exception{
		DeleteAuthorizationRequest request = DeleteAuthorizationRequestBuilder.createDeleteAuthRequest(authorizationNumber); 
		DeleteAuthServiceClient client = new DeleteAuthServiceClient(request);
		client.deleteAuthorization();
		System.out.println("claim-preclaimapi-test deleted legacy authorization #" + authorizationNumber + " from using authorization business service");
	}
	
}
