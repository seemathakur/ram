package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsp.api.claim.model.Claim;
import com.vsp.jaxrs.provider.VspObjectMapperFactory;

public final class JSONMapperUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(JSONMapperUtil.class);
	private static final ObjectMapper MAPPER = VspObjectMapperFactory.buildJsonMapper();

	private JSONMapperUtil() { }
	
	public static String convertToJSONString(Claim claim) {
		String message = "";
		
		try {
			message = MAPPER.writeValueAsString(claim);
		} catch (IOException ioException) {
			handleIoException(claim, ioException);
		}
		return message;
	}
	
	public static Claim convertFromJSONString(String message) {
		Claim claim = null;
		
		try {
			claim = MAPPER.readValue(message, Claim.class);
		} catch (IOException ioException) {
			handleIoException(claim, ioException);
		}
		return claim;
	}
	
	private static void handleIoException(Object object, IOException ioException) {
		String errorMessage = "Error cloning: " + object.getClass();
		LOG.error(errorMessage, ioException);
		throw new WebApplicationException(ioException);
	}
}
