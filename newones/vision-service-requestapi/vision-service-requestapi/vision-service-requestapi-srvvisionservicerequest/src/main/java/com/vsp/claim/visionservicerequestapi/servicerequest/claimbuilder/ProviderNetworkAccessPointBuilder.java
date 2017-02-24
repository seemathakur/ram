package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveAccessPointCommand;

public class ProviderNetworkAccessPointBuilder {
	
	private CommandMap commandMap;
	
	public ProviderNetworkAccessPointBuilder(CommandMap commandMap) {
		this.commandMap = commandMap; 
	}

	public ProviderNetworkAccessPoint buildProviderNetworkAccessPoint() {
		return getProviderNetworkAccessPoint();
	}

	protected ProviderNetworkAccessPoint getProviderNetworkAccessPoint() {
		RetrieveAccessPointCommand accessPointCommand = getProviderNetworkAccessPointCommand();
		return accessPointCommand.getReturnValue();
	}
	
	protected RetrieveAccessPointCommand getProviderNetworkAccessPointCommand() {
		return (RetrieveAccessPointCommand)commandMap.get(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND);
	}

}
