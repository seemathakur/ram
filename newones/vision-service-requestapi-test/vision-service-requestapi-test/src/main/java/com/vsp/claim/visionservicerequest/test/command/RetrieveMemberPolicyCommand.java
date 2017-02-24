package com.vsp.claim.visionservicerequest.test.command;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.claim.visionservicerequest.test.serviceclient.MemberPolicyServiceClient;

public class RetrieveMemberPolicyCommand {
	
	public static MemberPolicy getMemberPolicy(String policyKey) {
		MemberPolicy memberPolicy = loadMemberPolicy(policyKey);
		return memberPolicy;
	}

	private static MemberPolicy loadMemberPolicy(String policyKey) {
		MemberPolicyKey memberPolicyKey = buildMemberPolicyKeyObject(policyKey);
		MemberPolicy policy = 
				new MemberPolicyServiceClient().searchByMemberPolicyKey(memberPolicyKey);
		return policy;
	}
	
	private static MemberPolicyKey buildMemberPolicyKeyObject(String policyKeyString) {
		MemberPolicyKey policyKey = new MemberPolicyKey();
		String[] parameters = policyKeyString.split("-");
		if(parameters.length != 3) {
			throw new NullPointerException(
					"Not enough parameters to build a member policy key to load the member. "
					+ "Expected \"clientId-divisionId-policyId\". Actual \"" 
					+ policyKeyString 
					+ "\"");
		}
		policyKey.setClientId(parameters[0]);
		policyKey.setDivisionId(parameters[1]);
		policyKey.setPolicyId(parameters[2]);
		return policyKey;
	}
	
	
}
