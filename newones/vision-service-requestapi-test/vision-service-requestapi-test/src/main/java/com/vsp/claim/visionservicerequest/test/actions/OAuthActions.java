package com.vsp.claim.visionservicerequest.test.actions;

import com.vsp.il.test.jbehave.rest.actions.GivenActions;
import com.vsp.il.test.jbehave.rest.impl.RestActionsImpl;
import com.vsp.il.util.Preferences;
import com.vspglobal.ipa.jaxrs.oauth2.UserPasswordAccessTokenProvider;

public class OAuthActions {
	
	private GivenActions givenActions;
	private RestActionsImpl restAction;
	
	private static final String PING_TOKEN_PROVIDER = "ping"; 
	private static final String SPRING_TOKEN_PROVIDER = "spring"; 
	
	public OAuthActions(GivenActions givenActionsImpl, RestActionsImpl restAction) {
		this.givenActions = givenActionsImpl;
		this.restAction = restAction;
	}
	
	
	public void authenticateApiTest() {
		authenticateWithSpring("preclaimapi-test");
	}
	
	public void authenticateEyeconic() {
		authenticateWithSpring("eyeconic-batch");
	}
	
	public void authenticateWithSpring(String applicationId) {
		resetRestClient();
		swapTokenUriProvider(SPRING_TOKEN_PROVIDER);
		givenActions.auth(applicationId);
	}
	
	public void authenticateUserPasswordSpringCredentials(String doctorID, String doctorPW){
		resetRestClient();
		swapTokenUriProvider(SPRING_TOKEN_PROVIDER);
		System.out.println("Logged in with: " + doctorID + " & " + doctorPW); 
		givenActions.auth(doctorID, doctorPW);
	}
	
	public void authenticateVSPRetailUserPasswordTokenProvider(String username, String password) {
		resetRestClient();
		swapTokenUriProvider(PING_TOKEN_PROVIDER);
		System.out.println("Logged in with: " + username + " & " + password); 
		setUserPasswordAccessTokenProvider(username, password); 
	}

	private void setUserPasswordAccessTokenProvider(String username, String password) {
		UserPasswordAccessTokenProvider tokenProvider = UserPasswordAccessTokenProvider.get(
				Preferences.get("oauth-credentials","2020-test.client_id"), 
				Preferences.get("oauth-credentials","2020-test.client_secret"), username, password,  
				Preferences.getList("oauth-credentials","2020-test.authScopes").toArray(new String [0]));
		
		restAction.setAccessTokenProvider(tokenProvider);
	}
	
	@SuppressWarnings("rawtypes")
	private void resetRestClient(){
		restAction.setAccessTokenProvider(null);
	}
	
	private void swapTokenUriProvider(String tokenProvider){
		System.out.println("The token.uri was " + Preferences.get("rest","token.uri")); 
		
		Preferences.set("rest", "token.uri", Preferences.get("rest","token." + tokenProvider));
		
		System.out.println("The token.uri is now " + Preferences.get("rest","token.uri"));
	}

}
