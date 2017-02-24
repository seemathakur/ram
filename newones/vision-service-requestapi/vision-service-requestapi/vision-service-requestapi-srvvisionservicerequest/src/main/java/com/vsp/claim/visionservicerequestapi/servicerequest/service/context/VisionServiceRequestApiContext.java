package com.vsp.claim.visionservicerequestapi.servicerequest.service.context;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateMidnight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.home.model.Home;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.Notification;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.oauth.AccessToken;
import com.vsp.oauth.ServiceLocationConstraint;

public class VisionServiceRequestApiContext {
	
	private MemberPolicyKey memberPolicyKey;
	private String consumerId;
	private String networkId;
	private String productPackageName;
	private DateMidnight effectiveDate;
	private VisionServiceRequest serviceRequest;
	private ApiContext apiContext; 
	private RestClient<Home> restClient; 
	private Set<Notification> notifications;
	private List<String> clientIdsToIssueMemberAuthOnly;
	private static final String AUTHORIZATION_DOMAIN = "authorization";
	
	private static final Logger LOG = LoggerFactory.getLogger(VisionServiceRequestApiContext.class);
	

	public VisionServiceRequestApiContext(MemberPolicyKey memberPolicyKey,	String consumerId, String networkId, 
			String productPackageName, String effectiveDate, VisionServiceRequest serviceRequest) {
		this.memberPolicyKey = memberPolicyKey;
		this.consumerId = consumerId;
		this.networkId = networkId;
		this.productPackageName = productPackageName;
		this.serviceRequest = serviceRequest;
		this.effectiveDate = new DateMidnight(effectiveDate);
		notifications = new HashSet<Notification>();
		clientIdsToIssueMemberAuthOnly = getListOfClientIdsToIssueMemberAuthOnly();
		initializeServiceRequest();
	}

	private final void initializeServiceRequest() {
		if(serviceRequest == null) {
			serviceRequest = new VisionServiceRequest();
		}
		initializeIssueDate();
		initializeEffectiveDate();
	}

	private final void initializeIssueDate() {
		if(serviceRequest.getIssueDate() == null) {
			serviceRequest.setIssueDate(new DateMidnight());
		}
	}

	private void initializeEffectiveDate() {
		if (effectiveDate == null) {
			effectiveDate = new DateMidnight();
		}		
	}

	public MemberPolicyKey getMemberPolicyKey() {
		return memberPolicyKey;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public String getNetworkId() {
		return networkId;
	}

	public String getProductPackageName() {
		return productPackageName;
	}
	
	public VisionServiceRequest getServiceRequest() {
		return serviceRequest;
	}
	
	public DateMidnight getEffectiveDate() {
		return effectiveDate;
	}
		
	private List<String> getListOfClientIdsToIssueMemberAuthOnly() {
		return Preferences.getList(AUTHORIZATION_DOMAIN, "clientIdsToIssueMemberAuthorizationOnly");
	}

	public ApiContext getApiContext() {
		return apiContext;
	}
	
	public AccessToken getAccessToken() {
		return apiContext.getAccessToken();
	}

	public ServiceLocationConstraint getServiceLocationConstraint() {
		if(hasAccessToken()){
			return getServiceLocationConstraint(getAccessToken()); 
		}
		LOG.info("Access token does not have service location constraint");
		return null;
	}
	
	public boolean hasServiceLocationConstraint(){
		return getServiceLocationConstraint() != null;
	}

	private ServiceLocationConstraint getServiceLocationConstraint(AccessToken token) {
		return token.getService_location_constraint();
	}

	private boolean hasAccessToken() {
		return getAccessToken() != null; 
	}
	
	public void addNotification(Notification notification) {
		notifications.add(notification); 
	}
		
	public boolean hasNotifications() {
		return notifications != null && notifications.size() > 0;
	}

	public List<Notification> getNotifications() {
		List<Notification> notificationList = new ArrayList<Notification>();
		notificationList.addAll(notifications); 
		return notificationList; 
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications.addAll(notifications);
	}

	public boolean isIssueMemberAuthorizationOnly() {
		if(hasAccessToken()){
			return clientIdsToIssueMemberAuthOnly.contains(getAccessToken().getClient_id());
		}
		return false;
	}

	public void setApiContext(ApiContext apiContext) {
		this.apiContext = apiContext;
	}

	public RestClient<Home> getRestClient() {
		return restClient;
	}

	public void setRestClient(RestClient<Home> restClient) {
		this.restClient = restClient;
	}

}
