Feature: Customer Logout for Car Company
  Description: Customers should be able to log out from their accounts on the car company's website.

  Scenario: Customer logs out
    Given the customer is logged into their account
    When the customer clicks the logout button
    Then the customer should be logged out successfully
    And should be redirected to the home page
    And should see a logout confirmation message

  Scenario: Customer logs out after performing actions
    Given the customer is logged into their account
    When the customer performs various actions (e.g., browse products, view profile)
    And then the customer clicks the logout button
    Then the customer should be logged out successfully
    And should be redirected to the home page
    And should see a logout confirmation message

  Scenario: Customer logs out from a specific page
    Given the customer is on a specific page (e.g., product details, profile)
    When the customer clicks the logout button
    Then the customer should be logged out successfully
    And should be redirected to the home page
    And should see a logout confirmation message
