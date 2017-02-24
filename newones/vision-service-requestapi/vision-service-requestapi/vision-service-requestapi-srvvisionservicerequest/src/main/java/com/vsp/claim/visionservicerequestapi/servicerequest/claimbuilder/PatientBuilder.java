package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.Membership;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;

public class PatientBuilder {

	private VisionServiceRequestApiContext request;
	private CommandMap commandMap;
	private static final Logger LOG = LoggerFactory.getLogger(PatientBuilder.class);

	public PatientBuilder(VisionServiceRequestApiContext request,CommandMap commandMap) {
		this.request = request;
		this.commandMap = commandMap;
	}

	public Membership buildPatient() {
		RetrieveMemberPoliciesCommand memberPolicyCommand = getMemberPolicyCommandFromMap();
		MemberPolicy memberPolicy = getMemberPolicyFromMemberPolicyCommand(memberPolicyCommand);
		return getPatientMembershipFromMemberPolicyByConsumerId(memberPolicy);
	}

	private RetrieveMemberPoliciesCommand getMemberPolicyCommandFromMap() {
		return (RetrieveMemberPoliciesCommand) commandMap.get(CommandMap.RETRIEVE_MEMBER_POLICY_COMMAND);
	}

	private MemberPolicy getMemberPolicyFromMemberPolicyCommand(RetrieveMemberPoliciesCommand memberPolicyCommand) {
		MemberPolicy memberPolicy = null;
		memberPolicy = memberPolicyCommand.getReturnValue();
		return memberPolicy;
	}

	private Membership getPatientMembershipFromMemberPolicyByConsumerId(MemberPolicy memberPolicy) {
		return findMatchingMembershipByConsumerId(memberPolicy.getMemberships());
	}

	private Membership findMatchingMembershipByConsumerId(Membership[] memberships) {
		Membership matchingMembership = null;
		for(Membership currentMembership : memberships) {
			if(isMatchingMembership(currentMembership)) {
				matchingMembership = currentMembership;
				break;
			}
		}
		if(matchingMembership != null){
			DebugLogger.debugEnabled(LOG, "Found membership by consumderId: {}", matchingMembership.getConsumerId());
		}
		return matchingMembership;
	}

	private boolean isMatchingMembership(Membership currentMembership) {
		String currentConsumerId = currentMembership.getConsumerId();
		return currentConsumerId.equals(request.getConsumerId());
	}

}
