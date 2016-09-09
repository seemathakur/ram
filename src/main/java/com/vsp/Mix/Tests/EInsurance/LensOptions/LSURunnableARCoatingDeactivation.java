package com.vsp.Mix.Tests.EInsurance.LensOptions;

import com.codeborne.selenide.Configuration;
import com.vsp.Mix.Pages.EInsureance.CMS1500Page;
import com.vsp.Mix.Tests.EyeFinitySteps;
import com.vsp.testfw.LoginAuth;
import com.vsp.testfw.LoginAuthPool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.vsp.testfw.WebHelper.getWebDriver;
import static com.vsp.testfw.WebHelper.switchToFrameUsingName;

/**
 * Created by carlki on 9/8/2016.
 */
public class LSURunnableARCoatingDeactivation implements Runnable  {

    private LensOptionsTests lensOptionsTests = new LensOptionsTests();
    private EyeFinitySteps eyeFinitySteps = new EyeFinitySteps();
    private CMS1500Page cms1500Page = page(CMS1500Page.class);
    private List<TestRow> testRows = new ArrayList<>();
    private boolean runRemoteThreaded = false;

    private String mainWindow = "eInsurance";

    public LSURunnableARCoatingDeactivation(List<TestRow>  rows, Boolean runThreaded) {
        this.testRows = rows;
        this.runRemoteThreaded = runThreaded;
    }

    public void run() {
        try {
            processCommand();
        } catch (MalformedURLException m) {
            m.printStackTrace();
        }
    }

    private void processCommand() throws MalformedURLException {
        TestResult result = null;
        try {

            //this tells Selenide/Selenium to use a remote hub
            if (runRemoteThreaded) {
                Configuration.remote = "http://vsp-selgrid1:4444/wd/hub";
            }

            LoginAuth login = LoginAuthPool.getNextLogin();
            eyeFinitySteps.I_navigate_to_the_eyefinity_logon_portal();
            eyeFinitySteps.aUserLogsOnWithUsernameAndPassword(login.getUsername(), login.getPassword());
            lensOptionsTests.i_navigate_to_EInsurance_homepage_and_enter_auth_and_click_go(login.getAuthorization());

            //input options for this test
            switchToFrameUsingName("guiPage");
            if ($(By.id("enteredDateOfService")).getValue().isEmpty()) {
                cms1500Page.setDateOfServiceInput("08/18/2016");
            }
            //hit continue button
            switchTo().window(mainWindow);
            switchToFrameUsingName("navPage");
            cms1500Page.clickContinueButton();

            //whee frames!
            switchTo().window(mainWindow);

            //input options for this test
            switchToFrameUsingName("guiPage");


            for(int i = 0; i < testRows.size(); i ++){
                cms1500Page.selectLensFinishing("Lab Finishing");
                cms1500Page.selectionVisionType("Single Vision");
                cms1500Page.selectMaterial("Any Single Vision (Lab Choice) - Clear");

                String reportPageSource = getWebDriver().getPageSource();
                Document doc = Jsoup.parse(reportPageSource);

                Elements arCoatings = doc.select("#rde1invoice>form>table>tbody>tr>td>table>tbody>tr>td>select[name=miscOption_0] > optgroup > option");

                for(Element arCoating : arCoatings){
                    if(arCoating.text().contains(testRows.get(i).getARDescription())){
                        lensOptionsTests.postTestResult(new TestResult(false, "Deactivation FAILED and was seen in arCoating dropdown : " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                    } else {
                        lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and was NOT seen in arCoating dropdown for : " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                    }
                }
            }

            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}