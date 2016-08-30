package com.vsp.testfw;

import org.apache.logging.log4j.core.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads configuration property file for run time settings.
 * Created by carlki on 8/16/2016.
 */
public class RuntimeConfig {

    private static final ThreadLocal<Configuration> config = new InheritableThreadLocal();
    private static final Logger log = LoggerFactory.getLogger(RuntimeConfig.class);

    private RuntimeConfig() {}

    public static Configuration getConfig() {
        return config.get();
    }

    public static void setConfig(final Configuration c) {
        config.set(c);
    }

//    public static boolean useAuthPool(){
//        return RuntimeConfig.getConfig().getBoolean("use.auth.pool", false);
//    }
//    public static boolean useLoginPool() {
//        return RuntimeConfig.getConfig().getBoolean("use.login.pool", false);
//    }
//
//    public static boolean getUseHub() {
//        return getConfig().getBoolean("use.hub", false);
//    }
//
//    public static String getHubURL() {
//        return getConfig().getString("hub.url", "");
//    }

}
