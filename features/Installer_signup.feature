Feature: Installer Sign-Up for Car Company
  Description: New installers should be able to sign up for an account on the car company's website.

  Scenario Outline: Installer signs up with valid information
    Given the installer is on the sign-up page
    When the installer provides valid sign-up information
    And clicks the sign-up button
    Then the installer account should be created successfully
    And the installer should be redirected to the login page
    And the installer should receive a welcome email

    Examples:
      | full_name        | email                        | password   | confirm_password |
      | Installer One    | installer.one@example.com    | newPass123 | newPass123       |
      | Pro Installer    | pro.installer@gmail.com      | securePass | securePass       |
      | Expert Installer | expert.installer@hotmail.com | pass123    | pass123          |

  Scenario Outline: Installer signs up with invalid information
    Given the installer is on the sign-up page
    When the installer provides invalid sign-up information
    And clicks the sign-up button
    Then the installer account should not be created
    And the installer should see an error message

    Examples:
      | invalid_full_name | invalid_email                | invalid_password | invalid_confirm_password |
      | Invalid Installer | invalid_email@example        | 12345            | 12345                    |
      | Another Installer | another.installer@gmail.com  | short            | short                    |
      | Missing Password  | missing.password@hotmail.com |                  |                          |

  Scenario Outline: Installer signs up with an existing email
    Given there is an existing installer account
    When the installer tries to sign up with an existing email
    Then the installer account should not be created
    And the installer should see an error message indicating the email is already in use

    Examples:
      | existing_email            | new_password     | confirm_password |
      | existing@example.com      | new_password_123 | new_password_123 |
      | taken.installer@gmail.com | another_new_pass | another_new_pass |
