package com.vsp.claim.visionservicerequest.test.serviceclient;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateMidnight;

import com.vsp.api.consumer.model.MemberAddress;
import com.vsp.api.consumer.model.MemberCoverageCodeEnum;
import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.consumer.model.Membership;
import com.vsp.bl.ancillary.dto.personandcontact.v001.Address;
import com.vsp.bl.ancillary.dto.personandcontact.v001.Name;
import com.vsp.bl.claim.service.authorization.IssueAuthorizationRequest;
import com.vsp.bl.consumer.dto.member.v001.MemberKey;
import com.vsp.bl.consumer.dto.member.v001.SubscriberKey;
import com.vsp.claim.visionservicerequest.test.request.CreateHistoryRequest;
import com.vsp.il.util.Preferences;
import com.vsp.xl.dto.v002.Date;
import com.vsp.xl.dto.v002.SimpleCode;

public class IssueAuthorizationRequestBuilder {
	
	public IssueAuthorizationRequest buildIssueAuthorizationRequest(
			CreateHistoryRequest request) {
		IssueAuthorizationRequest builtRequest = new IssueAuthorizationRequest();
		builtRequest.setUserId("APL2AXN");
		builtRequest.setRequesterProcessName(Preferences.getApplication());
		builtRequest = buildAsOfDate(builtRequest, request.getAsOfDate());
		builtRequest = buildPatientInfo(builtRequest, request.getPatient());
		builtRequest = buildMemberPolicyInfo(builtRequest, request.getPolicy());
		builtRequest = buildBenefitType(builtRequest, request.getBenefitType());
		builtRequest = buildServices(builtRequest, request.getServices());
		builtRequest = buildStaticFields(builtRequest);
		builtRequest = buildProviderInfo(builtRequest, request.getDrPhoneNumber());
		return builtRequest;
	}

	private IssueAuthorizationRequest buildProviderInfo(
			IssueAuthorizationRequest builtRequest, String drPhoneNumber) {
		if(drPhoneNumber!=null){
			builtRequest.setDrPhoneNumber(drPhoneNumber);
		}
		return builtRequest;
	}

	private IssueAuthorizationRequest buildAsOfDate(IssueAuthorizationRequest builtRequest,
			DateMidnight asOfDate) throws NullPointerException {
		Date xmlAsOfDate = buildXmlDate(asOfDate);
		builtRequest.setAsOfDate(xmlAsOfDate);
		return builtRequest;
	}
	
	private Date buildXmlDate(DateMidnight date) {
		if(date == null) {
			throw new NullPointerException("Exception building XML date. "
					+ "Given DateMidnight is null");
		}
		int month = date.getMonthOfYear();
		int day = date.getDayOfMonth();
		int year = date.getYear();
		Date xmlAsOfDate = new Date(day, month, year);
		return xmlAsOfDate;
	}

	private IssueAuthorizationRequest buildPatientInfo(IssueAuthorizationRequest builtRequest,
			Membership patient) {
		if(patient == null) {
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Given patient info is null");
		}
		builtRequest = buildMemberKeyFromPatientInfo(builtRequest, patient);
		builtRequest = buildAddress(builtRequest, patient);
		return builtRequest;
	}

	private IssueAuthorizationRequest buildMemberKeyFromPatientInfo(
			IssueAuthorizationRequest builtRequest, Membership patient) {
		MemberKey memberKey = buildMemberKey(patient);
		builtRequest.setMemberKey(memberKey);
		setMemberName(builtRequest, patient.getName());
		setMemberId9Digit(builtRequest, memberKey.getSubscriberKey());
		
		return builtRequest;
	}

	private MemberKey buildMemberKey(Membership patient) {
		MemberKey memberKey = new MemberKey();
		Name name = buildName(patient.getName());
		memberKey.setMemberName(name);
		Date dateOfBirth = buildXmlDate(patient.getDateOfBirth());
		memberKey.setMemberDateOfBirth(dateOfBirth);
		SimpleCode memberRelationship = buildMemberRelationship(patient.getRelationToSubscriber());
		memberKey.setMemberRelationship(memberRelationship);
		SubscriberKey subscriberKey = buildSubscriberKey(patient.getMemberPolicyKey());
		memberKey.setSubscriberKey(subscriberKey);
		return memberKey;
	}

	private Name buildName(com.vsp.api.ancillary.model.personandcontact.Name name) {
		if(name == null) {
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Given patient's name is null.");
		}
		Name builtName = new Name();
		builtName.setFirstName(name.getFirstName());
		builtName.setLastName(name.getLastName());
		return builtName;
	}

	private SimpleCode buildMemberRelationship(MemberRelationEnum relationToSubscriber) {
		if(relationToSubscriber == null) {
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Given patient's relation to member is null.");
		}
		String relation = mapRelationToSubscriberToRelationToMember(relationToSubscriber.toString());
		
		return new SimpleCode("com.vsp.xl.codes.product.coverage.RelationToMemberCode", relation);
	}
	
	private String mapRelationToSubscriberToRelationToMember(String relationToSubscriber){
		relationToSubscriber = relationToSubscriber.toLowerCase();
		String relationToMember = ""; 
		
		switch(relationToSubscriber){
			case "dependentparent":
				relationToMember = "dependentParent";
				break;
			case "domesticpartner" :
				relationToMember = "domesticPartner";
				break;
			case "disableddependent" : 
				relationToMember = "disabledDep"; 
				break;
			default:
				relationToMember = relationToSubscriber;
		}
		
		return relationToMember; 
	}
	
	private SubscriberKey buildSubscriberKey(MemberPolicyKey memberPolicyKey) {
		if(memberPolicyKey == null) {
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Given patient's member policy key is null.");
		}
		SubscriberKey subscriberKey = new SubscriberKey();
		subscriberKey.setClientId(memberPolicyKey.getClientId());
		subscriberKey.setDivisionId(memberPolicyKey.getDivisionId());
		subscriberKey.setSubscriberId(memberPolicyKey.getPolicyId());
		return subscriberKey;
	}

	private IssueAuthorizationRequest buildAddress(
			IssueAuthorizationRequest builtRequest, Membership patient) {
		Address address = buildAddress(patient.getAddresses());
		builtRequest.setAddress(address);
		return builtRequest;
	}

	private Address buildAddress(MemberAddress[] addresses) {
		Address address = new Address();
		if(address == null || addresses == null) {
			System.out.println("WARNING: Patient does not have at least one address!");
			
			address.setStreetAddress1("3333 Quality Drive");
			address.setCity("Rancho Cordova");
			address.setState(new SimpleCode("com.vsp.xl.codes.common.StateCode", "CA"));
			address.setZip("95670");
			
			return address;
		}
		MemberAddress memberAddress = addresses[0];
		address.setStreetAddress1(memberAddress.getStreet1());
		address.setStreetAddress2(memberAddress.getStreet2());
		address.setCity(memberAddress.getCity());
		String state = memberAddress.getStateCode();
		address.setState(new SimpleCode("com.vsp.xl.codes.common.StateCode", state));
		address.setZip(formatZipCode(memberAddress.getZipCode()));
		address.setZipExtension(memberAddress.getZipExtension());
		return address;
	}
	
	private String formatZipCode(String zipCode) {
		if(zipCode != null && zipCode.length() > 5){
			return zipCode.substring(0, 5); 
		} else {
			return zipCode; 
		}
	}
	
	private void setMemberName(IssueAuthorizationRequest builtRequest, 
			com.vsp.api.ancillary.model.personandcontact.Name name) {
		Name memberName = buildName(name);
		builtRequest.setMemberName(memberName);
	}

	private void setMemberId9Digit(IssueAuthorizationRequest builtRequest, 
			SubscriberKey subscriberKey) {
		String subscriberId = subscriberKey.getSubscriberId();
		builtRequest.setMemberID9Digit(subscriberId);
	}

	private IssueAuthorizationRequest buildMemberPolicyInfo(IssueAuthorizationRequest builtRequest,
			MemberPolicy policy) {
		if(policy == null) {
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Given member policy info is null");
		}
		builtRequest.setClassId(policy.getClassId());
		builtRequest = setCoverageType(builtRequest, policy.getMemberCoverageCode());
		return builtRequest;
	}
	
	private IssueAuthorizationRequest setCoverageType(
			IssueAuthorizationRequest builtRequest, MemberCoverageCodeEnum coverageType) {
		SimpleCode coverageTypeCode = buildCoverageTypeCode(coverageType);
		builtRequest.setCoverageType(coverageTypeCode);
		return builtRequest;
	}

	private SimpleCode buildCoverageTypeCode(MemberCoverageCodeEnum coverageType) {
		String codeType = "com.vsp.xl.codes.consumer.CoverageTypeCode";
		String coverageTypeValue = mapCoverageType(coverageType);
		return new SimpleCode(codeType, coverageTypeValue);
	}

	private String mapCoverageType(MemberCoverageCodeEnum coverageType) {
		String coverageValue = "";
		switch(coverageType) {
		case MemberPlusFamily:
			coverageValue = "member+family";
			break;
		case MemberPlusOne:
			coverageValue = "member+1";
			break;
		case MemberOnly:
			coverageValue = "memberOnly";
			break;
		case MemberPlusChildren:
			coverageValue = "member+children";
			break;
		default:
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Unable to build CoverageTypeCode for given coverageType: " 
					+ coverageType.getCode());
		}
		return coverageValue;
	}

	private IssueAuthorizationRequest buildBenefitType(IssueAuthorizationRequest builtRequest,
			String benefitType) {
		if(benefitType == null) {
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Given product package name is null");
		}
		String codeType = "com.vsp.xl.codes.plan.BenefitTypeCode";
		SimpleCode benefitTypeCode = new SimpleCode(codeType, benefitType);
		builtRequest.setBenefitType(benefitTypeCode);
		return builtRequest;
	}

	private IssueAuthorizationRequest buildServices(IssueAuthorizationRequest builtRequest,
			List<String> services) {
		if(services == null || services.size() == 0) {
			throw new NullPointerException("Exception building IssueAuthorizationRequest. "
					+ "Given list of product items is empty");
		}
		SimpleCode[] soapServices = buildServiceArray(services);
		builtRequest.setServiceTypes(soapServices);
		return builtRequest;
	}

	private SimpleCode[] buildServiceArray(List<String> services) {
		List<SimpleCode> serviceTypes = new ArrayList<SimpleCode>();
		for(String service : services) {
			SimpleCode serviceType = buildServiceType(service);
			serviceTypes.add(serviceType);
		}
		return serviceTypes.toArray(new SimpleCode[0]);
	}

	private SimpleCode buildServiceType(String service) {
		String codeType = "com.vsp.xl.codes.plan.ServiceTypeCode";
		String serviceTypeValue = mapServiceType(service);
		return new SimpleCode(codeType, serviceTypeValue);
	}

	private String mapServiceType(String service) {
		String serviceType = "";
		if(service.contains("E")) {
			serviceType = "EXAM";
		} else if(service.contains("C")) {
			serviceType = "CL";
		} else if(service.contains("V")) {
			serviceType = "CLEX";
		} else if(service.contains("L")) {
			serviceType = "LENS";
		} else if(service.contains("F")) {
			serviceType = "FRAME";
		} else if(service.contains("T")) {
			serviceType = "TREAT";
		} else {
			throw new NullPointerException("A service type is null. "
					+ "Unable to find a service type match for given product item: " 
					+ service);
		}
		return serviceType;
	}

	private IssueAuthorizationRequest buildStaticFields(IssueAuthorizationRequest builtRequest) {
		builtRequest.setIsMemberAddress(true);
		SimpleCode originationSource = new SimpleCode(
				"com.vsp.xl.codes.claim.AuthorizationOriginationCode", "7");
		builtRequest.setOriginationSource(originationSource);
		return builtRequest;
	}

}
