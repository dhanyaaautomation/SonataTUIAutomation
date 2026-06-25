package org.sonatatui.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriver implements IDriver  {

    public WebDriver getDriver() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        //options.setApp(FrameworkConstants.getApkFilePath());
        options.setAppPackage("com.tui.qa.challenge");
        options.setAppActivity("com.tui.qa.challenge.MainActivity");

        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        return driver;

    }

}
