package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.consumer.model.Membership;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.il.util.Preferences;

public class SubscriberBuilderTest {
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}

	@Test
	public void testBuildSubscriberInfo() throws Exception {
		CommandMap commandMap = buildTestCommandMapWithMockedMemberPolicyCommand();
		Membership subscriber = new SubscriberBuilder(commandMap).buildSubscriber();
		assertNotNull(subscriber);
		assertEquals(MemberRelationEnum.Member, subscriber.getRelationToSubscriber());
	}

	private CommandMap buildTestCommandMapWithMockedMemberPolicyCommand() throws Exception {
		CommandMap commandMap = new CommandMap();
		RetrieveMemberPoliciesCommand memberPoliciesCommand = mockRetrieveMemberPoliciesCommand();
		commandMap.put(CommandMap.RETRIEVE_MEMBER_POLICY_COMMAND, memberPoliciesCommand);
		return commandMap;
	}

	private RetrieveMemberPoliciesCommand mockRetrieveMemberPoliciesCommand() throws Exception {
		RetrieveMemberPoliciesCommand memberPoliciesCommand = mock(RetrieveMemberPoliciesCommand.class);
		MemberPolicy mockResponse = buildMockedMemberPolicy();
		when(memberPoliciesCommand.getReturnValue()).thenReturn(mockResponse);
		return memberPoliciesCommand;
	}

	private MemberPolicy buildMockedMemberPolicy() {
		MemberPolicy mockMemberPolicy = new MemberPolicy();
		Membership mockMembership = new Membership();
		mockMembership.setRelationToSubscriber(MemberRelationEnum.Member);
		Membership mockChild = new Membership();
		mockChild.setRelationToSubscriber(MemberRelationEnum.Child);
		mockMemberPolicy.setMemberships(new Membership[] { mockMembership, mockChild });
		return mockMemberPolicy;
	}

}
