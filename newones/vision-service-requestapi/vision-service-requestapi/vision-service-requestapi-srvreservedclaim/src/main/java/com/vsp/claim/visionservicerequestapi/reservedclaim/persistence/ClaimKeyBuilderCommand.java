package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.ClaimKey;
import com.vsp.claim.visionservicerequestapi.shared.command.UncheckedExceptionCommand;
import com.vsp.claim.visionservicerequestapi.shared.exception.CommandExceptionHandler;
import com.vsp.claim.visionservicerequestapi.shared.exception.CommandExceptionHandlerFactory;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimUtil;

public class ClaimKeyBuilderCommand implements UncheckedExceptionCommand<ClaimKey> {
	
	private ClaimKeyDao claimKeyDao; 
	
	private static final Logger LOG = LoggerFactory.getLogger(ClaimKeyBuilderCommand.class);
	
	private static final String DEFAULT_CLM_EXT_NBR = "00"; 
	
	private ClaimKey returnValue;
	
	public ClaimKeyBuilderCommand(ClaimKeyDao claimKeyDao){
		this.claimKeyDao = claimKeyDao;
	}

	@Override
	public void run() {
		try {
			returnValue = buildClaimKey();
		} catch(Exception exception) {
			handleClaimBuilderException(exception);
		}
	}
	
	private void handleClaimBuilderException(Exception exception) {
		CommandExceptionHandler handler = CommandExceptionHandlerFactory.getExceptionHandler(exception);
		LOG.error("Exception occurred while building claimKey");
		handler.handle(exception, this.toString());
	}

	private ClaimKey buildClaimKey() {
		ClaimKey claimKey = new ClaimKey();
			
		String claimNumber = claimKeyDao.getClaimNumber().toString();
		claimKey.setClaimNumber(claimNumber); 
		claimKey.setClaimExtNumber(DEFAULT_CLM_EXT_NBR);

		return claimKey;
	}

	@Override
	public ClaimKey getReturnValue() {
		logReturnValue(returnValue);
		return returnValue;	
	}
	
	private void logReturnValue(ClaimKey returnValue) {
		if (returnValue==null) {
			DebugLogger.debugEnabled(LOG,"claimKey is null");
		}else {
			DebugLogger.debugEnabled(LOG,"returning claimKey: {}", ReservedClaimUtil.getClaimKeyAsString(returnValue));
		}
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}

}