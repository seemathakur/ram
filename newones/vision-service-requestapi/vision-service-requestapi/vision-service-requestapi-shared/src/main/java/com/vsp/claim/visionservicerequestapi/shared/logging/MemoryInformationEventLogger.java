package com.vsp.claim.visionservicerequestapi.shared.logging;

import org.slf4j.Logger;
import org.slf4j.ext.XLogger;

public final class MemoryInformationEventLogger {
	
	private MemoryInformationEventLogger() {
		
	}
	
	public static void startLoggingMemoryInformationEvent(Logger log, XLogger.Level level, MemoryInformationEvent event) {
		MemoryEventLogger.logEvent(log, level, event.begin());
	}
	
	public static void stopLoggingMemoryInformationEvent(Logger log, XLogger.Level level, MemoryInformationEvent event) {
		MemoryEventLogger.logEvent(log, level, event.end());
	}

	public static MemoryInformationEvent createMemoryInformationEvent(String name, String description) {
		return new MemoryInformationEvent(name, description);
	}
}
