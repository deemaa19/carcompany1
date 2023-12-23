package test;

import car.our_data;
import car.userr;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class customer_login {
    private userr user = new userr();
    private static List<userr> userList = our_data.listUsers();
    private boolean jal;
    @Then("I should be logged in to customer page")
    public void i_should_be_logged_in_to_customer_page() {

    }
    @When("I submit user name {string} and password {string} and should enter to customer page")
    public void iSubmitUserNameAndPasswordAndShouldEnterToCustomerPage(String string, String string2) {
        jal= user.login(string,string2,userList);
    }

    }
