package com.vsp.claim.visionservicerequestapi.shared.command;

import com.vsp.claim.visionservicerequestapi.shared.exception.CommandException;

public interface CheckedExceptionCommand<ReturnType> extends Command<ReturnType> {
	
	ReturnType getReturnValue() throws CommandException;
	
}
