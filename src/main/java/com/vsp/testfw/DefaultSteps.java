package com.vsp.testfw;

import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.vsp.testfw.config.RuntimeConfig;

/**
 * Created by carlki on 10/23/2016.
 */
@RunWith(Cucumber.class)
public class DefaultSteps {

    @Before
    public void defaultBeforeClass() {
        RuntimeConfig.setDefaultConfig();

    }
}
