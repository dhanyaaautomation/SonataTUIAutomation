package org.sonatatui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sonatatui.pages.HomePage;
import org.sonatatui.pages.LoginPage;
import org.sonatatui.pojo.LoginData;
import org.sonatatui.utils.JsonUtils;
import org.testng.Assert;

public class LoginSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final LoginData data = JsonUtils.getLoginData();

    @Given("User launches the TUI Challenge application")
    public void user_launches_the_tui_challenge_application() {

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page is not displayed");
    }

    @When("User logs in using valid test data")
    public void user_logs_in_using_valid_test_data() throws InterruptedException {

        loginPage.login(
                data.getUsername(),
                data.getPassword()
        ).enterDateOfBirth(data.getDob());

    }

    @Then("User should be navigated to the Home screen")
    public void user_should_be_navigated_to_the_home_screen() {

        Assert.assertTrue(
                homePage.isAllTabSelected(),
                "Home page is not displayed");

    }

    @When("User clicks Submit without entering mandatory fields")
    public void user_clicks_submit_without_entering_mandatory_fields() {
        loginPage.clickSubmit();
    }

    @Then("User should see mandatory field validation messages")
    public void user_should_see_mandatory_field_validation_messages() {
        int expectedCount = 3;
        Assert.assertEquals(loginPage.getRequiredValidationCount(), expectedCount);
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        loginPage.login(
                data.getUsername(),
                data.getPassword()
        );
    }

    @When("User selects date of birth")
    public void user_selects_date_of_birth() {

        loginPage.selectDate(data.getDob());

    }

    @Then("Selected date of birth should be displayed in the DOB field")
    public void selected_date_of_birth_should_be_displayed_in_DOB() {

        String dob = data.getDob(); // 05011997

        String expectedDate =
                dob.substring(4, 8) + "-" +
                        dob.substring(0, 2) + "-" +
                        dob.substring(2, 4);

        Assert.assertEquals(
                loginPage.getSelectedDate(),
                expectedDate,
                "Selected DOB is incorrect");
    }
}
