package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.joda.time.DateMidnight;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.util.ClaimFactory;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.Preferences;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={
		CreateReservedClaimsBeanIntegrationTest.Config.class
})
public class CreateReservedClaimsBeanIntegrationTest {
	
	@Configuration
	static class Config {
		static { 
			if(!Preferences.initialized()) {
				Preferences.initialize();
			}
		}
		
		@Bean
		public ApiContext apiContext(){
			return Mockito.mock(ApiContext.class);
		}
		
		@Bean
		public PreClaimRepository preclaimRepo(){
			return Mockito.mock(PreClaimRepository.class);
		}
		
		@Bean
		public CreateReservedClaimsBean createbean(){
			return spy(new CreateReservedClaimsBean());
		}
		
		@Bean(name = "reservedClaimEntityManagerFactory")		
		public EntityManagerFactory entityManagerFactoryBean() {
			  return Mockito.mock(EntityManagerFactory.class);
		}
	}

	
	@Autowired private CreateReservedClaimsBean bean; 
	@Autowired private PreClaimRepository preClaimRepository;
	@Autowired private ApiContext apiContext; 

	private static final String CLAIM_NUMBER = "10000000";
	private static final String CLAIM_EXT_NUMBER = "00";
	private static final String CLIENT_ID = "12345678";
	private static final String DIV_ID = "0001";
	private static final String POLICY_ID = "123456789";
	private static final String CONSUMER_ID = "1234567890";
	private static final String NETWORK_ID = "1000"; 
	private static final String AUTH_NUMBER = "10000000";
		
	@After
	public void clearMocks(){
		Mockito.reset(preClaimRepository, bean, apiContext);
	}
	
	@Test
	public void testAddSingleLineToClaim() throws Exception {
		int numOfLinesToBuild = 1; 
		int startingLineNumber = 5; 
		int initialLineCount = 4; 
		
		ClaimLines linesToBuild = buildClaimLines(numOfLinesToBuild, startingLineNumber); 
		Claim mockRetrieveClaim = buildClaimWithNumberOfLines(initialLineCount);
		
		mockRepositoryRetrieve(mockRetrieveClaim);
		mockRepositoryUpdate();
		
		ClaimLines addedClaimLines = bean.createLines(CLAIM_NUMBER, CLAIM_EXT_NUMBER, linesToBuild);
		assertHref(addedClaimLines.get(0));
	}
	
	@Test
	public void testAddMultipleLineToClaim() throws Exception {
		int numOfLinesToBuild = 2; 
		int startingLineNumber = 5; 
		int initialLineCount = 4; 
		
		ClaimLines linesToBuild = buildClaimLines(numOfLinesToBuild, startingLineNumber); 
		Claim mockRetrieveClaim = buildClaimWithNumberOfLines(initialLineCount);
		
		mockRepositoryRetrieve(mockRetrieveClaim);
		mockRepositoryUpdate();
		
		ClaimLines addedClaimLines = bean.createLines(CLAIM_NUMBER, CLAIM_EXT_NUMBER, linesToBuild);
		
		assertHref(addedClaimLines.get(0));
		assertHref(addedClaimLines.get(1));
	}
	
	
	@Test
	public void testCreate() throws Exception{
		mockCreateClaim();
		Claim returned = bean.create(buildClaimWithNumberOfLines(1));
		
		assertNotNull(returned);
		assertNotNull(returned.getSelf());
		assertEquals(returned.getAuthorizationNumber(),AUTH_NUMBER);
		
		verify(preClaimRepository).create(any(Claim.class)); 
	}
	
	
	private void assertHref(ClaimLine claimLine) {
		assertNotNull(claimLine.getSelfLink());		
		String href = claimLine.getSelfLink().getHref();
		assertEquals(href.substring(href.length() - 1), claimLine.getLineNumber().toString());	
	}
	
	private Claim buildClaimWithNumberOfLines(int numOfLines) {
		Claim claim = buildClaim();
		List<ClaimLine> claimLines = buildClaimLines(numOfLines); 
		claim.setClaimLines(claimLines);
		return claim;
	}
	

	
	public Claim buildClaim() {
		ClaimFactory factory = new ClaimFactory();
		factory.setClaimNumber(CLAIM_NUMBER);
		factory.setClaimExtNumber(CLAIM_EXT_NUMBER);
		factory.setClientId(CLIENT_ID);
		factory.setConsumerId(CONSUMER_ID);
		factory.setDivisionId(DIV_ID);
		factory.setNetworkId(NETWORK_ID);
		factory.setPolicyId(POLICY_ID);
		factory.setPatientDob(new DateMidnight("1990-10-11"));
		factory.setRelationToSubscriber(MemberRelationEnum.Member);
		factory.setProductPackageName("Signature");
		factory.setAffectEligibilityCode("N");
		Claim claim =  factory.buildClaim();
		claim.setAuthorizationNumber(AUTH_NUMBER);
		return claim;
	}

	private ClaimLines buildClaimLines(int numOfLines) {
		ClaimLines claimLines = new ClaimLines(); 
		for(int i=1; i <= numOfLines; i++){
			ClaimLine line = new ClaimLine();
			line.setLineNumber(i);
			if(i%2 == 0){
				line.setProductCatalogKey("GenExam");
			}else {
				line.setProductCatalogKey("Lens");
			}
			claimLines.add(line);
		}
		return claimLines;
	}
	
	private ClaimLines buildClaimLines(int numOfLines, int startNum) {
		ClaimLines claimLines = new ClaimLines(); 
		for(int i=startNum; i <numOfLines+startNum; ++i){
			ClaimLine line = new ClaimLine();
			line.setLineNumber(i);
			if(i%2 == 0){
				line.setProductCatalogKey("GenExam");
			}else {
				line.setProductCatalogKey("Lens");
			}
			claimLines.add(line);
		}
		return claimLines;
	}
	
	
	private void mockRepositoryRetrieve(Claim mockClaim) throws ClaimNotFoundException, DatabaseIOException {
		Mockito.when(preClaimRepository.retrieve(Mockito.any(ClaimKey.class))).thenReturn(mockClaim);
	}
	
	private void mockRepositoryUpdate() throws ClaimNotFoundException, DatabaseIOException {
		Mockito.when(preClaimRepository.update(Mockito.any(Claim.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
	}
	
	private void mockCreateClaim() throws DatabaseIOException{
		when(preClaimRepository.create(any(Claim.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
	}
}
