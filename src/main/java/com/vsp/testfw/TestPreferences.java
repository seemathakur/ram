package com.vsp.testfw;

import java.util.prefs.Preferences;

/**
 * Created by carlki on 8/15/2016.
 */
public class TestPreferences {
    private Preferences prefs;

    public void setPrefs(){
        prefs = Preferences.userRoot().node(this.getClass().getName());
    }


}
