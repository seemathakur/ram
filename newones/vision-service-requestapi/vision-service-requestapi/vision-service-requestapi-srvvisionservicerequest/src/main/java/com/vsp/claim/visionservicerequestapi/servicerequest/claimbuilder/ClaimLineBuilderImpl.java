package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import org.joda.time.DateMidnight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.DateInterval;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimLineNotEligibleException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.reservationinterval.ReservationIntervalBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveClientDivisionCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveEligibilityCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimStatusEnum;

public class ClaimLineBuilderImpl implements ClaimLineBuilder {
	
	private CommandMap commandMap;
	
	private String providerNetworkId; 
	private String productPackageName;
	private DateMidnight effectiveDate;
	private ClaimLine builtClaimLine; 
	
	private static final Logger LOG = LoggerFactory.getLogger(ClaimLineBuilderImpl.class);
	
	public ClaimLineBuilderImpl(CommandMap commandMap, VisionServiceRequestApiContext requestContext) {
		this.providerNetworkId = requestContext.getNetworkId(); 
		this.productPackageName = requestContext.getProductPackageName(); 
		this.effectiveDate = requestContext.getEffectiveDate();
		this.commandMap = commandMap;
	}
	
	@Override
	public ClaimLine buildClaimLine(String productCatalogKey, int lineNumber) throws ClaimBuilderException {
		builtClaimLine = new ClaimLine();
		builtClaimLine.setLineNumber(lineNumber);
		builtClaimLine.setProductCatalogKey(productCatalogKey);
		setClaimLineStatusToReserved(builtClaimLine);
		applyReservationInterval(builtClaimLine);
		confirmEligibility(builtClaimLine);
		return builtClaimLine; 
	}
	
	private void confirmEligibility(ClaimLine claimLineToBeBuilt) throws ClaimBuilderException{
		if(!isEligibilityConfirmed(claimLineToBeBuilt)){
			throw new ClaimLineNotEligibleException(claimLineToBeBuilt);
		}
	}

	private boolean isEligibilityConfirmed(ClaimLine claimLineToBeBuilt) throws ClaimBuilderException {
		EligibilityConfirmer eligibilityConfirmor = initalizeEligibilityConfirmor(claimLineToBeBuilt);
		return eligibilityConfirmor.confirmEligibility();
	}

	private EligibilityConfirmer initalizeEligibilityConfirmor(ClaimLine claimLineToBeBuilt) {
		EligibilityConfirmer eligibilityConfirmor = new EligibilityConfirmer(claimLineToBeBuilt, providerNetworkId, productPackageName);
		eligibilityConfirmor.setRetrieveEligibilityCommand(getEligibilityCommandFromMap());
		return eligibilityConfirmor;
	}

	private void setClaimLineStatusToReserved(ClaimLine builtClaimLine) {
		builtClaimLine.setStatusCode(ReservedClaimStatusEnum.RESERVED.getStatusCode());
	}	

	protected ClaimLine applyReservationInterval(ClaimLine claimLine) {
		ReservationIntervalBuilder reservationIntervalBuilder = initializeReservationIntervalBuilder(claimLine);
		
		DateInterval reservationInterval = reservationIntervalBuilder.buildReservationInterval();
		claimLine.setReservationInterval(reservationInterval);

		return claimLine; 
	}

	private ReservationIntervalBuilder initializeReservationIntervalBuilder(ClaimLine claimLine) {
		RetrieveClientDivisionCommand clientCommand = getClientCommandFromMap();
		return new ReservationIntervalBuilder(productPackageName, effectiveDate, clientCommand);
	}

	private RetrieveClientDivisionCommand getClientCommandFromMap() {
		return (RetrieveClientDivisionCommand) commandMap.get(CommandMap.RETRIEVE_CLIENT_DIVISION_COMMAND);
	}
	
	private RetrieveEligibilityCommand getEligibilityCommandFromMap() {
		return (RetrieveEligibilityCommand) commandMap.get(CommandMap.RETRIEVE_ELIGBILITY_COMMAND);
	}
	
	@Override
	public ClaimLine getClaimLine() {
		return builtClaimLine;
	}
				
}
