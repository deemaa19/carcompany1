Feature: Admin Login
  Description: Admins should be able to log in with their email and password.

  Scenario Outline: Successful admin login with email and password
    Given the admin is on the admin login page
    When the admin enters a valid email "<email>" and password "<password>"
    And clicks the login button
    Then the admin should be redirected to the admin dashboard
    And should see a welcome message

    Examples:
      | email                | password |
      | admin001@example.com | pass123  |
      | admin002@example.com | secret99 |

  Scenario Outline: Unsuccessful admin login with incorrect email
    Given the admin is on the admin login page
    When the admin enters an invalid email "<email>" and password "<password>"
    And clicks the login button
    Then the admin should see an error message
    And should remain on the admin login page

    Examples:
      | email                | password   |
      | invalidemail@example | wrongpass  |
      | nonadmin@example.com | invalid123 |

  Scenario Outline: Admin forgot password and resets it
    Given the admin is on the admin login page
    When the admin clicks on the "Forgot Password" link
    And provides a valid admin email address "<email>"
    And clicks the submit button
    Then the admin should receive a password reset email
    And should see a confirmation message

    Examples:
      | email                |
      | admin001@example.com |
      | admin002@example.com |

  Scenario Outline: Invalid admin login attempts with locked account
    Given the admin is on the admin login page
    When the admin enters <email> and <password>
    And clicks the login button
    Then the admin should see a message indicating the account is locked

    Examples:
      | email                | password    |
      | locked_admin@example | invalidpass |
      | another_locked@admin | wrongsecret |
