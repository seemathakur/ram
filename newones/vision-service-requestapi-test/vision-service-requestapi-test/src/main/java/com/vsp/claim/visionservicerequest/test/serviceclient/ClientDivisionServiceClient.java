package com.vsp.claim.visionservicerequest.test.serviceclient;

import java.net.URI;

import com.vsp.api.client.model.ClientDivision;
import com.vsp.api.consumer.model.MemberPolicies;
import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;
import com.vspglobal.ipa.jaxrs.oauth2.AccessTokenProvider;
import com.vspglobal.ipa.jaxrs.oauth2.ClientAccessTokenProvider;

public class ClientDivisionServiceClient {
	

	private RestClient<Home> restClient;
	
	public ClientDivisionServiceClient() {
		restClient = new RestClient<Home>(URI.create(Preferences.get("rest", "homeurl")));
		setTokenProviderOnRestClient();
	}
	
	private void setTokenProviderOnRestClient() {
		AccessTokenProvider provider = buildTokenProvider();
		setTokenProviderOnRestClient(provider);
	}

	private AccessTokenProvider buildTokenProvider() {
		String clientId = Preferences.get("oauth-credentials", "preclaimapi-test.client_id");
		String clientSecret = Preferences.get("oauth-credentials", "preclaimapi-test.client_secret");
		String[] items = null;
		String valuesString = Preferences.get("oauth-credentials", "preclaimapi-test.authScopes");
		if (valuesString != null) {
			items = valuesString.split(",");
		}
		return  ClientAccessTokenProvider.get(clientId, clientSecret, items);
	}

	private void setTokenProviderOnRestClient(AccessTokenProvider provider) {
		restClient.setTokenProvider(provider);
	}


	
	
	public ClientDivision getClientDivisionByKey(MemberPolicyKey memberPolicyKey) throws Exception
	{
		MemberPolicies policies;
		String clientId = memberPolicyKey.getClientId();
		String divisionId = memberPolicyKey.getDivisionId();
		String policyId = memberPolicyKey.getPolicyId();
		Link<ClientDivision> link;
		try {
			policies = (MemberPolicies) restClient.link("memberpolicies")
						.param("clientid", clientId)
						.param("divisionid", divisionId)
						.param("policyid", policyId)
						.follow();
			link = policies.get(0).getClientdivision();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// Searching by unique key should always return 1 result
		
		return (ClientDivision) restClient.link(link).follow();

		
	}
	
	public ClientDivision getClientDivisionByMemebership(MemberPolicy pol) throws Exception
	{
		Link<ClientDivision> link;
		try{
		link = pol.getClientdivision();
		
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// Searching by unique key should always return 1 result
		
		return (ClientDivision) restClient.link(link).follow();
		
	}

}
