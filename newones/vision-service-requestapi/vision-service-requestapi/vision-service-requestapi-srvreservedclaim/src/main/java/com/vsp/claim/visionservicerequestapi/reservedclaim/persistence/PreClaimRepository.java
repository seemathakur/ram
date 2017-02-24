package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import java.util.List;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.Claims;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.NameValuePair;

public interface PreClaimRepository {
	
	Claim retrieve(ClaimKey claimKey) throws ClaimNotFoundException, DatabaseIOException;
	Claims search(List<NameValuePair> criteria);
	Claim create(Claim claim) throws DatabaseIOException;
	Claim update(Claim claim) throws DatabaseIOException;	
	Claim delete(ClaimKey claimKey) throws ClaimNotFoundException, DatabaseIOException;
	ClaimLine deleteLine(ClaimKey claimKey, Integer lineNumber) throws ClaimNotFoundException,ClaimLineNotFoundException, DatabaseIOException;

}
