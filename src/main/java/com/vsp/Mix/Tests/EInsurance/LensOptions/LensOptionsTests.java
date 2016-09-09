package com.vsp.Mix.Tests.EInsurance.LensOptions;

import com.vsp.Mix.Pages.EInsureance.CMS1500Page;
import com.vsp.Mix.Pages.EInsureance.EInsuranceHomePage;
import com.codeborne.selenide.Condition;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vsp.testfw.RuntimeConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/12/2016.
 */

@RunWith(Cucumber.class)
public class LensOptionsTests {

    private static final Logger log = LoggerFactory.getLogger(RuntimeConfig.class);

    private CMS1500Page cms1500Page= page(CMS1500Page.class);
    private EInsuranceHomePage eInsuranceHomePage = page(EInsuranceHomePage.class);
    private String mainWindow = "eInsurance";
    private static XLSParser excelfile;
    private static int nextTest = 0;
    private static List<TestResult> results = new ArrayList<>();

    private static final String excelFilePath = "C:\\Carls Documents\\eclipse_workspace\\iDrTest\\";

    @Before
    public void init(){
        //eInsuranceHomePage = page(EInsuranceHomePage.class);
        //cms1500Page = page(CMS1500Page.class);
    }

    @Then("^I navigate to EInsurance homepage and enter <auth> and click go$")
    public void i_navigate_to_EInsurance_homepage_and_enter_auth_and_click_go(Map<String, String> auth) throws Throwable {
        eInsuranceHomePage.navigateTo();
        eInsuranceHomePage.enterAuthorizationNumber(auth.get("auth"));
        eInsuranceHomePage.clickGoButton();
    }

    public void i_navigate_to_EInsurance_homepage_and_enter_auth_and_click_go(String auth)  {
        eInsuranceHomePage.navigateTo();
        eInsuranceHomePage.enterAuthorizationNumber(auth);
        eInsuranceHomePage.clickGoButton();
    }

    @Given("^I hit the continue button.$")
    public void iHitTheContinueButton() throws Throwable {
        switchToFrameUsingName("navPage");
        cms1500Page.clickContinueButton();
    }

    @When("^I input the following lens options <finishing> , <vision> , <material> , <lens>$")
    public void iInputTheFollowingLensOptionsFinishingVisionMaterialLens(Map<String, String> options) throws Throwable {
        switchTo().window(mainWindow);

        switchToFrameUsingName("guiPage");
        cms1500Page.selectLensFinishing(options.get("finishing"));
        cms1500Page.selectionVisionType(options.get("vision"));
        cms1500Page.selectMaterial(options.get("material"));
        cms1500Page.selectLens(options.get("lens"));
    }

    @Then("^I select a lab.$")
    public void iSelectALab() throws Throwable {
        cms1500Page.selectLab();
    }

    @Then("^I calculate and continue.$")
    public void iCalculateAndContinue() throws Throwable {
        switchTo().window(mainWindow);
        switchToFrameUsingName("navPage");
        cms1500Page.clickCalculateAndContinueButton();
    }

    @Given("^I load the excel file <filename>$")
    public void i_load_the_excel_file_filename(DataTable filename)  {
        Map<String, String> files = filename.asMap(String.class, String.class);
        excelfile = parseExcelFile(excelFilePath + files.get("filename"));
    }

    @Then("^I iterate through the rows using selenium grid <run_remote>$")
    public void iIterateThroughTheRowsUsingSeleniumGrid(DataTable runremote)  {
        List<Boolean> remote = runremote.asList(Boolean.class);

        int poolsize = 1;
        if(remote.get(0)){
            poolsize = 2;
        }

        ExecutorService executor = Executors.newFixedThreadPool(poolsize);
        for (int i = 0; i < excelfile.getAdditions().size(); i++) {
            Runnable worker = new LSURunnableActivation(excelfile.getAdditions().get(i),remote.get(0));
            executor.execute(worker);
        }

        if(excelfile.getDeactivations().size() > 0){
            // Deactivations iterate on one page instead of needing to login for each one
            // so we iterate in the runner not here
            Runnable worker = new LSURunnableDeactivation(excelfile.getDeactivations(),remote.get(0));
            executor.execute(worker);
        }

        if(excelfile.getChanges().size() > 0){
            // Changes iterate on one page instead of needing to login for each one
            // so we iterate in the runner not here
            for (int k = 0; k < excelfile.getChanges().size(); k++) {
                Runnable worker = new LSURunnableActivation(excelfile.getChanges().get(k),remote.get(0));
                executor.execute(worker);
            }
        }

        if(excelfile.getArAdditions().size() > 0){
            // AR Additions iterate on one page instead of needing to login for each one
            // so we iterate in the runner not here

            for (int n = 0; n < excelfile.getArAdditions().size(); n++) {
                Runnable worker = new LSURunnableActivation(excelfile.getArAdditions().get(n),remote.get(0));
                executor.execute(worker);
            }
        }

        if(excelfile.getArChanges().size() > 0){
            // AR Changes iterate on one page instead of needing to login for each one
            // so we iterate in the runner not here

            for (int l = 0; l < excelfile.getArChanges().size(); l++) {
                Runnable worker = new LSURunnableActivation(excelfile.getArChanges().get(l),remote.get(0));
                executor.execute(worker);
            }
        }

        if(excelfile.getArDeactivations().size() > 0){
            // AR Deactivations iterate on one page instead of needing to login for each one
            // so we iterate in the runner not here

            for (int m = 0; m < excelfile.getDeactivations().size(); m++) {
                Runnable worker = new LSURunnableARCoatingDeactivation(excelfile.getArDeactivations(),remote.get(0));
                executor.execute(worker);
            }
        }



        executor.shutdown();


        while (!executor.isTerminated()) {
            // just need to wait until this dies to do results afterwards
        }
        log.info("******************************************************************************");
        log.info("Test run complete. Total number of test rows processed was : " + results.size());
        int passed = 0;
        int failed = 0;

        for(TestResult tr : results){
            log.debug(tr.getReason());
            if(tr.didPass()){
                passed++;
                log.info(" Row passed : " + tr.getReason());
            } else if (!tr.didPass()) {
                failed++;
                log.warn(" !!!!Row FAILED!!!! : " + tr.getReason());
            } else {
                log.warn("WARNING!!!  Null test result found , something went wrong! Test reason info was : " + tr.getReason());
            }
            assertThat( tr.getReason(), true , is(tr.didPass()));
        }
        log.info("Number of tests that passed : " + passed);
        log.info("Number of tests that failed : " + failed);
        log.info("******************************************************************************");
    }

    public void postTestResult(TestResult result){
        results.add(result);
    }

    @Then("^I verify the service report contains <results>$")
    public void iVerifyTheServiceReportConatinsResults(DataTable results) throws Throwable {
        List<String> optionResults = results.asList(String.class);
        List<String> actualResults = new ArrayList<>();

        cms1500Page.clickReportsButton();

        switchToWindowUsingTitle("Primary doctor.vsp.com Reports Interface Page");
        switchToFrameUsingName("rptTop");
        $(By.name("imgdrsvcrpt")).click();

        switchToFrameUsingName("rptPage");
        $(By.className("drSvcOrderInfo")).waitUntil(Condition.visible, 6000);

        String allText = $$(By.className("drSvcOrderInfo")).toString();
        for(String s : optionResults){
            assertThat(allText.contains(s), is(true));
        }
        switchToWindowUsingTitle(mainWindow);
    }

    public TestResult runTest(TestRow row){
        TestResult result =  new TestResult(false, "");
        try{
            //hit continue button
            switchToFrameUsingName("navPage");
            cms1500Page.clickContinueButton();

            //whee frames!
            switchTo().window(mainWindow);

            //input options for this test
            switchToFrameUsingName("guiPage");
            cms1500Page.selectLensFinishing(row.getFinishing());
            cms1500Page.selectionVisionType(row.getVisionType());
            cms1500Page.selectMaterial(row.getMaterial());
            cms1500Page.selectLens(row.getLensStyle());

            //select lab
            cms1500Page.selectLab();

            //calculate and continue
            switchTo().window(mainWindow);
            switchToFrameUsingName("navPage");
            cms1500Page.clickCalculateAndContinueButton();

            //TODO get a method to wait until the barbershop pole/loading bar dissapears
            sleep(1500);

            List<String> optionResults = new ArrayList<>();

            for (Map.Entry<String, Boolean> entry : row.getOptionCodes().entrySet())
            {
                optionResults.add(entry.getKey());
            }

            switchToFrameUsingName("navPage");
            cms1500Page.clickReportsButton();

            switchToWindowUsingTitle("Primary doctor.vsp.com Reports Interface Page");
            switchToFrameUsingName("rptTop");
            $(By.name("imgdrsvcrpt")).click();

            switchToFrameUsingName("rptPage");
            $(By.className("drSvcOrderInfo")).waitUntil(Condition.visible, 6000);

            String allText = $$(By.className("drSvcOrderInfo")).toString();
            for(String s : optionResults){

                if(allText.contains(s)){

                    result = new TestResult(true, "Option codes match for " + row.getFinishing() +  row.getVisionType() + row.getMaterial() + row.getLensStyle());
                } else {
                    result = new TestResult(false, "Option codes DO NOT match for " + row.getFinishing() +  row.getVisionType() + row.getMaterial() + row.getLensStyle() + " expected option : " + optionResults.toString() + ",  but got results of : " + allText );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = new TestResult(false, "Something went wrong!");
        } finally {
            switchToWindowUsingTitle(mainWindow);
            return result;
        }
    }


    public XLSParser parseExcelFile(String filename) {
        return new XLSParser(filename, 0);
    }


}
