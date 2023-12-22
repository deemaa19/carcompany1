Feature: Installer Scheduling Appointment for Car Company
  Description: Installers should be able to schedule appointments for installations on the car company's website.

  Scenario Outline: Installer schedules a new appointment
    Given the installer is logged into their account
    When the installer navigates to the appointment scheduling page
    And selects a customer's appointment details
    And chooses the installation date and time
    And clicks the schedule button
    Then the appointment should be scheduled successfully
    And the installer should see a confirmation message

    Examples:
      | customer_name  | customer_email             | installation_date | installation_time |
      | John Doe       | john.doe@example.com       | 2023-08-15        | 10:00 AM          |
      | Jane Smith     | jane.smith@gmail.com       | 2023-08-20        | 02:30 PM          |
      | Robert Johnson | robert.johnson@hotmail.com | 2023-08-25        | 01:00 PM          |


