package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.ClaimError;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.Notification;
import com.vsp.il.util.Preferences;

public class ClaimErrorBuilderTest {
	
	private ClaimErrorBuilder builder; 
	private static final String ERROR_CAT = "Claim";
	private static final String ERROR_NUMBER ="PRELIQ0014"; 
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testErrorBuilderMapsNotificationToClaimError(){
		List<Notification> notifications = buildNotificationsList(); 
		builder = new ClaimErrorBuilder();
		List<ClaimError> errors = builder.buildClaimErrorsFromNotifications(notifications);
		assertEquals(notifications.size(), errors.size());
		assertEquals(ERROR_CAT, errors.get(0).getErrorCategory());
		assertEquals(ERROR_NUMBER, errors.get(0).getErrorNumber()); 
	}
	
	@Test
	public void testErrorBuilderMapsLongNotificationToClaimError(){
		List<Notification> notifications = buildLongNotificationsList();
		builder = new ClaimErrorBuilder();
		List<ClaimError> errors = builder.buildClaimErrorsFromNotifications(notifications);
		assertEquals(notifications.size(), errors.size());
		assertEquals(ERROR_CAT, errors.get(0).getErrorCategory());
		assertEquals(ERROR_NUMBER, errors.get(0).getErrorNumber()); 
	}
	
	@Test
	public void testErrorBuilderMapsNoNotificationsToNoClaimError(){
		List<Notification> notifications = buildNotificationsListNoNotifications();
		builder = new ClaimErrorBuilder();
		List<ClaimError> errors = builder.buildClaimErrorsFromNotifications(notifications);
		assertEquals(notifications.size(), errors.size());
	}
	
	@Test
	public void testErrorBuilderMapsNullSuspendsToNoClaimError(){
		List<Notification> notifications = null;
		builder = new ClaimErrorBuilder();
		List<ClaimError> errors = builder.buildClaimErrorsFromNotifications(notifications);
		assertEquals(0, errors.size());
	}
	
	public List<Notification> buildNotificationsListNoNotifications(){
		List<Notification> notifications = new ArrayList<Notification>();
		return notifications; 
	}
	
	private List<Notification> buildNotificationsList() {
		List<Notification> notifications = new ArrayList<Notification>(); 
		Notification notification = new Notification();
		notification.setCode(ERROR_NUMBER);
		notification.setDescription("MISSING/INV ADDRESS");
		notifications.add(notification);
		return notifications;
	}
	
	private List<Notification> buildLongNotificationsList() {
		List<Notification> notifications = new ArrayList<Notification>(); 
		Notification notification = new Notification();
		notification.setCode("ERROR_"+ERROR_NUMBER);
		notification.setDescription("MISSING/INV ADDRESS");
		notifications.add(notification);
		return notifications;
	}

}
