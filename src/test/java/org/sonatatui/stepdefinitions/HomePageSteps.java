package org.sonatatui.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sonatatui.pages.HomePage;
import org.testng.Assert;

public class HomePageSteps {


  private final HomePage homePage = new HomePage();

    @When("User scrolls till end of the results list")
    public void user_scrolls_till_end_of_the_results_list() {

        homePage.scrollTillEnd();
    }

    @Then("Application should remain stable without crashing")
    public void application_should_remain_stable_without_crashing() {

        Assert.assertTrue(
                homePage.isAllTabSelected(),
                "Application crashed while scrolling through the results list");
    }

    @When("User clicks Hotels tab")
    public void user_clicks_hotels_tab() {

        homePage.clickHotelsTab();
    }

    @Then("Hotels tab should be selected")
    public void hotels_tab_should_be_selected() {

        Assert.assertTrue(
                homePage.isHotelsTabSelected(),
                "Hotels tab is not selected");
    }

    @When("User clicks Holidays tab")
    public void user_clicks_holidays_tab() {

        homePage.clickHolidaysTab();
    }

    @Then("Holidays tab should be selected")
    public void holidays_tab_should_be_selected() {

        Assert.assertTrue(
                homePage.isHolidaysTabSelected(),
                "Holidays tab is not selected");
    }

    @When("User clicks All tab")
    public void user_clicks_all_tab() {

        homePage.clickAllTab();
    }

    @Then("All tab should be selected")
    public void all_tab_should_be_selected() {

        Assert.assertTrue(
                homePage.isAllTabSelected(),
                "All tab is not selected");
    }
}

