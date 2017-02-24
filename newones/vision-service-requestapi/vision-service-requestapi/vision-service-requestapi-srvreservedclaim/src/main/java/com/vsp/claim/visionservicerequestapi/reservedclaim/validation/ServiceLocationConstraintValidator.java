package com.vsp.claim.visionservicerequestapi.reservedclaim.validation;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.provider.model.Provider;
import com.vsp.api.provider.model.ProviderKey;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.api.provider.model.ServiceLocationKey;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.ReservedClaimRequestContext;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.claim.visionservicerequestapi.shared.validation.Validator;
import com.vsp.oauth.ServiceLocationConstraint;

public class ServiceLocationConstraintValidator implements Validator{
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceLocationConstraintValidator.class);
	
	private ReservedClaimRequestContext requestContext; 
	private ProviderKey providerKey; 
	private ServiceLocationKey serviceLocationKey;
	
	private ServiceLocationConstraint serviceLocationConstraint; 
	private static final String EMPTY_STRING = ""; 
	
	public ServiceLocationConstraintValidator(ReservedClaimRequestContext requestContext){
		this.requestContext = requestContext;
		ServiceLocation serviceLocation = getServiceLocation();
		serviceLocationKey = getServiceLocationKey(serviceLocation);
		providerKey = getProviderKey();
		serviceLocationConstraint = getServiceLocationConstraint();
	}
	
	@Override
	public boolean isValid() {
		boolean valid = false; 
		
		if(!isServiceLocationConstraintOnAccessToken()) {
			LOG.info("Access token does not have service location constraint populated");
			valid = true; 
		}else if(!isServiceLocationOnClaimPopulated() && !isProviderTaxIdPopulated()){
			LOG.info("Service Location is not populated on claim"); 
			LOG.info("Provider Tax Id is not populated on claim"); 
			valid = true;  
		}else if (serviceLocationConstraintMatchesServiceLocationOnClaim()){
			LOG.info("Service Location Constraint and Provider Tax Id match on claim and access token");
			valid = true;  
		}
		
		if(!valid){
			LOG.info("Service Location Constraint and Provider Tax Id do not match on claim and access token");
		}
		
		return valid; 
	}
	
	private boolean isProviderTaxIdPopulated() {
		String taxId = providerKey.getProviderTaxId();
		return !isEmpty(taxId);
	}

	private Provider getProvider() {
		Claim claim = requestContext.getClaim();
		Provider toReturn = null; 
		if(claim != null){
			toReturn = claim.getProvider();
			logProvider(toReturn);

		}
		return toReturn;
	}

	private void logProvider(Provider provider) {
		if(provider != null){
			DebugLogger.debugEnabled(LOG, "Claim provider name: {}", provider.getName());
		}
	}

	private boolean serviceLocationConstraintMatchesServiceLocationOnClaim(){
		boolean nullKeys = providerKey != null && serviceLocationKey != null;
		return nullKeys	&& serviceLocationConstraintHashCodeMatchesServiceLocationHashCode(serviceLocationConstraint.getService_location_hash_code(), serviceLocationKey.getServiceLocationHashCode()) 
				&& serviceLocationConstraintSequenceMatchesServiceLocationSequence(serviceLocationConstraint.getService_location_sequence(), serviceLocationKey.getServiceLocationSequence())
				&& serviceLocationConstraintTaxIdMatchesProviderTaxId(serviceLocationConstraint.getProvider_tax_id(), providerKey.getProviderTaxId()); 
	}
	
	private boolean serviceLocationConstraintTaxIdMatchesProviderTaxId(String constraintTaxId, String providerId){
		String constraintTaxIdTrimmed = trimString(constraintTaxId); 
		String providerIdTrimmed = trimString(providerId);
		
		return constraintTaxIdTrimmed.equals(providerIdTrimmed); 
	}
	
	private boolean serviceLocationConstraintHashCodeMatchesServiceLocationHashCode(String constraintHashCode, String serviceLocationHashCode){
		String constraintHashCodeTrimmed = trimString(constraintHashCode);
		String serviceLocationHashCodeTrimmed = trimString(serviceLocationHashCode);
		
		return constraintHashCodeTrimmed.equals(serviceLocationHashCodeTrimmed); 
	}
	
	private boolean serviceLocationConstraintSequenceMatchesServiceLocationSequence(String constraintSequence, String serviceLocationSequence){
		String constraintSequenceTrimmed = trimString(constraintSequence);
		String serviceLocationSequenceTrimmed = trimString(serviceLocationSequence);
		
		return constraintSequenceTrimmed.equals(serviceLocationSequenceTrimmed); 
	}

	private boolean isServiceLocationOnClaimPopulated() {				
		return serviceLocationKey != null
				&& !isEmpty(serviceLocationKey.getServiceLocationHashCode()) 
				&& !isEmpty(serviceLocationKey.getServiceLocationSequence()); 
	}
	
	private boolean isEmpty(String field){
		String assertionField = trimString(field);
		return assertionField.equals(EMPTY_STRING);
	}
	
	private String trimString(String field){
        String trimmedField = EMPTY_STRING;
        if(field != null){
            trimmedField = field.trim();
        }
        return trimmedField;

	}
	
	private boolean isServiceLocationConstraintOnAccessToken(){
		return getServiceLocationConstraint() != null;
	}
	
	private ServiceLocationConstraint getServiceLocationConstraint(){
		return requestContext.getServiceLocationConstraint(); 
	}
	
	private ServiceLocation getServiceLocation(){
		Claim claim = requestContext.getClaim();
		ProviderNetworkAccessPoint accesspoint = getProviderNetworkAccesspointFromClaim(claim);
		return getServiceLocationFromProviderNetworkAccessPoint(accesspoint);
	}
	
	private ProviderNetworkAccessPoint getProviderNetworkAccesspointFromClaim(Claim claim){
		ProviderNetworkAccessPoint accesspoint = null; 
		if(claim != null){
			accesspoint = claim.getProviderNetworkAccessPoint();
			logAccesspoint(accesspoint);
		}
		return accesspoint; 
	}
	
	private void logAccesspoint(ProviderNetworkAccessPoint accesspoint) {
		if(accesspoint != null){
			DebugLogger.debugEnabled(LOG, "Accesspoint assigned to the network Id of: {}", accesspoint.getProviderNetworkKey().getNetworkId());
		}
	}

	private ServiceLocation getServiceLocationFromProviderNetworkAccessPoint(ProviderNetworkAccessPoint accesspoint){
		ServiceLocation toReturn = null; 
		if(accesspoint != null){
			toReturn = accesspoint.getServiceLocation();
			logServiceLocationInformation(toReturn);

		}
		return toReturn; 
	}
	
	private void logServiceLocationInformation(ServiceLocation serviceLocation) {
		if(serviceLocation != null && serviceLocation.getKey()!=null) {
			DebugLogger.debugEnabled(LOG, "Service location: ProviderTaxId {}, ServiceLocationHashCode {},"
					+ " ServiceLocationSequence {}, Name {}, Service Type {}, Type {}",	
					serviceLocation.getKey().getProviderTaxId(),
					serviceLocation.getKey().getServiceLocationHashCode(),
					serviceLocation.getKey().getServiceLocationSequence(), 
					serviceLocation.getName(),
					serviceLocation.getServiceType(), 
					serviceLocation.getType());
		}

	}

	private ServiceLocationKey getServiceLocationKey(ServiceLocation serviceLocation) {
		ServiceLocationKey key = null;
		if(serviceLocation != null){
			key = serviceLocation.getKey();
			logServiceLocationKey(key);
		}
		return key;
	}
	
	
	private void logServiceLocationKey(ServiceLocationKey key) {
		if(key != null){
			DebugLogger.debugEnabled(LOG, "Service location key: Provider Tax Id {}, Service Location Hash Code {}, Service Location Sequence {}",
					key.getProviderTaxId(), 
					key.getServiceLocationHashCode(), 
					key.getServiceLocationSequence());
		}
		
	}

	private ProviderKey getProviderKey(){
		Provider provider = getProvider();
		ProviderKey key = null;
		if(provider != null){
			key = provider.getKey();
			logProviderKey(key);
		}
		return key; 
	}
	

	private void logProviderKey(ProviderKey key) {
		if(key!=null){
			DebugLogger.debugEnabled(LOG, "Provider key: Tax Id {}", key.getProviderTaxId());
		}
	}

	@Override
	public String getErrorMessage() {
		return Response.Status.FORBIDDEN.getReasonPhrase();
	}

	@Override
	public String getErrorCode() {
		return Integer.toString(Response.Status.FORBIDDEN.getStatusCode());
	}

}
