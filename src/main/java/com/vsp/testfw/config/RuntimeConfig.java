package com.vsp.testfw.config;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by carlki on 10/23/2016.
 */
public class RuntimeConfig {

        private static final ThreadLocal<Configuration> config = new InheritableThreadLocal<>();
        private static final Logger log = LoggerFactory.getLogger(RuntimeConfig.class);
        private static  PropertiesConfiguration defaultProps;

        private RuntimeConfig() {}

        public static Configuration getConfig() {
            if (config.get() == null) {

                    setDefaultConfig();
                }
            return config.get();
        }

        public static void setConfig(final Configuration c) {
            config.set(c);
        }

        public static void setDefaultConfig() {
            try {
                defaultProps = new PropertiesConfiguration("default.properties");

            } catch(ConfigurationException ce) {
                log.error("Unable to load properties for test!");
                throw new AssertionError(ce.getMessage());
            }
            config.set(defaultProps);
        }

        public static String getPrefByName(String prefName) {
            String returnVal = getConfig().getString(prefName, "");
            if (returnVal.isEmpty()) {
                log.error("Pref value requested not found: {}", prefName);
            }

            return returnVal;
        }

        public static void setPrefByName(String prefName, String prefValue) {
            getConfig().setProperty(prefName, prefValue);
        }


        public static boolean getUseHub() {
            return getConfig().getBoolean("use_hub", false);
        }

        public static String getHubURL() {
            return getConfig().getString("hub_url", "");
        }

        public static String getStartingPage() {
           return getConfig().getString("mix_host");
        }

        public static String getDoctorHost() {
            return getConfig().getString("dr_host");
        }

}
