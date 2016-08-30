package com.vsp.Mix.Pages;

import com.vsp.Mix.Pages.EInsureance.VSPOnlinePage;
import org.openqa.selenium.By;
import static com.vsp.testfw.WebHelper.*;

/**
 * Created by carlki on 8/2/2016.
 */

public class EyeFinityHomePage {

    private static final String relativeURL = "/home/";

    public VSPOnlinePage navigateToVSPOnline(){
        $(By.linkText("VSPOnline")).click();
        return page(VSPOnlinePage.class);
    }
}
