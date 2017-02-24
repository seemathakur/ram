package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityStatus;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveEligibilityCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.EligibilityFilter;
import com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.exception.EligibilityFilterException;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;

public class EligibilityConfirmer {
	
	private ClaimLine claimLine; 
	private String providerNetworkId;
	private String productPackageName;
	private RetrieveEligibilityCommand retrieveEligibilityCommand; 
	private static final Logger LOG = LoggerFactory.getLogger(EligibilityConfirmer.class);

	public EligibilityConfirmer(ClaimLine claimLine, String providerNetworkId, String productPackageName){
		this.claimLine = claimLine; 
		this.providerNetworkId = providerNetworkId;
		this.productPackageName = productPackageName;
	}
	
	public boolean confirmEligibility() {
		String productCatalogKey = claimLine.getProductCatalogKey(); 
		boolean isEligible = confirmEligibilityForProductItem(retrieveEligibilityProductItem (productCatalogKey));
		logConfirmedEligibility(isEligible, productCatalogKey);
		
		return isEligible;
	}
	
	private void logConfirmedEligibility(boolean isEligible, String productItemName) {
		if(isEligible){
			DebugLogger.debugEnabled(LOG, "Eligibility Product Item {} is available", productItemName);
		}else {
			DebugLogger.debugEnabled(LOG, "Eligibility Product Item {} is not available", productItemName);
		}
	}

	public boolean confirmEligibilityForProductItem(EligibilityProductItem eligibilityProductItem){
		return eligibilityProductItem.getStatus().equals(EligibilityStatus.AVAILABLE);
	}
		
	private EligibilityProductItem retrieveEligibilityProductItem(String productCatalogKey) {
		Eligibility eligibility = retrieveEligibility();
		return filterEligibilityToProductItem(eligibility, productCatalogKey);
	}
	
	private EligibilityProductItem filterEligibilityToProductItem(Eligibility eligibility, String productCatalogKey) {
		EligibilityProductItem eligibilityProductItem =  buildDefaultEligibilityProductItem();
		EligibilityFilter filter = new EligibilityFilter(eligibility);
		
		try {
			DebugLogger.debugEnabled(LOG, "Filter Eligibility by providerNetworkId: {}, productPackageName:{}, productCatalogKey:{}", providerNetworkId, productPackageName, productCatalogKey);
			eligibilityProductItem = filter.filterEligibilityByProviderNetworkIdAndProductPackageAndProductItem(providerNetworkId, productPackageName, productCatalogKey);
		} catch (EligibilityFilterException e) {
			LOG.error("Unable to filter Eligibility by providerNetworkId:{}, productPackageName: {}, productCatalogKey: {}, exception: {}", providerNetworkId, productPackageName, productCatalogKey, ExceptionUtils.getMessage(e));
		} 
		return eligibilityProductItem;
	}

	private EligibilityProductItem buildDefaultEligibilityProductItem(){
		EligibilityProductItem productItem = new EligibilityProductItem();
		productItem.setStatus(EligibilityStatus.UNAVAILABLE);
		return productItem;
	}
	
	private Eligibility retrieveEligibility() {
		return retrieveEligibilityCommand.getReturnValue();
	}
	
	public void setRetrieveEligibilityCommand(RetrieveEligibilityCommand retrieveEligibilityCommand){
		this.retrieveEligibilityCommand = retrieveEligibilityCommand; 
	}
	
}
