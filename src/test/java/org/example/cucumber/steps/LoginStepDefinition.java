package org.example.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinition {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Given("The User navigates to the Login page")
    public void theUserNavigatesToTheLoginPage() {
        loginPage.navigateToPuppyPage();
    }

    @When("The User inputs {string} as a username")
    public void theUserInputsAsAUsername(String input) {
        loginPage.enterUsername(input);
    }

    @When("The User inputs {string} as a password")
    public void theUserInputsAsAPassword(String input) {
        loginPage.enterPassword(input);
    }

    @When("The User clicks Login button")
    public void theUserClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("The User is on Dashboard page")
    public void theUserIsOnDashboardPage() {
        Assertions.fail();
        dashboardPage.checkDashboardIsDisplayed();
    }
}
