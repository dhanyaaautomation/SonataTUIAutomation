package org.sonatatui.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sonatatui.drivers.DriverManager;
import org.sonatatui.utils.Log;

public class HomePage extends BasePage {

    private static final Logger logger = Log.getLogger(HomePage.class);

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
    private WebElement allTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hotels']")
    private WebElement hotelsTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Holidays']")
    private WebElement holidaysTab;

    public HomePage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);

    }

    public void clickAllTab() {
        click(allTab);
    }

    public void clickHotelsTab() {
        click(hotelsTab);
    }

    public void clickHolidaysTab() {
        click(holidaysTab);
    }


    public boolean isAllTabSelected() {

        return allTab.isDisplayed();
    }

    public boolean isHotelsTabSelected() {

        return hotelsTab.isDisplayed();
    }

    public boolean isHolidaysTabSelected() {

        return holidaysTab.isDisplayed();
    }

    public void scrollTillEnd() {

        String previousPageSource = "";

        while (true) {

            String currentPageSource = DriverManager.getDriver().getPageSource();

            if (currentPageSource.equals(previousPageSource)) {
                //System.out.println("Reached end of list");
                logger.info("Reached end of list");
                break;
            }

            previousPageSource = currentPageSource;

            scroll();
        }
    }

}
