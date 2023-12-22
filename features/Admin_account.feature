Feature: Admin Account Management for Car Company
  Description: Admins in a car company should be able to manage their accounts effectively.

  Scenario: View admin account details
    Given the admin is logged in
    When the admin navigates to the account details section
    Then the admin should see their account information
    And should be able to view details such as username, email, and role
    And should see additional information related to the car company, such as dealership details

  Scenario Outline: Edit admin account information
    Given the admin is on the account details page
    When the admin updates their account information
    And saves the changes
    Then the admin account details should be updated successfully
    And the admin should see a success message

    Examples:
      | new_email                     | new_phone    |
      | admin_car_updated@example.com | 555-123-4567 |
      | another_admin_car@gmail.com   | 555-987-6543 |

  Scenario Outline: Change admin password
    Given the admin is on the account details page
    When the admin selects to change the password
    And enters the current password and a new password
    And clicks the save button
    Then the admin password should be changed successfully
    And the admin should see a password change confirmation message

    Examples:
      | current_password  | new_password   |
      | password_car123   | newPass_car456 |
      | securePass_car789 | anotherPass123 |

  Scenario: Admin logs out
    Given the admin is logged in
    When the admin clicks the logout button
    Then the admin should be logged out successfully
    And redirected to the login page

  Scenario: Admin deletes their account
    Given the admin is on the account details page
    When the admin selects to delete their account
    And confirms the deletion
    Then the admin account should be deleted
    And the admin should be redirected to the login page
    And all associated dealership information should be removed from the system

