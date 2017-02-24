package com.vsp.claim.visionservicerequestapi.servicerequest.command.factory;

import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;


public abstract class RetrieveMemberPolicyCommandFactory implements CommandFactory {

	@Override
	public Command buildCommand() {
		return createRetrieveMemberPoliciesCommand();
	}

	protected abstract RetrieveMemberPoliciesCommand createRetrieveMemberPoliciesCommand(); 
}
