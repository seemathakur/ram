package com.vsp.claim.visionservicerequestapi.reservedclaim.junit;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsp.jaxrs.provider.VspObjectMapperFactory;

public class MockObjectProvider {

	private ObjectMapper jsonMapper;
	
	
	public MockObjectProvider() {
		jsonMapper = VspObjectMapperFactory.buildJsonMapper();
	}
	
	
	public <T> Object mockObjectFromJson(String fileName, Class<T> classType)
			throws JsonParseException, JsonMappingException, IOException {
		InputStream jsonData = 
			this.getClass().getClassLoader().getResourceAsStream(fileName);
		return mockObjectFromJson(jsonData, classType);
	}
	
	
	public <T> Object mockObjectFromJson(InputStream source, 
			Class<T> classType) 
			throws JsonParseException, JsonMappingException, IOException {
		return jsonMapper.readValue(source, classType);
	}
}