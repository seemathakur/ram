package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper.buildVisionServiceRequestApiContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.client.model.Client;
import com.vsp.api.client.model.ClientDivision;
import com.vsp.api.client.model.ClientKey;
import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.util.DateInterval;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimLineNotEligibleException;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveClientDivisionCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveEligibilityCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockObjectProvider;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;
import com.vsp.il.util.Preferences;

public class ClaimLineBuilderImplTest { 
	
	private static final int LINE_NUMBER = 1;
	
	private VisionServiceRequestApiContext context; 
	
	@Before
	public void setUp() {
		if(!Preferences.initialized()) {
			Preferences.initialize();
		}
	}
	
	@After
	public void tearDown() {
	}
	

	@Test 
	public void testBuildReservedClaimLine() throws Exception {
		ClaimLineBuilder claimLineBuilder = buildClaimLineBuilderWithMockedCommandMap();
		String productCatalogKey = "GenExam"; 
		ClaimLine builtClaimLine = claimLineBuilder.buildClaimLine(productCatalogKey, LINE_NUMBER);
		
		assertClaimLineStatus(builtClaimLine);
		assertDefaultClaimLineReservationInterval(builtClaimLine);
		assertClaimLineNumber(builtClaimLine);
		assertProductCatalogKey(productCatalogKey, builtClaimLine.getProductCatalogKey()); 
	}
	
	private void assertProductCatalogKey(String expected, String actual) {
		assertEquals(expected, actual); 	
	}
	
	@Test(expected = ClaimLineNotEligibleException.class)
	public void exceptionIsThrownWhenLineCatalogKeyIsNotEligible() throws Exception {
		ClaimLineBuilder claimLineBuilder = buildClaimLineBuilderWithMockedCommandMap();
		claimLineBuilder.buildClaimLine("Lens", LINE_NUMBER);
	}
	
	private ClaimLineBuilder buildClaimLineBuilderWithMockedCommandMap() throws Exception {
		CommandMap mockedCommandMap = mockCommandMap(mockRetrieveClientCommandAndResponse(), mockRetrieveEligiblilityCommandAndResponse());
		context = buildVisionServiceRequestApiContext();
		return new ClaimLineBuilderImpl(mockedCommandMap, context);
	}

	private CommandMap mockCommandMap(Command<?> clientCommand, Command<?> eligibilityCommand) throws Exception {
		CommandMap commandMapOfMockCommands = new CommandMap();
		commandMapOfMockCommands.put(CommandMap.RETRIEVE_CLIENT_DIVISION_COMMAND, clientCommand);
		commandMapOfMockCommands.put(CommandMap.RETRIEVE_ELIGBILITY_COMMAND, eligibilityCommand);
		return commandMapOfMockCommands;
	}

	private Command<?> mockRetrieveClientCommandAndResponse() throws Exception {
		RetrieveClientDivisionCommand clientCommand = mock(RetrieveClientDivisionCommand.class);
		ClientDivision clientDivisionResponse = buildClientDivisionResponse();
		when(clientCommand.getReturnValue()).thenReturn(clientDivisionResponse);
		
		return clientCommand;
	}
	
	private ClientDivision buildClientDivisionResponse() {
		ClientDivision clientDivision = new ClientDivision();
		Client client = new Client();
		ClientKey clientKey = new ClientKey();
		clientKey.setClientId("00857001");
		client.setKey(clientKey);
		client.setGroupPopulationCode("C");
		clientDivision.setClient(client);
		return clientDivision;
		
	}

	private Command<?> mockRetrieveEligiblilityCommandAndResponse() throws Exception {
		RetrieveEligibilityCommand eligibilityCommand = mock(RetrieveEligibilityCommand.class);
		Eligibility mockEligibility = (Eligibility) new MockObjectProvider().mockObjectFromJson("com/vsp/claim/visionservicerequestapi/servicerequest/eligibilityfilter/Eligibility.json", Eligibility.class);
		when(eligibilityCommand.getReturnValue()).thenReturn(mockEligibility);

		return eligibilityCommand;
	}

	
	private void assertClaimLineStatus(ClaimLine builtClaimLine) {
		assertEquals("RS", builtClaimLine.getStatusCode());
	}

	private void assertDefaultClaimLineReservationInterval(ClaimLine builtClaimLine) {
		assertNotNull(builtClaimLine.getReservationInterval());
		DateInterval expectedInterval = new DateInterval(context.getEffectiveDate(), context.getEffectiveDate().plusDays(Preferences.getInt("authorization", "DefaultReservationInterval")));
		assertEquals(expectedInterval, builtClaimLine.getReservationInterval());
	}
	
	private void assertClaimLineNumber(ClaimLine builtClaimLine) {
		assertNotNull(builtClaimLine.getLineNumber());
		assertEquals(new Integer(1), builtClaimLine.getLineNumber());
	}
	


		
}
