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


                String reportPageSource = getWebDriver().getPageSource();
                Document doc = Jsoup.parse(reportPageSource);

                //Elements options = doc.select("#rde1invoice > form > table:nth-child(35) > tbody > tr:nth-child(3) > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(3) > select > option");
               // Elements options = doc.select(".//*[@id='rde1invoice']/form/table[9]/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[3]/select");
                Elements arCoatings = doc.select("#rde1invoice>form>table>tbody>tr>td>table>tbody>tr>td>select[name=miscOption_0] > optgroup > option");

//                if(options.size() > 0 ){
//                    //Checks to see if Lens Style is present in the dropdown
//                    for (Element option : options) {
//                        if (option.text().equals(testRows.get(i).getLensStyle())) {
//                            //check the style codes to see if its not a false positive.
//                            if (option.val().equals(testRows.get(i).getStyleCode())) {
//                                //this is bad, return false to fail the test
//                                lensOptionsTests.postTestResult(new TestResult(false, "Deactivation FAILED and is present for : " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
//                            }
//                        } else {
//                            lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and is not present for:  " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
//                        }
//                    }
//                } else {
//                    lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and is not present for:  " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
//                }

                for(Element arCoating : arCoatings){
                    if(arCoating.text().contains(testRows.get(i).getARDescription())){
                        lensOptionsTests.postTestResult(new TestResult(false, "Deactivation FAILED and was seen in arCoating dropdown : " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                    }
                }


                // Boolean elementExists = $$(By.name("lensStyle")).contains(testRows.get(i).getLensStyle());//.size() == 0;
                SelenideElement dropdown = $(By.name("lensStyle"));
                Boolean elementExists = $$(By.name("lensStyle")).contains(testRows.get(i).getLensStyle());//;.size() > 0;

                String[] values = $$(By.name("lensStyle")).getTexts();
                //SelenideElement[] options = $$(By.name("lensStyle")).add();

                $(By.name("lensStyle")).click();
                //ElementsCollection col = $$(By.xpath(".//*[@id='rde1invoice']/form/table[9]/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[3]/select"));
                ElementsCollection col = $$(By.xpath(".//*[@id='rde1invoice']/form/table[9]/tbody/tr[2]/td[1]/table/tbody/tr[3]"));
                String pageSource = getWebDriver().getPageSource();

                String optionVal = "<option value=";
                String opValCode = "\"" + testRows.get(i).getStyleCode() + "\"";
                String isCustomizable = " iscustomizable=\"N\">";

                String tempVal = optionVal + opValCode + isCustomizable + testRows.get(i).getLensStyle() + "</option>";
                String tempVal2 = "<option value=\"3718\" iscustomizable=\"N\">Perfection - Clear</option>";

                boolean stringsequal = tempVal.equals(tempVal2);

                if(stringsequal){
                    //
                    // assertThat(stringsequal, is(true));
                    lensOptionsTests.postTestResult(new TestResult(false, "Deactivation FAILED and is present for : " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                }


                pageSource.indexOf(tempVal);

                if(elementExists){
                    //TODO need to make sure the web element value is not the value on the LSU sheet to ensure not false positive

                    cms1500Page.selectLens(testRows.get(i).getLensStyle());
                    String value = $(By.name("lensStyle")).getSelectedOption().getValue();
                    if(value == testRows.get(i).getStyleCode()){
                        lensOptionsTests.postTestResult(new TestResult(false, "Deactivation FAILED and is present for : " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                    } else {
                        lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and is not present for:  " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                    }

                } else {
                    lensOptionsTests.postTestResult(new TestResult(true, "Deactivation passed and is not present for:  " + testRows.get(i).getFinishing() +  testRows.get(i).getVisionType() + testRows.get(i).getMaterial() + testRows.get(i).getLensStyle()));
                }
                lensOptionsTests.postTestResult(result);
            }

            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}