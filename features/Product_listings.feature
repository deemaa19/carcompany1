Feature: Product Listings for Car Company
  Description: Users and admins should be able to view and manage product listings on the car company's website.

  Background:
    Given the admin is logged into their account

  Scenario Outline: Admin views all product listings
    When the admin navigates to the product listings page
    Then the admin should see a list of all available products
    And each product should display its name, description, price, and availability status

    Examples:
      | product_name     | product_description                                     | product_price | availability_status |
      | Steering Wheel   | High-quality steering wheel for vehicles                | $150          | Available           |
      | Brake Pad Set    | Performance brake pad set for improved braking          | $50           | Available           |
      | Spark Plug Kit   | High-performance spark plug kit for efficient ignition  | $30           | Available           |
      | All-Season Tires | Durable all-season tires for various weather conditions | $120          | Available           |

  Scenario Outline: Admin updates product details
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

  Scenario Outline: Admin adds a new product to the listings
    When the admin adds a new product to the listings
    Then the new product should be added successfully
    And the admin should see a confirmation message

    Examples:
      | new_product_name      | new_product_description              | new_product_price | new_availability |
      | Headlight Upgrade Kit | Kit to upgrade vehicle headlights    | $80               | Available        |
      | Oil Change Kit        | Complete kit for an oil change       | $45               | Available        |
      | Alloy Wheel Set       | Stylish alloy wheels for vehicles    | $200              | Available        |
      | Battery Replacement   | High-performance replacement battery | $100              | Available        |

  Scenario Outline: Admin removes an existing product from the listings
    Given there is an existing product in the system
    When the admin removes the product from the listings
    Then the product should be removed successfully
    And the admin should see a confirmation message

    Examples:
      | product_to_remove   |
      | Spark Plug Kit      |
      | Oil Change Kit      |
      | Battery Replacement |
      | Alloy Wheel Set     |
