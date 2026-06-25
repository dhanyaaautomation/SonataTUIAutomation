package org.sonatatui.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sonatatui.drivers.DriverManager;
import java.util.List;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='username_input_field']")
    private WebElement username_element;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password_input_field']")
    private WebElement password_element;

    @AndroidFindBy(accessibility = "Calendar")
    private WebElement dob;

    @AndroidFindBy(accessibility = "Switch to text input mode")
    private WebElement dob_edit;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement dob_input;

    @AndroidFindBy(xpath = "//*[@resource-id='date_of_birth_dialog_confirm_button']//android.widget.Button")
    private WebElement confirm_button;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='login_form_submit_button']//android.widget.Button")
    private WebElement submit_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log in']")
    private WebElement login_text;

    @AndroidFindBy(accessibility = "Switch to selecting a year")
    private WebElement switch_year;

    @AndroidFindBy(accessibility = "Change to previous month")
    private WebElement previous_month;

    @AndroidFindBy(accessibility = "Change to next month")
    private WebElement next_month;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='date_of_birth_field']")
    private WebElement dobField;

    By year_by = By.xpath("//android.widget.TextView[@text='Navigate to year 2024']");

    public LoginPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);

    }

    public LoginPage login(String username, String password) throws InterruptedException {

        sendKeys(username_element, username);
        sendKeys(password_element, password);
        return this;

    }

    public HomePage enterDateOfBirth(String dob) {
        click(this.dob);
        click(dob_edit);
        sendKeys(dob_input, dob);
        click(confirm_button);
        click(submit_button);

        return new HomePage();
    }

    public int getRequiredValidationCount() {

        List<WebElement> requiredMessages =
                DriverManager.getDriver()
                        .findElements(AppiumBy.xpath("//*[@text='Required']"));

        return requiredMessages.size();
    }

    public boolean isLoginPageDisplayed() {
        return login_text.isDisplayed();
    }

    public void clickSubmit() {
        click(submit_button);
    }

    public void selectDate(String dob) {

        String month = dob.substring(0, 2);
        String day = String.valueOf(Integer.parseInt(dob.substring(2, 4)));
        String year = dob.substring(4, 8);

        click(this.dob);
        click(switch_year);

        scrollToSpecificElement(getYearLocator(year));

        navigateToMonth(month);

        String targetDate = getMonthName(month) + " " + day + ", " + year;

        DriverManager.getDriver()
                .findElement(
                        AppiumBy.xpath(
                                "//android.widget.TextView[contains(@text,'" +
                                        targetDate + "')]"))
                .click();
        click(confirm_button);

    }

    public String getSelectedDate() {

        return dobField.getText();
    }

    private By getYearLocator(String year) {
        return By.xpath("//android.widget.TextView[@text='Navigate to year " + year + "']");
    }

    private void navigateToMonth(String targetMonth) {

        String targetMonthName = getMonthName(targetMonth);

        int maxAttempts = 12;

        while (maxAttempts-- > 0) {

            List<WebElement> monthElements =
                    DriverManager.getDriver().findElements(
                            AppiumBy.xpath(
                                    "//android.widget.TextView[contains(@text,'" +
                                            targetMonthName + "')]"));

            if (!monthElements.isEmpty()) {
                return;
            }

            click(previous_month);
        }

        throw new RuntimeException(
                "Unable to navigate to month : " + targetMonthName);
    }

    private String getMonthName(String month) {

        String[] months = {
                "January","February","March","April",
                "May","June","July","August",
                "September","October","November","December"
        };

        return months[Integer.parseInt(month) - 1];
    }
}
