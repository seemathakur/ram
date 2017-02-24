package com.vsp.claim.visionservicerequest.test.link.builder;

import com.vsp.api.claim.VisionServiceRequestResource;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.claim.model.VisionServiceRequests;
import com.vsp.api.core.Link;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityProductItems;
import com.vsp.jaxrs.link.LinkBuilder;

public class VisionServiceRequestLinkBuilder {
	
	public static Link<EligibilityProductItem> buildDeleteEligibilityProductItemLink(String trackingNumber, String productCatalogKey){
		Link<EligibilityProductItem> deleteSelectedEPILink = new Link<EligibilityProductItem>();
		
		LinkBuilder.resource(VisionServiceRequestResource.class)
		.link(deleteSelectedEPILink)
		.deleteSelectedEligibleProductItemFromVisionServiceRequest(trackingNumber, productCatalogKey);
		
		deleteSelectedEPILink.setType(EligibilityProductItem.class.getName());
		deleteSelectedEPILink.setRel("urn://vnd.vsp.rels/removeeligibleproductitem");
		
		return deleteSelectedEPILink;
	}
	
	public static Link<VisionServiceRequest> buildDeleteVisionServiceRequestLink(String trackingNumber){
		Link<VisionServiceRequest> deleteVSRLink = new Link<VisionServiceRequest>();
		
		LinkBuilder.resource(VisionServiceRequestResource.class)
		.link(deleteVSRLink)
		.deleteVisionServiceRequest(trackingNumber);
		
		deleteVSRLink.setType(VisionServiceRequest.class.getName());
		deleteVSRLink.setRel("urn://vnd.vsp.rels/deletevisionservicerequest");
		
		return deleteVSRLink;
	}
	
	public static Link<VisionServiceRequests> buildSearchVisionServiceRequestsLink(String clientId,
			String divisionId, String policyId, String consumerId){
		Link<VisionServiceRequests> searchVSRLink = new Link<VisionServiceRequests>();
		
		LinkBuilder.resource(VisionServiceRequestResource.class)
		.link(searchVSRLink)
		.searchVisionServiceRequests(clientId, divisionId, policyId, consumerId);
		
		searchVSRLink.setType(VisionServiceRequests.class.getName());
		searchVSRLink.setRel("urn://vnd.vsp.rels/searchvisionservicerequests");
		
		return searchVSRLink;
	}
	
	public static Link<VisionServiceRequest> buildCreateVisionServiceRequestLink(String clientId, String divisionId, String policyId, String consumerId,
			String networkId, String productPackageName, String effectiveDate, VisionServiceRequest selectedEligibleProductItems ){
		Link<VisionServiceRequest> createVSRLink = new Link<VisionServiceRequest>();
		
		LinkBuilder.resource(VisionServiceRequestResource.class)
		.link(createVSRLink)
		.createVisionServiceRequest(clientId, divisionId, policyId, consumerId, networkId, productPackageName, effectiveDate, selectedEligibleProductItems);
		
		createVSRLink.setType(VisionServiceRequest.class.getName());
		createVSRLink.setRel("urn://vnd.vsp.rels/createvisionservicerequest");
		
		return createVSRLink;
	}
	
	public static Link<EligibilityProductItems> buildAddSelectedEligibleProductItemsLinkToVisionServiceRequestLink(String trackingId, EligibilityProductItems selectedEligibleProductItems ){
		Link<EligibilityProductItems> addEligibleProductItemsToVSRLink = new Link<EligibilityProductItems>();
		
		LinkBuilder.resource(VisionServiceRequestResource.class)
		.link(addEligibleProductItemsToVSRLink)
		.addSelectedEligibleProductItemsToVisionServiceRequest(trackingId, selectedEligibleProductItems);
		
		addEligibleProductItemsToVSRLink.setType(EligibilityProductItems.class.getName());
		addEligibleProductItemsToVSRLink.setRel("urn://vnd.vsp.rels/addeligibleproductitems");
		
		return addEligibleProductItemsToVSRLink;
	}
	
	public static Link<VisionServiceRequest> buildRetrieveVisionServiceRequestLink(String trackingNumber){
		Link<VisionServiceRequest> retrieveVSRLink = new Link<VisionServiceRequest>();
		
		LinkBuilder.resource(VisionServiceRequestResource.class)
		.link(retrieveVSRLink)
		.retrieveVisionServiceRequest(trackingNumber);
		
		retrieveVSRLink.setType(VisionServiceRequest.class.getName());
		retrieveVSRLink.setRel("urn://vnd.vsp.rels/retrievevisionservicerequest");
		
		return retrieveVSRLink;
	}

}
