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


