package com.vsp.Mix.Pages.EInsureance.Administration;

/**
 * Created by carlki on 8/10/2016.
 */
public class ProviderProfile {

    private boolean profileActive;

    private String doctorName;

    private String practicingSince;

    private String schoolName1;

    private String schoolName2;

    private String schoolName3;

    private String schoolName4;

    private String schoolName5;

    private String degreeType1;

    private String degreeType2;

    private String degreeType3;

    private String degreeType4;

    private String degreeType5;

    private String city1;

    private String city2;

    private String city3;

    private String city4;

    private String city5;

    private String selectedState1;

    private String selectedState2;

    private String selectedState3;

    private String selectedState4;

    private String selectedState5;

    private boolean seesChildren03;

    private boolean seesChildren35;

    private boolean hardToFitContactLenses;

    private boolean lowVision;

    private boolean visionTherapy;

    private String professionalStatement;

    private boolean includePhoto;

    private String pathToPhoto;

    private String genderString;

    private boolean includeGenderInProfile;

    private boolean includeCertificationsInProfile;

    private String certification1;

    private String certification2;

    private String certification3;

    private String certification4;

    private String certification5;

    private boolean ama_PinkEye;

    private boolean ama_Glaucoma;

    private boolean ama_Cunjunctivitis;

    private boolean ama_Astigmatism;

    private boolean ama_Cataracts;

    private boolean ama_MacularDegeneration;

    private boolean ama_ColorBlindTest;

    private String language1;
    private String language2;

    public ProviderProfile(){

        this.profileActive = false;
        this.doctorName = "";
        this.practicingSince = "";

        this.schoolName1 = "";
        this.schoolName2 = "";
        this.schoolName3 = "";
        this.schoolName4 = "";
        this.schoolName5 = "";

        this.degreeType1 = "select";
        this.degreeType2 = "select";
        this.degreeType3 = "select";
        this.degreeType4 = "select";
        this.degreeType5 = "select";

        this.city1 = "";
        this.city2 = "";
        this.city3 = "";
        this.city4 = "";
        this.city5 = "";

        this.selectedState1 = "";
        this.selectedState2 = "";
        this.selectedState3 = "";
        this.selectedState4 = "";
        this.selectedState5 = "";

        this.seesChildren03 = false;
        this.seesChildren35 = false;
        this.hardToFitContactLenses = false;
        this.lowVision = false;
        this.visionTherapy = false;

        this.professionalStatement = "";

        this.includePhoto = false;
        this.pathToPhoto = "";

        this.genderString = "";
        this.includeGenderInProfile = false;

        this.includeCertificationsInProfile = false;
        this.certification1 = "";
        this.certification2 = "";
        this.certification3 = "";
        this.certification4 = "";
        this.certification5 = "";

        this.ama_PinkEye = false;
        this.ama_Glaucoma = false;
        this.ama_Cunjunctivitis = false;
        this.ama_Astigmatism = false;
        this.ama_Cataracts = false;
        this.ama_MacularDegeneration = false;
        this.ama_ColorBlindTest = false;

        this.language1 = "";
        this.language2 = "";

    }

    public ProviderProfile(boolean _profileActive, String _doctorName,String _practicingSince,
                           String _schoolName1, String _schoolName2,String _schoolName3, String _schoolName4, String _schoolName5,
                           String _degree1, String _degree2, String _degree3, String _degree4, String _degree5,
                           String _city1, String _city2, String _city3, String _city4, String _city5,
                           String _state1, String _state2, String _state3, String _state4, String _state5,
                           boolean _seeChildren03, boolean seeChildren35, boolean _hardToFitContactLenses, boolean _lowVision, boolean _visionTherapy,
                           String _gender, boolean _includeGenderInProfile, boolean _includeCertificationsInProfile,
                           String _cert1,String _cert2,String _cert3,String _cert4,String _cert5,
                           boolean _amaPinkEye, boolean _amaGlaucoma, boolean _amaCunjunctivitis, boolean _amaAstigmatism, boolean _amaCataracts,
                           boolean _amaMacularDegeneration, boolean _amaColorBlindTest,
                           boolean _includePhoto, String _pathToPhoto,String _profStatement,
                           String _language1, String _language2)
    {

        this.profileActive = false;
        this.doctorName = _doctorName;
        this.practicingSince = "";

        this.schoolName1 = _schoolName1;
        this.schoolName2 = _schoolName2;
        this.schoolName3 = _schoolName3;
        this.schoolName4 = _schoolName4;
        this.schoolName5 = _schoolName5;

        this.degreeType1 = _degree1;
        this.degreeType2 = _degree2;
        this.degreeType3 = _degree3;
        this.degreeType4 = _degree4;
        this.degreeType5 = _degree5;

        this.city1 = _city1;
        this.city2 = _city2;
        this.city3 = _city3;
        this.city4 = _city4;
        this.city5 = _city5;

        this.selectedState1 = _state1;
        this.selectedState2 = _state2;
        this.selectedState3 = _state3;
        this.selectedState4 = _state4;
        this.selectedState5 = _state5;

        this.seesChildren03 = _seeChildren03;
        this.seesChildren35 = seeChildren35;
        this.hardToFitContactLenses = _hardToFitContactLenses;
        this.lowVision = _lowVision;
        this.visionTherapy = _visionTherapy;

        this.professionalStatement = _profStatement;

        this.includePhoto = _includePhoto;
        this.pathToPhoto = _pathToPhoto;

        this.genderString = _gender;
        this.includeGenderInProfile = _includeGenderInProfile;

        this.includeCertificationsInProfile = _includeCertificationsInProfile;
        this.certification1 = _cert1;
        this.certification2 = _cert2;
        this.certification3 = _cert3;
        this.certification4 = _cert4;
        this.certification5 = _cert5;

        this.ama_PinkEye = _amaPinkEye;
        this.ama_Glaucoma = _amaGlaucoma;
        this.ama_Cunjunctivitis = _amaCunjunctivitis;
        this.ama_Astigmatism = _amaAstigmatism;
        this.ama_Cataracts = _amaCataracts;
        this.ama_MacularDegeneration = _amaMacularDegeneration;
        this.ama_ColorBlindTest = _amaColorBlindTest;
        this.language1 = _language1;
        this.language2 = _language2;

    }

    public boolean isProfileActive() {
        return profileActive;
    }

    public void setProfileActive(boolean profileActive) {
        this.profileActive = profileActive;
    }

    public void setDoctorName(String _name){
        this.doctorName = _name;
    }

    public String getDoctorName(){
        return doctorName;
    }

    public String getPracticingSince() {
        return practicingSince;
    }

    public void setPracticingSince(String practicingSince) {
        this.practicingSince = practicingSince;
    }

    public String getSchoolName1() {
        return schoolName1;
    }

    public void setSchoolName1(String schoolName1) {
        this.schoolName1 = schoolName1;
    }

    public String getSchoolName2() {
        return schoolName2;
    }

    public void setSchoolName2(String schoolName2) {
        this.schoolName2 = schoolName2;
    }

    public String getSchoolName3() {
        return schoolName3;
    }

    public void setSchoolName3(String schoolName3) {
        this.schoolName3 = schoolName3;
    }

    public String getSchoolName4() {
        return schoolName4;
    }

    public void setSchoolName4(String schoolName4) {
        this.schoolName4 = schoolName4;
    }

    public String getSchoolName5() {
        return schoolName5;
    }

    public void setSchoolName5(String schoolName5) {
        this.schoolName5 = schoolName5;
    }

    public String getDegreeType1() {
        return degreeType1;
    }

    public void setDegreeType1(String degreeType1) {
        this.degreeType1 = degreeType1;
    }

    public String getDegreeType2() {
        return degreeType2;
    }

    public void setDegreeType2(String degreeType2) {
        this.degreeType2 = degreeType2;
    }

    public String getDegreeType3() {
        return degreeType3;
    }

    public void setDegreeType3(String degreeType3) {
        this.degreeType3 = degreeType3;
    }

    public String getDegreeType4() {
        return degreeType4;
    }

    public void setDegreeType4(String degreeType4) {
        this.degreeType4 = degreeType4;
    }

    public String getDegreeType5() {
        return degreeType5;
    }

    public void setDegreeType5(String degreeType5) {
        this.degreeType5 = degreeType5;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getCity3() {
        return city3;
    }

    public void setCity3(String city3) {
        this.city3 = city3;
    }

    public String getCity4() {
        return city4;
    }

    public void setCity4(String city4) {
        this.city4 = city4;
    }

    public String getCity5() {
        return city5;
    }

    public void setCity5(String city5) {
        this.city5 = city5;
    }

    public String getSelectedState1() {
        return selectedState1;
    }

    public void setSelectedState1(String selectedState1) {
        this.selectedState1 = selectedState1;
    }

    public String getSelectedState2() {
        return selectedState2;
    }

    public void setSelectedState2(String selectedState2) {
        this.selectedState2 = selectedState2;
    }

    public String getSelectedState3() {
        return selectedState3;
    }

    public void setSelectedState3(String selectedState3) {
        this.selectedState3 = selectedState3;
    }

    public String getSelectedState4() {
        return selectedState4;
    }

    public void setSelectedState4(String selectedState4) {
        this.selectedState4 = selectedState4;
    }

    public String getSelectedState5() {
        return selectedState5;
    }

    public void setSelectedState5(String selectedState5) {
        this.selectedState5 = selectedState5;
    }

    public boolean isSeesChildren03() {
        return seesChildren03;
    }

    public void setSeesChildren03(boolean seesChildren03) {
        this.seesChildren03 = seesChildren03;
    }

    public boolean isSeesChildren35() {
        return seesChildren35;
    }

    public void setSeesChildren35(boolean seesChildren35) {
        this.seesChildren35 = seesChildren35;
    }

    public boolean isHardToFitContactLenses() {
        return hardToFitContactLenses;
    }

    public void setHardToFitContactLenses(boolean hardToFitContactLenses) {
        this.hardToFitContactLenses = hardToFitContactLenses;
    }

    public boolean isLowVision() {
        return lowVision;
    }

    public void setLowVision(boolean lowVision) {
        this.lowVision = lowVision;
    }

    public boolean isVisionTherapy() {
        return visionTherapy;
    }

    public void setVisionTherapy(boolean visionTherapy) {
        this.visionTherapy = visionTherapy;
    }

    public String getProfessionalStatement() {
        return professionalStatement;
    }

    public void setProfessionalStatement(String professionalStatement) {
        this.professionalStatement = professionalStatement;
    }

    public boolean isIncludePhoto() {
        return includePhoto;
    }

    public void setIncludePhoto(boolean includePhoto) {
        this.includePhoto = includePhoto;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    public String getGenderString() {
        return genderString;
    }

    public void setGenderString(String genderString) {
        this.genderString = genderString;
    }

    public boolean isIncludeGenderInProfile() {
        return includeGenderInProfile;
    }

    public void setIncludeGenderInProfile(boolean includeGenderInProfile) {
        this.includeGenderInProfile = includeGenderInProfile;
    }

    public boolean isIncludeCertificationsInProfile() {
        return includeCertificationsInProfile;
    }

    public void setIncludeCertificationsInProfile(boolean includeCertificationsInProfile) {
        this.includeCertificationsInProfile = includeCertificationsInProfile;
    }

    public String getCertification1() {
        return certification1;
    }

    public void setCertification1(String certification1) {
        this.certification1 = certification1;
    }

    public String getCertification2() {
        return certification2;
    }

    public void setCertification2(String certification2) {
        this.certification2 = certification2;
    }

    public String getCertification3() {
        return certification3;
    }

    public void setCertification3(String certification3) {
        this.certification3 = certification3;
    }

    public String getCertification4() {
        return certification4;
    }

    public void setCertification4(String certification4) {
        this.certification4 = certification4;
    }

    public String getCertification5() {
        return certification5;
    }

    public void setCertification5(String certification5) {
        this.certification5 = certification5;
    }

    public boolean isAma_PinkEye() {
        return ama_PinkEye;
    }

    public void setAma_PinkEye(boolean ama_PinkEye) {
        this.ama_PinkEye = ama_PinkEye;
    }

    public boolean isAma_Glaucoma() {
        return ama_Glaucoma;
    }

    public void setAma_Glaucoma(boolean ama_Glaucoma) {
        this.ama_Glaucoma = ama_Glaucoma;
    }

    public boolean isAma_Cunjunctivitis() {
        return ama_Cunjunctivitis;
    }

    public void setAma_Cunjunctivitis(boolean ama_Cunjunctivitis) {
        this.ama_Cunjunctivitis = ama_Cunjunctivitis;
    }

    public boolean isAma_Astigmatism() {
        return ama_Astigmatism;
    }

    public void setAma_Astigmatism(boolean ama_Astigmatism) {
        this.ama_Astigmatism = ama_Astigmatism;
    }

    public boolean isAma_Cataracts() {
        return ama_Cataracts;
    }

    public void setAma_Cataracts(boolean ama_Cataracts) {
        this.ama_Cataracts = ama_Cataracts;
    }

    public boolean isAma_MacularDegeneration() {
        return ama_MacularDegeneration;
    }

    public void setAma_MacularDegeneration(boolean ama_MacularDegeneration) {
        this.ama_MacularDegeneration = ama_MacularDegeneration;
    }

    public boolean isAma_ColorBlindTest() {
        return ama_ColorBlindTest;
    }

    public void setAma_ColorBlindTest(boolean ama_ColorBlindTest) {
        this.ama_ColorBlindTest = ama_ColorBlindTest;
    }

    public void setLanguage1(String _lang){
        this.language1 = _lang;
    }

    public void setLanguage2(String _lang){
        this.language2 = _lang;
    }

    public String getLanguage1(){
        return language1;
    }
    public String getLanguage2(){
        return language2;
    }

}
