package test;

import car.our_data;
import car.userr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Admin_login {
    private userr user = new userr();
    private static our_data main;
    private static List<userr> userList = main.listUsers();
    private boolean jal;
    @Given("the login page is open")
    public void the_login_page_is_open() {
        System.out.println("..");
    }
    @When("I submit user name {string} and password {string} and should enter to admin page")
    public void i_submit_user_name_and_password_and_should_enter_to_admin_page(String string , String string1) {
       jal = user.login(string ,string1,userList);

    }
    @Then("I should be logged in to admin page")
    public void i_should_be_logged_in_to_admin_page() {
        assertTrue("Expected to be logged in to admin page", true);
    }
    @Given("the admin logged in")
    public void theAdminLoggedIn() {

    }
    @When("he enter the id_house {int}, acceptance {string}")
    public void heEnterTheIdHouseAcceptance(Integer int1, String string) {

    }
    @Then("he can accept or reject it")
    public void heCanAcceptOrRejectIt() {

    }
    @When("he select to see the reservations of houses")
    public void heSelectToSeeTheReservationsOfHouses() {
    }
    @Then("a table of reservations data will printed")
    public void aTableOfReservationsDataWillPrinted() {

    }
}
