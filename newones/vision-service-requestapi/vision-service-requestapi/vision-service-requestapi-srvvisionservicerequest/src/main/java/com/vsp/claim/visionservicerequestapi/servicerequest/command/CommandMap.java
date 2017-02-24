package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.util.HashMap;

import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.ClaimKeyBuilderCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;

public class CommandMap extends HashMap<String, Command<?>> {

	private static final long serialVersionUID = 1L;
	
	public static final String RETRIEVE_ELIGBILITY_COMMAND = RetrieveEligibilityCommand.class.getSimpleName(); 
	public static final String RETRIEVE_CLIENT_DIVISION_COMMAND = RetrieveClientDivisionCommand.class.getSimpleName();
	public static final String RETRIEVE_ACCESS_POINT_COMMAND = RetrieveAccessPointCommand.class.getSimpleName();
	public static final String RETRIEVE_MEMBER_POLICY_COMMAND = RetrieveMemberPoliciesCommand.class.getSimpleName();
	public static final String GENERATE_TRACKING_NUMBER_COMMAND = ClaimKeyBuilderCommand.class.getSimpleName();

}
