package org.sonatatui.drivers;

import org.openqa.selenium.WebDriver;
import org.sonatatui.enums.Modes;

import java.net.MalformedURLException;

public class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver driver = null;

    public static WebDriver getMode(Modes mode) throws MalformedURLException {


        if (mode.equals(Modes.LOCAL)) {

            driver = new LocalDriver().getDriver();
        }

        else if(mode.equals(Modes.BS)) {
            driver = new BrowserStackDriver().getDriver();
        }

        return driver;
    }

}
