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


