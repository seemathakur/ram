package com.vsp.Mix.Tests.EInsurance.LensOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementsCollection;
import com.vsp.Mix.Pages.EInsureance.CMS1500Page;
import com.vsp.Mix.Tests.EyeFinitySteps;
import com.vsp.testfw.LoginAuth;
import com.vsp.testfw.LoginAuthPool;
import org.openqa.selenium.By;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import static com.vsp.testfw.WebHelper.getWebDriver;
import static com.vsp.testfw.WebHelper.switchToFrameUsingName;

/**
 * Created by carlki on 8/18/2016.
 */
public class LSURunnableDeactivation implements Runnable {

    private LensOptionsTests lensOptionsTests = new LensOptionsTests();
    private EyeFinitySteps eyeFinitySteps = new EyeFinitySteps();
    private CMS1500Page cms1500Page = page(CMS1500Page.class);
    private List<TestRow> testRows = new ArrayList<>();
    private boolean runRemoteThreaded = false;

    private String mainWindow = "eInsurance";

    public LSURunnableDeactivation(List<TestRow>  rows, Boolean runThreaded) {
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
                cms1500Page.selectLensFinishing(testRows.get(i).getFinishing());
                cms1500Page.selectionVisionType(testRows.get(i).getVisionType());
                cms1500Page.selectMaterial(testRows.get(i).getMaterial());

                // we need to click the drop down as a javascript populates the list when you click it
                $(By.name("lensStyle")).click();

                String pageSource = getWebDriver().getPageSource();

                // we are testing if the Lens Style and its Option Code are BOTH present ; otherwise we might get false positive
                int indexofOptionCode = pageSource.indexOf(testRows.get(i).getStyleCode());

                if(indexofOptionCode == -1){
                    // PASS -1 is not found
                     lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and is not present for:  " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                } else {
                    // note 34 below accounts for the text in between the option code and the closing option bracket so we can get the whole thing
                    try {
                        String optionText = pageSource.substring(indexofOptionCode, indexofOptionCode +(34 + testRows.get(i).getLensStyle().toString().length() ) );
                        if(optionText == null){
                            // PASS - it was not found
                            lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and is not present for:  " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                        } else if(optionText.contains(testRows.get(i).getLensStyle())){
                            // FAIL option text and option code were found (avoids false positive when including option code)
                            lensOptionsTests.postTestResult(new TestResult(false, "Deactivation FAILED and is present for : " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                        }
                    } catch (IndexOutOfBoundsException iOOBE) {
                        // if the index was out of bounds then this option isn't present
                        lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and is not present for:  " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                    }

                }

            }

            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}