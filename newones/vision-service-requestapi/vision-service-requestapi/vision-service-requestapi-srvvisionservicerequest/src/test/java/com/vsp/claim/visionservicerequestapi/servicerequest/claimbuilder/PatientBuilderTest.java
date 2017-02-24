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
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.CreateServiceRequestTestHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.il.util.Preferences;

public class PatientBuilderTest {
	
	private static final String MOCK_CONSUMER_ID = "42424242";
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}

	@Test
	public void testBuildPatientInfo() throws Exception {
		VisionServiceRequestApiContext testRequest = 
				new VisionServiceRequestApiContext(null, MOCK_CONSUMER_ID, null, null, CreateServiceRequestTestHelper.EFFECTIVE_DATE_STR, null);
		CommandMap commandMap = buildTestCommandMapWithMockedMemberPolicyCommand();
		Membership patient = new PatientBuilder(testRequest, commandMap).buildPatient();
		assertNotNull(patient);
		assertEquals(MemberRelationEnum.Child, patient.getRelationToSubscriber());
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
		mockMembership.setConsumerId("12345678");
		Membership mockChild = new Membership();
		mockChild.setRelationToSubscriber(MemberRelationEnum.Child);
		mockChild.setConsumerId(MOCK_CONSUMER_ID);
		mockMemberPolicy.setMemberships(new Membership[] { mockMembership, mockChild });
		return mockMemberPolicy;
	}

}
