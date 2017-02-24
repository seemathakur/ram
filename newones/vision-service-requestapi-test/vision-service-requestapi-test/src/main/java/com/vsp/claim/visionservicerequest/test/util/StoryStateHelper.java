package com.vsp.claim.visionservicerequest.test.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateMidnight;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityProductItems;
import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.il.test.jbehave.core.state.StoryStateSingleton;

/**
 * @author huyng
 *
 * Utility class to assist in working with StoryState
 */
public class StoryStateHelper {
	public static void saveKeyValue(String key, Object value) {
		StoryStateSingleton.INSTANCE.set(key, value);
	}	
	
	public static Object getKey(String key, Object value) {
		return StoryStateSingleton.INSTANCE.get(key);
	}
	
	public static EligibilityProductItems getEligibilityProductItems() {
		return (EligibilityProductItems) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.ELIGIBLE_PRODUCT_ITEMS.getName());
	}
	
	public static String getPolicyId() {
		return (String) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.POLICY_ID.getName());
	}
	
	public static EligibilityProductItem getEligibleProductItem() {
		return (EligibilityProductItem) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.ELIGIBLE_PRODUCT_ITEM.getName());
	}
	
	public static void setClaimKey(ClaimKey claimKey) {
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CLAIM_KEY.getName(), claimKey);	
	}
	
	public static void setClaimLineNumber(int lineNumber) {
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.LINE_NUMBER.getName(), lineNumber);	
	}
	
	public static ClaimKey getClaimKey(){
		return (ClaimKey) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.CLAIM_KEY.getName());
	}
	
	public static String getTrackingNumber(){
		return (String) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.TRACKING_NUMBER.getName());
	}
	
	public static String getClientId(){
		return (String) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.CLIENT_ID.getName());
	}
	
	public static String getConsumerId(){
		return (String) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.CONSUMER_ID.getName());
	}
	
	public static String getNetworkId(){
		return (String) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.NETWORK_ID.getName());
	}
	
	public static String getEffectiveDate(){
		DateMidnight effectiveDate = (DateMidnight) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.EFFECTIVE_DATE.getName());
		if(effectiveDate != null) {
			return effectiveDate.toString("YYYY-MM-dd");
		} else {
			return null;
		}
	}
	
	public static String getProductPackage(){
		return (String) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.PRODUCT_PACKAGE_NAME.getName());
	}
	
	public static String getDivision(){
		return (String) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.DIVISION_ID.getName());
	}
	
	public static Claim getClaim() {
		return (Claim) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.CLAIM.getName());
	}
	
	public static ClaimLine getClaimLine() {
		return (ClaimLine) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.CLAIM_LINE.getName());
	}
	
	public static int getClaimLineNumber() {
		return (int) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.LINE_NUMBER.getName());
	}
	
	public static VisionServiceRequest getVisionServiceRequest() {
		return (VisionServiceRequest) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.VISION_SERVICE_REQUEST.getName());
	}
	
	public static Set<String> getOutstandingAuthorizations() {		
		return Collections.unmodifiableSet(allAuthorizations());
	}
	
	public static Set<String> getOutstandingClaims() {		
		return Collections.unmodifiableSet(allClaims());
	}
	
	public static void clearOutstandingAuthorizations() {		
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.AUTH_ISSUED_IN_SCENARIO.getName(), null);
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getProductCatalogKeyList(){
		return (List<String>) StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.PRODUCT_CATALOG_KEYS.getName());
	}
	
	private static Set<String> allClaims(){
		Object claims = StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.CLAIMS_CREATED_IN_SCENARIO.getName());
		if (claims == null) {
			Set<String> emptyClaims = new HashSet<String>();
			StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CLAIMS_CREATED_IN_SCENARIO.getName(), emptyClaims);
			
			return emptyClaims;
		}
		
		return (Set<String>) claims;
	}
	
	public static void addOutstandingClaim(String claimNumber){
		Set<String> claims = allClaims(); 
		claims.add(claimNumber);
	}
	
	public static void deleteOutstandingClaim(String claimNumber) {
		Set<String> claims = allClaims();
		claims.remove(claimNumber);
	}
	
	public static void addOutstandingAuthorization(String auth) {		
		Set<String> auths = allAuthorizations();
		String authNumber = auth.trim(); 
		if(!authNumber.equals("")){
			auths.add(authNumber);
		}
	}
	
	public static void deleteOutstandingAuthorization(String auth) {
		Set<String> auths = allAuthorizations();
		auths.remove(auth);
	}
	
	@SuppressWarnings("unchecked")
	private static Set<String> allAuthorizations() {
		Object auths = StoryStateSingleton.INSTANCE.get(StoryStateSingletonEnum.AUTH_ISSUED_IN_SCENARIO.getName());
		if (auths == null) {
			Set<String> emptyAuths = new HashSet<String>();
			StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.AUTH_ISSUED_IN_SCENARIO.getName(), emptyAuths);
			
			return emptyAuths;
		}
		
		return (Set<String>) auths;
	}
	
}
