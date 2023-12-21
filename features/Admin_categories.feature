Feature: Admin Categories Management for Car Company
  Description: Admins in a car company should be able to manage product categories effectively.

  Scenario: View list of product categories
    Given the admin is logged in
    When the admin navigates to the product categories section
    Then the admin should see a list of existing product categories
    And should see details such as category name, description, and associated products

  Scenario Outline: Add a new product category
    Given the admin is on the product categories page
    When the admin selects to add a new category
    And enters the category details
    And clicks the save button
    Then the new product category should be added successfully
    And the admin should see a success message

    Examples:
      | category_name | description               |
      | Sedans        | Four-door passenger cars  |
      | SUVs          | Sport Utility Vehicles    |
      | Sports Cars   | High-performance vehicles |

  Scenario Outline: Edit an existing product category
    Given the admin is on the product categories page
    When the admin selects an existing category to edit
    And modifies the category details
    And clicks the save button
    Then the product category should be updated successfully
    And the admin should see a success message

    Examples:
      | existing_category | new_category_name | new_description                  |
      | Sedans            | Luxury Sedans     | Premium four-door passenger cars |
      | SUVs              | Crossovers        | Compact and midsize SUVs         |
      | Sports Cars       | Performance Cars  | High-speed and powerful vehicles |

  Scenario Outline: Delete an existing product category
    Given the admin is on the product categories page
    When the admin selects an existing category to delete
    And confirms the deletion
    Then the product category should be deleted successfully
    And the admin should see a confirmation message
    And all products associated with the deleted category should be removed

    Examples:
      | category_to_delete |
      | Sedans             |
      | SUVs               |
      | Sports Cars        |

  Scenario Outline: View details of a specific product category
    Given the admin is on the product categories page
    When the admin selects a specific category
    Then the admin should see detailed information about the selected category
    And should see a list of products associated with the category

    Examples:
      | selected_category |
      | Sedans            |
      | SUVs              |
      | Sports Cars       |

