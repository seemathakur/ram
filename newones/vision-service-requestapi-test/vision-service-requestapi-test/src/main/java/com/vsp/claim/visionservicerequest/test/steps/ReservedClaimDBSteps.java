package com.vsp.claim.visionservicerequest.test.steps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.vsp.api.claim.model.ClaimKey;
import com.vsp.claim.visionservicerequest.test.util.StoryStateHelper;
import com.vsp.il.test.jbehave.db.DbActions;
import com.vsp.il.test.jbehave.db.DbSteps;

public class ReservedClaimDBSteps extends DbSteps{
	
	private DbActions actions; 
	
	public ReservedClaimDBSteps(DbActions dbActions){
		super(dbActions);
		actions = dbActions;
	}
		
	/**
	 * Inserts a new claim with claim lines into preclaim tables. Adds the claim key to 
	 * story state to be deleted at the end of the scenario
	 */
	@Given("a default claim: $claimNumber-$claimExtNumber")
	public void createDefaultClaim(String claimNumber, String claimExtNumber){
		createClaim(claimNumber, claimExtNumber); 
		StoryStateHelper.addOutstandingClaim(claimNumber);
	}
	
	/**
	 * Inserts a new claim with claim lines into preclaim tables. Adds the claim key to 
	 * story state to be deleted at the end of the scenario
	 */
	@When("I initialize the claim with default values")
	public void createDefaultClaim(){
		ClaimKey claimKey = StoryStateHelper.getClaimKey(); 
		createDefaultClaim(claimKey.getClaimNumber(), claimKey.getClaimExtNumber()); 
	}
	
	public void createClaim(String claimNumber, String claimExtNumber) {

		try {
			List<String> updateSqlStatements = new ArrayList<String>(); 
			
			updateSqlStatements.add(generateClaimSql(claimNumber, claimExtNumber)); 
			updateSqlStatements.add(generateFrameLineSql(claimNumber, claimExtNumber)); 
			updateSqlStatements.add(generateLensLineSql(claimNumber, claimExtNumber)); 

			for(String sql : updateSqlStatements){
				actions.executeUpdateSQL(sql);
			}
			
			System.out.println("Created reserved claim number " + claimNumber + "-" + claimExtNumber);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	private String setClaimKeyOnSql(String claimNumber, String claimExtNumber, String sql){
		sql = sql.replace("claimNumber", claimNumber);
		sql = sql.replace("claimExtNumber", claimExtNumber);
		return sql; 
	}


	private String generateFrameLineSql(String claimNumber,String claimExtNumber) throws IOException {
		String sql = FileUtils.readFileToString(new File("src/main/resources/com/vsp/claim/visionservicerequest/resources/test/sql/DefaultFrameClaimLineSQL.txt"));
		return setClaimKeyOnSql(claimNumber, claimExtNumber, sql);  
	}
	
	private String generateLensLineSql(String claimNumber,String claimExtNumber) throws IOException {
		String sql = FileUtils.readFileToString(new File("src/main/resources/com/vsp/claim/visionservicerequest/resources/test/sql/DefaultLensClaimLineSQL.txt"));
		return setClaimKeyOnSql(claimNumber, claimExtNumber, sql); 
	}

	private String generateClaimSql(String claimNumber, String claimExtNumber) throws IOException {
		String sql = FileUtils.readFileToString(new File("src/main/resources/com/vsp/claim/visionservicerequest/resources/test/sql/DefaultClaimSQL.txt"));
		return setClaimKeyOnSql(claimNumber, claimExtNumber, sql); 
	}
	
	@Then("I delete the claim with claim key: $claimNumber-$claimExtNumber")
	public void deleteClaim(String claimNumber, String claimExtNumber){
		try {
			List<String> deleteSqlStatements = new ArrayList<String>(); 
			String sql1 = FileUtils.readFileToString(new File("src/main/resources/com/vsp/claim/visionservicerequest/resources/test/sql/DeleteClaimLineByClaimKeySQL.txt"));
			deleteSqlStatements.add(setClaimKeyOnSql(claimNumber, claimExtNumber, sql1));
			
			String sql2 = FileUtils.readFileToString(new File("src/main/resources/com/vsp/claim/visionservicerequest/resources/test/sql/DeleteClaimByClaimKeySQL.txt"));
			deleteSqlStatements.add(setClaimKeyOnSql(claimNumber, claimExtNumber, sql2));
			
			for(String sql : deleteSqlStatements){
				actions.executeSQL(sql);
			}
			
			System.out.println("Deleted reserved claim number " + claimNumber + "-" + claimExtNumber);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
