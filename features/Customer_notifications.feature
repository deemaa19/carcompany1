Feature: Customer Notifications for Car Company
  Description: Customers should be able to manage their notification preferences on the car company's website.

  Scenario: Customer views current notification preferences
    Given the customer is logged into their account
    When the customer navigates to the notification preferences page
    Then the customer should see their current notification preferences

  Scenario Outline: Customer updates email notification preferences
    Given the customer is on the notification preferences page
    When the customer toggles the email notification setting
    And clicks the save button
    Then the customer's email notification preferences should be updated successfully
    And the customer should see a confirmation message

    Examples:
      | current_email_preference | new_email_preference |
      | true                     | false                |
      | false                    | true                 |

  Scenario Outline: Customer updates SMS notification preferences
    Given the customer is on the notification preferences page
    When the customer toggles the SMS notification setting
    And clicks the save button
    Then the customer's SMS notification preferences should be updated successfully
    And the customer should see a confirmation message

    Examples:
      | current_sms_preference | new_sms_preference |
      | true                   | false              |
      | false                  | true               |

  Scenario Outline: Customer updates both email and SMS notification preferences
    Given the customer is on the notification preferences page
    When the customer toggles both email and SMS notification settings
    And clicks the save button
    Then the customer's email and SMS notification preferences should be updated successfully
    And the customer should see a confirmation message

    Examples:
      | current_email_preference | current_sms_preference | new_email_preference | new_sms_preference |
      | true                     | true                   | false                | false              |
      | false                    | false                  | true                 | true               |