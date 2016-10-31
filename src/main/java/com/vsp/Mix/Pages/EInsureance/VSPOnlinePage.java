package com.vsp.Mix.Pages.EInsureance;

import static com.vsp.testfw.WebHelper.*;
import com.vsp.Mix.Pages.EInsureance.Administration.PracticeUpdatesPage;

/**
 * Created by carlki on 8/2/2016.
 */
public class VSPOnlinePage {

    private static final String relativeURL = "/vspdctr/html/vspOnline.htm";

    public PracticeUpdatesPage admin_PracticeUpdates(){
        // need a direct nav here as the javascript leftnav menu is a hot mess
        //TODO do need to make this relative instead of hard coded to one server
        open("https://doctor-a7.vsp.com/pr/html/updateinfo.htm");
        return page(PracticeUpdatesPage.class);
    }
}
