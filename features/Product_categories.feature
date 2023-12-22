Feature: Product Categories for Car Company
  Description: Users should be able to manage and view product categories on the car company's website.

  Background:
    Given the admin is logged into their account

  Scenario Outline: Admin views existing product categories
    When the admin navigates to the product categories page
    Then the admin should see a list of existing product categories
    And each category should display its name and description

    Examples:
      | category_name     | category_description                      |
      | Steering System   | Components related to steering systems    |
      | Brake System      | Parts and accessories for braking systems |
      | Electrical System | Electrical components and wiring          |
      | Tire and Wheel    | Tires, wheels, and related accessories    |

  Scenario Outline: Admin adds a new product category
    When the admin adds a new product category
    Then the new category should be added successfully
    And the admin should see a confirmation message

    Examples:
      | new_category_name | new_category_description            |
      | Suspension System | Parts related to vehicle suspension |
      | Exhaust System    | Exhaust components and accessories  |
      | Lighting System   | Lighting products for vehicles      |

  Scenario Outline: Admin updates an existing product category
    When the admin updates an existing product category
    Then the category details should be updated successfully
    And the admin should see a confirmation message

    Examples:
      | existing_category_name | updated_category_name   | updated_category_description                          |
      | Steering System        | Updated Steering System | Improved components for steering systems              |
      | Brake System           | Enhanced Brake System   | High-performance braking system parts and accessories |
      | Tire and Wheel         | Premium Tire and Wheel  | High-quality tires, wheels, and related accessories   |

  Scenario Outline: Admin deletes an existing product category
    When the admin deletes an existing product category
    Then the category should be deleted successfully
    And the admin should see a confirmation message

    Examples:
      | category_to_delete |
      | Exhaust System     |
      | Lighting System    |
      | Suspension System  |
