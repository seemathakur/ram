package com.vsp.claim.visionservicerequestapi.servicerequest.helper;

import com.vsp.api.claim.VisionServiceRequestResource;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.core.Link;
import com.vsp.jaxrs.link.LinkBuilder;
import com.vsp.jaxrs.provider.VspMediaTypeRegistry;

public final class VisionServiceRequestLinkBuilder {

	private static final String SELF_REL = "self";
	public static final Class<VisionServiceRequestResource> VISION_SERVICE_REQUEST_RESOURCE = VisionServiceRequestResource.class;
	
	private VisionServiceRequestLinkBuilder() {}

	public static Link<VisionServiceRequest> buildSelfLink(String trackingNumber) {
		Link<VisionServiceRequest> selfLink = buildSelfLink();
		LinkBuilder.resource(VISION_SERVICE_REQUEST_RESOURCE)
			.link(selfLink)
			.retrieveVisionServiceRequest(trackingNumber);
		return selfLink;
	}
	
	private static Link<VisionServiceRequest> buildSelfLink() {
		Link<VisionServiceRequest> visionServiceRequestLink = new Link<VisionServiceRequest>();
		visionServiceRequestLink.setRel(SELF_REL);
		visionServiceRequestLink.setType(VspMediaTypeRegistry.getInstance().getMediaType(VisionServiceRequest.class).toString());
		return visionServiceRequestLink;
	}
	
}
