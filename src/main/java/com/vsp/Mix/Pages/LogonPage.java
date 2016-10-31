package com.vsp.Mix.Pages;

import com.codeborne.selenide.Condition;
import com.vsp.testfw.config.RuntimeConfig;
import cucumber.api.java.Before;
import org.openqa.selenium.By;

import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/2/2016.
 */

public class LogonPage  {

    //https://mixed-a1.eyefinity.com/eyefinity/html/eyefinity_logon.htm
    private static final String URL =  RuntimeConfig.getStartingPage() + "/eyefinity/html/eyefinity_logon.htm";
    @Before
    public void defaultBeforeClass() {
        RuntimeConfig.setDefaultConfig();

    }
    public void navigateTo() {
        open(URL);
        //sleep(1500);
    }

    public void logon(String username, String password){
        $(By.xpath("//input[@name='accessID']")).shouldBe(Condition.visible).val(username);
        $(By.xpath("//*[@name='password']")).val(password);
        $(By.xpath("//*[@name='logon']")).click();

    }


}
