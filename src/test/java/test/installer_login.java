package test;

import car.our_data;
import car.userr;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class installer_login {
    private boolean jal;
    private userr user = new userr();
    private static List<userr> userList = our_data.listUsers();
    private String username;
    private String password;


    @Then("I should be logged in to installer page")
    public void i_should_be_logged_in_to_installer_page() {
        Assert.assertTrue(jal);
    }
    @When("I submit user name {string} and password\"{int}\" and should enter to installer page")
    public void iSubmitUserNameAndPasswordAndShouldEnterToInstallerPage(String string, Integer int1) {
        System.out.println("..");}
}
