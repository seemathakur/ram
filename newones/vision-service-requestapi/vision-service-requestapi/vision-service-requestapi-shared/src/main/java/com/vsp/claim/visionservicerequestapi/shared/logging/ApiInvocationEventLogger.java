package com.vsp.claim.visionservicerequestapi.shared.logging;

import org.slf4j.Logger;
import org.slf4j.ext.XLogger;

public final class ApiInvocationEventLogger {
	
	private ApiInvocationEventLogger() {
		
	}
	
	public static void startLoggingApiInvocationEvent(Logger log, XLogger.Level level, ApiInvocationEvent event) {
		TimerEventLogger.logEvent(log, level, event.begin());
	}
	
	public static void stopLoggingApiInvocationEvent(Logger log, XLogger.Level level, ApiInvocationEvent event) {
		TimerEventLogger.logEvent(log, level, event.end());
	}

	public static ApiInvocationEvent createApiInvocationEvent(String name, String description) {
		return new ApiInvocationEvent(name, description);
	}

}
