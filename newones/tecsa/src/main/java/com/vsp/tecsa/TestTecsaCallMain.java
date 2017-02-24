package com.vsp.tecsa;

import com.vsp.il.test.jbehave.core.VspStoryRunnerDelegator;
import com.vsp.il.test.jbehave.gui.actions.GuiActions;
import com.vsp.il.test.jbehave.gui.actions.WebDriverActions;
import com.vsp.tecsa.steps.TecsaSteps;

public class TestTecsaCallMain {
	
	private static GuiActions webDriverActions = new WebDriverActions();

	public static void main(String... args) throws Throwable {
		VspStoryRunnerDelegator.quickExecuteWithVspProperties("com.vsp.tecsa", "tecsa", new TecsaSteps(webDriverActions));
	}
	
}