package test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

public class Admin_login {

    @Given("the login page is open")
    public void the_login_page_is_open() {

    }
    @When("I submit user name {string} and password {string} and should enter to admin page")
    public void i_submit_user_name_and_password_and_should_enter_to_admin_page(String string , String string2 ) {


    }
    @Then("I should be logged in to admin page")
    public void i_should_be_logged_in_to_admin_page() {
    }

}
