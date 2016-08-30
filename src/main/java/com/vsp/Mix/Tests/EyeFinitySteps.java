package com.vsp.Mix.Tests;


import com.vsp.Mix.Pages.LogonPage;
import com.codeborne.selenide.Condition;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import cucumber.api.java.en.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.Map;

import static com.vsp.testfw.WebHelper.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.Matchers.is;

/**
 * Created by carlki on 8/1/2016.
 */
@RunWith(Cucumber.class)
public class EyeFinitySteps {

   // private WebDriver driver = null;
    private static final String URL = "https://mixed-a1.eyefinity.com/eyefinity/html/eyefinity_logon.htm";
    private LogonPage logonPage = page(LogonPage.class);

    @Before
    public void init(){
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = new FirefoxProfile();
        //FirefoxProfile myprofile = profile.getProfile("automationQA");
        logonPage = page(LogonPage.class);
    }

    @Given("^I navigate to the Eyefinity Logon Portal")
    public void I_navigate_to_the_eyefinity_logon_portal(){
       open(URL);
    }

    @When("^A user logs on with <credentials>$")
    public void aUserLogsOnWithUsernameAndPassword(Map<String, String> logons) throws Throwable {
        String username = logons.get("username").toString();
        String password = logons.get("password").toString();
        logonPage.logon(username,password);
    }

    public void aUserLogsOnWithUsernameAndPassword(String username, String password) {
        logonPage.logon(username,password);
    }

    @Then("^I should see  the VSP Online link$")
    public void iShouldSeeTheVSPOnlineLink() throws Throwable {
        assertThat($(By.linkText("VSPOnline")).is(Condition.present), is(true));
    }

}
