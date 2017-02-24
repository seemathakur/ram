package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.consumer.model.Membership;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;


public class SubscriberBuilder {
	
	private CommandMap commandMap;
	
	private static final Logger LOG = LoggerFactory.getLogger(SubscriberBuilder.class);

	public SubscriberBuilder(CommandMap commandMap) {
		this.commandMap = commandMap;
	}

	public Membership buildSubscriber() {
		RetrieveMemberPoliciesCommand memberPolicyCommand = getMemberPolicyCommandFromMap();
		MemberPolicy memberPolicyResponse = getMemberPolicyFromMemberPolicyCommand(memberPolicyCommand);
		logMemberPolicyResponse(memberPolicyResponse);
		Membership returnMembership = getSubscriberMembershipFromMemberPolicyByRelation(memberPolicyResponse);
		logMembershipResponse(returnMembership);

		return returnMembership;
	}

	private void logMembershipResponse(Membership returnMembership) {
		if (returnMembership==null) {
			DebugLogger.debugEnabled(LOG, "get subscriber membership from memberPolicy by relation returned null");
		}
	}

	private void logMemberPolicyResponse(MemberPolicy memberPolicy) {
		if (memberPolicy==null) {
			DebugLogger.debugEnabled(LOG, "get memberPolicy from memberPolicyCommand returned null");
		}
	}

	private RetrieveMemberPoliciesCommand getMemberPolicyCommandFromMap() {
		DebugLogger.debugEnabled(LOG,"getting member policy command from map");
		return (RetrieveMemberPoliciesCommand) commandMap.get(CommandMap.RETRIEVE_MEMBER_POLICY_COMMAND);
	}

	private MemberPolicy getMemberPolicyFromMemberPolicyCommand(RetrieveMemberPoliciesCommand memberPolicyCommand) {
		MemberPolicy memberPolicy = null;
		DebugLogger.debugEnabled(LOG,"returning value from memberPolicyCommand");
		memberPolicy = memberPolicyCommand.getReturnValue();
		return memberPolicy;
	}

	private Membership getSubscriberMembershipFromMemberPolicyByRelation(MemberPolicy memberPolicy) {
		return findMatchingMembershipByMemberRelationship(memberPolicy.getMemberships());
	}

	private Membership findMatchingMembershipByMemberRelationship(Membership[] memberships) {
		Membership matchingMembership = null;
		for(Membership currentMembership : memberships) {
			DebugLogger.debugEnabled(LOG,"currentMembership= {}",currentMembership.getRelationToSubscriber());
			if(isMemberRelationMembership(currentMembership)) {
				matchingMembership = currentMembership;
				break;
			}
		}
		return matchingMembership;
	}

	private boolean isMemberRelationMembership(Membership currentMembership) {
		return currentMembership.getRelationToSubscriber().equals(MemberRelationEnum.Member);
	}

}
