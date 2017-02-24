package com.vsp.claim.visionservicerequest.test.util;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.consumer.model.Membership;

public class MembershipHelper {
	
	public static Membership extractMembershipByConsumerId(MemberPolicy memberPolicy, String consumerId) {
		Membership[] memberships = memberPolicy.getMemberships();
		return extractMembershipByConsumerId(memberships, consumerId);
	}

	public static Membership extractMembershipByConsumerId(Membership[] memberships, String consumerId) {
		Membership correctMembership = null;
		for(Membership currentMembership : memberships) {
			if(currentMembership.getConsumerId().equals(consumerId)) {
				correctMembership = currentMembership;
			}
		}
		if(correctMembership == null) {
			throw new NullPointerException("The given consumer id, " 
					+ consumerId 
					+ " could not be found as a part of the retrieved member policy");
		}
		return correctMembership;
	}
	
	
	public static Membership extractMembershipForSubscriber(MemberPolicy memberPolicy){
		return extractMembershipByRelationToSubscriber(memberPolicy, 
				MemberRelationEnum.Member.getCode());
	}
	
	private static Membership extractMembershipByRelationToSubscriber(MemberPolicy memberPolicy, 
			String relationToSubscriber) {
		Membership[] memberships = memberPolicy.getMemberships();
		return extractMembershipByRelationToSubscriber(memberships, relationToSubscriber);
	}
	
	private static Membership extractMembershipByRelationToSubscriber(Membership[] memberships, 
			String relationToSubscriber) {
		Membership correctMembership = null;
		for(Membership currentMembership : memberships) {
			if(currentMembership.getRelationToSubscriber()
					.getCode().equals(relationToSubscriber)) {
				correctMembership = currentMembership;
			}
		}
		if(correctMembership == null) {
			throw new NullPointerException("The matching relation to subscriber " 
					+ relationToSubscriber 
					+ " could not be found as a part of the retrieved member policy");
		}
		return correctMembership;
	}

}
