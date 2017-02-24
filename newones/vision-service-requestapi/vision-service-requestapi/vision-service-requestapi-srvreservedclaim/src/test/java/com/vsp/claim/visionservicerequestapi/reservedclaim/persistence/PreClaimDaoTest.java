package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.io.Files;
import com.vsp.claim.visionservicerequestapi.reservedclaim.factory.PreClaimFactoryForPersistence;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.search.SearchCriteriaBuilder;
import com.vsp.il.util.NameValuePair;
import com.vsp.il.util.Preferences;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={
		PreClaimDaoTest.Config.class,
		PreClaimDao.class
})
public class PreClaimDaoTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@EnableTransactionManagement
	@Configuration
	static class Config {
		static { 
			if(!Preferences.initialized()) {
				Preferences.initialize();
			}
		}
		
	    @Bean(name = "transactionManager")
	    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf){
	        return new JpaTransactionManager();
	    }
		
		@Bean(name = "reservedClaimEntityManagerFactory")
		public LocalContainerEntityManagerFactoryBean preClaimEntityManagerFactoryBean(){
			HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			Properties jpaProperties = new Properties(); 
			LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
			
			jpaProperties.setProperty("hibernate.hbm2ddl.auto" , "create");
			jpaProperties.setProperty("hibernate.show_sql" , "true");
			jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.DB2Dialect");
			
			factory.setJpaVendorAdapter(vendorAdapter);
			factory.setJpaProperties(jpaProperties);
			factory.setPackagesToScan("com.vsp.claim.common.model.jpa", "com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model");
			factory.setDataSource(dataSource());
			factory.setPersistenceUnitName("ReservedClaimDaoTest");
			factory.afterPropertiesSet();
			return factory;
			}
		
		@Bean(name = "dataSource")
		public DataSource dataSource() {
		    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		    dataSource.setUrl("jdbc:derby:memory:test-jpa;create=true");
		    dataSource.setUsername("UVSP001");
		    dataSource.setPassword("user1");
		    return dataSource;
		}
	}
	
	private static final String EMPTY_STRING = "";
	private static final String INSERT_CLAIM_ERROR_SQL_FILE = "src/test/resources/com/vsp/claim/visionservicerequestapi/reservedclaim/persistence/sql/InsertClaimErrorClaimHeader.txt"; 
	private static final String INSERT_CLAIM_LINE_SQL_FILE = "src/test/resources/com/vsp/claim/visionservicerequestapi/reservedclaim/persistence/sql/InsertClaimLine.txt";
	private static final String INSERT_CLAIM_SQL_FILE = "src/test/resources/com/vsp/claim/visionservicerequestapi/reservedclaim/persistence/sql/InsertClaim.txt"; 
	private static final String COUNT_CLAIM_SQL = "select count(*) from uvsp001.clm2342t where clm_nbr = ? and clm_ext_nbr = ?";
	private static final String COUNT_CLAIM_LINE_SQL = "select count(*) from uvsp001.clm2343t where clm_nbr = ? and clm_ext_nbr = ?";
	private static final String COUNT_CLAIM_ERROR_SQL = "select count(*) from uvsp001.clm2344t where clm_nbr = ? and clm_ext_nbr = ?";
	private static final String CLIENT_ID_SEARCH_CRITERIA = "12140859";
	private static final String DIVISION_ID_SEARCH_CRITERIA = "0011";
	private static final String SUBSCRIBER_ID_SEARCH_CRITERIA = "851126228";
	private static final String CONSUMER_ID_SEARCH_CRITERIA = "1559098";
	
	
	static {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Autowired 
	private PreClaimDao dao; 
	
	private String claimNumber;
	private String claimExtNumber;
	private int expectedClaimLineCount = -1;
	private int expectedClaimCount = -1;
	private int expectedClaimErrorCount = -1; 
	private boolean deletedClaim = false; 
	private PreClaim actualClaim;
	private PreClaim expectedClaim;
	private String expectedClmLnPicNm;
	private List<PreClaim> searchResults;
	private int expectedSearchResultsCount;
	private boolean ignorePostTransactionalAssertions; 
			
	@Before
	public void setUp(){
		reset(); 
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		} catch (InstantiationException|IllegalAccessException|ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	private void reset(){
		claimNumber = null;
		claimExtNumber = null; 
		expectedClaimLineCount = -1;
		expectedClaimCount = -1; 
		expectedClaimErrorCount = -1; 
		actualClaim = null; 
		expectedClmLnPicNm = null;
		expectedSearchResultsCount = -1; 
		ignorePostTransactionalAssertions = false;
		deletedClaim = false;
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testRetrieve() {
		insertNewClaimRecord("10000000", "00");
		
		expectedClaim = retrieveClaim();
		
		setExpectedClaimCount(1);
		setExpectedLineCount(1);
		setExpectedErrorCount(1);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testSearch() {
		deleteAllRecords();
		
		insertNewClaimRecord("20000000", "00");
		insertNewClaimRecord("20000001", "00");
		insertNewClaimRecord("20000002", "00");
		
		
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder();
		builder.setClientId(CLIENT_ID_SEARCH_CRITERIA);
		builder.setDivisionId(DIVISION_ID_SEARCH_CRITERIA);
		builder.setSubscriberId(SUBSCRIBER_ID_SEARCH_CRITERIA);
		builder.setConsumerId(CONSUMER_ID_SEARCH_CRITERIA);
		
		searchResults = dao.search(builder.build()); 
		setExpectedSearchResultsCount(3); 
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testSearchNoResults() {
		deleteAllRecords();
			
		
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder();
		builder.setClientId(CLIENT_ID_SEARCH_CRITERIA);
		builder.setDivisionId(DIVISION_ID_SEARCH_CRITERIA);
		builder.setSubscriberId(SUBSCRIBER_ID_SEARCH_CRITERIA);
		builder.setConsumerId(CONSUMER_ID_SEARCH_CRITERIA);
		
		searchResults = dao.search(builder.build()); 
		setExpectedSearchResultsCount(0);
	}
	
	private void setExpectedSearchResultsCount(int i) {
		expectedSearchResultsCount = i; 
	}


	@Test
	@Transactional
	@Rollback(false)
	public void testCreate() {
		setClaimNumberAndExtension("100046580", "01");
		assertEquals(0, countClaimRecords());
		
		PreClaimFactoryForPersistence fac = new PreClaimFactoryForPersistence();
		expectedClaim = fac.buildClaim(claimNumber, claimExtNumber); 
		dao.create(expectedClaim);
		
		setExpectedClaimCount(1);
		setExpectedLineCount(1);
		setExpectedErrorCount(1);
	}
		
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdate() {
	      insertNewClaimRecord("10000005", "00");
	      assertEquals(1, countClaimRecords());
	        
	      PreClaim insertedClaim = retrieveClaim();
	      PreClaimLine lineToUpdate = getClaimLineFromClaim(insertedClaim, 1);
	      expectedClmLnPicNm = "SigChoice";
	      lineToUpdate.setClmlnPicNm(expectedClmLnPicNm);
	        
	      insertedClaim.getClaimLines().remove(lineToUpdate);
	      insertedClaim.getClaimLines().add(lineToUpdate);
	
	      dao.update(insertedClaim);
	        
	       setExpectedClaimCount(1);
	       setExpectedLineCount(1);
	       setExpectedErrorCount(1);
	  }
	
	  @Test
	  @Transactional
	  @Rollback(false)
	  public void testRemoveAClaimLine() {
         insertNewClaimRecord("10000001", "00");
         addClaimLines(3);
         assertEquals(4, countClaimLineRecords());
        
         expectedClaim =  retrieveClaim();
         dao.deleteLine(expectedClaim, getClaimLineFromClaim(expectedClaim, 2));
        
         setExpectedClaimCount(1);
         setExpectedLineCount(3);
         setExpectedErrorCount(1);
	  }
	  
	  @Test
	  @Transactional
	  @Rollback(false)
	  public void deleteClaim() {
		 deletedClaim = true; 
         insertNewClaimRecord("110000001", "00");
         addClaimLines(3);
         assertEquals(1, countClaimRecords());
         assertEquals(4, countClaimLineRecords());
        
         expectedClaim =  retrieveClaim();
         dao.delete(expectedClaim);
        
         setExpectedClaimCount(0);
         setExpectedLineCount(0);
         setExpectedErrorCount(0);
	  }
		
	@AfterTransaction
	/**
	 * This method executes after each transaction. This includes transactions to setup test data. We'd like to assess the results post-transaction.
	 */
	public void postTransacationalAssertions() {
		if(ignorePostTransactionalAssertions) return; 
			
		if(hasSearchResults()) {
			assertSearchResults();
		}else {
			assertRetrievedClaimCounts();
		}
		
		if(hasExpectedClaim()) {
			assertRetrievedClaim();
		}
		
		if(hasExpectedClaimLine()) {
			assertRetrievedClaimLines();
		}
		
		if(hasNoResultsExpected()) {
			assertNoResultException();
		}
		
	}
	
	private void assertRetrievedClaimLines() {
		String actualClmLnPicNm = getClaimLineFromClaim(retrieveClaim(),1).getClmlnPicNm();
		assertEquals(expectedClmLnPicNm, actualClmLnPicNm);
	}

	private boolean hasNoResultsExpected() {
		return deletedClaim;
	}

	private boolean hasExpectedClaimLine() {
		return expectedClmLnPicNm != null;
	}

	private void assertRetrievedClaim() {
		actualClaim = retrieveClaim(); 
		assertEquals(claimNumber, actualClaim.getClaimKey().getClaimNumber());
		assertEquals(claimExtNumber, actualClaim.getClaimKey().getClaimExtNumber());
		assertEquals(expectedClaim.getClmStatus(), actualClaim.getClmStatus());	
	}

	private boolean hasExpectedClaim() {
		return expectedClaim !=null && !deletedClaim;
	}

	private void assertSearchResults() {
		assertEquals(expectedSearchResultsCount, searchResults.size());
		assertSearchResultsMatchSearchCriteria(); 
	}

	private void assertRetrievedClaimCounts() {
		assertEquals(expectedClaimLineCount, countClaimLineRecords());
		assertEquals(expectedClaimCount, countClaimRecords());
		assertEquals(expectedClaimErrorCount, countClaimErrorRecords()); 
	}

	private boolean hasSearchResults(){
		return searchResults != null; 
	}
  
	private void assertSearchResultsMatchSearchCriteria() {
		if(searchResults.size() > 0){
			for(PreClaim preclaim: searchResults){
				assertEquals(CLIENT_ID_SEARCH_CRITERIA, preclaim.getMembrGroupId());
				assertEquals(DIVISION_ID_SEARCH_CRITERIA, preclaim.getMembrGroupDiv());
				assertEquals(SUBSCRIBER_ID_SEARCH_CRITERIA, preclaim.getMembrId());
				assertEquals(Integer.valueOf(CONSUMER_ID_SEARCH_CRITERIA), new Integer(preclaim.getConsumerId()));
			}
		}
	}

	private PreClaimLine getClaimLineFromClaim(PreClaim claim, int lineNumber){
	    PreClaimLine [] preClaimLines = claim.getClaimLines().toArray(new PreClaimLine[0]);
	    return preClaimLines[--lineNumber];
	}
   
	private void addClaimLines(int numOfLinesToAdd) {
	    int start = 2;
	    int lineCount = numOfLinesToAdd + start;
	   
	    for(int i = start; i < lineCount; i++){
	    	insertClaimLine(i);
	    }
	}
	
	private PreClaim retrieveClaim(){
		List<NameValuePair> criteria = buildClaimKeySearchCriteria();
		return dao.retrieveByClaimKey(criteria);
	}
	
	private void assertNoResultException(){
		try{
			retrieveClaim();
			Assert.fail("No claim should be returned after deletion");
		}catch(Exception exception){
			Assert.assertTrue(exception instanceof NoResultException);
		}
	}
	
	private void setExpectedClaimCount(int count) {
		expectedClaimCount = count; 
	}

	@SuppressWarnings("deprecation")
	private int countClaimRecords(){
		return simpleJdbcTemplate.queryForInt(COUNT_CLAIM_SQL, claimNumber, claimExtNumber);
	}
		
	@SuppressWarnings("deprecation")
	private int countClaimLineRecords(){
		return simpleJdbcTemplate.queryForInt(COUNT_CLAIM_LINE_SQL, claimNumber, claimExtNumber);
	} 
	
	@SuppressWarnings("deprecation")
	private int countClaimErrorRecords(){
		return simpleJdbcTemplate.queryForInt(COUNT_CLAIM_ERROR_SQL, claimNumber, claimExtNumber);
	} 
	
	@SuppressWarnings("deprecation")
	private void insertClaim(){
		String sql = getSqlFromFile(INSERT_CLAIM_SQL_FILE);
		simpleJdbcTemplate.update(sql, claimNumber, claimExtNumber);
	}
	
  @SuppressWarnings("deprecation")
		private void insertClaimLine(int claimLineNumber){
		String sql = getSqlFromFile(INSERT_CLAIM_LINE_SQL_FILE);
		simpleJdbcTemplate.update(sql, claimNumber, claimExtNumber, claimLineNumber);
	}
	
	@SuppressWarnings("deprecation")
	private void insertClaimError(){
		String sql = getSqlFromFile(INSERT_CLAIM_ERROR_SQL_FILE);
		simpleJdbcTemplate.update(sql, claimNumber, claimExtNumber);
	}
	
	private void deleteAllRecords(){
		ignorePostTransactionalAssertions = true; 
		simpleJdbcTemplate.update("delete from uvsp001.clm2343t");
		simpleJdbcTemplate.update("delete from uvsp001.clm2344t");
		simpleJdbcTemplate.update("delete from uvsp001.clm2342t");
		ignorePostTransactionalAssertions = false; 
	}
	
	private void setExpectedLineCount(int count) {
		expectedClaimLineCount = count; 
	}
		
	private void setExpectedErrorCount(int count){
		expectedClaimErrorCount = count;
	}
	
	private void setClaimNumberAndExtension(String claimNumber, String claimExtNumber) {
		this.claimNumber = claimNumber; 
		this.claimExtNumber = claimExtNumber; 
	}

	private List<NameValuePair> buildClaimKeySearchCriteria(){
		List<NameValuePair> criteria = new ArrayList<NameValuePair>();
		
		NameValuePair claimNumberPair = new NameValuePair("claimNumber", claimNumber);
		NameValuePair claimExtNumberPair = new NameValuePair("claimExtNumber", claimExtNumber);
		criteria.add(claimNumberPair);
		criteria.add(claimExtNumberPair);
		
		return criteria; 
	}
	
	private String getSqlFromFile(String fileName) {
		try {
			return Files.toString(new File(fileName), Charset.defaultCharset());
		} catch (IOException e) {
			return EMPTY_STRING; 
		}
	}
	
  private void insertNewClaimRecord(String claimNumber, String claimExtNumber){
    setClaimNumberAndExtension(claimNumber, claimExtNumber);
    insertClaim();
    insertClaimLine(1);
    insertClaimError();
  }
}
