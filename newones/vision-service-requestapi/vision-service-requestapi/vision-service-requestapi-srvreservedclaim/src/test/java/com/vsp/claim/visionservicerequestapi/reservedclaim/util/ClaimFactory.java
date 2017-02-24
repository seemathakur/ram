package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import org.joda.time.DateMidnight;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.consumer.model.Membership;
import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.Provider;
import com.vsp.api.provider.model.ProviderKey;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.api.provider.model.ServiceLocationKey;

public class ClaimFactory {
	
	private String taxId;
	private String hashCode;
	private String locationSequence; 
	private String claimNumber;
	private String claimExtNumber;
	private String clientId;
	private String divisionId;
	private String policyId;
	private String consumerId;
	private String networkId;
	private DateMidnight dateOfBirth;
	private MemberRelationEnum relationToSubscriber;
	private String productPackageName;
	private String affectEligibilityCode;
	
	public ClaimFactory(){
		
	}
	
	public Claim buildClaim(){
		Claim claim = new Claim();
		
		claim.setClaimKey(new ClaimKey(claimNumber, claimExtNumber));
		claim.setProviderNetworkAccessPoint(buildProviderNetworkAccessPoint());
		claim.setProvider(buildProvider());
		claim.setSubscriber(buildMember());
		claim.setPatient(buildPatient());
		claim.setProductPackageName(productPackageName);
		claim.setAffectEligibilityCode(affectEligibilityCode);
		
		return claim; 
	}
	
	private Membership buildMember(){
		Membership membership = new Membership();
		MemberPolicyKey key = new MemberPolicyKey();
		key.setClientId(clientId);
		key.setDivisionId(divisionId);
		key.setPolicyId(policyId);
		membership.setMemberPolicyKey(key);
		return membership; 
	}
	
	private Membership buildPatient(){
		Membership membership = new Membership();
		membership.setConsumerId(consumerId);
		membership.setRelationToSubscriber(relationToSubscriber);
		membership.setDateOfBirth(dateOfBirth);
		return membership; 
	}
	
	private Provider buildProvider() {
		Provider provider = new Provider();
		provider.setKey(buildProviderKey());
		return provider;
	}
	
	private ProviderKey buildProviderKey(){
		ProviderKey key = new ProviderKey();
		
		key.setProviderTaxId(taxId);

		return key; 
	}


	private ProviderNetworkAccessPoint buildProviderNetworkAccessPoint(){
		ProviderNetworkAccessPoint accesspoint = new ProviderNetworkAccessPoint();
		accesspoint.setProviderNetworkKey(buildProviderNetworkKey());
		accesspoint.setServiceLocation(buildServiceLocation());
		
		return accesspoint;
	}
	
	private ProviderNetworkKey buildProviderNetworkKey() {
		ProviderNetworkKey key = new ProviderNetworkKey();
		key.setNetworkId(networkId);
		return key;
	}

	private ServiceLocation buildServiceLocation(){
		ServiceLocation serviceLocation = new ServiceLocation();

		ServiceLocationKey serviceLocationKey = buildServiceLocationKey(); 
		serviceLocation.setKey(serviceLocationKey);
		
		return serviceLocation;
	}


	private ServiceLocationKey buildServiceLocationKey() {
		ServiceLocationKey serviceLocationKey = new ServiceLocationKey();
		
		serviceLocationKey.setProviderTaxId(taxId);
		serviceLocationKey.setServiceLocationHashCode(hashCode);
		serviceLocationKey.setServiceLocationSequence(locationSequence);

		
		return serviceLocationKey;
	}
	
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public void setLocationSequence(String locationSequence) {
		this.locationSequence = locationSequence;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getClaimExtNumber() {
		return claimExtNumber;
	}

	public void setClaimExtNumber(String claimExtNumber) {
		this.claimExtNumber = claimExtNumber;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public DateMidnight getPatientDob() {
		return dateOfBirth;
	}

	public void setPatientDob(DateMidnight dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public MemberRelationEnum getRelationToSubscriber() {
		return relationToSubscriber;
	}

	public void setRelationToSubscriber(MemberRelationEnum relationToSubscriber) {
		this.relationToSubscriber = relationToSubscriber;
	}

	public String getProductPackageName() {
		return productPackageName;
	}

	public void setProductPackageName(String productPackageName) {
		this.productPackageName = productPackageName;
	}

	public String getAffectEligibilityCode() {
		return affectEligibilityCode;
	}

	public void setAffectEligibilityCode(String affectEligibilityCode) {
		this.affectEligibilityCode = affectEligibilityCode;
	}
	
}
