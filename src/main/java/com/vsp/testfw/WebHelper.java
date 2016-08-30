package com.vsp.testfw;

import com.codeborne.selenide.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import java.util.Set;


/**
 * iDr Team specific selenium helper methods.  This gives direct access to webdriver/selenium.
 * <p></p>
 * To use:  {@code import static com.vsp.testfw.WebHelper}
 *
 * Created by carlki on 8/2/2016.
 */

public class WebHelper extends Selenide {
        private static Log log = LogFactory.getLog(WebHelper.class);
        /**
         * Get the current WebDriver instance
         *
         * @return WebDriver
         */
        public static WebDriver getWebDriver() {
            return WebDriverRunner.getWebDriver();
        }

        /**
         * Sets a checkbox on or off
         *
         * @param e the location of the checkbox
         * @param selected true to set on, false to set off
         * @return true if the checkbox state was modified (was off, now on or was on, now off), false if not
         */

        public static boolean setCheckboxState(SelenideElement e, boolean selected) {
            boolean isChecked = $(e).isSelected();
            if (isChecked && !selected || !isChecked && selected ) {
                $(e).setSelected(selected);
                return true;
            }
            return false;
        }

        /**
         * Switch to a window by its Title
         *
         * @param title of the window you want to switch to.
         */

        public static void switchToWindowUsingTitle(String title) {
            Set<String> availableWindows = getWebDriver().getWindowHandles();
            if (!availableWindows.isEmpty()) {
                for (String windowId : availableWindows) {
                    if (getWebDriver().switchTo().window(windowId).getTitle().equals(title)) {
                        return;
                    }
                }
            }
            log.error("Unable to switch to a window of title: " + title );
        }

        /**
         * Close the currently active window.
         */
        public static void closeWindow() {
            getWebDriver().close();
        }

        /**
         * Switch to a window by its handle
         *
         * @param handle of the window you want to switch to.
         */
        public static void switchToWindowUsingHandle(String handle) {
            switchTo().window(handle);
        }
        /**
         * Get the current window handle.
         */
        public static String getCurrentWindowHandle() {
            return getWebDriver().getWindowHandle();
        }

        /**
         * Switch to a frame by its name
         *
         * @param name of the frame you want to switch to.
         */
        public static void switchToFrameUsingName(String name) {
            switchTo().frame(name);
        }

}
