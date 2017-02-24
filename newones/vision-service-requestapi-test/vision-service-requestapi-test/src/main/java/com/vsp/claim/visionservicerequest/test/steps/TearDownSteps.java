package com.vsp.claim.visionservicerequest.test.steps;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;

import com.vsp.claim.visionservicerequest.test.StoryStateSingletonEnum;
import com.vsp.claim.visionservicerequest.test.util.StoryStateHelper;
import com.vsp.il.test.jbehave.core.state.StoryStateSingleton;
import com.vsp.il.test.jbehave.db.DbActions;
import com.vsp.il.test.jbehave.db.DbSteps;
import com.vsp.il.test.jbehave.rest.impl.RestActionsImpl;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;

public class TearDownSteps extends DbSteps{
	
	private DbActions actions; 
	private RestActionsImpl restAction; 

	public TearDownSteps(DbActions dbActions, RestActionsImpl restActions) {
		super(dbActions);
		actions = dbActions;
		this.restAction = restActions;
	}
	
	@BeforeScenario
	public void intializeRestClient(){
		restAction.setRestClient(new RestClient(URI.create(Preferences.get("rest", "homeurl"))));
		setDefaultTokenEndpointToSpring(); 
	}
	
	private void setDefaultTokenEndpointToSpring() {
		System.out.println("The token.uri was " + Preferences.get("rest","token.uri")); 
		Preferences.set("rest", "token.uri", Preferences.get("rest","token.spring"));
		System.out.println("The token.uri is now " + Preferences.get("rest","token.uri"));
	}

	@AfterScenario
	public void clearState() throws InterruptedException{
		actions.beforeScenarioSetVariables();
		deleteClaimAndLinesAfterScenario();
		sqlDeleteAuthorizations();
		
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.EFFECTIVE_DATE.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.PRODUCT_CATALOG_KEYS.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.MEMBER_POLICY_KEY.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.MEMBER_POLICY.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.PATIENT_KEY.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CONSUMER_ID.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.NETWORK_ID.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.PRODUCT_PACKAGE_NAME.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.LINE_NUMBER.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CLAIM_LINE.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.NUM_CLAIM_LINES.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.LEGACY_AUTH_NUMBER.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.LEGACY_AUTH_PATIENT_HISTORY.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.TRACKING_NUMBER.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CLIENT_ID.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.POLICY_ID.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.DIVISION_ID.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.ELIGIBLE_PRODUCT_ITEM.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.ELIGIBLE_PRODUCT_ITEMS.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.VISION_SERVICE_REQUEST.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CLAIM.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CLAIM_KEY.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.AUTH_ISSUED_IN_SCENARIO.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.ACCESS_TOKEN_PROVIDER.getName(), null);
		StoryStateSingleton.INSTANCE.set(StoryStateSingletonEnum.CLAIMS_CREATED_IN_SCENARIO.getName(), null);
		
		restAction.setAccessTokenProvider(null);
		
		actions.afterScenarioSetVariables();
	}
	
	@BeforeStories 
	public void beforeStories(){
		actions.beforeScenarioSetVariables();
		sqlDeleteAuthorizationsByMemberIds();
		actions.afterScenarioSetVariables();
	}
	
	@AfterStories 
	public void afterStories(){
		actions.beforeScenarioSetVariables();
		sqlDeleteAuthorizationsByMemberIds();
		actions.afterScenarioSetVariables();
	}
	
	public void deleteClaimAndLinesAfterScenario(){
		Set<String> claimNumbersToDelete = StoryStateHelper.getOutstandingClaims(); 
		for(String claimNumber:claimNumbersToDelete){
			deleteClaim(claimNumber); 
			StoryStateHelper.deleteOutstandingClaim(claimNumber);
		}
	}
	
	public void sqlDeleteAuthorizations() throws InterruptedException{
		Set<String> auths = StoryStateHelper.getOutstandingAuthorizations();
		for(String auth: auths){
		    deleteLegacyAuthorization(auth);
		} 
		StoryStateHelper.clearOutstandingAuthorizations();
		sqlDeleteAuthorizationsByMemberId();
	}
	
	public void sqlDeleteAuthorizationsByMemberId(){
		if(hasPolicyId()){
			String deleteAuthSqlByMemberId  = buildDeleteAuthSqlByMemberId(StoryStateHelper.getPolicyId()); 
			
			try {
				actions.executeUpdateSQL(deleteAuthSqlByMemberId);
				System.out.println("Deleted auths by memberId SQL " + deleteAuthSqlByMemberId);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}

	}
			
	private boolean hasPolicyId() {
		return StoryStateHelper.getPolicyId() != null;
	}

	public void sqlDeleteAuthorizationsByMemberIds(){
		String deleteAuthSqlByMemberId  = buildDeleteAuthSqlByMemberId(Preferences.getList("cleanup", "deleteBRByMemberId")); 
		
		try {
			actions.executeUpdateSQL(deleteAuthSqlByMemberId);
			System.out.println("Deleted auths by memberId SQL " + deleteAuthSqlByMemberId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private String buildDeleteAuthSqlByMemberId(List<String> memberIds) {
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append("VVSP001.REQ3302t ");
		sql.append("where MBR_SSN_NBR in (");
		sql.append(formatMemberIds(memberIds));
		sql.append(")");
		sql.append(";");

		return sql.toString();
	}
	
	private String buildDeleteAuthSqlByMemberId(String memberId) {
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append("VVSP001.REQ3302t ");
		sql.append("where MBR_SSN_NBR in (");
		sql.append("'");
		sql.append(memberId);
		sql.append("'");
		sql.append(")");
		sql.append(";");

		return sql.toString();
	}

	private String formatMemberIds(List<String> memberIds) {
		StringBuffer memberIdClause = new StringBuffer();
		for(String memberId: memberIds){
			memberIdClause.append("'");
			memberIdClause.append(memberId);
			memberIdClause.append("'"); 
			memberIdClause.append(",");
		}
		memberIdClause.deleteCharAt(memberIdClause.lastIndexOf(","));
		return memberIdClause.toString();
	}

	private void deleteLegacyAuthorization(String legacyAuthNumber){
		String deleteAuthSql = buildDeleteAuthSql(legacyAuthNumber); 
		
		try {
			actions.executeUpdateSQL(deleteAuthSql);
			System.out.println("claim-preclaimapi-test deleted legacy authorization #" + legacyAuthNumber + " from REQ3302T");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	private String buildDeleteAuthSql(String legacyAuthNumber) {
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append("VVSP001.REQ3302t ");
		sql.append("where req_nbr = '");
		sql.append(legacyAuthNumber);
		sql.append("'");

		return sql.toString();
	}

	private void deleteClaim(String claimNumber) {
		String deleteSql = buildDeleteSql(claimNumber);
		
		try {
			actions.executeUpdateSQL(deleteSql);
			System.out.println("Deleted reserved claim number " + claimNumber);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private String buildDeleteSql(String claimNumber) {
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append("VVSP001.CLM2342T ");
		sql.append("where clm_nbr = '");
		sql.append(claimNumber);
		sql.append("'");

		return sql.toString();
	}
}
