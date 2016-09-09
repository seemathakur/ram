package com.vsp.Mix.Pages.EInsureance;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/12/2016.
 */
public class CMS1500Page {

    private static final By continueButton = By.linkText("CONTINUE");
    private static final By reportsButton = By.linkText("REPORTS");
    private static final By calculateAndContinueButton = By.xpath("html/body/form/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/a/div");

    private static final By lensFinishingDropDown = By.name("lensFinishing");
    private static final By visionTypeDropDown = By.name("lensType");
    private static final By materialDropDown = By.name("lensMatType");
    private static final By lensDropDown = By.name("lensStyle");

    private static final By showLabsButton = By.id("showLabs");
    private static final By selectLabDropDown = By.id("labList_cbxDiv");
    private static final By dateOfServiceInput = By.id("enteredDateOfService");
    private static final By rSphereInput = By.name("rSphere");
    private static final By lSphereInput = By.name("lSphere");
    private static final By rightDistance = By.name("rDist");


    public void clickContinueButton(){
        $(continueButton).click();
    }

    public void clickCalculateAndContinueButton(){
        $(calculateAndContinueButton).waitUntil(Condition.visible,5000);
        $(calculateAndContinueButton).click();
    }

    public void selectLensFinishing(String option){
     $(lensFinishingDropDown).waitUntil(Condition.visible,5000);
     $(lensFinishingDropDown).selectOption(option);
    }

    public void selectionVisionType(String option){
        $(visionTypeDropDown).waitUntil(Condition.visible,5000);
        $(visionTypeDropDown).selectOption(option);
    }

    public void selectMaterial(String option){
        $(materialDropDown).waitUntil(Condition.visible,5000);
        $(materialDropDown).selectOption(option);
    }

    public void selectLens(String option){
        $(lensDropDown).selectOption(option);
    }
//    public boolean lensStyleExistInDropDown(String style){
//        return $(lensDropDown).getSelectedOption(style);
//    }
//
//    public boolean lensStyleContainsValue(String val){
//
//    }

    public void setDateOfServiceInput(String date){
        $(dateOfServiceInput).waitUntil(Condition.visible,5000);
        $(dateOfServiceInput).setValue(date);
        sleep(1000);
    }

    public void setRSphereInput(String rsphere){
        $(rSphereInput).waitUntil(Condition.visible,5000);
        $(rSphereInput).setValue(rsphere);
    }

    public void setLSphereInput(String lsphere){
        $(lSphereInput).scrollTo();
        $(lSphereInput).setValue(lsphere);
    }

    public void setRDistant(String dist){
        $(rightDistance).waitUntil(Condition.visible,5000);
        $(rightDistance).setValue(dist);
    }

    public void selectLab(){
        $(By.name("Lab")).scrollTo();
        $(showLabsButton).click();
        $(By.id("labList_cbxo_1")).click();
        //$(selectLabDropDown).selectOption(1);
    }

    public void clickReportsButton(){
        $(reportsButton).click();
    }


}
