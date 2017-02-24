
package com.vsp.claim.visionservicerequest.test;

import com.vsp.claim.visionservicerequest.test.steps.AuthorizationSteps;
import com.vsp.claim.visionservicerequest.test.steps.ClaimBuilderSteps;
import com.vsp.claim.visionservicerequest.test.steps.OAuthSteps;
import com.vsp.claim.visionservicerequest.test.steps.PatientHistorySteps;
import com.vsp.claim.visionservicerequest.test.steps.ReservedClaimDBSteps;
import com.vsp.claim.visionservicerequest.test.steps.ReservedClaimGivenSteps;
import com.vsp.claim.visionservicerequest.test.steps.ReservedClaimThenSteps;
import com.vsp.claim.visionservicerequest.test.steps.ReservedClaimWhenSteps;
import com.vsp.claim.visionservicerequest.test.steps.TearDownSteps;
import com.vsp.claim.visionservicerequest.test.steps.VisionServiceRequestSteps;
import com.vsp.il.test.jbehave.core.VspStoryRunnerDelegator;
import com.vsp.il.test.jbehave.db.DbActionsImpl;
import com.vsp.il.test.jbehave.rest.impl.AfterActionsImpl;
import com.vsp.il.test.jbehave.rest.impl.GivenActionsImpl;
import com.vsp.il.test.jbehave.rest.impl.RestActionsImpl;
import com.vsp.il.test.jbehave.rest.impl.ThenActionsImpl;
import com.vsp.il.test.jbehave.rest.impl.WhenActionsImpl;
import com.vsp.il.test.jbehave.rest.steps.GivenSteps;
import com.vsp.il.test.jbehave.rest.steps.ThenSteps;
import com.vsp.il.test.jbehave.rest.steps.WhenSteps;

public class TestRestCallMain {
	
	private static GivenActionsImpl givenActionImpl =  new GivenActionsImpl();
	private static WhenActionsImpl whenActionImpl =  new WhenActionsImpl();
	private static ThenActionsImpl thenActionImpl =  new ThenActionsImpl();
	private static AfterActionsImpl afterActionImpl =  new AfterActionsImpl();
	private static DbActionsImpl dbActionsImpl = new DbActionsImpl();
	private static RestActionsImpl restActionsImpl = new RestActionsImpl();
	
	public static void main(String... args) throws Throwable {
		VspStoryRunnerDelegator.quickExecuteWithVspProperties(
					"com.vsp.claim.visionservicerequest.test", "claim.visionservicerequest.test",
					new ReservedClaimGivenSteps(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl),
					new ReservedClaimWhenSteps(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl),
					new ReservedClaimThenSteps(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl),
					new AuthorizationSteps(),
					new VisionServiceRequestSteps(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl,restActionsImpl),
					new ClaimBuilderSteps(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl, restActionsImpl),
					new TearDownSteps(dbActionsImpl, restActionsImpl), new GivenSteps(), new ThenSteps(thenActionImpl),
					new ReservedClaimDBSteps(dbActionsImpl),
					new WhenSteps(whenActionImpl),
					new PatientHistorySteps(givenActionImpl, whenActionImpl, thenActionImpl, afterActionImpl),
					new OAuthSteps(givenActionImpl, restActionsImpl));
	}
}