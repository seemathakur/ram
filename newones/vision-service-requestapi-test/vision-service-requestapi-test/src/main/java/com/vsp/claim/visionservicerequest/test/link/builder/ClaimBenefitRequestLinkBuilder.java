package com.vsp.claim.visionservicerequest.test.link.builder;

import com.vsp.api.claim.ClaimBenefitRequestResource;
import com.vsp.api.claim.model.Claim;
import com.vsp.api.core.Link;
import com.vsp.jaxrs.link.LinkBuilder;

public class ClaimBenefitRequestLinkBuilder {
	
	public static Link<Claim> buildDeleteEligibilityProductItemLink(String claimNumber, String claimExtNumber){
		Link<Claim> deleteCBRLink = new Link<Claim>();
		
		LinkBuilder.resource(ClaimBenefitRequestResource.class)
		.link(deleteCBRLink)
		.deleteBenefitRequestForClaim(claimNumber, claimExtNumber);
		
		deleteCBRLink.setType(Claim.class.getName());
		deleteCBRLink.setRel("urn://vnd.vsp.rels/deleteclaimbenefitrequest");
		
		return deleteCBRLink;
	}

}
