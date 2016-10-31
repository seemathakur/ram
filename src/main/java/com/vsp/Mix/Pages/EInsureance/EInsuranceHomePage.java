package com.vsp.Mix.Pages.EInsureance;


import org.openqa.selenium.By;

import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/12/2016.
 */
public class EInsuranceHomePage {

    private static final By authorizationInputBox = By.id("authNum");
    private static final By goButton = By.xpath(".//*[@id='vsp_page']/table/tbody/tr[2]/td[3]/input[2]");

    public void navigateTo(){
        //TODO need this to be a relative URL not absolute so it can run on different environments
        open("https://mixed-a7.eyefinity.com/eyefinity/html/eInsurance.htm");
    }

    public void enterAuthorizationNumber(String auth){
        switchToFrameUsingName("guiPage");
        $(authorizationInputBox).setValue(auth);
    }

    public void clickGoButton(){
        $(goButton).click();
    }

}
