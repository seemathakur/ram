package com.vsp.Mix.Tests.EInsurance.LensOptions;

import com.codeborne.selenide.Configuration;
import com.vsp.Mix.Pages.EInsureance.CMS1500Page;
import com.vsp.Mix.Tests.EyeFinitySteps;
import com.codeborne.selenide.Condition;
import com.vsp.testfw.LoginAuth;
import org.openqa.selenium.By;
import com.vsp.testfw.LoginAuthPool;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/16/2016.
 */
public class LSURunnableActivation implements Runnable {

    private LensOptionsTests lensOptionsTests = new LensOptionsTests();
    private EyeFinitySteps eyeFinitySteps = new EyeFinitySteps();
    private CMS1500Page cms1500Page = page(CMS1500Page.class);
    private TestRow testRow;
    private boolean runRemoteThreaded = false;

    private String mainWindow = "eInsurance";

    public LSURunnableActivation(TestRow row, Boolean runThreaded){
        this.testRow = row;
        this.runRemoteThreaded = runThreaded;
    }

    public void run(){
        try {
            processCommand();
        } catch(MalformedURLException m){
            m.printStackTrace();
        }
    }

    private void processCommand()throws MalformedURLException {
        TestResult result = null;
        try {

            //this tells Selenide/Selenium to use a remote hub
            if(runRemoteThreaded){
                Configuration.remote = "http://vsp-selgrid1:4444/wd/hub";
            }

            LoginAuth login = LoginAuthPool.getNextLogin();
            eyeFinitySteps.I_navigate_to_the_eyefinity_logon_portal();
            eyeFinitySteps.aUserLogsOnWithUsernameAndPassword(login.getUsername(), login.getPassword());
            lensOptionsTests.i_navigate_to_EInsurance_homepage_and_enter_auth_and_click_go(login.getAuthorization());

            //input options for this test
            switchToFrameUsingName("guiPage");
            if($(By.id("enteredDateOfService")).getValue().isEmpty()){
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
            cms1500Page.selectLensFinishing(testRow.getFinishing());
            cms1500Page.selectionVisionType(testRow.getVisionType());
            cms1500Page.selectMaterial(testRow.getMaterial());
            cms1500Page.selectLens(testRow.getLensStyle());

            //select lab
            cms1500Page.selectLab();

            switchTo().window(mainWindow);
            switchToFrameUsingName("guiPage");
            // set some required fields depends on the configuration of the lens
            cms1500Page.setLSphereInput("+2.25");
            cms1500Page.setRSphereInput("+2.25");

            if(!testRow.getVisionType().equals("Single Vision") && !testRow.getVisionType().equals("Lenticular Single Vision")){
                $(By.name("rAdd")).setValue("2.25");
                $(By.name("lAdd")).setValue("2.25");
                $(By.name("rSeg")).setValue("23");
                $(By.name("lSeg")).setValue("23");
            } else {
                $(By.name("rAdd")).clear();
                $(By.name("lAdd")).clear();
                $(By.name("rSeg")).clear();
                $(By.name("lSeg")).clear();
            }

            // bifocal special handling
            if(testRow.getVisionType().equals("Bifocal")){
                $(By.xpath("//input[@name='pdType'][@value='1']")).click();
                $(By.name("rDist")).clear();
                $(By.name("lDist")).clear();
                $(By.name("dist")).setValue("23");
            } else {
                $(By.xpath("//input[@name='pdType'][@value='2']")).click();
                $(By.name("rDist")).setValue("23");
                $(By.name("lDist")).setValue("23");
            }

            //calculate and continue
            switchTo().window(mainWindow);
            switchToFrameUsingName("navPage");
            cms1500Page.clickCalculateAndContinueButton();

            //TODO get a method to wait until the barbershop pole/loading bar dissapears
            sleep(1500);

            List<String> optionResults = new ArrayList<String>();

            for (Map.Entry<String, Boolean> entry : testRow.getOptionCodes().entrySet())
            {
                optionResults.add(entry.getKey());
            }

            switchTo().window(mainWindow);
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

                    result = new TestResult(true, "Option codes match for " + testRow.getFinishing() +  testRow.getVisionType() + testRow.getMaterial() + testRow.getLensStyle());
                } else {
                    result = new TestResult(false, "Option codes DO NOT match for " + testRow.getFinishing() +  testRow.getVisionType() + testRow.getMaterial() + testRow.getLensStyle() + " expected option : " + optionResults.toString() + ",  but got results of : " + allText );
                }
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lensOptionsTests.postTestResult(result);
        }
    }

}
