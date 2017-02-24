package com.vsp.claim.visionservicerequestapi.shared.logging;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;

/**
 * Wraps the MDC class in order to intercept the put operations and create a new entry containing all the values already set on the MDC map. 
 * the new entry's key is mdcData and is formatted with a key=value approach. This will allow to flush all
 * the MDC information at once for every log entry by adding %X{mdcData} to the formatter pattern.
 * 
 * @author denyco
 *
 */
public class MDCHelper {
		
	public static final String MDC_KEY = "mdcData";
	
	private static final String LOG_DATA_SEPARATOR = "|";
	
	/**
	 * Put all the values from the elementsMap to the MDC map, and also append the key=value pairs to the mdcData entry.
	 * @param key
	 * @param value
	 */
	public void put(Map<String, String> elementMap) {
		if (MapUtils.isEmpty(elementMap)) {
			return;
		}
		for (Entry<String , String> entry : (Set<Entry<String , String>>) elementMap.entrySet())  {
			String key = entry.getKey();
			String value = entry.getValue();
			MDC.put(key, value);
		}
		updateMergedEntry();
	}

	private void updateMergedEntry() {
		
		StringBuilder builder = new StringBuilder();
		MDC.remove(MDC_KEY);
		for (Entry<String , String> entry : (Set<Entry<String , String>>) MDC.getCopyOfContextMap().entrySet())  {
			String chunk = entry.getKey() + "=" + entry.getValue();
			builder.append(chunk).append(LOG_DATA_SEPARATOR);
		}
		if (builder.length() > 0) {
			String newString = StringUtils.removeEnd(builder.toString(), LOG_DATA_SEPARATOR); // one extra separator was appended, removing that
			MDC.put(MDC_KEY, newString);
		}	
	}
	
	/**
	 * Clears the MDC
	 */
	public void clear() {
		
		MDC.clear();
	}
}
