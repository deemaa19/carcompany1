Feature: Customer Edit Profile for Car Company
  Description: Customers should be able to edit their profiles on the car company's website.

  Scenario: Customer navigates to the profile editing page
    Given the customer is logged into their account
    When the customer navigates to the profile editing page
    Then the customer should see their current profile information

  Scenario Outline: Customer edits profile information
    Given the customer is on the profile editing page
    When the customer updates their profile information
    And clicks the save button
    Then the customer's profile information should be updated successfully
    And the customer should see a success message

    Examples:
      | new_email                    | new_phone    |
      | updated_customer@example.com | 555-123-4567 |
      | another_customer@gmail.com   | 555-987-6543 |

  Scenario Outline: Customer changes password
    Given the customer is on the profile editing page
    When the customer selects to change their password
    And enters the current password and a new password
    And clicks the save button
    Then the customer's password should be changed successfully
    And the customer should see a password change confirmation message

    Examples:
      | current_password | new_password   |
      | password123      | newPassword456 |
      | securePass789    | anotherPass123 |

  Scenario Outline: Customer updates notification preferences
    Given the customer is on the profile editing page
    When the customer updates their notification preferences
    And clicks the save button
    Then the customer's notification preferences should be updated successfully
    And the customer should see a confirmation message

    Examples:
      | email_notification | sms_notification |
      | true               | false            |
      | false              | true             |

  Scenario Outline: Customer uploads a new profile picture
    Given the customer is on the profile editing page
    When the customer uploads a new profile picture
    And clicks the save button
    Then the customer's profile picture should be updated successfully
    And the customer should see a confirmation message

    Examples:
      | new_profile_picture |
      | profile_image1.jpg  |
      | profile_image2.png  |
