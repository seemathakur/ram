package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsp.jaxrs.provider.VspObjectMapperFactory;

public final class ClonerUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClonerUtil.class);
	private static final ObjectMapper MAPPER = VspObjectMapperFactory.buildJsonMapper();

	private ClonerUtil() { }
	
	public static <T> T clone(T object) {
		T clone = null;
		
		try {
			clone = doClone(object);
		} catch(IOException ioException) {
			handleIoException(object, ioException);
		}
		
		return clone;
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T doClone(T object) throws IOException {
		byte[] raw = MAPPER.writeValueAsBytes(object);		
		return (T) MAPPER.readValue(raw, object.getClass());
	}
	
	private static void handleIoException(Object object, IOException ioException) {
		String errorMessage = "Error cloning: " + object.getClass();
		LOG.error(errorMessage, ioException);
		throw new WebApplicationException(ioException);
	}
}
