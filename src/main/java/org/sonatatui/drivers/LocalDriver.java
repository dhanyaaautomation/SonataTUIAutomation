package org.sonatatui.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sonatatui.utils.Log;
import org.sonatatui.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriver implements IDriver  {

    private static final Logger logger = Log.getLogger(LocalDriver.class);

    public WebDriver getDriver() throws MalformedURLException {

        String device = PropertyUtils.getValue("local.device");
        String appPackage = PropertyUtils.getValue("local.app.package");
        String appActivity = PropertyUtils.getValue("local.app.activity");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName(device);
        //options.setApp(FrameworkConstants.getApkFilePath());
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);

        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        logger.info("Local Android Driver initialized successfully");
        return driver;

    }

}
