Feature: Installer Login with Email and Password for Car Company
  Description: Installers should be able to log into their accounts using their email and password on the car company's website.

  Scenario Outline: Installer logs in with valid email and password
    Given the installer is on the login page
    When the installer enters a valid email and password
    And clicks the login button
    Then the installer should be redirected to their dashboard
    And should see a welcome message

    Examples:
      | email                         | password    |
      | installer123@example.com      | pass123     |
      | installpro456@abc.com         | securePass  |
      | serviceinstaller789@gmail.com | anotherPass |

  Scenario Outline: Installer logs in with incorrect password
    Given the installer is on the login page
    When the installer enters a valid email and incorrect password
    And clicks the login button
    Then the installer should see an error message
    And should remain on the login page

    Examples:
      | email                         | incorrect_password |
      | installer123@example.com      | wrongpass          |
      | installpro456@abc.com         | invalid123         |
      | serviceinstaller789@gmail.com | pass456            |

  Scenario Outline: Installer logs in with non-existent email
    Given the installer is on the login page
    When the installer enters a non-existent email
    And a valid password
    And clicks the login button
    Then the installer should see an error message
    And should remain on the login page

    Examples:
      | non_existent_email          | password   |
      | user_not_found@example.com  | secret123  |
      | unknown_installer@abc.com   | pass456    |
      | missing_installer@gmail.com | newPass789 |
