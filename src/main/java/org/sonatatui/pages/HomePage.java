package org.sonatatui.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sonatatui.drivers.DriverManager;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
    private WebElement all_tab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hotels']")
    private WebElement hotels_tab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Holidays']")
    private WebElement holidays_tab;

    public HomePage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);

    }

    public void clickAllTab() {
        click(all_tab);
    }

    public void clickHotelsTab() {
        click(hotels_tab);
    }

    public void clickHolidaysTab() {
        click(holidays_tab);
    }


    public boolean isAllTabSelected() {

        return all_tab.isDisplayed();
    }

    public boolean isHotelsTabSelected() {

        return hotels_tab.isDisplayed();
    }

    public boolean isHolidaysTabSelected() {

        return holidays_tab.isDisplayed();
    }

    public void scrollTillEnd() {

        String previousPageSource = "";

        while (true) {

            String currentPageSource = DriverManager.getDriver().getPageSource();

            if (currentPageSource.equals(previousPageSource)) {
                System.out.println("Reached end of list");
                break;
            }

            previousPageSource = currentPageSource;

            scroll();
        }
    }

}
