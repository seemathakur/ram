package com.vsp.claim.visionservicerequestapi.servicerequest.notification;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vsp.il.util.Preferences;

public class NotificationHandlerTest {
	private List<Notification> notifications; 
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testNotificationHandler(){
		assert(NotificationHandler.hasNotifications(buildNotificationsList()));
	}	
	
	@Test
	public void testNotificationHandlerEmpty(){
		assert(!NotificationHandler.hasNotifications(new ArrayList<Notification>()));
	}	
	
	private List<Notification> buildNotificationsList() {
		notifications = new ArrayList<Notification>();
		Notification notification = new Notification();
		notification.setCode("PRELIQ0014");
		notification.setDescription("MISSING/INV ADDRESS");
		notifications.add(notification);
		return notifications;
	}

}
