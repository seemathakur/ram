package com.vsp.claim.visionservicerequestapi.servicerequest.command.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.ClaimKeyBuilderCommand;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.ClaimKeyDao;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;

@Service("trackingNumberBuilderCommandFactory")
public class TrackingNumberBuilderCommandFactory implements CommandFactory{
	
	@Autowired
	private ClaimKeyDao claimKeyDao;

	public Command buildCommand() {
		return new ClaimKeyBuilderCommand(claimKeyDao);
	}
	
}
