package com.vsp.claim.visionservicerequestapi.shared.logging;

import org.slf4j.Logger;
import org.slf4j.ext.XLogger;

public final class MemoryEventLogger {
	
	private MemoryEventLogger() {
	}
	
	public static void logEvent(Logger log, XLogger.Level level, MemoryEvent memoryEvent) {
		
		if (level.equals(XLogger.Level.INFO)) {
			if (!log.isInfoEnabled()) {
				return;
			}

			if (memoryEvent == null) {
				return;
			}
			String eventDescription = getEventDescription(memoryEvent);
			if (memoryEvent.hasEnded()) {
				eventDescription = String.format("%s - Ending memory=%s bytes, consumed memory=%s bytes", eventDescription, memoryEvent.getEnd(), memoryEvent.getConsumedMemory());
			}
			else {
				eventDescription = String.format("%s - Starting memory=%s bytes", eventDescription, memoryEvent.getBegin());
			}
			log.info(eventDescription);
		}
		
		else if (level.equals(XLogger.Level.DEBUG)) {
			if (!log.isDebugEnabled()) {
				return;
			}

			if (memoryEvent == null) {
				return;
			}
			String eventDescription = getEventDescription(memoryEvent);
			if (memoryEvent.hasEnded()) {
				eventDescription = String.format("%s - Ending memory=%s bytes, consumed memory=%s bytes", eventDescription, memoryEvent.getEnd(), memoryEvent.getConsumedMemory());
			}
			else {
				eventDescription = String.format("%s - Starting memory=%s bytes", eventDescription, memoryEvent.getBegin());
			}
			log.debug(eventDescription);
		}
	}
	
	private static String getEventDescription(Event event) {
		return event.getDescription();
	}

}
