package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimUtil.retrieveClaimLineByLineNumber;

import java.util.ArrayList;
import java.util.List;

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
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.core.Link;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.common.claimlinksbuilder.ReservedClaimLineLinksBuilder;
import com.vsp.claim.common.claimlinksbuilder.ReservedClaimLinksBuilder;
import com.vsp.claim.visionservicerequestapi.reservedclaim.config.ReservedClaimResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.util.ClonerUtil;
import com.vsp.claim.visionservicerequestapi.reservedclaim.validation.ServiceLocationConstraintValidator;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;

@Transactional
public class CreateReservedClaimsBean {
	
	@Autowired private PreClaimRepository preClaimRepository;
	@Autowired private ApiContext apiContext;
		
	private static final Logger LOG = LoggerFactory.getLogger(CreateReservedClaimsBean.class);

	public Claim create(Claim claim) throws DatabaseIOException{
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.CREATE_CLAIM.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaim(claim)
			.configure();
		
		ApiInvocationEvent event = createApiInvocationEvent("create()", "Create reserved claim");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		
		Claim toReturn = createToDb(claim);
		setSelfLink(toReturn);
	
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		return toReturn; 
	} 
	
	public ClaimLines createLines(String claimNumber, String claimExtNumber, ClaimLines claimLines) throws DatabaseIOException {
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.CREATE_CLAIM_LINES.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaimNumber(claimNumber)
			.setClaimExtNumber(claimExtNumber)
			.configure();
		
		ApiInvocationEvent event = createApiInvocationEvent("createLines()", "Create reserved claim lines");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		
		Claim retrievedClaim = retrieveFromDb(claimNumber, claimExtNumber);
		ReservedClaimRequestContext requestContext = getRequestContext(retrievedClaim, claimLines); 
		
		validateServiceLocationConstraint(requestContext);
		Claim updatedClaim = createLinesOnClaim(retrievedClaim, claimLines);
		
		ClaimLines toReturn = buildSelfLinkOnLines(updatedClaim, claimLines);
		DebugLogger.debugEnabled(LOG, "After buildSelfLinkOnLines()");
		
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		return toReturn;
	}

	private Claim createLinesOnClaim(Claim claim, List<ClaimLine> claimLines) throws DatabaseIOException {
		for (ClaimLine claimLine: claimLines){
			claim.getClaimLines().add(claimLine);
		}
		return updateClaim(claim);
	}
	
	private ClaimLines buildSelfLinkOnLines(Claim updatedClaim, List<ClaimLine> claimLines){
		ClaimLines toReturn = new ClaimLines();
		for (ClaimLine claimLine:claimLines){
			buildSelfLinkOnLine(updatedClaim, toReturn, claimLine);
		}
		return toReturn;
	}
	
	private void buildSelfLinkOnLine(Claim updatedClaim, ClaimLines claimLines, ClaimLine line){
		try {
			ClaimLine lineToReturn = retrieveClaimLineByLineNumber(updatedClaim, line.getLineNumber());
			lineToReturn.setSelfLink(buildSelfLink(updatedClaim.getClaimKey(), lineToReturn));
			claimLines.add(lineToReturn);
		} catch (ClaimLineNotFoundException e) {
			LOG.error("ClaimLineNotFoundException: {}", ExceptionUtils.getStackTrace(e));
			throw new NotFoundException(e);
		}
	}

	protected ReservedClaimRequestContext getRequestContext(Claim claim){
		Claim request = cloneClaim(claim);
		return new ReservedClaimRequestContext(request, apiContext); 
	}
	
	protected ReservedClaimRequestContext getRequestContext(Claim claim, ClaimLines claimLines){
		Claim requestedClaim = cloneClaim(claim);
		List<ClaimLine> requestClaimLines = cloneClaimLines(claimLines); 
		return new ReservedClaimRequestContext(requestedClaim, requestClaimLines, apiContext); 
	}
		
	private Claim cloneClaim(Claim claim) {
		return ClonerUtil.clone(claim);
	}
	
	private List<ClaimLine> cloneClaimLines(ClaimLines claimLines){
		List<ClaimLine> clonedClaimLines = new ArrayList<ClaimLine>();
		for(ClaimLine claimLine: claimLines){
			clonedClaimLines.add(ClonerUtil.clone(claimLine));
		}
		return clonedClaimLines;
	}

	private Claim createToDb(Claim claim) throws DatabaseIOException {
		return preClaimRepository.create(claim);
	}
	
	private void setSelfLink(Claim claim) {
		claim.setSelf(buildSelfLink(claim));
	}
	
	private Link<Claim> buildSelfLink(Claim claim){
		ReservedClaimLinksBuilder linksBuilder = new ReservedClaimLinksBuilder();
		return linksBuilder.buildSelfLink(claim.getClaimKey());
	}
	
	private Link<ClaimLine> buildSelfLink(ClaimKey claimKey,ClaimLine claimLine){
		ReservedClaimLineLinksBuilder reservedClaimLineLinksBuilder = new ReservedClaimLineLinksBuilder();
		return reservedClaimLineLinksBuilder.buildSelfLink(claimKey, claimLine.getLineNumber());
	}
			
	private Claim retrieveFromDb(String claimNumber, String claimExtNumber) throws DatabaseIOException {
		try {
			ClaimKey claimKey = new ClaimKey(claimNumber, claimExtNumber);
			return preClaimRepository.retrieve(claimKey);
		} catch (ClaimNotFoundException e) {
			throw new NotFoundException(e);
		}
	}

	private Claim updateClaim(Claim request) throws DatabaseIOException {
		return preClaimRepository.update(request);
	}
	
	protected void validateServiceLocationConstraint(ReservedClaimRequestContext requestContext){
		if(!isServiceLocationConstraintValid(requestContext)){
			LOG.error("Service location constraint is not valid. Throwing ForbiddenException");
			throw new ForbiddenException();
		}
	}
	
	protected boolean isServiceLocationConstraintValid(ReservedClaimRequestContext requestContext){
		ServiceLocationConstraintValidator validator = new ServiceLocationConstraintValidator(requestContext);
		return validator.isValid();
	}
	
	protected ApiContext getApiContext(){
		return apiContext;
	}
	
}
