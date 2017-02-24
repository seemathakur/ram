package com.vsp.claim.visionservicerequestapi.servicerequest.command.factory;

import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveEligibilityCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;

public abstract class RetrieveEligibilityCommandFactory implements CommandFactory {
	
	@Override
	public Command buildCommand() {
		return createRetrieveEligibilityCommand();
	}
	
	protected abstract RetrieveEligibilityCommand createRetrieveEligibilityCommand(); 

}
