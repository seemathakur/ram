package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimLineNotEligibleException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.NoEligibleServicesException;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.il.util.Preferences;

public class ClaimLinesBuilderImplTest {
	
	private ClaimLinesBuilderImpl claimLinesBuilder;
	
	@Mock
	private ClaimLineBuilderImpl claimLineBuilder;

		
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void tearDown() {
		claimLinesBuilder = null;
	}
	
	@Test
	public void claimLineNumberingShouldBeginWithOne(){
		claimLinesBuilder = new ClaimLinesBuilderImpl(claimLineBuilder, buildReservedClaimRequestContext()); 
		assertTrue("The line number should not start with 0", claimLinesBuilder.getNextLineNumber() == 1); 
	}
	
	@Test
	public void claimLineNumberingShouldResumeWithEight(){
		claimLinesBuilder = new ClaimLinesBuilderImpl(claimLineBuilder, buildReservedClaimRequestContext(), 7); 
		assertTrue("The line number should not start with 7", claimLinesBuilder.getNextLineNumber() == 8); 
	}
	
	@Test(expected= NoEligibleServicesException.class)
	public void builderDoesntBuildLinesWhenLinesAreNull() throws ClaimBuilderException{
		claimLinesBuilder = new ClaimLinesBuilderImpl(claimLineBuilder, buildReservedClaimRequestContext()); 
		claimLinesBuilder.buildClaimLines();
	}
	
	@Test
	public void claimLinesAreDeletedWhenNotEligibleExceptionIsThrown() throws ClaimBuilderException { 
		mockClaimLineBuilderThrowsIneligibleException("GenExam");
		claimLinesBuilder = new ClaimLinesBuilderImpl(claimLineBuilder, buildReservedClaimRequestContext("GenExam", "Lens")); 
		List<ClaimLine> lines = claimLinesBuilder.buildClaimLines();
		assertEquals(1, lines.size());
		assertEquals(2, claimLinesBuilder.getNextLineNumber());
	}
	
	@Test(expected = NoEligibleServicesException.class)
	public void throwNoEligibleServicesExceptionWhenClaimHasNoLines() throws ClaimBuilderException{
		mockClaimLineBuilderThrowsIneligibleException("GenExam");
		claimLinesBuilder = new ClaimLinesBuilderImpl(claimLineBuilder, buildReservedClaimRequestContext()); 
		claimLinesBuilder.buildClaimLines();
	}
	
	private ClaimLine buildClaimLine(String service) {
		ClaimLine claimLine = new ClaimLine();
		claimLine.setProductCatalogKey(service);
		return claimLine;
	}

	private void mockClaimLineBuilderThrowsIneligibleException(String productCatalogKey) throws ClaimBuilderException {
		when(claimLineBuilder.buildClaimLine(org.mockito.Matchers.same(productCatalogKey), anyInt())).thenThrow(new ClaimLineNotEligibleException(buildClaimLine(productCatalogKey)));
	}

	private VisionServiceRequestApiContext buildReservedClaimRequestContext(String ... productCatalogKeys){
		return MockHelper.buildVisionServiceRequestApiContext(productCatalogKeys);	
	}
	
}
