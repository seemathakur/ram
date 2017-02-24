package com.vsp.claim.visionservicerequestapi.shared.command;

public interface UncheckedExceptionCommand<ReturnType> extends Command<ReturnType>{
	ReturnType getReturnValue();
}
