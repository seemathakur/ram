package com.vsp.claim.visionservicerequestapi.servicerequest.service.context;

import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.consumer.model.MemberPolicyKey;

public class VisionServiceRequestApiContextBuilder {
	
	private String clientId;
	private String divisionId;
	private String policyId;
	private String consumerId;
	private String networkId;
	private String productPackageName;
	private String effectiveDate;
	private VisionServiceRequest serviceRequest; 
	
	public VisionServiceRequestApiContextBuilder(String clientId, String divisionId, String policyId, 
			String consumerId, String networkId, String productPackageName, String effectiveDate,
			VisionServiceRequest serviceRequest){
		
		this.clientId = clientId;
		this.divisionId = divisionId; 
		this.policyId = policyId;
		this.consumerId = consumerId;
		this.networkId = networkId;
		this.productPackageName = productPackageName;
		this.effectiveDate = effectiveDate;
		this.serviceRequest = serviceRequest;
		
	}
	
	public VisionServiceRequestApiContext buildContext() {
		MemberPolicyKey requestContextMemberPolicyKey = buildMemberPolicyKey();
		return new VisionServiceRequestApiContext(requestContextMemberPolicyKey, consumerId, networkId, productPackageName, effectiveDate, serviceRequest);
	}

	private MemberPolicyKey buildMemberPolicyKey() {
		MemberPolicyKey memberPolicyKey = new MemberPolicyKey();
		memberPolicyKey.setClientId(clientId);
		memberPolicyKey.setDivisionId(divisionId);
		memberPolicyKey.setPolicyId(policyId);
		return memberPolicyKey;
	}

}
