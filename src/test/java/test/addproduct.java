package test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addproduct {

    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {

    }
    @Given("there is a product with name {string} , type {string} , and the price {string}, amount {string}")
    public void there_is_a_product_with_name_type_and_the_price_amount(String string, String string2, String string3, String string4) {

    }
    @When("the meal is added to the menu")
    public void the_meal_is_added_to_the_menu() {

    }
    @Then("the meal with name {string} ,type {string} , and the price {string}, amount {string} inside the listing")
    public void the_meal_with_name_type_and_the_price_amount_inside_the_listing(String string, String string2, String string3, String string4) {

    }

    @Given("that the admin is not logged in")
    public void that_the_admin_is_not_logged_in() {

    }
    @Given("there is a meal with name {string} , type {string} , and the price {string}, amount {string}")
    public void there_is_a_meal_with_name_type_and_the_price_amount(String string, String string2, String string3, String string4) {

    }
    @Then("the error message {string} is given")
    public void the_error_message_is_given(String string) {

    }
}
