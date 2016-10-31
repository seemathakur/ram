package com.vsp.Mix.Tests.EInsurance.Administration;

import com.vsp.Mix.Pages.EInsureance.Administration.DrProfilePage;
import com.vsp.testfw.DefaultSteps;
import com.vsp.testfw.config.RuntimeConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;

import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/4/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        tags = "@tags",
        features = "src/test/resources/features/EInsurance/Administration",
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" },
        dryRun = false,
        glue = "src/main/java/mix/Tests/EInsurance/Administration" )
public class ProviderProfileSteps {

    private DrProfilePage providerProfilePage;
    @Before
    public void defaultBeforeClass() {
        RuntimeConfig.setDefaultConfig();

    }
    @Given("^I navigate to the practice page to monitor my profile")
    public void navigateToProfilePage() {
        providerProfilePage = page(DrProfilePage.class);
        providerProfilePage.navigateTo();
    }

    @When("^a user updates a provider <profile>$")
    public void aUserUpdatesAProviderProfile(DataTable arg1) throws Throwable {
        List<Map<String,String>> profile = arg1.asMaps(String.class, String.class);

        providerProfilePage.setProviderProfileStatus(Boolean.parseBoolean(profile.get(0).get("active")));
        providerProfilePage.setPracticingSince(profile.get(0).get("_practicingSince"));

        providerProfilePage.setSchoolName1(profile.get(0).get("_schoolName1"));
        providerProfilePage.setSchoolName2(profile.get(0).get("_schoolName2"));
        providerProfilePage.setSchoolName3(profile.get(0).get("_schoolName3"));
        providerProfilePage.setSchoolName4(profile.get(0).get("_schoolName4"));
        providerProfilePage.setSchoolName5(profile.get(0).get("_schoolName5"));

        providerProfilePage.setDegree1(profile.get(0).get("_degree1"));
        providerProfilePage.setDegree2(profile.get(0).get("_degree2"));
        providerProfilePage.setDegree3(profile.get(0).get("_degree3"));
        providerProfilePage.setDegree4(profile.get(0).get("_degree4"));
        providerProfilePage.setDegree5(profile.get(0).get("_degree5"));

        providerProfilePage.setCity1(profile.get(0).get("_city1"));
        providerProfilePage.setCity2(profile.get(0).get("_city2"));
        providerProfilePage.setCity3(profile.get(0).get("_city3"));
        providerProfilePage.setCity4(profile.get(0).get("_city4"));
        providerProfilePage.setCity5(profile.get(0).get("_city5"));

        providerProfilePage.setState(1, profile.get(0).get("_state1"));
        providerProfilePage.setState(2, profile.get(0).get("_state2"));
        providerProfilePage.setState(3, profile.get(0).get("_state3"));
        providerProfilePage.setState(4, profile.get(0).get("_state4"));
        providerProfilePage.setState(5, profile.get(0).get("_state5"));

        providerProfilePage.clickAvailableLanguage(profile.get(0).get("lang1"));
        providerProfilePage.addSelectedLanguage();
        providerProfilePage.clickAvailableLanguage(profile.get(0).get("lang2"));
        providerProfilePage.addSelectedLanguage();

        providerProfilePage.setChildren03Checkbox(Boolean.parseBoolean(profile.get(0).get("_seeChildren03")));
        providerProfilePage.setChildren35Checkbox(Boolean.parseBoolean(profile.get(0).get("_seeChildren35")));
        providerProfilePage.setHardToFitContactLensesCheckbox(Boolean.parseBoolean(profile.get(0).get("_hardToFitContactLenses")));
        providerProfilePage.setLowVisionCheckbox(Boolean.parseBoolean(profile.get(0).get("_lowVision")));
        providerProfilePage.setVisionTherapyChecbox(Boolean.parseBoolean(profile.get(0).get("_visionTherapy")));

        providerProfilePage.setProfessionalStatement(profile.get(0).get("_profStatement"));

        providerProfilePage.setIncludeGenderCheckbox(Boolean.parseBoolean(profile.get(0).get("_includeGenderInProfile")));
        providerProfilePage.setGender(profile.get(0).get("_gender"));

        providerProfilePage.setIncludeCertificationsCheckbox(Boolean.parseBoolean(profile.get(0).get("_includeCertificationsInProfile")));
        providerProfilePage.setCertification1(profile.get(0).get("_cert1"));
        providerProfilePage.setCertification2(profile.get(0).get("_cert2"));
        providerProfilePage.setCertification3(profile.get(0).get("_cert3"));
        providerProfilePage.setCertification4(profile.get(0).get("_cert4"));
        providerProfilePage.setCertification5(profile.get(0).get("_cert5"));

        providerProfilePage.setPinkEyeCheckbox(Boolean.parseBoolean(profile.get(0).get("_amaPinkEye")));
        providerProfilePage.setGlaucomaCheckbox(Boolean.parseBoolean(profile.get(0).get("_amaGlaucoma")));
        providerProfilePage.setCunjunctivitisCheckbox(Boolean.parseBoolean(profile.get(0).get("_amaCunjunctivitis")));
        providerProfilePage.setAstigmatismCheckbox(Boolean.parseBoolean(profile.get(0).get("_amaAstigmatism")));
        providerProfilePage.setCataractsCheckbox(Boolean.parseBoolean(profile.get(0).get("_amaCataracts")));
        providerProfilePage.setMacularDegenerationCheckbox(Boolean.parseBoolean(profile.get(0).get("_amaMacular")));
        providerProfilePage.setColorBlindTestCheckbox(Boolean.parseBoolean(profile.get(0).get("_amaColorblind")));
    }

    @Then("^I save and publish the profile.$")
    public void iSaveAndPublishTheProfile() throws Throwable {
        providerProfilePage.clickPublishProfileButton();
    }


    @Given("^I navigate to the VSP online page")
    public void iNavigateToTheVSPOnlinePage() throws Throwable {
        $(By.linkText("VSPOnline")).click();
    }


    @Then("^I validate a previously input <profile>$")
    public void iValidateAPreviouslyInputProfile(DataTable arg1) throws Throwable {
        List<Map<String,String>> profile = arg1.asMaps(String.class, String.class);

        assertThat(providerProfilePage.getProviderProfileStatus(), is(Boolean.parseBoolean(profile.get(0).get("active"))));
        assertThat(providerProfilePage.getPracticingSince(), is(profile.get(0).get("_practicingSince")));

        assertThat(providerProfilePage.getSchoolName1(), is(profile.get(0).get("_schoolName1")));
        assertThat(providerProfilePage.getSchoolName2(), is(profile.get(0).get("_schoolName2")));
        assertThat(providerProfilePage.getSchoolName3(), is(profile.get(0).get("_schoolName3")));
        assertThat(providerProfilePage.getSchoolName4(), is(profile.get(0).get("_schoolName4")));
        assertThat(providerProfilePage.getSchoolName5(), is(profile.get(0).get("_schoolName5")));

        assertThat(providerProfilePage.getDegree1(), is(profile.get(0).get("_degree1")));
        assertThat(providerProfilePage.getDegree2(), is(profile.get(0).get("_degree2")));
        assertThat(providerProfilePage.getDegree3(), is(profile.get(0).get("_degree3")));
        assertThat(providerProfilePage.getDegree4(), is(profile.get(0).get("_degree4")));
        assertThat(providerProfilePage.getDegree5(), is(profile.get(0).get("_degree5")));

        assertThat(providerProfilePage.getCityName1(), is(profile.get(0).get("_city1")));
        assertThat(providerProfilePage.getCityName2(), is(profile.get(0).get("_city2")));
        assertThat(providerProfilePage.getCityName3(), is(profile.get(0).get("_city3")));
        assertThat(providerProfilePage.getCityName4(), is(profile.get(0).get("_city4")));
        assertThat(providerProfilePage.getCityName5(), is(profile.get(0).get("_city5")));


        assertThat(providerProfilePage.getState1(), is(profile.get(0).get("_state1")));
        assertThat(providerProfilePage.getState2(), is(profile.get(0).get("_state2")));
        assertThat(providerProfilePage.getState3(), is(profile.get(0).get("_state3")));
        assertThat(providerProfilePage.getState4(), is(profile.get(0).get("_state4")));
        assertThat(providerProfilePage.getState5(), is(profile.get(0).get("_state5")));

//        providerProfilePage.clickAvailableLanguage(profile.get(0).get("lang1"));
//        providerProfilePage.addSelectedLanguage();
//        providerProfilePage.clickAvailableLanguage(profile.get(0).get("lang2"));
//        providerProfilePage.addSelectedLanguage();

        assertThat(providerProfilePage.getChildren03Checkbox(), is(Boolean.parseBoolean(profile.get(0).get("_seeChildren03"))));
        assertThat(providerProfilePage.getChildren35Checkbox(), is(Boolean.parseBoolean(profile.get(0).get("_seeChildren35"))));
        assertThat(providerProfilePage.getHardToFitContactLensesCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_hardToFitContactLenses"))));
        assertThat(providerProfilePage.getLowVisionCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_lowVision"))));
        assertThat(providerProfilePage.getVisionTherapyCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_visionTherapy"))));

        assertThat(providerProfilePage.getProfessionalStatement(), is(profile.get(0).get("_profStatement")));

        assertThat(providerProfilePage.getIncludeGenderCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_includeGenderInProfile"))));

        assertThat(providerProfilePage.getGender(), is(profile.get(0).get("_gender")));

        assertThat(providerProfilePage.getIncludeCertificationsCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_includeCertificationsInProfile"))));

        assertThat(providerProfilePage.getCertification1(), is(profile.get(0).get("_cert1")));
        assertThat(providerProfilePage.getCertification2(), is(profile.get(0).get("_cert2")));
        assertThat(providerProfilePage.getCertification3(), is(profile.get(0).get("_cert3")));
        assertThat(providerProfilePage.getCertification4(), is(profile.get(0).get("_cert4")));
        assertThat(providerProfilePage.getCertification5(), is(profile.get(0).get("_cert5")));

        assertThat(providerProfilePage.getPinkEyeCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_amaPinkEye"))));

        assertThat(providerProfilePage.getGlaucomaCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_amaGlaucoma"))));
        assertThat(providerProfilePage.getCunjunctivitisCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_amaCunjunctivitis"))));
        assertThat(providerProfilePage.getAstigmatismCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_amaAstigmatism"))));
        assertThat(providerProfilePage.getCataractsCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_amaCataracts"))));
        assertThat(providerProfilePage.getMacularDegenerationCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_amaMacular"))));
        assertThat(providerProfilePage.getColorBlindTestCheckbox(), is(Boolean.parseBoolean(profile.get(0).get("_amaColorblind"))));

    }


    @Then("^view the Doctor Title field I verify it displays <doctorTitle>$")
    public void view_the_Doctor_Title_field_I_verify_it_displays_doctorTitle(DataTable arg1) throws Throwable {
        Map<String, String> doctitle = arg1.asMap(String.class, String.class);
        assertThat(providerProfilePage.getDoctorTitle().contains(doctitle.get("doctorTitle")), is(true));
    }

    @Then("^view the Doctor Highlights field I verify it displays <highlights>$")
    public void viewTheDoctorTitleFieldIVerifyItDisplaysHighlights(DataTable higlightList) throws Throwable {
        List<String> doctitle = higlightList.asList(String.class);
        assertThat(providerProfilePage.doctorHighlightsContainsAll(doctitle), is(true));
    }

    @Then("^view the Doctor Network field I verify it displays <networks>$")
    public void viewTheDoctorNetworkFieldIVerifyItDisplaysNetworks(DataTable networkList) throws Throwable {
        List<String> networks = networkList.asList(String.class);
        assertThat(providerProfilePage.doctorNetworksContainsAll(networks), is(true));
    }

    @And("^I refresh the page and verify my <gender>$")
    public void iRefreshThePageAndVerifyMyGender(String gender) throws Throwable {
        refresh();
        assertThat(providerProfilePage.getGender().contentEquals(gender), is(true));
    }

    @Then("^update my <gender>$")
    public void updateMyGender(String _gender) throws Throwable {
        providerProfilePage.setGender(_gender);

    }
}
