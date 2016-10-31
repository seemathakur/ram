package com.vsp.Mix.Pages.EInsureance.Administration;

import com.codeborne.selenide.Condition;
import com.vsp.testfw.config.RuntimeConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/4/2016.
 */
public class DrProfilePage {

    private static String URL = "/pr/html/updateinfo.htm#tab2";

    private static final By doctorTitleField = By.id("doctorDegreeCode");
    private static final By doctorHighlights = By.id("highlights");
    private static final By doctorNetworks = By.id("doctorNetworks");

    private static final By previewProfile_Top_Button = By.id("previewProfile");
    private static final By previewProfile_Bottom_Button = By.id("previewProfile");

    private static final By publishProfile_Top_Button = By.id("publishBtnTop");
    private static final By publishProfile_Bottom_Button = By.id("publishBtnBottom");
    private static final By profileActive_CheckBox = By.id("doctorOptedOutProfile");
    private static final By changeName_Button = By.id("doctorNameList");
    private static final By practicingSince_Input = By.id("practicingSince");

    private static final By schoolName1_Input = By.id("school1");
    private static final By schoolName2_Input = By.id("school2");
    private static final By schoolName3_Input = By.id("school3");
    private static final By schoolName4_Input = By.id("school4");
    private static final By schoolName5_Input = By.id("school5");

    private static final By school1_Degree_Dropdown = By.id("degree1");
    private static final By school2_Degree_Dropdown = By.id("degree2");
    private static final By school3_Degree_Dropdown = By.id("degree3");
    private static final By school4_Degree_Dropdown = By.id("degree4");
    private static final By school5_Degree_Dropdown = By.id("degree5");

    private static final By school1_City_Input = By.id("city1");
    private static final By school2_City_Input = By.id("city2");
    private static final By school3_City_Input = By.id("city3");
    private static final By school4_City_Input = By.id("city4");
    private static final By school5_City_Input = By.id("city5");

    private static final By school1_State_Dropdown = By.id("state1");
    private static final By school2_State_Dropdown = By.id("state2");
    private static final By school3_State_Dropdown = By.id("state3");
    private static final By school4_State_Dropdown = By.id("state4");
    private static final By school5_State_Dropdown = By.id("state5");

    private static final By children03_Checkbox = By.id("prodAndSrvcsChildren0to3");
    private static final By children35_Checkbox = By.id("prodAndSrvcsChildren3to5");
    private static final By hardToFitContactLenses_Checkbox = By.id("prodAndSrvcsHardToFitContactLenses");
    private static final By lowVision_Checkbox = By.id("prodAndSrvcsLowVision");
    private static final By visionTherapy_Checkbox = By.id("prodAndSrvcsVisionTherapy");

    private static final By professionalStatement_Input = By.id("profStatement");

    private static final By includePhoto_Checkbox = By.id("photoInlcude");
    private static final By changePhoto_Button = By.xpath("//table/tbody/tr/td[3]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div[2]/div[2]/form/section[7]/div[2]/a");
    private static final By browsePhoto_Button = By.id("imgInp");
    private static final By includeGender_Checkbox = By.id("genderInclude");
    private static final By gender_dropdown = By.id("gender");

    private static final By includeCertifications_Checkbox = By.id("certInclude");
    private static final By certification1_Input = By.id("certification1");
    private static final By certification2_Input = By.id("certification2");
    private static final By certification3_Input = By.id("certification3");
    private static final By certification4_Input = By.id("certification4");
    private static final By certification5_Input = By.id("certification5");

    private static final By ama_PinkEye_Checkbox = By.id("askPinkEyes");
    private static final By ama_Glaucoma_Checkbox = By.id("askGlaucoma");
    private static final By ama_Cunjunctivitis_Checkbox = By.id("askCunjunctivitis");
    private static final By ama_Astigmatism_Checkbox = By.id("askAstigmatism");
    private static final By ama_Cataracts_Checkbox = By.id("askCataracts");
    private static final By ama_MacularDegeneration_Checkbox = By.id("askMacularDegeneration");
    private static final By ama_ColorBlindTest_Checkbox = By.id("askColorBlindTest");

    private static final By available_languagesSelectBox = By.id("availableLanguages");
    private static final By known_languagesSelectBox = By.id("selectedLanguages");
    private static final By selectLanguageButton = By.id("leftSelect");
    private static final By removeLanguageButton = By.id("rightSelect");

    public void navigateTo() {
         String destination = RuntimeConfig.getDoctorHost() + "/pr/html/updateinfo.htm#tab2";
        //TODO need this to be a relative URL not absolute so it can run on different environments
        open(destination);
        sleep(3000);
    }

    public String getDoctorTitle(){
        return $(doctorTitleField).getText();
    }

    public boolean doctorHighlightsContainsAll(List<String> highlights){
        List<WebElement> list2 = $(doctorHighlights).findElementsByTagName("li");
        List<String> actualHighlights = new ArrayList<String>();
        for(WebElement e : list2 ){
            actualHighlights.add($(e).getText());
        }
        return highlights.containsAll(actualHighlights);
    }

    public boolean doctorNetworksContainsAll(List<String> highlights){
        List<WebElement> list2 = $(doctorNetworks).findElementsByTagName("li");
        List<String> actualHighlights = new ArrayList<String>();
        for(WebElement e : list2 ){
            actualHighlights.add($(e).getText());
        }
        return highlights.containsAll(actualHighlights);
    }

    public void setProviderProfileStatus(boolean onOrOff){
        $(profileActive_CheckBox).setSelected(onOrOff);
    }

    public boolean getProviderProfileStatus(){
        return $(profileActive_CheckBox).isSelected();
    }

    public boolean isProviderProfileStatus(){
        return $(profileActive_CheckBox).isSelected();
    }

    public void setPracticingSince(String since){
        $(practicingSince_Input).setValue(since);
    }

    public String getPracticingSince(){
        return $(practicingSince_Input).getValue();
    }

    public void clickPreviewProfileButton() {
        $(previewProfile_Top_Button).shouldBe(Condition.visible).click();
    }

    public void clickPublishProfileButton() {
        $(publishProfile_Top_Button).shouldBe(Condition.visible).click();
        sleep(3000);
        confirm();
    }

    public void clickChangeNameButton() {
        $(changeName_Button).click();
    }

    public void setSchoolName1(String schoolname) {
        $(schoolName1_Input).setValue(schoolname);
    }

    public void setSchoolName2(String schoolname) {
        $(schoolName2_Input).setValue(schoolname);
    }

    public void setSchoolName3(String schoolname) {
        $(schoolName3_Input).setValue(schoolname);
    }

    public void setSchoolName4(String schoolname) {
        $(schoolName4_Input).setValue(schoolname);
    }

    public void setSchoolName5(String schoolname) {
        $(schoolName5_Input).setValue(schoolname);
    }

    public String getSchoolName1() {
        return $(schoolName1_Input).getValue();
    }

    public String getSchoolName2() {
        return $(schoolName2_Input).getValue();
    }
    public String getSchoolName3() {
        return $(schoolName3_Input).getValue();
    }
    public String getSchoolName4() {
        return $(schoolName4_Input).getValue();
    }
    public String getSchoolName5() {
        return $(schoolName5_Input).getValue();
    }

    public void setCity1(String cityName) {
        $(school1_City_Input).setValue(cityName);
    }

    public void setCity2(String cityName) {
        $(school2_City_Input).setValue(cityName);
    }

    public void setCity3(String cityName) {
        $(school3_City_Input).setValue(cityName);
    }

    public void setCity4(String cityName) {
        $(school4_City_Input).setValue(cityName);
    }

    public void setCity5(String cityName) {
        $(school5_City_Input).setValue(cityName);
    }

    public void setState(int schoolNum, String state){
        switch (schoolNum) {
            case 1:
                $(school1_State_Dropdown).selectOption(state);
                break;
            case 2:
                $(school2_State_Dropdown).selectOption(state);
                break;
            case 3:
                $(school3_State_Dropdown).selectOption(state);
                break;
            case 4:
                $(school4_State_Dropdown).selectOption(state);
                break;
            case 5:
                $(school5_State_Dropdown).selectOption(state);
                break;
        }
    }

    public String getState1(){
        return $(school1_State_Dropdown).getSelectedValue();
    }

    public String getState2(){
        return $(school2_State_Dropdown).getSelectedValue();
    }
    public String getState3(){
        return $(school3_State_Dropdown).getSelectedValue();
    }
    public String getState4(){
        return $(school4_State_Dropdown).getSelectedValue();
    }
    public String getState5(){
        return $(school5_State_Dropdown).getSelectedValue();
    }
    public void setDegree1(String deg){
        $(school1_Degree_Dropdown).selectOption(deg);
    }

    public void setDegree2(String deg){
        $(school2_Degree_Dropdown).selectOption(deg);
    }

    public void setDegree3(String deg){
        $(school3_Degree_Dropdown).selectOption(deg);
    }

    public void setDegree4(String deg){
        $(school4_Degree_Dropdown).selectOption(deg);
    }

    public void setDegree5(String deg){
        $(school5_Degree_Dropdown).selectOption(deg);
    }

    public String getDegree1() {
        return $(school1_Degree_Dropdown).getSelectedValue();
    }
    public String getDegree2() {
        return $(school2_Degree_Dropdown).getSelectedValue();
    }
    public String getDegree3() {
        return $(school3_Degree_Dropdown).getSelectedValue();
    }
    public String getDegree4() {
        return $(school4_Degree_Dropdown).getSelectedValue();
    }
    public String getDegree5() {
        return $(school5_Degree_Dropdown).getSelectedValue();
    }

    public String getCityName1() {
        return $(school1_City_Input).getValue();
    }

    public String getCityName2() {
        return $(school2_City_Input).getValue();
    }
    public String getCityName3() {
        return $(school3_City_Input).getValue();
    }
    public String getCityName4() {
        return $(school4_City_Input).getValue();
    }
    public String getCityName5() {
        return $(school5_City_Input).getValue();
    }


    public void setChildren03Checkbox(boolean enabled) {
        $(children03_Checkbox).setSelected(enabled);
    }

    public boolean getChildren03Checkbox() {
        return $(children03_Checkbox).isSelected();
    }

    public void setChildren35Checkbox(boolean enabled) {
        $(children35_Checkbox).setSelected(enabled);
    }

    public boolean getChildren35Checkbox() {
        return $(children35_Checkbox).isSelected();
    }

    public void setHardToFitContactLensesCheckbox(boolean enabled) {
        $(hardToFitContactLenses_Checkbox).setSelected(enabled);
    }

    public boolean getHardToFitContactLensesCheckbox() {
        return $(hardToFitContactLenses_Checkbox).isSelected();
    }

    public void setLowVisionCheckbox(boolean enabled) {
        $(lowVision_Checkbox).setSelected(enabled);
    }

    public boolean getLowVisionCheckbox() {
        return $(lowVision_Checkbox).isSelected();
    }

    public void setVisionTherapyChecbox(boolean enabled) {
        $(visionTherapy_Checkbox).setSelected(enabled);
    }

    public boolean getVisionTherapyCheckbox() {
        return $(visionTherapy_Checkbox).isSelected();
    }

    public void setProfessionalStatement(String statement) {
        $(professionalStatement_Input).setValue(statement);
    }

    public String getProfessionalStatement() {
        return $(professionalStatement_Input).getValue();
    }

    public void setIncludePhotoCheckbox(boolean enabled) {
        $(includePhoto_Checkbox).setSelected(enabled);
    }

    public boolean getIncludePhotoCheckbox() {
        return $(includePhoto_Checkbox).isSelected();
    }

    public void clickChangePhotoButton() {
        $(changePhoto_Button).click();
    }

    public void clickBrowsePhotoButton() {
        $(browsePhoto_Button).click();
    }

    public void setIncludeGenderCheckbox(boolean enabled) {
        $(includeGender_Checkbox).scrollTo().setSelected(enabled);
    }

    public boolean getIncludeGenderCheckbox() {
        return $(includeGender_Checkbox).isSelected();
    }

    public void setGender(String _gender){
        $(gender_dropdown).selectOptionByValue(_gender);
    }

    public String getGender(){
        //TODO not sure this will return the text value I'm looking for ... check what happens during test
        //return $(gender_dropdown).getSelectedOption().toString();
        return $(gender_dropdown).getSelectedValue();
    }

    public void setIncludeCertificationsCheckbox(boolean enabled) {
        $(includeCertifications_Checkbox).setSelected(enabled);
    }

    public boolean getIncludeCertificationsCheckbox() {
        return $(includeCertifications_Checkbox).isSelected();
    }

    public void setCertification1(String certification) {
        $(certification1_Input).setValue(certification);
    }

    public void setCertification2(String certification) {
        $(certification2_Input).setValue(certification);
    }

    public void setCertification3(String certification) {
        $(certification3_Input).setValue(certification);
    }

    public void setCertification4(String certification) {
        $(certification4_Input).setValue(certification);
    }

    public void setCertification5(String certification) {
        $(certification5_Input).setValue(certification);
    }

    public String getCertification1() {
        return $(certification1_Input).getValue();
    }
    public String getCertification2() {
        return $(certification2_Input).getValue();
    }
    public String getCertification3() {
        return $(certification3_Input).getValue();
    }
    public String getCertification4() {
        return $(certification4_Input).getValue();
    }
    public String getCertification5() {
        return $(certification5_Input).getValue();
    }

    public void clickKnownLanguage(String language){
        $(known_languagesSelectBox).selectOptionByValue(language);
    }

    public void clickAvailableLanguage(String language){
        $(available_languagesSelectBox).selectOptionByValue(language);
    }

    public void addSelectedLanguage(){
        $(selectLanguageButton).click();
    }

    public void removeSelectedLanguage(){
        $(removeLanguageButton).click();
    }

    public void setPinkEyeCheckbox(boolean enabled) {
        $(ama_PinkEye_Checkbox).setSelected(enabled);
    }

    public boolean getPinkEyeCheckbox() {
        return $(ama_PinkEye_Checkbox).isSelected();
    }

    public void setGlaucomaCheckbox(boolean enabled) {
        $(ama_Glaucoma_Checkbox).setSelected(enabled);
    }

    public boolean getGlaucomaCheckbox() {
        return $(ama_Glaucoma_Checkbox).isSelected();
    }

    public void setCunjunctivitisCheckbox(boolean enabled) {
        $(ama_Cunjunctivitis_Checkbox).setSelected(enabled);
    }

    public boolean getCunjunctivitisCheckbox() {
        return $(ama_Cunjunctivitis_Checkbox).isSelected();
    }

    public void setAstigmatismCheckbox(boolean enabled) {
        $(ama_Astigmatism_Checkbox).setSelected(enabled);
    }

    public boolean getAstigmatismCheckbox() {
        return $(ama_Astigmatism_Checkbox).isSelected();
    }

    public void setCataractsCheckbox(boolean enabled) {
        $(ama_Cataracts_Checkbox).setSelected(enabled);
    }

    public boolean getCataractsCheckbox() {
        return $(ama_Cataracts_Checkbox).isSelected();
    }

    public void setMacularDegenerationCheckbox(boolean enabled) {
        $(ama_MacularDegeneration_Checkbox).setSelected(enabled);
    }

    public boolean getMacularDegenerationCheckbox() {
        return $(ama_MacularDegeneration_Checkbox).isSelected();
    }

    public void setColorBlindTestCheckbox(boolean enabled) {
        $(ama_ColorBlindTest_Checkbox).setSelected(enabled);
    }

    public boolean getColorBlindTestCheckbox() {
        return $(ama_ColorBlindTest_Checkbox).isSelected();
    }

}
