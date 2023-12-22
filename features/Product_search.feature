Feature: Product Search for Car Company
  Description: Users and admins should be able to search for specific products on the car company's website.

  Background:
    Given the user is on the product listing page

  Scenario Outline: User searches for a product by name
    When the user enters the name of a specific product in the search bar
    Then the user should see a list of products containing the searched name
    And each product should display its name, description, and price

    Examples:
      | search_keyword | expected_products_with_keyword                         |
      | Brake          | Brake Pad Set - Performance brake pad set - $50        |
      | Spark Plug     | Spark Plug Kit - High-performance spark plug kit - $30 |
      | Tires          | All-Season Tires - Durable all-season tires - $120     |
      | Wheel          | Steering Wheel - High-quality steering wheel - $150    |

  Scenario Outline: Admin searches for a product by category
    Given the admin is on the product listing page
    When the admin enters the name of a specific category in the search bar
    Then the admin should see a list of products in that category
    And each product should display its name, description, and price

    Examples:
      | search_category   | expected_products_in_category                          |
      | Steering System   | Steering Wheel - High-quality steering wheel - $150    |
      | Brake System      | Brake Pad Set - Performance brake pad set - $50        |
      | Electrical System | Spark Plug Kit - High-performance spark plug kit - $30 |
      | Tire and Wheel    | All-Season Tires - Durable all-season tires - $120     |

  Scenario Outline: User searches for a non-existing product
    When the user enters the name of a product that does not exist
    Then the user should see a message indicating that no products were found

    Examples:
      | search_non_existing_product | expected_message                             |
      | Non-Existent Product        | "No products found for the entered keyword." |
      | Not Available Product       | "No products found for the entered keyword." |
      | Product Not Found           | "No products found for the entered keyword." |

  Scenario Outline: Admin searches for products with a common keyword
    Given the admin is on the product listing page
    When the admin enters a common keyword in the search bar
    Then the admin should see a list of products containing the common keyword
    And each product should display its name, description, and price

    Examples:
      | common_search_keyword | expected_products_with_common_keyword                  |
      | High                  | Steering Wheel - High-quality steering wheel - $150    |
      | Performance           | Brake Pad Set - Performance brake pad set - $50        |
      | Kit                   | Spark Plug Kit - High-performance spark plug kit - $30 |
      | Durable               | All-Season Tires - Durable all-season tires - $120     |
