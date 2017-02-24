package com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;

import com.vsp.claim.common.mapping.exception.ClaimMappingException;
import com.vsp.claim.common.mapping.factory.jpa.DocumentReviewApprovalFactory;
import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaultsInitializer;
import com.vsp.claim.common.mapping.factory.jpa.JPAClaimKeyFactory;
import com.vsp.claim.common.mapping.factory.jpa.MemberAddressFactory;
import com.vsp.claim.common.mapping.factory.jpa.MemberPhoneFactory;
import com.vsp.claim.common.mapping.factory.jpa.PatientAddressFactory;
import com.vsp.claim.common.mapping.factory.jpa.PatientPhoneFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;



public class PreClaimFactory implements ObjectFactory<PreClaim>{
	
	public PreClaim create(Object source, MappingContext mappingContext) {
		PreClaim preClaim = new PreClaim();
		try {
			preClaim = JPAClaimDefaultsInitializer.initializeDefaultValues(preClaim);
			preClaim.setClaimKey(new JPAClaimKeyFactory().create(source, mappingContext));
			preClaim.setPatientAddress(new PatientAddressFactory().create(source, mappingContext));
			preClaim.setPatientPhone(new PatientPhoneFactory().create(source, mappingContext));
			preClaim.setMemberAddress(new MemberAddressFactory().create(source, mappingContext));
			preClaim.setMemberPhone(new MemberPhoneFactory().create(source, mappingContext));
			preClaim.setClmDocRvwApInd(new DocumentReviewApprovalFactory().create(source, mappingContext));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ClaimMappingException("Error initializing claim.", e);
		}
		
		return preClaim; 
	}
	
	
	

}
