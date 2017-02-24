package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.config.ReservedClaimResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.validation.ServiceLocationConstraintValidator;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;

@Transactional
public class DeleteReservedClaimsBean {

	@Autowired private PreClaimRepository preClaimRepository;
	@Autowired private ApiContext apiContext;
	
	private static final Logger LOG = LoggerFactory.getLogger(DeleteReservedClaimsBean.class);
	
	public Claim delete(String claimNumber, String claimExtNumber) throws DatabaseIOException {
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.DELETE_CLAIM.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaimNumber(claimNumber)
			.setClaimExtNumber(claimExtNumber)
			.configure();
		
		ApiInvocationEvent event = createApiInvocationEvent("delete()", "Delete reserved claim");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		
		Claim existingClaim =  retrieveFromDb(new ClaimKey(claimNumber, claimExtNumber));
		DebugLogger.debugEnabled(LOG, "After retrieveFromDb()");
		
		validateServiceLocationConstraint(getRequestContext(existingClaim));
		DebugLogger.debugEnabled(LOG, "After validateServiceLocationConstraint()");
		
		Claim updatedClaim = doDelete(existingClaim);

		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		return updatedClaim;
	} 
	
	public ClaimLine deleteLine(String claimNumber, String claimExtNumber, int lineNumber) throws DatabaseIOException {
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
				
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.DELETE_CLAIM_LINE.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaimNumber(claimNumber)
			.setClaimExtNumber(claimExtNumber)
			.setLineNumber(lineNumber)
			.configure();
		
		ApiInvocationEvent event = createApiInvocationEvent("deleteLine()", "Delete reserved claim line");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		
		ClaimKey key = new ClaimKey(claimNumber, claimExtNumber);
		Claim existingClaim = retrieveFromDb(key);
		DebugLogger.debugEnabled(LOG, "After retrieveFromDb()");
		
		validateServiceLocationConstraint(getRequestContext(existingClaim)); 
		DebugLogger.debugEnabled(LOG, "After validateServiceLocationConstraint()");
		
		ClaimLine updatedClaimLine = doDeleteLine(key,lineNumber);
		
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		return updatedClaimLine;
} 
	
	private ClaimLine doDeleteLine(ClaimKey key, int lineNumber) throws DatabaseIOException {
		return deleteClaimLineFromDb(key, lineNumber);
	}

	private ClaimLine deleteClaimLineFromDb(ClaimKey key, int lineNumber) throws DatabaseIOException{
		try {
			return preClaimRepository.deleteLine(key, lineNumber);
		} catch (ClaimNotFoundException | ClaimLineNotFoundException e) {
			LOG.error("ClaimNotFoundException | ClaimLineNotFoundException: {}", ExceptionUtils.getStackTrace(e));
			throw new NotFoundException(e); 
		}
	}
	
	private Claim retrieveFromDb(ClaimKey claimKey) throws DatabaseIOException {	
		try {
			return preClaimRepository.retrieve(claimKey);
		}catch (ClaimNotFoundException e) {
			LOG.error("ClaimNotFoundException: {}", ExceptionUtils.getStackTrace(e));
			throw new NotFoundException(e); 
		}
	}
	
	
	private Claim doDelete(Claim existingClaim) throws DatabaseIOException {
		try {
			return preClaimRepository.delete(existingClaim.getClaimKey());
		} catch (ClaimNotFoundException e) {
			LOG.error("ClaimNotFoundException: {}", ExceptionUtils.getStackTrace(e));
			throw new NotFoundException(e); 
		}
	}	
	
	protected void validateServiceLocationConstraint(ReservedClaimRequestContext requestContext){
		if(!isServiceLocationConstraintValid(requestContext)){
			LOG.error("Throwing ForbiddenException");
			throw new ForbiddenException();
		}
	}
	
	protected boolean isServiceLocationConstraintValid(ReservedClaimRequestContext requestContext){
		ServiceLocationConstraintValidator validator = new ServiceLocationConstraintValidator(requestContext);
		return validator.isValid();
	}
	
	protected ReservedClaimRequestContext getRequestContext(Claim claim){
		return new ReservedClaimRequestContext(claim, apiContext); 
	}	
		
}
