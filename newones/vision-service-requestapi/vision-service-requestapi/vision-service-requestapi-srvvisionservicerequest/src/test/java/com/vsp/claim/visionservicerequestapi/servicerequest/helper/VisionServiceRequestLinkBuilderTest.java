package com.vsp.claim.visionservicerequestapi.servicerequest.helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.core.Link;
import com.vsp.il.util.Preferences;

public class VisionServiceRequestLinkBuilderTest {

	private static final String TRACKING_NUMBER = "12345678";
	private static final String SELF_REL = "self";
	private static final String SELF_TYPE = "application/vnd.vsp.visionservicerequest";
	private static final String SELF_HREF_PARTIAL = "service-requestapi-web/visionservicerequests/" + TRACKING_NUMBER;
	
	@Before
	public void init(){
		if(!Preferences.initialized()) {
			Preferences.initialize();
		}
	}
	
	@Test
	public void testBuildSelfLink(){
		Link<VisionServiceRequest> visionServiceLink = VisionServiceRequestLinkBuilder.buildSelfLink(TRACKING_NUMBER);
		Assert.assertTrue("SELF_REL match fails", SELF_REL.equals(visionServiceLink.getRel()));
		Assert.assertTrue("SELF_TYPE match fails", SELF_TYPE.equals(visionServiceLink.getType()));
		String selfHREF = visionServiceLink.getHref();
		Assert.assertTrue("SELF_HREF_PARTIAL match fails", selfHREF.contains(SELF_HREF_PARTIAL));
	}
}
