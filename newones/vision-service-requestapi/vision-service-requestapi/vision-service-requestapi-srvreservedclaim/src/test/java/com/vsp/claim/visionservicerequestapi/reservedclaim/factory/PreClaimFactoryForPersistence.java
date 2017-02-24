package com.vsp.claim.visionservicerequestapi.reservedclaim.factory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaults;
import com.vsp.claim.common.model.jpa.ClaimErrorKey;
import com.vsp.claim.common.model.jpa.ClaimKey;
import com.vsp.claim.common.model.jpa.ClaimLineDocReview;
import com.vsp.claim.common.model.jpa.ClaimLineKey;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimError;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories.PreClaimErrorFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories.PreClaimFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories.PreClaimLineFactory;

public final class PreClaimFactoryForPersistence {
	
	private PreClaim newClaim;
	private PreClaimLine newLine;
	private PreClaimError newError;
	
	public PreClaim buildClaim(String claimNumber, String claimExtNumber){
		createDefaults();
		setDefaults(claimNumber,claimExtNumber);
		addDefaults();
		
		return newClaim;
	}
	
	public void createDefaults() {
		PreClaimFactory preClaimFactory = new PreClaimFactory();
		PreClaimLineFactory preClaimLineFactory =  new PreClaimLineFactory();
		PreClaimErrorFactory preClaimErrorFactory = new PreClaimErrorFactory();
		
		newClaim = preClaimFactory.create(new Object(),null);
		newLine = preClaimLineFactory.create(new Object(),null);
		newError = preClaimErrorFactory.create(new Object(),null);
	}
	
	public void setDefaults(String claimNumber, String claimExtNumber) {
		setPreClaimDefaults(claimNumber,claimExtNumber);
		setPreClaimLineDefaults(claimNumber,claimExtNumber);
		setPreClaimErrorDefaults(claimNumber,claimExtNumber);
	}
	
	public void addDefaults() {
		List<PreClaimLine> newLines = new ArrayList<PreClaimLine>(); 
		Set<PreClaimError> newErrors = new HashSet<PreClaimError>();
		newLines.add(newLine);
		newErrors.add(newError);
		
		newClaim.setClaimLines(newLines);
		newClaim.setClaimErrors(newErrors);
	}
	
	public void setPreClaimDefaults(String claimNumber, String claimExtNumber) {
		ClaimKey claimKey = new ClaimKey(); 
		claimKey.setClaimNumber(claimNumber);
		claimKey.setClaimExtNumber(claimExtNumber);
		
		newClaim.setClaimKey(claimKey);
		newClaim.setClmStatus("RS");
	}
	
	public void setPreClaimLineDefaults(String claimNumber, String claimExtNumber) {
		ClaimLineKey claimLineKey = new ClaimLineKey(); 
		claimLineKey.setClaimNumber(claimNumber);
		claimLineKey.setClaimExtNumber(claimExtNumber);
		ClaimLineDocReview docReview = new ClaimLineDocReview();
		docReview.setClmlnDocRvw(JPAClaimDefaults.EMPTY_STRING);
		
		newLine.setClaimLineKey(claimLineKey);
		newLine.setClmlnDocRvw(docReview);
		newLine.setClmlnStatus("RS");
	}
	
	public void setPreClaimErrorDefaults(String claimNumber, String claimExtNumber) {
		ClaimErrorKey claimErrorKey = new ClaimErrorKey(); 
		claimErrorKey.setClaimNumber(claimNumber);
		claimErrorKey.setClaimExtNumber(claimExtNumber);
		claimErrorKey.setId(JPAClaimDefaults.EMPTY_STRING);
		claimErrorKey.setErrorCategory("Claim");
		claimErrorKey.setErrorNumber("SVCCLaim");
		
		newError.setErrorKey(claimErrorKey);
	}
	
}
