package com.vsp.claim.visionservicerequest.test.request;

import com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey;
import com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest;
import com.vsp.il.util.Preferences;

public class DeleteAuthorizationRequestBuilder {
	public static DeleteAuthorizationRequest createDeleteAuthRequest(String authorizationNumber){
		AuthorizationKey authorizationKey = new AuthorizationKey(
				Integer.parseInt(authorizationNumber)); 

        String businessTransactionId = "deleteAuthorization :" + authorizationNumber; 
        String requesterProcessName = Preferences.getApplication(); 
        
        String comment = "Clean up for claim-preclaimapi-test";

		DeleteAuthorizationRequest request = new DeleteAuthorizationRequest();
		request.setAuthorizationKey(authorizationKey);
		request.setComments(comment);
		request.setBusinessTransactionId(businessTransactionId);
		request.setRequesterProcessName(requesterProcessName);
		
		return request; 
	}

}
