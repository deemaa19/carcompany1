package test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static car.Category.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.categories.Categories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import car.Category;
import io.cucumber.java.en.*;
import car.Appointment;
import car.User;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.deletecat;
import static org.example.Main.manageCat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static car.Appointment.*;
import static org.junit.Assert.assertTrue;

public class AdminManage {
    Category category;
    Category category2;
    private String categoryName;
    private String categoryName2;
    private String categoryName3;
    private String categoryName4;
    private String productName;
    List<Category> categoryList = new ArrayList<Category>();


    public static Category categoryyy;
    @Given("they choose Add Category")
    public void theyChooseAddCategory() {
        category.setAddcat(true);
        assertTrue(isAddcat());
        setSearchproduct(true);
        assertTrue(isSearchproduct());
    }
    @When("Category name is {string}")
    public void categoryNameIs(String string) {
        this.categoryName=string;
    }
    @When("Category2 name is {string}")
    public void category2NameIs(String string) {
        this.categoryName2=string;
    }
    @Then("the category should be added successfully")
    public void theCategoryShouldBeAddedSuccessfully() {
        category=new Category(categoryName);
        category2=new Category(categoryName2);
        categoryList.add(category);
        categoryList.add(category2);
        assertTrue(addcatTest(categoryName));
        assertTrue(addcatTest(categoryName2));
    }
    @When("Category namee is {string}")
    public void categoryNameeIs(String string) {
        this.categoryName=string;
    }
    @Then("the category should not be added")
    public void theCategoryShouldNotBeAdded() {

    }
    @Given("they choose Delete Category")
    public void theyChooseDeleteCategory() {
        category.setDeletecat(true);
        assertTrue(isDeletecat());
    }
    @Then("the category should be removed successfully")
    public void theCategoryShouldBeRemovedSuccessfully() {
        categoryList.remove(category);
        assertTrue(deletecatTest(categoryName));
    }
    @When("Categoryy namee is {string}")
    public void categoryyNameeIs(String string) {
        this.categoryName4=string;
    }
    @Then("the category should not be deleted")
    public void theCategoryShouldNotBeDeleted() {
        assertFalse(deletecatTest(categoryName));
    }
    @Then("they should see a list of available categories")
    public void theyShouldSeeAListOfAvailableCategories() {
        for(Category category:categoryList){
            System.out.println( category.getName()  );
        }
        listCategoriesTest();
    }
}
