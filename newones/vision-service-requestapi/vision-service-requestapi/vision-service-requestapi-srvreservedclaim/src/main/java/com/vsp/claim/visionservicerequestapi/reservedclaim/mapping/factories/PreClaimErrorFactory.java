package com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;

import com.vsp.claim.common.mapping.exception.ClaimMappingException;
import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaultsInitializer;
import com.vsp.claim.common.mapping.factory.jpa.JPAClaimErrorKeyFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimError;

public class PreClaimErrorFactory implements ObjectFactory<PreClaimError> {

	public PreClaimError create(Object source, MappingContext context) {
		PreClaimError claimError = new PreClaimError();
		
		try {
			claimError = JPAClaimDefaultsInitializer.initializeDefaultValues(claimError);
			claimError.setErrorKey(new JPAClaimErrorKeyFactory().create(source, context));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ClaimMappingException("Error initializing claim error.", e);
		}
		
		return claimError;
	}

}
