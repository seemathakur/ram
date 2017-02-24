package com.vsp.claim.visionservicerequestapi.servicerequest.command.factory;

import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveAccessPointCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;

public abstract class RetrieveAccessPointCommandFactory implements CommandFactory{

	@Override
	public Command buildCommand() {
		return createAccessPointCommand();
	}
		
	protected abstract RetrieveAccessPointCommand createAccessPointCommand(); 

}
