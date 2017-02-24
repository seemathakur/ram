package com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;

import com.vsp.claim.common.mapping.exception.ClaimMappingException;
import com.vsp.claim.common.mapping.factory.jpa.ClaimLineDocReviewFactory;
import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaultsInitializer;
import com.vsp.claim.common.mapping.factory.jpa.JPAClaimLineKeyFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;



public class PreClaimLineFactory implements ObjectFactory<PreClaimLine> {

	@Override
	public PreClaimLine create(Object source, MappingContext context) {
		PreClaimLine claimLine = new PreClaimLine();
		
		try {
			claimLine = JPAClaimDefaultsInitializer.initializeDefaultValues(claimLine);
			claimLine.setClaimLineKey(new JPAClaimLineKeyFactory().create(source, context));
			claimLine.setClmlnDocRvw(new ClaimLineDocReviewFactory().create(source,context));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ClaimMappingException("Error initializing claim line.", e);
		}
		
		return claimLine;
	}

}
