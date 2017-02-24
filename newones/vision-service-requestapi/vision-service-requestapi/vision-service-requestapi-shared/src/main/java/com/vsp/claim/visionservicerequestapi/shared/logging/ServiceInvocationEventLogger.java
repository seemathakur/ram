package com.vsp.claim.visionservicerequestapi.shared.logging;

import org.slf4j.Logger;
import org.slf4j.ext.XLogger;

import com.vsp.jaxrs.client.HttpMethod;

public final class ServiceInvocationEventLogger {
	
	private ServiceInvocationEventLogger() {
		
	}
	
	public static void startLoggingServiceInvocationEvent(Logger log, XLogger.Level level, ServiceInvocationEvent event) {
		TimerEventLogger.logEvent(log, level, event.begin());
	}
	
	public static void stopLoggingServiceInvocationEvent(Logger log, XLogger.Level level, ServiceInvocationEvent event) {
		TimerEventLogger.logEvent(log, level, event.end());
	}

	public static ServiceInvocationEvent createServiceInvocationEvent(String name, String description) {
		return new ServiceInvocationEvent(name, description);
	}
	
	public static ServiceInvocationEvent startServiceInvocationLogEvent(String resourceName, HttpMethod httpMethod, Logger log) {
		ServiceInvocationEvent timerEvent = createServiceInvocationEvent(resourceName, httpMethod.toString() + " on " + resourceName);
		startLoggingServiceInvocationEvent(log, XLogger.Level.INFO, timerEvent);
		return timerEvent;
	}
	
	public static void stopServiceInvocationLogEvent(Logger log, ServiceInvocationEvent timerEvent) {
		stopLoggingServiceInvocationEvent(log, XLogger.Level.INFO, timerEvent);
	}

}
