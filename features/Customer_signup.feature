Feature: Customer Sign-Up for Car Company
  Description: New customers should be able to sign up for an account on the car company's website.

  Scenario Outline: Customer signs up with valid information
    Given the customer is on the sign-up page
    When the customer provides valid sign-up information
    And clicks the sign-up button
    Then the customer account should be created successfully
    And the customer should be redirected to the login page
    And the customer should receive a welcome email

    Examples:
      | username          | email                      | password    | confirm_password |
      | new_customer123   | new_customer@example.com   | newPassword | newPassword      |
      | car_enthusiast456 | car_enthusiast@example.com | securePass  | securePass       |
      | drive123          | drive123@gmail.com         | pass123     | pass123          |

  Scenario Outline: Customer signs up with invalid information
    Given the customer is on the sign-up page
    When the customer provides invalid sign-up information
    And clicks the sign-up button
    Then the customer account should not be created
    And the customer should see an error message

    Examples:
      | username     | email                     | password   | confirm_password |
      | invalid*user | invalid_email@example.com | pass123    | pass123          |
      | anotherUser  | customer@example          | secretPass | secretPass       |
      | user123      | user123@company.com       | pass456    | pass456          |

  Scenario Outline: Customer signs up with an existing username
    Given there is an existing customer account
    When the customer tries to sign up with an existing username
    Then the customer account should not be created
    And the customer should see an error message indicating the username is already taken

    Examples:
      | existing_username   | email                      | password    | confirm_password |
      | existingCustomer123 | new_customer@example.com   | newPassword | newPassword      |
      | takenUsername456    | car_enthusiast@example.com | securePass  | securePass       |

  Scenario Outline: Customer signs up with an existing email
    Given there is an existing customer account
    When the customer tries to sign up with an existing email
    Then the customer account should not be created
    And the customer should see an error message indicating the email is already in use

    Examples:
      | username       | existing_email           | password   | confirm_password |
      | newCustomer789 | customer@example.com     | pass123    | pass123          |
      | freshUser456   | new_customer@example.com | secretPass | secretPass       |
