package com.vsp.claim.visionservicerequest.test.request;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.jbehave.core.model.ExamplesTable;

import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.util.ExamplesTableBuilder;
import com.vsp.il.test.jbehave.core.state.StoryStateSingleton;

public class ReservedClaimsLinkBuilder {
	
	public static final String RESERVED_CLAIMS_SEARCH_URL = "/vision-service-requestapi-web/reservedClaims";
	public static final String RESERVED_CLAIMS_TYPE = "com.vsp.api.claim.model.Claims";
		
	public static ExamplesTable buildReservedClaimsLinkAsTable() throws Exception {
		ExamplesTableBuilder urlBuilder = new ExamplesTableBuilder();
		String href = buildUrlKeyPathParamForReservedClaimsSearch();
        
		urlBuilder.addValue("href", href);
		urlBuilder.addValue("type", RESERVED_CLAIMS_TYPE);
		urlBuilder.addValue("rel", "search");
		return urlBuilder.build();
	}
	
	private static String buildUrlKeyPathParamForReservedClaimsSearch() {
		URI uri = null;
		String keyClientId = StoryStateSingletonEnum.CLIENT_ID.getName();
		String keyDivisionId = StoryStateSingletonEnum.DIVISION_ID.getName();
		String keyPolicyId = StoryStateSingletonEnum.POLICY_ID.getName();;
		String keyConsumerId = StoryStateSingletonEnum.CONSUMER_ID.getName();
		
		try {
			UriBuilder b = UriBuilder.fromPath(RESERVED_CLAIMS_SEARCH_URL).
					queryParam(keyClientId, (String) StoryStateSingleton.INSTANCE.get(keyClientId)).
					queryParam(keyDivisionId, (String) StoryStateSingleton.INSTANCE.get(keyDivisionId)).
					queryParam(keyPolicyId, (String) StoryStateSingleton.INSTANCE.get(keyPolicyId)).
					queryParam(keyConsumerId, (String) StoryStateSingleton.INSTANCE.get(keyConsumerId));
			uri = b.build();
			
		} catch (Exception e) {
			System.out.println("buildUrlKeyPathParamForReservedClaimsSearch: URI syntax incorrect: " + ExceptionUtils.getMessage(e));
		}
		return uri.toString();
	}
}
