package test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchproduct {

    @Given("these products in the menu")
    public void these_products_in_the_menu(io.cucumber.datatable.DataTable dataTable) {

    }
    @Given("the admin loggs out")
    public void the_admin_loggs_out() {

    }
    @Given("the admin is not  logged in")
    public void the_admin_is_not_logged_in() {

    }
    @When("the user search for the text {string}")
    public void the_user_search_for_the_text(String string) {

    }
    @Then("the meal with name {string} is found")
    public void the_meal_with_name_is_found(String string) {

    }

    @Then("no product found")
    public void no_product_found() {

    }
    @Then("enter the name again")
    public void enter_the_name_again() {

    }

    @Then("the product with name {string} and {string} are found")
    public void the_product_with_name_and_are_found(String string, String string2) {

    }

}
