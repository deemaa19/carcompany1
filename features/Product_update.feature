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

  Scenario Outline: Admin attempts to update product with invalid details
    Given there is an existing product in the system
    When the admin attempts to update the product with invalid details
    Then the admin should see an error message
    And no changes should be made to the product

    Examples:
      | existing_product_name | invalid_updated_product_name | invalid_updated_description               | invalid_updated_price | invalid_updated_availability |
      | Steering Wheel        |                              |                                           |                       |                              |
      | Brake Pad Set         | Updated Brake Pad Set        |                                           | $60                   | Not Available                |
      | Spark Plug Kit        | Invalid Spark Plug Kit       | High-quality spark plug kit for ignition  |                       | Available                    |
      | All-Season Tires      | Updated All-Season Tires     | High-performance tires for all conditions | $150                  |                              |

  Scenario Outline: Admin attempts to update non-existing product
    When the admin attempts to update a product that does not exist
    Then the admin should see an error message
    And no changes should be made to the system

    Examples:
      | non_existing_product_name | updated_description                          | updated_price | updated_availability |
      | Non-Existent Product      | Updated Description for Non-Existent Product | $50           | Available            |
      | Not Available Product     | New Description for Not Available Product    | $30           | Not Available        |
      | Product Not Found         | Description for Product Not Found            | $100          | Available            |
