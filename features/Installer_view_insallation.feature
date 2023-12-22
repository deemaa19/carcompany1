Feature: Installer View Installation for Car Company
  Description: Installers should be able to view information about installations on the car company's website.

  Background:
    Given the installer is logged into their account

  Scenario Outline: Installer views upcoming installations
    When the installer navigates to the upcoming installations page
    Then the installer should see a list of upcoming installations
    And each installation should display customer details, product, date, and time

    Examples:
      | customer_name  | customer_email             | product_name     | installation_date | installation_time |
      | John Doe       | john.doe@example.com       | Steering Wheel   | 2023-08-15        | 10:00 AM          |
      | Jane Smith     | jane.smith@gmail.com       | Brake System     | 2023-08-20        | 02:30 PM          |
      | Robert Johnson | robert.johnson@hotmail.com | Tire Replacement | 2023-08-25        | 01:00 PM          |

  Scenario Outline: Installer views completed installations
    When the installer navigates to the completed installations page
    Then the installer should see a list of completed installations
    And each installation should display customer details, product, date, and time

    Examples:
      | customer_name    | customer_email             | product_name        | installation_date | installation_time |
      | Susan Williams   | susan.williams@example.com | Battery Replacement | 2023-07-28        | 03:30 PM          |
      | Michael Anderson | michael.anderson@gmail.com | Headlight Upgrade   | 2023-07-30        | 11:00 AM          |
      | Emily Davis      | emily.davis@hotmail.com    | Oil Change          | 2023-08-05        | 09:00 AM          |
