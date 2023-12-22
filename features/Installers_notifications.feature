Feature: Installer Notifications for Car Company
  Description: Installers should receive notifications about new appointments and updates on the car company's website.

  Background:
    Given the installer is logged into their account

  Scenario Outline: Installer receives a new appointment notification
    When a new appointment is scheduled for the installer
    Then the installer should receive a notification
    And the notification should contain details about the new appointment

    Examples:
      | customer_name  | customer_email             | product_name     | installation_date | installation_time |
      | John Doe       | john.doe@example.com       | Steering Wheel   | 2023-08-15        | 10:00 AM          |
      | Jane Smith     | jane.smith@gmail.com       | Brake System     | 2023-08-20        | 02:30 PM          |
      | Robert Johnson | robert.johnson@hotmail.com | Tire Replacement | 2023-08-25        | 01:00 PM          |

  Scenario Outline: Installer receives an update notification
    When there is an update about a scheduled appointment
    Then the installer should receive a notification
    And the notification should contain details about the updated appointment

    Examples:
      | customer_name    | customer_email             | product_name        | original_date | original_time | updated_date | updated_time |
      | Susan Williams   | susan.williams@example.com | Battery Replacement | 2023-07-28    | 03:30 PM      | 2023-07-29   | 02:00 PM     |
      | Michael Anderson | michael.anderson@gmail.com | Headlight Upgrade   | 2023-07-30    | 11:00 AM      | 2023-07-31   | 10:30 AM     |
      | Emily Davis      | emily.davis@hotmail.com    | Oil Change          | 2023-08-05    | 09:00 AM      | 2023-08-06   | 10:00 AM     |
