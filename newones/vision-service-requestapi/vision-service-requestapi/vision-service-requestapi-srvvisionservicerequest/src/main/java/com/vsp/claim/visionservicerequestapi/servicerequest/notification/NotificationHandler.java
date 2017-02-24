package com.vsp.claim.visionservicerequestapi.servicerequest.notification;

import java.util.List;

import com.vsp.api.claim.model.Claim;

public abstract class NotificationHandler {
	
	public static boolean hasNotifications(List<Notification> notifications) {
		return notifications != null && notifications.size() > 0;
	}

	public abstract Claim handleNotifications(Claim claim); 
	
}
