Feature: Admin Logout for Car Company
  Description: Admins should be able to log out from their accounts in the car company's admin panel.

  Scenario: Admin logs out
    Given the admin is logged into their account
    When the admin clicks the logout button
    Then the admin should be logged out successfully
    And should be redirected to the login page
    And should see a logout confirmation message

  Scenario: Admin logs out after performing actions
    Given the admin is logged into their account
    When the admin performs various actions (e.g., manage products, view reports)
    And then the admin clicks the logout button
    Then the admin should be logged out successfully
    And should be redirected to the login page
    And should see a logout confirmation message

  Scenario: Admin logs out from a specific page
    Given the admin is on a specific page (e.g., product management, user accounts)
    When the admin clicks the logout button
    Then the admin should be logged out successfully
    And should be redirected to the login page
    And should see a logout confirmation message
