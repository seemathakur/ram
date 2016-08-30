package com.vsp.Mix.Tests.EInsurance.LensOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

/**
 * Created by carlki on 8/12/2016.
 */

//features = "src/test/resources/com/vsp/Mix/EInsurance/LensOptions/LensOptions.feature",
@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        features = "test-classes/com/vsp/Mix/EInsurance/LensOptions/LensOptions.feature",
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" },
        dryRun = false,
        glue= "com.vsp.Mix.Tests.EInsurance.LensOptions")
public class TestRunner {

    public static void main(String[] args) throws Throwable{
/* command line to run this after building jar:
 * java -cp test-fw-1.0-SNAPSHOT.jar org.junit.runner.JUnitCore com.vsp.Mix.Tests.EInsurance.LensOptions.TestRunner
 */
                JUnitCore.main(
                "com.vsp.Mix.Tests.EInsurance.LensOptions");
        //String[] arguments = {"-Dremote = http://vsp-selgrid1:4444/wd/hub"};
        cucumber.api.cli.Main.main(args);
    }



}
