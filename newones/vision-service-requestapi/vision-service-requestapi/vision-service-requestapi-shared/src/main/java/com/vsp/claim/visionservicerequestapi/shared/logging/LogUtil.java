package com.vsp.claim.visionservicerequestapi.shared.logging;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateMidnight;
import org.slf4j.Logger;
import org.slf4j.ext.XLogger;

import com.vsp.api.claim.model.ClaimError;
import com.vsp.api.home.model.Home;
import com.vsp.jaxrs.client.RestClient;

public final class LogUtil {
	
	private LogUtil() {
	   }
	
	public static void logClaimErrors(Logger log, List<ClaimError> errors) {
		if (CollectionUtils.isNotEmpty(errors)) {
			log.info("Claim returned with errors, claimErrors.size(): {}", errors.size());
			for (ClaimError e : errors) {
				log.info("error number: {} ; category: {} ; message: {}",
						e.getErrorNumber(),e.getErrorCategory(),e.getClaimMessage());
			}
		}
	}
	
	public static String getDateAsString(DateMidnight date){
		String dateString = null; 
		if(date != null){
			dateString = date.toString("yyyy-MM-dd");
		}
		return dateString;
	}

	public static void logRestClientReferenceValue(Logger log, XLogger.Level level, RestClient<Home> restClient, String message) {
		if (restClient != null) {
			if (level.equals(XLogger.Level.DEBUG)) {
				DebugLogger.debugEnabled(log, message + ": {}", restClient.toString());
			}
			else if (level.equals(XLogger.Level.INFO)) {
				log.info(message + ": {}", restClient.toString());
			}
			else if (level.equals(XLogger.Level.ERROR)) {
				log.error(message + ": {}", restClient.toString());
			}
		}
	}
}
