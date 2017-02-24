package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimUtil.replaceClaimLine;
import static com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimUtil.retrieveClaimLineByLineNumber;

import javax.ws.rs.BadRequestException;
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
import com.vsp.claim.visionservicerequestapi.reservedclaim.config.ReservedClaimResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.util.ClonerUtil;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;

@Transactional
public class UpdateReservedClaimBean {
	
	@Autowired private PreClaimRepository preClaimRepository;

	private static final Logger LOG = LoggerFactory.getLogger(UpdateReservedClaimBean.class);
	
	public Claim update(String claimNumber, String claimExtNumber, Claim claim) throws DatabaseIOException {
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.UPDATE_CLAIM.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaimNumber(claimNumber)
			.setClaimExtNumber(claimExtNumber)
			.configure();
		
		ApiInvocationEvent event = createApiInvocationEvent("update()", "Update reserved claim");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		
		getClaimFromDb(claimNumber, claimExtNumber);
		DebugLogger.debugEnabled(LOG, "After getClaimFromDb()");
		
		validateClaimParams(claimNumber, claimExtNumber, claim.getClaimKey());
		DebugLogger.debugEnabled(LOG, "After validateClaimParams()");
		Claim request = cloneClaim(claim);
		Claim toReturn = updateClaim(request);
		
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		return toReturn;
	}
	
	public ClaimLine updateLine(String claimNumber, String claimExtNumber, int lineNumber, ClaimLine claimLine) throws DatabaseIOException {
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.UPDATE_CLAIM_LINE.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaimNumber(claimNumber)
			.setClaimExtNumber(claimExtNumber)
			.setLineNumber(lineNumber);
			
		ApiInvocationEvent event = new ApiInvocationEvent("updateLine", "Update reserved claim line");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		
		Claim persistedClaim = getClaimFromDb(claimNumber, claimExtNumber);
		DebugLogger.debugEnabled(LOG, "After getClaimFromDb()");
		
		ClaimLine request = ClonerUtil.clone(claimLine);
		validateClaimLineParams(lineNumber, request, persistedClaim);
		DebugLogger.debugEnabled(LOG, "After validateClaimLineParams()");
		
		ClaimLine toReturn = updateClaimWithClaimLine(persistedClaim, request, lineNumber);
		
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		
		return toReturn;
	}
	
	private ClaimLine updateClaimWithClaimLine(Claim persistedClaim, ClaimLine request, int lineNumber) throws DatabaseIOException {
		try {
			replaceClaimLine(persistedClaim, request);
			Claim updatedClaim = updateClaim(persistedClaim);
			return retrieveClaimLineByLineNumber(updatedClaim, lineNumber);
		} catch (ClaimLineNotFoundException e) {
			LOG.error("ClaimLineNotFoundException :{}", ExceptionUtils.getStackTrace(e));
			throw new NotFoundException(e); 
		} 
	}

	private Claim updateClaim(Claim request) throws DatabaseIOException {
		return preClaimRepository.update(request);
	}

	private Claim cloneClaim(Claim claim) {
		return ClonerUtil.clone(claim);
	}

	private Claim getClaimFromDb(String claimNumber, String claimExtNumber) throws DatabaseIOException {
		try {
			return preClaimRepository.retrieve(new ClaimKey(claimNumber, claimExtNumber));
		} catch (ClaimNotFoundException ex) {
			LOG.error("ClaimNotFoundException :{}", ExceptionUtils.getStackTrace(ex));
			throw new NotFoundException(ex);
		}
		
	}
	
	public void validateClaimParams(String claimNumber, String claimExtNumber, ClaimKey claimKey) {
		if (!isClaimKeyValid(claimNumber, claimExtNumber, claimKey)) {
			LOG.error("Throwing BadRequestException");
			throw new BadRequestException(new Exception("Claim Key doesn't match path segment"));			
		}
	}
	
	public void validateClaimLineParams(int lineNumber, ClaimLine claimLine, Claim existedClaim) {
		if (lineNumber != claimLine.getLineNumber()) {
			LOG.error("Throwing BadRequestException");
			throw new BadRequestException(new Exception("Claim LineNumber doesn't match path segment"));			
		}
	}
	
	private boolean isClaimKeyValid(String claimNumber, String claimExtNumber, ClaimKey claimKey) {
		ClaimKey key = new ClaimKey(claimNumber, claimExtNumber);
		return key.equals(claimKey);
	}
	
}
