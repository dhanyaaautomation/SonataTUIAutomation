package org.sonatatui.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackDriver implements IDriver {

    public WebDriver getDriver() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", "dhanyaa_3sNY5K");
        bstackOptions.put("accessKey", "sU6R2EAuVxyrGRzkzTJz");
        bstackOptions.put("deviceName", "Samsung Galaxy S22 Ultra");
        bstackOptions.put("osVersion", "12");

        options.setCapability("bstack:options", bstackOptions);
        options.setApp("bs://844f7a8313097c946a1ad7036578df097d3979dc");

        WebDriver driver = new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"),
                options);
        return driver;
    }
}
