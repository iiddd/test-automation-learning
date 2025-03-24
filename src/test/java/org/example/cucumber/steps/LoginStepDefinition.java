package org.example.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;

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

    @When("The User enters a random {int} character text as username")
    public void theUserInputsRandomTextAsAUsername(int input) {
        loginPage.enterRandomUsername(input);
    }

    @When("The User enters a random {int} character text as password")
    public void theUserEntersARandomCharacterTextAsPassword(int input) {
        loginPage.enterRandomPassword(input);
    }

    @Then("The User is on Dashboard page")
    public void theUserIsOnDashboardPage() {
        dashboardPage.checkDashboardIsDisplayed();
    }

    @Then("The User sees the error message 'Please enter a correct username and password. Note that both fields may be case-sensitive'.")
    public void theUserSeesTheErrorMessage() {
        loginPage.checkErrorMessageIsDisplayed();
    }
}
