Feature: Customers Management


  Scenario: registers a new customer
    Given they choose Register Customer
    When customer username is "deema"
    And customer email is "deema@gmail.com"
    And customer password is "111"
    And customer2 username is "deema2"
    And customer2 email is "deema2@gmail.com"
    And customer2 password is "111"
    Then the customers should be registered successfully

  Scenario: register a existed customer
    Given they choose Register Customer
    When customerr username is "deema"
    And customerr email is "deema@gmail.com"
    And customerr password is "111"
    Then the customers should not be registered

  Scenario: lists customers
    Given they choose List Customers
    Then they should see a list of registered customers
