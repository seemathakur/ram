package com.vsp.claim.visionservicerequestapi.shared.logging;

import org.slf4j.Logger;
import org.slf4j.ext.XLogger;

public final class TimerEventLogger {
	
	private TimerEventLogger() {
	}
	
	public static void logEvent(Logger log, XLogger.Level level, TimerEvent timerEvent) {
		
		if (level.equals(XLogger.Level.INFO)) {
			if (!log.isInfoEnabled()) {
				return;
			}

			if (timerEvent == null) {
				return;
			}
			String eventDescription = getEventDescription(timerEvent);
			if (timerEvent.hasEnded()) {
				eventDescription = String.format("%s - Result=Success, duration time=%s ms", eventDescription, timerEvent.getDurationInMillis());
			} 
			log.info(eventDescription);
		}
		
		else if (level.equals(XLogger.Level.DEBUG)) {
			if (!log.isDebugEnabled()) {
				return;
			}
			
			if (timerEvent == null) {
				return;
			}
			String eventDescription = getEventDescription(timerEvent);
			if (timerEvent.hasEnded()) {
				eventDescription = String.format("%s - Result=Success, duration time=%s ms", eventDescription, timerEvent.getDurationInMillis());
			} 
			log.debug(eventDescription);
		}	
	}
	
	private static String getEventDescription(Event event) {
		return event.getDescription();
	}

}
