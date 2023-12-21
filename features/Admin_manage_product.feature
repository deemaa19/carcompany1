Feature: Admin Manage Products for Car Company
  Description: Admins in a car company should be able to manage products effectively.

  Scenario: View list of products
    Given the admin is logged in
    When the admin navigates to the product management section
    Then the admin should see a list of existing products
    And should see details such as product name, model, price, and category

  Scenario Outline: Add a new product
    Given the admin is on the product management page
    When the admin selects to add a new product
    And enters the product details
    And clicks the save button
    Then the new product should be added successfully
    And the admin should see a success message

    Examples:
      | product_name | model    | price  | category    |
      | BMW 3 Series | 3 Series | 45000  | Sedans      |
      | Toyota RAV4  | RAV4     | 35000  | SUVs        |
      | Porsche 911  | 911      | 100000 | Sports Cars |

  Scenario Outline: Edit an existing product
    Given the admin is on the product management page
    When the admin selects an existing product to edit
    And modifies the product details
    And clicks the save button
    Then the product should be updated successfully
    And the admin should see a success message

    Examples:
      | existing_product_name | new_model       | new_price | new_category |
      | BMW 3 Series          | 3 Series Luxury | 50000     | Sedans       |
      | Toyota RAV4           | RAV4 Limited    | 38000     | SUVs         |
      | Porsche 911           | 911 Turbo S     | 120000    | Sports Cars  |


  Scenario Outline: View details of a specific product
    Given the admin is on the product management page
    When the admin selects a specific product
    Then the admin should see detailed information about the selected product
    And should see information such as specifications, features, and availability

    Examples:
      | selected_product_name |
      | BMW 3 Series          |
      | Toyota RAV4           |
      | Porsche 911           |