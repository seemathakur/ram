package com.vsp.claim.visionservicerequest.test.request;

import java.util.List;

import org.joda.time.DateMidnight;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.consumer.model.Membership;

public class CreateHistoryRequest {
	
	private DateMidnight asOfDate;
	private Membership patient;
	private MemberPolicy policy;
	private String benefitType;
	private List<String> services;
	private String drPhoneNumber;
	
	public DateMidnight getAsOfDate() {
		return asOfDate;
	}
	
	public void setAsOfDate(DateMidnight asOfDate) {
		this.asOfDate = asOfDate;
	}
	
	public Membership getPatient() {
		return patient;
	}
	
	public void setPatient(Membership patient) {
		this.patient = patient;
	}
	
	public MemberPolicy getPolicy() {
		return policy;
	}
	
	public void setPolicy(MemberPolicy policy) {
		this.policy = policy;
	}
	
	public String getBenefitType() {
		return benefitType;
	}
	
	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}

	public List<String> getServices() {
		return services;
	}
	
	public void setServices(List<String> services) {
		this.services = services;
	}

	public String getDrPhoneNumber() {
		return drPhoneNumber;
	}

	public void setDrPhoneNumber(String drPhoneNumber) {
		this.drPhoneNumber = drPhoneNumber;
	}
	
}
