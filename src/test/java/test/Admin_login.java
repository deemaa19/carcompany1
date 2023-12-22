package test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Admin_login {
    @Given("the admin is on the admin login page")
    public void theAdminIsOnTheAdminLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        //  throw new io.cucumber.java.PendingException();
    }
    @When("the admin enters a valid email {string} and password {string}")
    public void theAdminEntersAValidEmailAndPassword(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }
    @When("clicks the login button")
    public void clicksTheLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the admin should be redirected to the admin dashboard")
    public void theAdminShouldBeRedirectedToTheAdminDashboard() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("should see a welcome message")
    public void shouldSeeAWelcomeMessage() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
