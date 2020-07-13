package net.votervoice.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.votervoice.pages.DashboardPage;
import net.votervoice.pages.LoginPage;
import net.votervoice.utilities.ConfigurationReader;


public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        dashboardPage.verifyTitle("login");

    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @Then("{} page should be displayed")
    public void page_should_be_displayed(String pageName) {
        dashboardPage.verifyTitle(pageName);
    }

    @When("I log out")
    public void i_log_out() {
        dashboardPage.logout();
    }


    @When("I fill in {string} with {string}")
    public void i_fill_in_with(String fieldName, String input) {
        loginPage.inputIntoField(fieldName, input);
    }

    @When("I click login button")
    public void i_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("{} error message should be displayed")
    public void error_should_be_displayed(String errorType) {
        loginPage.verifyErrorIsDisplayed(errorType);
    }

    }


