Feature: Product Update for Car Company
  Description: Admins should be able to update product details on the car company's website.

  Background:
    Given the admin is logged into their account

  Scenario Outline: Admin updates product details successfully
    Given there is an existing product in the system
    When the admin updates the details of the product
    Then the product details should be updated successfully
    And the admin should see a confirmation message

    Examples:
      | existing_product_name | updated_product_name         | updated_description                               | updated_price | updated_availability |
      | Steering Wheel        | Improved Steering Wheel      | Enhanced steering wheel for vehicles              | $180          | Available            |
      | Brake Pad Set         | Upgraded Brake Pad Set       | Advanced brake pad set for optimal performance    | $60           | Available            |
      | Spark Plug Kit        | Premium Spark Plug Kit       | High-quality spark plug kit for improved ignition | $40           | Available            |
      | All-Season Tires      | Performance All-Season Tires | High-performance tires for all weather conditions | $150          | Available            |

