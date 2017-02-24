package com.vsp.claim.visionservicerequest.test.serviceclient;

import java.net.URI;

import com.vsp.api.consumer.model.MemberPolicies;
import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.home.model.Home;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;
import com.vspglobal.ipa.jaxrs.oauth2.AccessTokenProvider;
import com.vspglobal.ipa.jaxrs.oauth2.ClientAccessTokenProvider;

public class MemberPolicyServiceClient {
	
	private RestClient<Home> restClient;
	
	public MemberPolicyServiceClient() {
		restClient = new RestClient<Home>(URI.create(Preferences.get("rest", "homeurl")));
		Preferences.set("rest", "token.uri", Preferences.get("rest","token.spring"));
		setTokenProviderOnRestClient();
	}
	
	private void setTokenProviderOnRestClient() {
		AccessTokenProvider provider = buildTokenProvider();
		setTokenProviderOnRestClient(provider);
	}

	private AccessTokenProvider buildTokenProvider() {
		String clientId = Preferences.get("oauth-credentials", "api-test.client_id");
		String clientSecret = Preferences.get("oauth-credentials", "api-test.client_secret");
		String[] items = null;
		String valuesString = Preferences.get("oauth-credentials", "api-test.authScopes");
		if (valuesString != null) {
			items = valuesString.split(",");
		}
		return  ClientAccessTokenProvider.get(clientId, clientSecret, items);
	}

	private void setTokenProviderOnRestClient(AccessTokenProvider provider) {
		restClient.setTokenProvider(provider);
	}

	public MemberPolicy searchByMemberPolicyKey(MemberPolicyKey memberPolicyKey) {
		MemberPolicies policies;
		String clientId = memberPolicyKey.getClientId();
		String divisionId = memberPolicyKey.getDivisionId();
		String policyId = memberPolicyKey.getPolicyId();
		try {
			policies = (MemberPolicies) restClient.link("memberpolicies")
						.param("clientid", clientId)
						.param("divisionid", divisionId)
						.param("policyid", policyId)
						.follow();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// Searching by unique key should always return 1 result
		return policies.getFirst();
	}
	


}
