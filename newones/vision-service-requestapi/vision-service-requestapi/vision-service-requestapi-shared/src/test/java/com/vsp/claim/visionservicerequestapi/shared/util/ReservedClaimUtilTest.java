package com.vsp.claim.visionservicerequestapi.shared.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.ancillary.model.personandcontact.Address;
import com.vsp.api.ancillary.model.personandcontact.Name;
import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.consumer.model.Membership;
import com.vsp.api.core.Link;
import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.Doctor;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.api.util.DateInterval;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.il.util.Preferences;

public class ReservedClaimUtilTest {
	
	private static final String CREATE_LINES_REL = "urn://vnd.vsp.rels/createlines";
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}

	@Test
	public void testGetMemberPolicyKeyFromClaim(){
		MemberPolicyKey key = ReservedClaimUtil.getMemberPolicyKeyFromClaim(buildClaimWithSubscriber()); 
		assertNotNull(key);
	}
	
	@Test
	public void testGetNetwork() {
		assertEquals("1000", ReservedClaimUtil.getNetworkId(buildClaimWithSubscriber()));
	}
	
	@Test
	public void testGetMemberPolicyKeyFromClaimNotNull(){
		MemberPolicyKey key = ReservedClaimUtil.getMemberPolicyKeyFromClaim(buildClaimWithPatient()); 
		assertNotNull(key);
	}
	
	@Test
	public void testServiceExisted() {
		Claim claim = buildClaimWithSubscriber();
		assertTrue(ReservedClaimUtil.isServiceExisted(claim));
	}
	
	@Test
	public void testServiceExistedNull() {
		Claim claim = buildClaimWithLines(buildClaimWithSubscriber(), null);		
		assertFalse(ReservedClaimUtil.isServiceExisted(claim));
	}
	
	@Test
	public void testServiceExistedEmpty() {
		Claim claim = buildClaimWithLines(buildClaimWithSubscriber(), new ArrayList<ClaimLine>());		
		assertFalse(ReservedClaimUtil.isServiceExisted(claim));
	}
		
	@Test
	public void testDoctorPhone() {
		Claim claim = buildClaimWithSubscriber();
		assertEquals(ReservedClaimUtil.getDrPhoneNumberFromClaim(claim), "800-877-7195");
	}
	
	@Test
	public void testClaimStatus() {
		Claim claim = buildClaimWithSubscriber();
		ReservedClaimUtil.setClaimStatus(claim, "IR");
		assertEquals("IR", claim.getStatusCode());
	}
	
	@Test
	public void testClaimLinesStatus() {
		Claim claim = buildClaimWithSubscriber();
		ReservedClaimUtil.setClaimLinesStatus(claim, "IR");
		List<ClaimLine> lines = claim.getClaimLines();
		
		assertNotNull(lines);
		assertEquals(1, lines.size());
		
		ClaimLine single = lines.get(0);
		assertEquals("IR", single.getStatusCode());
	}
	
	@Test
	public void testMakeQueueMessage(){
		ClaimKey claimKey = new ClaimKey("10000000", "00");
		String actualMessage = ReservedClaimUtil.getClaimKeyAsString(claimKey);
		String expectedMessage = claimKey.getClaimNumber() + "-" + claimKey.getClaimExtNumber(); 
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void testFindClaimLineByLineNumber() throws ClaimLineNotFoundException {
		Claim claim = buildClaimWithSubscriber();
		assertEquals(ReservedClaimUtil.findClaimLineIndexByLineNumber(claim, 1), 0);
	}
	
	@Test
	public void testRetrieveClaimLineByLineNumber() throws ClaimLineNotFoundException {
		Claim claim = buildClaimWithSubscriber();
		
		ReservedClaimUtil.retrieveClaimLineByLineNumber(claim, 1);
		
		List<ClaimLine> lines = claim.getClaimLines();
		ClaimLine retrievedLine = lines.get(0);
		assertEquals(1, retrievedLine.getLineNumber().intValue());
	}
	
	@Test (expected = ClaimLineNotFoundException.class)
	public void testRetrieveClaimLineByLineNumberNotFound() throws ClaimLineNotFoundException {
		Claim claim = buildClaimWithSubscriber();
		
		ReservedClaimUtil.retrieveClaimLineByLineNumber(claim, 11);
	}
	
	@Test
	public void testRemoveClaimLineByLineNumber() throws ClaimLineNotFoundException {
		Claim claim = buildClaimWithSubscriber();
		
		ReservedClaimUtil.removeClaimLineByLineNumber(claim, 1);
		
		assertEquals(claim.getClaimLines().size(),0);
	}
	
	@Test (expected = ClaimLineNotFoundException.class)
	public void testRemoveClaimLineByLineNumberNotFound() throws ClaimLineNotFoundException {
		Claim claim = buildClaimWithSubscriber();
		
		ReservedClaimUtil.removeClaimLineByLineNumber(claim, 11);
	}
	
	
	@Test
	public void testReplaceClaimLine() throws ClaimLineNotFoundException {
		Claim claim = buildClaimWithSubscriber();
		ClaimLine newLine = new ClaimLine();
		newLine.setLineNumber(1);
		
		ReservedClaimUtil.replaceClaimLine(claim, newLine);
		
		List<ClaimLine> lines = claim.getClaimLines();
		ClaimLine replacedLine = lines.get(0);
		assertEquals(newLine.getLineNumber(), replacedLine.getLineNumber());
	}
	
	@Test(expected=ClaimLineNotFoundException.class)
	public void testReplaceClaimLineByIndexOutOfBounds() throws ClaimLineNotFoundException {
		Claim claim = buildClaimWithSubscriber();
		ClaimLine newLine = new ClaimLine();
		newLine.setLineNumber(2);
		
		ReservedClaimUtil.replaceClaimLine(claim, newLine);
	}
	
	@Test
	public void testRetrieveClaimLineByProductCatalogKey() throws ClaimLineNotFoundException{
		Claim claim = buildClaimWithPatient();
		List<ClaimLine> claimLines = buildClaimLines();
		claim = buildClaimWithLines(claim, claimLines);
		String productCatalogKeyName = "Lens";
		
		ClaimLine line = ReservedClaimUtil.retrieveClaimLineByProductCatalogKey(claim, productCatalogKeyName);
		assertEquals(line.getProductCatalogKey(), productCatalogKeyName); 
	}
	
	@Test(expected=ClaimLineNotFoundException.class)
	public void testRetrieveClaimLineByProductCatalogKeyNotFound() throws ClaimLineNotFoundException{
		Claim claim = buildClaimWithPatient();
		List<ClaimLine> claimLines = buildClaimLines();
		claim = buildClaimWithLines(claim, claimLines);
		String productCatalogKeyName = "ContactLens";
		
		ReservedClaimUtil.retrieveClaimLineByProductCatalogKey(claim, productCatalogKeyName);
	}
	
	@Test
	public void testGetHighestClaimLineNumber(){
		int highestNum = 8; 
		ClaimLine highestNumberLine = new ClaimLine();
		highestNumberLine.setLineNumber(highestNum);
		
		ClaimLines claimLines = buildClaimLines();
		claimLines.add(highestNumberLine);
		int result = ReservedClaimUtil.getHighestLineNumber(claimLines);
		
		assertEquals(highestNum, result);
	}
	
	@Test
	public void testGetHighestClaimLineNumberWithList(){
		int highestNum = 8; 
		ClaimLine highestNumberLine = new ClaimLine();
		highestNumberLine.setLineNumber(highestNum);
		
		List<ClaimLine> claimLines = buildClaimLines();
		claimLines.add(highestNumberLine);
		int result = ReservedClaimUtil.getHighestLineNumber(claimLines);
		
		assertEquals(highestNum, result);
	}
	
	@Test
	public void testGetCreateLinesLinkExists() {
		List<Link<?>> links = new ArrayList<Link<?>>();
		links.add(createLinkWithRel(CREATE_LINES_REL));
		links.add(createLinkWithRel("urn://vnd.vsp.rels/createline"));
		Claim claim = new Claim();
		claim.setValidClaimOperations(links);
		Link<ClaimLines> responseLink = ReservedClaimUtil.getCreateLinesLink(claim);
		assertEquals(responseLink.getRel(),CREATE_LINES_REL);
	}
	
	@Test
	public void testGetCreateLinesLinkDoesNotExist() {
		List<Link<?>> links = new ArrayList<Link<?>>();
		links.add(createLinkWithRel("urn://vnd.vsp.rels/deleteLine"));
		links.add(createLinkWithRel("urn://vnd.vsp.rels/createLine"));
		Claim claim = new Claim();
		claim.setValidClaimOperations(links);
		Link<ClaimLines> responseLink = ReservedClaimUtil.getCreateLinesLink(claim);
		assertNull(responseLink);
	}
	
	@Test
	public void testFindEarliestReservationIntervalDateSameDates() {
		Claim claim = new Claim();
		List<ClaimLine> lines = new ArrayList<ClaimLine>();
		DateMidnight inputDate = new DateMidnight(2016,1,1);
		lines.add(buildClaimLineWithReservationIntervalStartDate(inputDate));
		lines.add(buildClaimLineWithReservationIntervalStartDate(inputDate));
		claim.setClaimLines(lines);
		DateMidnight response = ReservedClaimUtil.findEarliestReservationIntervalDate(claim);
		assertEquals(response,inputDate);
	}
	
	@Test
	public void testFindEarliestReservationIntervalDateVaryingDates() {
		Claim claim = new Claim();
		List<ClaimLine> lines = new ArrayList<ClaimLine>();
		DateMidnight inputDate1 = new DateMidnight(2016,1,1);
		DateMidnight inputDate2 = new DateMidnight(2016,1,2);
		lines.add(buildClaimLineWithReservationIntervalStartDate(inputDate1));
		lines.add(buildClaimLineWithReservationIntervalStartDate(inputDate2));
		claim.setClaimLines(lines);
		DateMidnight response = ReservedClaimUtil.findEarliestReservationIntervalDate(claim);
		assertEquals(response,inputDate1);
	}
	
	@Test
	public void testFindEarliestReservationIntervalDateNoLines() {
		Claim claim = new Claim();
		List<ClaimLine> lines = new ArrayList<ClaimLine>();
		claim.setClaimLines(lines);
		DateMidnight response = ReservedClaimUtil.findEarliestReservationIntervalDate(claim);
		assertEquals(response,new DateMidnight());
	}
	
	private ClaimLine buildClaimLineWithReservationIntervalStartDate(DateMidnight date) {
		ClaimLine line = new ClaimLine();
		DateInterval interval = new DateInterval();
		interval.setBegin(new DateMidnight(2016,1,1));
		line.setReservationInterval(interval);
		return line;
	}
	
	private Link<ClaimLines> createLinkWithRel(String rel) {
		Link<ClaimLines> link = new Link<ClaimLines>();
		link.setRel(rel);
		return link;
	}
	
	private ClaimLines buildClaimLines() {
		ClaimLines lines = new ClaimLines();
		
		ClaimLine line1 = new ClaimLine();
		line1.setLineNumber(1);
		line1.setProductCatalogKey("GenExam");
		
		ClaimLine line2 = new ClaimLine();
		line2.setLineNumber(2);
		line2.setProductCatalogKey("Lens");
		
		ClaimLine line3 = new ClaimLine();
		line3.setLineNumber(3);
		line3.setProductCatalogKey("Frame");
		
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
		
		return lines;
	}

	private Claim buildClaimWithLines(Claim claim, List<ClaimLine> lines) {
		claim.setClaimLines(lines);		
		return claim;
	}
	
	private Claim buildClaimWithSubscriber(){
		DateMidnight date = new DateMidnight("2015-01-01"); 
		Claim claim = new Claim();
		claim.setProductPackageName("Signature");
		claim.setReservationIssueDate(date);
		claim.setProviderNetworkAccessPoint(buildProviderNetworkAccessPoint());
		claim.setStatusCode("RS");
		List<ClaimLine> claimLines = new ArrayList<ClaimLine>();
		ClaimLine claimLine = new ClaimLine();
		claimLine.setLineNumber(1);
		claimLine.setStatusCode("RS");
		Membership subscriber = new Membership(); 
		MemberPolicyKey key = new MemberPolicyKey(); 
		key.setClientId("123456");
		key.setDivisionId("0002");
		key.setPolicyId("2567");
		subscriber.setMemberPolicyKey(key);
		subscriber.setMembershipId("1234567");
		subscriber.setConsumerId("12345");
		claim.setSubscriber(subscriber);
		claim.setClassId("0001");
		claimLines.add(claimLine); 
		claim.setClaimLines(claimLines);
		return claim;
	}
	
	private Claim buildClaimWithPatient(){
		DateMidnight date = new DateMidnight("2015-01-01"); 
		Claim claim = new Claim();
		claim.setReservationIssueDate(date);
		claim.setProviderNetworkAccessPoint(buildProviderNetworkAccessPoint());
		List<ClaimLine> claimLines = new ArrayList<ClaimLine>();
		ClaimLine claimLine = new ClaimLine(); 
		Membership patient = new Membership(); 
		Membership subscriber = new Membership(); 
		claim.setSubscriber(subscriber);
		MemberPolicyKey key = new MemberPolicyKey(); 
		key.setClientId("123456");
		key.setDivisionId("0002");
		key.setPolicyId("2567");
		patient.setMemberPolicyKey(key);
		patient.setMembershipId("1234567");
		patient.setConsumerId("12345");
		claim.setPatient(patient);
		claim.setClassId("0001");
		claimLines.add(claimLine); 
		claim.setClaimLines(claimLines);
		return claim;
	}
	
	private ProviderNetworkAccessPoint buildProviderNetworkAccessPoint() {
		ProviderNetworkAccessPoint accesspoint = new ProviderNetworkAccessPoint();
		ServiceLocation location = new ServiceLocation();
		location.setPhoneNumber("800-877-7195");
		accesspoint.setServiceLocation(location);
		accesspoint.setProviderNetworkKey(new ProviderNetworkKey("1000"));
		Doctor doctor = new Doctor();
		
		Name name = new Name();
		name.setFirstName("John");
		name.setLastName("Watson");
		name.setMiddle("H");
		
		doctor.setName(name);
		doctor.setAddress(buildAddress());
		accesspoint.setDoctor(doctor);
		
		return accesspoint;
	}
	
	private Address buildAddress() {
		Address address = new Address();
		address.setStreet1("3333 Quality Drive");
		address.setCity("Rancho Cordova");
		address.setStateCode("CA");
		address.setZipCode("95670");
		
		return address;
	}
	
}
