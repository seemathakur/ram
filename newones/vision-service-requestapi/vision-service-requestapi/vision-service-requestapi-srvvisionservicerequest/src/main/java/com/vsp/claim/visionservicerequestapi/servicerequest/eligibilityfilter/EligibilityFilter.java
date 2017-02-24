package com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.eligibility.model.EligibilityNetwork;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityProductPackage;
import com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.exception.EligibilityFilterException;
import com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.exception.EligibilityNetworkNotFoundException;
import com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.exception.EligibilityProductItemNotFoundException;
import com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.exception.EligibilityProductPackageNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;

public class EligibilityFilter {
	
	private Eligibility eligibility;

	private static final Logger LOG = LoggerFactory.getLogger(EligibilityFilter.class);
	
	public EligibilityFilter(Eligibility eligibility){
		this.eligibility = eligibility; 
	}
	
	public EligibilityProductItem filterEligibilityByProviderNetworkIdAndProductPackageAndProductItem(String providerNetworkId, 
			String productPackageName, String productCatalogKey) throws EligibilityFilterException{
		EligibilityProductPackage eligibilityProductPackage = filterEligibilityByProviderNetworkIdAndProductPackage(providerNetworkId, 
				productPackageName);
		return filterEligibilityByProductItem(eligibilityProductPackage.getEligibleItems(), productCatalogKey); 
	} 
	
	public EligibilityProductPackage filterEligibilityByProviderNetworkIdAndProductPackage(String providerNetworkId, 
			String productPackageName) throws EligibilityFilterException{
		if(providerNetworkId != null){	
			List<EligibilityNetwork> eligibilityNetworks = eligibility.getNetworks(); 
			if(eligibilityNetworks == null){
				LOG.error("Network not found, providerNetworkId: {}", providerNetworkId);
				throw new EligibilityNetworkNotFoundException(providerNetworkId);
			}
			for(EligibilityNetwork eligibilityNetwork : eligibilityNetworks) {
				if(eligibilityNetwork.getNetworkId().equalsIgnoreCase(providerNetworkId)){ 
					return filterEligibilityByProductPackage(eligibilityNetwork.getPackages(), productPackageName); 
				}
			}
			LOG.error("Network not found, providerNetworkId: {}", providerNetworkId);
			throw new EligibilityNetworkNotFoundException(providerNetworkId); 
		}else{
			LOG.error("Network not found, providerNetworkId is Null");
			throw new EligibilityNetworkNotFoundException(providerNetworkId); 
		}
	}
	

	private EligibilityProductPackage filterEligibilityByProductPackage(
			List<EligibilityProductPackage> eligibilityProductPackages, 
			String productPackageName) throws EligibilityProductPackageNotFoundException{
		if(productPackageName != null){
			for(EligibilityProductPackage eligibilityProductPackage : eligibilityProductPackages){
				if(eligibilityProductPackage.getName().equalsIgnoreCase(productPackageName)) {
					DebugLogger.debugEnabled(LOG, "Found {}", eligibilityProductPackage.getName());
					return eligibilityProductPackage; 
				}
			}
			LOG.error("Product Package not found, productPackageName: {}", productPackageName);
			throw new EligibilityProductPackageNotFoundException(productPackageName); 
		}else{
			LOG.error("Product Package not found, productPackageName is Null");
			throw new EligibilityProductPackageNotFoundException(productPackageName); 
		}
	}

	private EligibilityProductItem filterEligibilityByProductItem(
			List<EligibilityProductItem> eligibilityProductItems, 
			String productCatalogKey) throws EligibilityProductItemNotFoundException{
		if(productCatalogKey != null){
			for(EligibilityProductItem eligibilityProductItem : eligibilityProductItems){
				if(eligibilityProductItem.getProductCatalogKey().equalsIgnoreCase(productCatalogKey)) {
					DebugLogger.debugEnabled(LOG, "Found {}", eligibilityProductItem.getProductCatalogKey());
					return eligibilityProductItem; 
				}
			}
			LOG.error("Product item not found, productCatalogKey: {}", productCatalogKey);
			throw new EligibilityProductItemNotFoundException(productCatalogKey); 
		}else{
			LOG.error("Product item not found, productCatalogKey is Null");
			throw new EligibilityProductItemNotFoundException(productCatalogKey); 
		}
	}
}
