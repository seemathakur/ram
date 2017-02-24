package com.vsp.claim.visionservicerequest.test.request;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateMidnight;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.Membership;
import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.command.RetrieveMemberPolicyCommand;
import com.vsp.claim.visionservicerequest.test.util.AccessTokenHelper;
import com.vsp.claim.visionservicerequest.test.util.MembershipHelper;
import com.vsp.il.test.jbehave.core.state.StoryStateSingleton;
import com.vsp.oauth.ServiceLocationConstraint;

public class CreateHistoryRequestBuilder {
	
	public static CreateHistoryRequest buildCreateHistoryRequest(String benefitType, String services, 
			DateMidnight asOfDate) {
		CreateHistoryRequest request = new CreateHistoryRequest();
		request.setPolicy(getMemberPolicy());
		request.setPatient(getPatient());
		request.setBenefitType(benefitType);
		request.setServices(convertServicesToList(services));
		request.setAsOfDate(asOfDate);
		request.setDrPhoneNumber(getDoctorPhoneNumber());
		return request;
	}
	
	private static String getDoctorPhoneNumber() {
		ServiceLocationConstraint serviceLocationConstraint = AccessTokenHelper.getServiceLocationConstraint(); 
		String drPhoneNumber = getDoctorPhoneNumberFromServiceLocationConstraint(serviceLocationConstraint);
		return drPhoneNumber;
	}
	

	private static String getDoctorPhoneNumberFromServiceLocationConstraint(ServiceLocationConstraint serviceLocationConstraint) {
		String phoneNumber = null;
		
		if(serviceLocationConstraint!=null){
			phoneNumber = serviceLocationConstraint.getService_location_phone();
		}
		
		return phoneNumber;
	}

	private static Membership getPatient() {
		Membership patient = (Membership) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.PATIENT_KEY.getName());
		if(patient == null){
			String consumerId = getConsumerId();
			MemberPolicy memberPolicy = getMemberPolicy();
			if(consumerId != null && memberPolicy != null){
				patient = MembershipHelper.extractMembershipByConsumerId(memberPolicy, consumerId);
				StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.PATIENT_KEY.getName(), patient);
			}
		}
		
		return patient;
	}
	
	private static String getConsumerId(){
		return (String)StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.CONSUMER_ID.getName());
	}

	private static MemberPolicy getMemberPolicy(){
		MemberPolicy memberPolicy = (MemberPolicy)StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.MEMBER_POLICY.getName());
		if(memberPolicy == null){
			String memberPolicyKey = getMemberPolicyKey(); 
			if(memberPolicyKey !=null){
				memberPolicy = RetrieveMemberPolicyCommand.getMemberPolicy(memberPolicyKey);
				StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.MEMBER_POLICY.getName(), memberPolicy);
			}
		}
		
		return memberPolicy;
	}
	
	private static String getMemberPolicyKey(){
		return (String)StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.MEMBER_POLICY_KEY.getName());
	}
	
	private static List<String> convertServicesToList(String services) {
		List<String> servicesList = new ArrayList<String>();
		char[] servicesArray = services.toCharArray();
		for(char service : servicesArray) {
			servicesList.add(String.valueOf(service));
		}
		return servicesList;
	}
	
}
