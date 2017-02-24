package com.vsp.claim.visionservicerequest.test.util;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.il.test.jbehave.core.state.StoryStateSingleton;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.link.HomeRelativeEndpointProvider;
import com.vsp.oauth.ServiceLocationConstraint;
import com.vspglobal.ipa.domain.OAuth2Token;
import com.vspglobal.ipa.jaxrs.oauth2.AccessTokenProvider;

public class AccessTokenHelper {
	
	private static final String SERVICE_LOCATION_CONSTRAINT_KEY = "service_location_constraint";

	private static AccessTokenProvider getAccessTokenProvider(){
		return (AccessTokenProvider) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.ACCESS_TOKEN_PROVIDER.getName());
	}
	
	private static URI getTokenURI() throws URISyntaxException{
		HomeRelativeEndpointProvider endpointProvider = new HomeRelativeEndpointProvider(new URI(Preferences.get("rest", "homeurl")));
		return endpointProvider.getTokenEndpoint();
	}
	
	private static OAuth2Token getAccessToken(){
		OAuth2Token token = null;
		try {
			AccessTokenProvider tokenProvider = getAccessTokenProvider();
			if(tokenProvider != null){
				tokenProvider.refresh(getTokenURI());
				token = tokenProvider.get();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return token; 
	}
	
	public static ServiceLocationConstraint getServiceLocationConstraint() {
		OAuth2Token token = getAccessToken();
		ServiceLocationConstraint constraint = null;
		if(token != null){
			constraint = getServiceLocationConstraintFromTokenAttributes(token.getAdditionalAttributes());
		}
		return constraint;
	}

	@SuppressWarnings("unchecked")
	private static ServiceLocationConstraint getServiceLocationConstraintFromTokenAttributes(
			Map<String, Object> tokenAttributes) {
		ServiceLocationConstraint constraint = new ServiceLocationConstraint();
		LinkedHashMap<String, String> constraintValues = 
				(LinkedHashMap<String, String>) tokenAttributes.get(SERVICE_LOCATION_CONSTRAINT_KEY);
		if(constraintValues != null){
			Set<String> constraintFieldNames = constraintValues.keySet();
			for(String fieldName : constraintFieldNames) {
				try {
					Field constraintField = ServiceLocationConstraint.class.getDeclaredField(fieldName);
					constraintField.setAccessible(true);
					constraintField.set(constraint, constraintValues.get(fieldName));
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					throw new RuntimeException("Unable to build ServieLocationConstraint", e);
				}
			}
		}

		return constraint;
	}

}
