Feature: Admin Sign-Up for Car Company
  Description: New admins in a car company should be able to sign up for an account.

  Scenario Outline: Admin signs up with valid information
    Given the admin is on the sign-up page
    When the admin provides valid sign-up information
    And clicks the sign-up button
    Then the admin account should be created successfully
    And the admin should be redirected to the login page
    And the admin should receive a confirmation email

    Examples:
      | username     | email                    | password    | confirm_password |
      | new_admin123 | new_admin@example.com    | newPassword | newPassword      |
      | adminCar456  | admin_car456@example.com | securePass  | securePass       |

  Scenario Outline: Admin signs up with invalid information
    Given the admin is on the sign-up page
    When the admin provides invalid sign-up information
    And clicks the sign-up button
    Then the admin account should not be created
    And the admin should see an error message

    Examples:
      | username      | email                     | password   | confirm_password |
      | invalid*admin | invalid_email@example.com | pass123    | pass123          |
      | anotherAdmin  | admin@example             | secretPass | secretPass       |
