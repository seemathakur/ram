package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimLineNotEligibleException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.NoEligibleServicesException;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;

public class ClaimLinesBuilderImpl implements ClaimLinesBuilder {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClaimLinesBuilderImpl.class);
	
	private ClaimLineBuilder claimLineBuilder; 
	private int claimLineCount;
	private List<ClaimLine> builtClaimLines;
	private List<EligibilityProductItem> eligibilityProductItems;
	
	
	public ClaimLinesBuilderImpl(CommandMap commandMap, VisionServiceRequestApiContext requestContext) {
		this(new ClaimLineBuilderImpl(commandMap, requestContext), requestContext);
	}
	
	public ClaimLinesBuilderImpl(CommandMap commandMap, VisionServiceRequestApiContext requestContext, int claimLineCount) {
		this(new ClaimLineBuilderImpl(commandMap, requestContext), requestContext, claimLineCount);
	}

	protected ClaimLinesBuilderImpl(ClaimLineBuilder claimLineBuilder, VisionServiceRequestApiContext requestContext) {
		this(claimLineBuilder, requestContext, 0);
	}
	
	protected ClaimLinesBuilderImpl(ClaimLineBuilder claimLineBuilder, VisionServiceRequestApiContext requestContext, int claimLineCount) {
		this.claimLineBuilder = claimLineBuilder;
		this.claimLineCount = claimLineCount;
		this.eligibilityProductItems = requestContext.getServiceRequest().getSelectedEligibleProductItems(); 
		builtClaimLines = new ArrayList<ClaimLine>();
	}
	
	@Override
	public List<ClaimLine> buildClaimLines() throws ClaimBuilderException {
		DebugLogger.debugEnabled(LOG, "Before calling buildReservedClaimLines()");
		buildReservedClaimLines(); 
		if(hasNoEligibleClaimLines()){
			throw new NoEligibleServicesException();
		}
		return builtClaimLines; 
	}
			
	private void buildReservedClaimLines() throws ClaimBuilderException {
		if(hasSelectedEligibleProductItems()){
			for(EligibilityProductItem eligibilityProductItem : eligibilityProductItems){
				buildClaimLineFromEligibilityProductItem(eligibilityProductItem, getNextLineNumber());
			}
		}
	}

	private boolean hasSelectedEligibleProductItems(){
		return eligibilityProductItems != null;
	}
	
	protected int getNextLineNumber(){
		return ++claimLineCount;
	}
	
	private void buildClaimLineFromEligibilityProductItem(EligibilityProductItem eligibilityProductItem, int lineNumber) throws ClaimBuilderException {
		try {
			builtClaimLines.add(claimLineBuilder.buildClaimLine(eligibilityProductItem.getProductCatalogKey(), lineNumber));
		} catch(ClaimLineNotEligibleException ineligibleException) {
			handleIneligibleException(ineligibleException);
		} 		
	}

	private boolean hasNoEligibleClaimLines() {
		return builtClaimLines.size() == 0; 
	}

	private void handleIneligibleException(ClaimLineNotEligibleException ineligibleException) {
		LOG.error("Claim line with product catalog key: {} is ineligible. We will not build the claim line", ineligibleException.getIneligibleProductCatalogKey());
		rollBackClaimLineCountByOne();
	}

	private void rollBackClaimLineCountByOne() {
		claimLineCount--;
		DebugLogger.debugEnabled(LOG, "claimLineCount: {}", claimLineCount);
	}
		
	@Override
	public List<ClaimLine> getClaimLines() {
		return builtClaimLines;
	}
	
}