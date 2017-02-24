package com.vsp.claim.visionservicerequestapi.servicerequest.notification;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimStatusEnum;
import com.vsp.il.util.Preferences;

public class ClaimBuilderNotificationHandlerTest {
	
	private VisionServiceRequestApiContext testContext; 

	@Before
	public void setup() {
		if (!Preferences.initialized()) {
			Preferences.initialize();
		}
		testContext = buildTestContext();
	}

	@Test
	public void testNotificationsAreSetOnClaimErrorsAndStatusIsIR() {
		List<Notification> notifications = buildNotificationsList();
		testContext.setNotifications(notifications);

		Claim claim = buildTestClaim();
		ClaimBuilderNotificationHandler handler = new ClaimBuilderNotificationHandler(testContext);
		Claim result = handler.handleNotifications(claim);

		assertEquals(notifications.size(), result.getClaimErrors().size());
		assertClaimStatus(result,ReservedClaimStatusEnum.INVALID_RESERVED.getStatusCode());
	}
	
	@Test
	public void testEmptyNotificationsAreSetNotOnClaimErrorsAndStatusIsRS() {
		List<Notification> notifications = new ArrayList<Notification>(); 
		notifications.add(new Notification()); 
		testContext.setNotifications(notifications);

		Claim claim = buildTestClaim();
		ClaimBuilderNotificationHandler handler = new ClaimBuilderNotificationHandler(testContext);
		Claim result = handler.handleNotifications(claim);

		assertEquals(0, result.getClaimErrors().size());
		assertClaimStatus(result, ReservedClaimStatusEnum.RESERVED.getStatusCode());
	}
	
	@Test
	public void testEmptyStringNotificationsAreSetNotOnClaimErrorsAndStatusIsRS() {
		List<Notification> notifications = new ArrayList<Notification>(); 
		notifications.add(new Notification("")); 
		testContext.setNotifications(notifications);

		Claim claim = buildTestClaim();
		ClaimBuilderNotificationHandler handler = new ClaimBuilderNotificationHandler(testContext);
		Claim result = handler.handleNotifications(claim);

		assertEquals(0, result.getClaimErrors().size());
		assertClaimStatus(result, ReservedClaimStatusEnum.RESERVED.getStatusCode());
	}
	
	@Test
	public void testEmptyStringMixedWithErrorNotificationsAreSetOnClaimErrorsAndStatusIsIR() {
		List<Notification> notifications = new ArrayList<Notification>(); 
		notifications.add(new Notification("")); 
		notifications.add(new Notification("error")); 
		testContext.setNotifications(notifications);

		Claim claim = buildTestClaim();
		ClaimBuilderNotificationHandler handler = new ClaimBuilderNotificationHandler(testContext);
		Claim result = handler.handleNotifications(claim);

		assertEquals(1, result.getClaimErrors().size());
		assertClaimStatus(result, ReservedClaimStatusEnum.INVALID_RESERVED.getStatusCode());
	}

	private void assertClaimStatus(Claim result, String statusCode) {
		assertEquals(statusCode, result.getStatusCode()); 
		for(ClaimLine claimLine : result.getClaimLines()){
			assertEquals(statusCode, claimLine.getStatusCode()); 
		}
	}

	private VisionServiceRequestApiContext buildTestContext() {
		return MockHelper.buildVisionServiceRequestApiContext();
	}

	private Claim buildTestClaim() {
		Claim testClaim = new Claim();
		testClaim.setClaimLines(new ArrayList<ClaimLine>());
		ClaimLine line = new ClaimLine();
		line.setStatusCode(ReservedClaimStatusEnum.RESERVED.getStatusCode());
		testClaim.getClaimLines().add(line);
		testClaim.setStatusCode(ReservedClaimStatusEnum.RESERVED.getStatusCode());
		return testClaim;
	}

	private List<Notification> buildNotificationsList() {
		List<Notification> notifications = new ArrayList<Notification>();
		Notification notification = new Notification();
		notification.setCode("PRELIQ0014");
		notification.setDescription("MISSING/INV ADDRESS");
		notifications.add(notification);
		return notifications;
	}
}
