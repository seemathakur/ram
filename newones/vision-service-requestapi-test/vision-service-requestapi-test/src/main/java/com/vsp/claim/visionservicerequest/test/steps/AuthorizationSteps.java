package com.vsp.claim.visionservicerequest.test.steps;

import org.jbehave.core.annotations.Given;

import com.vsp.claim.visionservicerequest.test.actions.AuthorizationActions;
import com.vsp.claim.visionservicerequest.test.util.StoryStateHelper;

public class AuthorizationSteps{
	
	private AuthorizationActions actions; 
	
	public AuthorizationSteps() {
		actions = new AuthorizationActions(); 
	}
	
		
	@Given("the patient has an outstanding auth for $benefitType with services $services "
			+ "as of $dateToken")
	public void outstandingAuths(String benefitType, String services, String dateToken) 
			throws Exception {
		String authNumber = "";
		try {
			authNumber = actions.issueAuthForPatient(benefitType, services, dateToken);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error creating past history.", e);
		}
		
		StoryStateHelper.addOutstandingAuthorization(authNumber);
	}		
}
