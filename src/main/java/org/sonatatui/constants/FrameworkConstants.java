package org.sonatatui.constants;


public class FrameworkConstants {

    private FrameworkConstants() {

    }

    private static final String APK_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/apps/TUIChallengeApp.apk";
    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    private static final int EXPLICIT_WAIT_DURATION = 10;
    private static final int POLLING_FREQUENCY = 5;

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static String getApkFilePath() {
        return APK_FILE_PATH;
    }

    public static int getExplicitWaitDuration() { return EXPLICIT_WAIT_DURATION; }

    public static int getPollingFrequency() { return POLLING_FREQUENCY; }
}
