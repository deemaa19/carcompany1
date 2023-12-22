Feature: Product Schedule for Car Company
  Description: Users should be able to schedule installations for specific products on the car company's website.

  Background:
    Given the user is logged into their account

  Scenario Outline: User schedules installation for a product
    Given the user is on the product details page
    When the user selects a specific product
    And schedules an installation for that product
    Then the installation should be scheduled successfully
    And the user should see a confirmation message

    Examples:
      | product_name     | installation_date | installation_time | installation_location     |
      | Steering Wheel   | 2023-09-01        | 10:00 AM          | User's Garage             |
      | Brake Pad Set    | 2023-09-05        | 02:30 PM          | Local Auto Shop           |
      | Spark Plug Kit   | 2023-09-10        | 11:00 AM          | Authorized Service Center |
      | All-Season Tires | 2023-09-15        | 01:00 PM          | Home Driveway             |

  Scenario: User attempts to schedule installation without selecting a product
    Given the user is on the product details page
    When the user attempts to schedule an installation without selecting a product
    Then the user should see an error message
    And no installation should be scheduled

  Scenario Outline: User attempts to schedule installation with invalid date and time
    Given the user is on the product details page
    When the user attempts to schedule an installation with an invalid date and time
    Then the user should see an error message
    And no installation should be scheduled

    Examples:
      | product_name     | invalid_installation_date | invalid_installation_time |
      | Steering Wheel   | 2023-08-25                | 08:00 AM                  |
      | Brake Pad Set    | 2023-08-30                | 14:45 PM                  |
      | Spark Plug Kit   | 2023-08-22                | 00:30 AM                  |
      | All-Season Tires | 2023-08-28                | 03:00 PM                  |

  Scenario Outline: User views scheduled installations
    When the user navigates to the scheduled installations page
    Then the user should see a list of their scheduled installations
    And each installation should display product details, date, time, and location

    Examples:
      | scheduled_product_name | scheduled_installation_date | scheduled_installation_time | scheduled_location        |
      | Steering Wheel         | 2023-09-01                  | 10:00 AM                    | User's Garage             |
      | Brake Pad Set          | 2023-09-05                  | 02:30 PM                    | Local Auto Shop           |
      | Spark Plug Kit         | 2023-09-10                  | 11:00 AM                    | Authorized Service Center |
      | All-Season Tires       | 2023-09-15                  | 01:00 PM                    | Home Driveway             |
