package org.sonatatui.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager() {

    }

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static void unLoad() {

        threadLocalDriver.remove();

    }
}
