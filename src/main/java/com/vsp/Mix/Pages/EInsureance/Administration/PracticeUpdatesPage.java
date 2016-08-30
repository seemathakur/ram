package com.vsp.Mix.Pages.EInsureance.Administration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by carlki on 8/2/2016.
 */
public class PracticeUpdatesPage {

    private static final String relativeURL = "/pr/html/updateinfo.htm#tab2";

    public void monitorProfile(){
        //TODO do need to make this relative instead of hard coded to one server
        open("https://doctor-a1.vsp.com/pr/html/updateinfo.htm#tab2");
    }
}
