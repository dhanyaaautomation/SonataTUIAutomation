package org.sonatatui.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sonatatui.utils.Log;
import org.sonatatui.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackDriver implements IDriver {

    private static final Logger logger = Log.getLogger(BrowserStackDriver.class);

    public WebDriver getDriver() throws MalformedURLException {

        String user = PropertyUtils.getValue("browserstack.user");
        String accessKey = PropertyUtils.getValue("browserstack.key");

        String device = PropertyUtils.getValue("browserstack.device");
        String osVersion = PropertyUtils.getValue("browserstack.os.version");
        String app = PropertyUtils.getValue("browserstack.app");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", user);
        bstackOptions.put("accessKey", accessKey);
        bstackOptions.put("deviceName", device);
        bstackOptions.put("osVersion", osVersion);

        options.setCapability("bstack:options", bstackOptions);
        options.setApp(app);

        WebDriver driver = new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"),
                options);
        logger.info("BrowserStack Driver initialized successfully");
        return driver;
    }
}
