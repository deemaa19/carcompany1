Feature: Product Delete for Car Company
  Description: Admins should be able to delete products on the car company's website.

  Background:
    Given the admin is logged into their account

  Scenario Outline: Admin deletes an existing product
    Given there is an existing product in the system
    When the admin selects the product to delete
    And confirms the deletion
    Then the product should be deleted successfully
    And the admin should see a confirmation message

    Examples:
      | product_name     | product_description                      |
      | Steering Wheel   | High-quality steering wheel for vehicles |
      | Brake System     | Performance brake system components      |
      | Tire Replacement | Durable tires for various vehicle types  |

  Scenario Outline: Admin attempts to delete a non-existing product
    When the admin tries to delete a product that does not exist
    Then the admin should see an error message
    And no changes should be made to the system

    Examples:
      | non_existing_product_name | non_existing_product_description               |
      | Non-Existent Product      | Description for a non-existent product         |
      | Not Available Product     | Another description for a non-existent product |
      | Product Not Found         | A third description for a non-existent product |

  Scenario Outline: Admin attempts to delete a product with dependencies
    Given there is a product with dependencies in the system
    When the admin tries to delete the product with dependencies
    Then the admin should see an error message
    And no changes should be made to the system

    Examples:
      | product_with_dependencies | dependent_product_name | dependent_product_description        |
      | Exhaust System            | Exhaust Component A    | Component A for the exhaust system   |
      | Lighting System           | Headlights Upgrade Kit | Kit to upgrade vehicle headlights    |
      | Suspension System         | Suspension Kit         | Kit for improving vehicle suspension |
