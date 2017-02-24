package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimError;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.consumer.model.MemberRelationEnum;
import com.vsp.api.consumer.model.Membership;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.Notification;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.il.util.Preferences;

public class ClaimBuilderImplTest {
	
	private Claim builtClaim;
	private ClaimBuilderImpl builder; 
	private VisionServiceRequestApiContext requestContext;
	private CommandMap commandMap; 
		
	@Before
	public void init() throws Exception{
		builtClaim = null;
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testBuildClaim() throws Exception{
		buildRequestContext();
		buildTestCommandMap();
		initializePreClaimBuilder(requestContext, commandMap);
		builtClaim = builder.buildClaim(); 
		
		assertAccessPointWereSet();
		
		assertClaimFields(); 
	}
	
	@Test
	public void testNoServiceLocationConstraintDoNotInvokeProviderNetworkAccessPointBuilder() throws Exception{
		buildRequestContext();
		buildTestCommandMap();
		commandMap.remove(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND);
		initializePreClaimBuilder(requestContext, commandMap);
		builtClaim = builder.buildClaim();
	
		assertAccessPointWereNotSet();
		assertNetworkIdHasNotChanged();
	}
	
	@Test
	public void testErrorsBuiltOnClaimFromNotifications() throws Exception{
		String errorCode = "error"; 
		buildRequestContext();
		requestContext.addNotification(new Notification(errorCode));
		
		buildTestCommandMap();
		initializePreClaimBuilder(requestContext, commandMap);
		builtClaim = builder.buildClaim();
		assertClaimHasErrorWithMatchingErrorNumber(errorCode); 
	}

	private void assertClaimHasErrorWithMatchingErrorNumber(String errorCode) {
		List<ClaimError> errors = builtClaim.getClaimErrors(); 
		assertEquals(1, errors.size()); 
		assertEquals(errorCode, errors.get(0).getErrorNumber()); 
	}

	private void buildRequestContext()  {
		requestContext = MockHelper.buildVisionServiceRequestApiContext(); 
	}
	
	private void buildTestCommandMap() throws Exception {
		commandMap = MockHelper.buildCommandMap();
	}
	
	private void initializePreClaimBuilder(VisionServiceRequestApiContext request, CommandMap commandMap) throws ClaimBuilderException{
		builder = spy(new ClaimBuilderImpl(request, commandMap));
		doReturn(new ArrayList<ClaimLine>()).when(builder).buildClaimLines(); 
	} 
	
	private void assertClaimFields(){
		assertClaimKeyIsPopulated();
		assertNetworkIdIsPopulated();
		assertSubscriberIsPopulatedOnClaim();
		assertPatientIsPopulatedOnClaim();
		assertClassIdIsPopulatedOnClaim();
		assertProductPackageNameIsPopulatedOnClaim();
		assertAccesspointIsPopulated();
		assertProviderTaxIdIsPopulatedOnProvider();
	}

	private void assertClaimKeyIsPopulated() {
		assertEquals(MockHelper.CLAIM_NUMBER, builtClaim.getClaimKey().getClaimNumber()); 
		assertEquals(MockHelper.CLAIM_EXT_NUMBER, builtClaim.getClaimKey().getClaimExtNumber()); 
	}

	private void assertProductPackageNameIsPopulatedOnClaim() {
		assertEquals(requestContext.getProductPackageName(), builtClaim.getProductPackageName());
	}

	private void assertNetworkIdIsPopulated(){
		assertEquals(requestContext.getNetworkId(), builtClaim.getProviderNetworkAccessPoint().getProviderNetworkKey().getNetworkId());
	}
	
	private void assertSubscriberIsPopulatedOnClaim() {
		Membership subscriber = builtClaim.getSubscriber();
		assertNotNull(subscriber);
		assertEquals(MemberRelationEnum.Member, subscriber.getRelationToSubscriber());
	}

	private void assertPatientIsPopulatedOnClaim() {
		Membership patient = builtClaim.getPatient();
		assertNotNull(patient);
		assertEquals(requestContext.getConsumerId(), patient.getConsumerId());
	}

	private void assertClassIdIsPopulatedOnClaim() {
		assertEquals(MockHelper.CLASS_ID, builtClaim.getClassId());
	}
	
	private void assertProviderTaxIdIsPopulatedOnProvider() {
		assertNotNull(builtClaim.getProvider().getKey().getProviderTaxId());
		assertEquals(builtClaim.getProvider().getKey().getProviderTaxId(), MockHelper.TAX_ID);
	}

	private void assertAccesspointIsPopulated() {
		assertNotNull(builtClaim.getProviderNetworkAccessPoint());
		assertNotNull(builtClaim.getProviderNetworkAccessPoint().getServiceLocation());
		assertNotNull(builtClaim.getProviderNetworkAccessPoint().getServiceLocation().getKey());
	}
	
	private void assertAccessPointWereNotSet() {
		Mockito.verify(builder, Mockito.times(0)).buildProviderNetworkAccessPoint();
	}
	
	private void assertAccessPointWereSet() {
		Mockito.verify(builder, Mockito.times(1)).buildProviderNetworkAccessPoint();
	}

	private void assertNetworkIdHasNotChanged(){
		assertNotNull(builtClaim.getProviderNetworkAccessPoint());
		assertEquals(requestContext.getNetworkId(), builtClaim.getProviderNetworkAccessPoint().getProviderNetworkKey().getNetworkId());
	}
		
}
