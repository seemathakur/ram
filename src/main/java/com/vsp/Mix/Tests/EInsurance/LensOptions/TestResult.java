package com.vsp.Mix.Tests.EInsurance.LensOptions;

/**
 * Created by carlki on 8/16/2016.
 */
public class TestResult {

    private boolean result;
    private String reason;

    public TestResult(boolean result, String reason) {
        this.result = result;
        this.reason = reason;
    }

    public boolean didPass() {
        return result;
    }

    public String getReason() {
        return reason;
    }

}
