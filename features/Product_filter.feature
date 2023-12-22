Feature: Product Filter for Car Company
  Description: Users and admins should be able to use filters to view specific products on the car company's website.

  Background:
    Given the user is on the product listing page

  Scenario Outline: User filters products by category
    When the user applies a filter to view products in a specific category
    Then the user should see a list of products in that category
    And each product should display its name, description, and price

    Examples:
      | filter_category   | expected_products_in_category                          |
      | Steering System   | Steering Wheel - High-quality steering wheel - $150    |
      | Brake System      | Brake Pad Set - Performance brake pad set - $50        |
      | Electrical System | Spark Plug Kit - High-performance spark plug kit - $30 |
      | Tire and Wheel    | All-Season Tires - Durable all-season tires - $120     |

  Scenario Outline: Admin filters products by price range
    Given the admin is on the product listing page
    When the admin applies a filter to view products in a specific price range
    Then the admin should see a list of products within that price range
    And each product should display its name, description, and price

    Examples:
      | filter_price_range | expected_products_in_price_range                       |
      | $50 - $100         | Brake Pad Set - Performance brake pad set - $50        |
      | $100 - $200        | Steering Wheel - High-quality steering wheel - $150    |
      | $30 - $60          | Spark Plug Kit - High-performance spark plug kit - $30 |
      | $120 - $200        | All-Season Tires - Durable all-season tires - $120     |

  Scenario Outline: User filters products by keyword search
    When the user enters a keyword in the search bar to filter products
    Then the user should see a list of products containing the keyword
    And each product should display its name, description, and price

    Examples:
      | keyword_search | expected_products_with_keyword                         |
      | Brake          | Brake Pad Set - Performance brake pad set - $50        |
      | Spark Plug     | Spark Plug Kit - High-performance spark plug kit - $30 |
      | Tires          | All-Season Tires - Durable all-season tires - $120     |
      | Wheel          | Steering Wheel - High-quality steering wheel - $150    |

  Scenario Outline: Admin filters products by availability
    Given the admin is on the product listing page
    When the admin applies a filter to view available products
    Then the admin should see a list of available products
    And each product should display its name, description, and price

    Examples:
      | filter_availability | expected_available_products                            |
      | Available           | Steering Wheel - High-quality steering wheel - $150    |
      | Available           | Brake Pad Set - Performance brake pad set - $50        |
      | Available           | Spark Plug Kit - High-performance spark plug kit - $30 |
      | Available           | All-Season Tires - Durable all-season tires - $120     |
