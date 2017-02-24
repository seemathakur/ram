package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;

import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.common.claimlinksbuilder.ClaimLinksBuilder;
import com.vsp.claim.common.claimlinksbuilder.ReservedClaimLineLinksBuilder;
import com.vsp.claim.common.claimlinksbuilder.ReservedClaimLinksBuilder;
import com.vsp.claim.visionservicerequestapi.reservedclaim.config.ReservedClaimResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.validation.ServiceLocationConstraintValidator;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;

public class RetrieveReservedClaimsBean {
	
	@Autowired private PreClaimRepository preClaimRepository;
	@Autowired private ApiContext apiContext;
	
	private static final Logger LOG = LoggerFactory.getLogger(RetrieveReservedClaimsBean.class);
	
	public Claim retrieve(String claimNumber, String claimExtNumber){
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.RETRIEVE_CLAIM.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaimNumber(claimNumber)
			.setClaimExtNumber(claimExtNumber)
			.configure();
		
		ApiInvocationEvent event = createApiInvocationEvent("retrieve()", "Retrieve reserved claim");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		
		ClaimKey claimKey = new ClaimKey(claimNumber, claimExtNumber);
		Claim toReturn = retrieveFromDb(claimKey);
		DebugLogger.debugEnabled(LOG, "After retrieveFromDb()");
		toReturn = setLinksOnClaim(toReturn);
		
		validateServiceLocationConstraint(getRequestContext(toReturn));
		DebugLogger.debugEnabled(LOG, "After validateServiceLocationConstraint()");
				
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		return toReturn;
	}
	
	protected void validateServiceLocationConstraint(ReservedClaimRequestContext requestContext){
		if(!isServiceLocationConstraintValid(requestContext)){
			LOG.error("Throwing ForbiddenException");
			throw new ForbiddenException();
		}
	}
	
	protected boolean isServiceLocationConstraintValid(ReservedClaimRequestContext requestContext){
		ServiceLocationConstraintValidator validator = new ServiceLocationConstraintValidator(requestContext);
		DebugLogger.debugEnabled(LOG, "validator.isValid(): {}", validator.isValid());
		return validator.isValid();
	}
	
	protected ReservedClaimRequestContext getRequestContext(Claim claim){
		return new ReservedClaimRequestContext(claim, apiContext); 
	}

	private Claim retrieveFromDb(ClaimKey key) {
		Claim claim = new Claim();
		try {
			claim = preClaimRepository.retrieve(key);
		} catch (ClaimNotFoundException e) {
			LOG.error("ClaimNotFoundException :{}", ExceptionUtils.getStackTrace(e));
			throw new NotFoundException(e);
		} catch(DatabaseIOException e){
			LOG.error("DatabaseIOException :{}", ExceptionUtils.getStackTrace(e));
			throw new InternalServerErrorException(e);
		}
		return claim;
	}

	private Claim setLinksOnClaim(Claim claim) {
		ClaimLinksBuilder linksBuilder = new ReservedClaimLinksBuilder();
		ClaimKey claimKey = claim.getClaimKey();
		
		claim.setSelf(linksBuilder.buildSelfLink(claimKey));
		claim.setValidClaimOperations(linksBuilder.buildValidClaimOperations(claimKey));
		
		if(hasClaimLines(claim)){
			setLinksOnClaimLines(claimKey, claim.getClaimLines()); 
		}
		
		return claim;
	}

	private boolean hasClaimLines(Claim claim) {
		return claim.getClaimLines()!=null;
	}

	private void setLinksOnClaimLines(ClaimKey claimKey, List<ClaimLine> claimLines) {
		for(ClaimLine claimLine : claimLines){
			setLinkOnClaimLine(claimKey, claimLine); 
		}	
	}

	private void setLinkOnClaimLine(ClaimKey claimKey, ClaimLine claimLine) {
		ReservedClaimLineLinksBuilder builder = new ReservedClaimLineLinksBuilder(); 
		claimLine.setSelfLink(builder.buildSelfLink(claimKey, claimLine.getLineNumber()));
	}

}
