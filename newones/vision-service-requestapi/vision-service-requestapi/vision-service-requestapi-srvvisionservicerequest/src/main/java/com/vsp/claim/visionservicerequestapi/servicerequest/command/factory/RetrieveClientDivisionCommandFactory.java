package com.vsp.claim.visionservicerequestapi.servicerequest.command.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveClientDivisionCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.ClientDivisionServiceClient;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;

public abstract class RetrieveClientDivisionCommandFactory implements CommandFactory {
	
	@Autowired
	private ClientDivisionServiceClient serviceClient; 

	@Override
	public Command buildCommand() {
		return createRetrieveClientDivisionCommand(); 
	}
	
	protected abstract RetrieveClientDivisionCommand createRetrieveClientDivisionCommand(); 

}
