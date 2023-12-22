Feature: Customer Login with Email and Password for Car Company
  Description: Customers should be able to log into their accounts using their email and password on the car company's website.

  Scenario Outline : Customer logs in with valid email and password
    Given the customer is on the login page
    When the customer enters a valid email and password
    And clicks the login button
    Then the customer should be redirected to their dashboard
    And should see a welcome message

    Examples:
      | email                     | password    |
      | carlover123@example.com   | pass123     |
      | autoenthusiast456@abc.com | securePass  |
      | driver789@gmail.com       | anotherPass |

  Scenario Outline: Customer logs in with incorrect password
    Given the customer is on the login page
    When the customer enters a valid email and incorrect password
    And clicks the login button
    Then the customer should see an error message
    And should remain on the login page

    Examples:
      | email                     | incorrect_password |
      | carlover123@example.com   | wrongpass          |
      | autoenthusiast456@abc.com | invalid123         |
      | driver789@gmail.com       | pass456            |

  Scenario Outline: Customer logs in with non-existent email
    Given the customer is on the login page
    When the customer enters a non-existent email
    And a valid password
    And clicks the login button
    Then the customer should see an error message
    And should remain on the login page

    Examples:
      | non_existent_email         | password   |
      | user_not_found@example.com | secret123  |
      | unknown_user@abc.com       | pass456    |
      | missing_user@gmail.com     | newPass789 |

  Scenario Outline: Customer forgot password and resets it with email
    Given the customer is on the login page
    When the customer clicks on the "Forgot Password" link
    And provides a valid email address
    And clicks the submit button
    Then the customer should receive a password reset email
    And should see a confirmation message

    Examples:
      | email                     |
      | carlover123@example.com   |
      | autoenthusiast456@abc.com |
      | driver789@gmail.com       |
