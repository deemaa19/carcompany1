Feature: Customer Browse Products for Car Company
  Description: Customers should be able to browse and view product listings on the car company's website.

  Scenario: Customer views a list of product categories
    Given the customer is on the car company website
    When the customer navigates to the product categories page
    Then the customer should see a list of available product categories

  Scenario Outline: Customer browses product listings within a category
    Given the customer is on the product categories page
    When the customer selects a specific product category
    Then the customer should see a list of product listings within that category
    And each product listing should display details such as product name, model, and price

    Examples:
      | selected_category |
      | Luxury Sedans     |
      | SUVs              |
      | Electric Vehicles |

  Scenario Outline: Customer views details of a specific product
    Given the customer is on the product listings page
    When the customer selects a specific product
    Then the customer should see detailed information about the selected product
    And should see information such as specifications, features, and availability

    Examples:
      | selected_product_name |
      | Tesla Model S         |
      | Ford Explorer         |
      | BMW X5                |

  Scenario Outline: Customer searches for a specific product
    Given the customer is on the car company website
    When the customer uses the search functionality to find a product
    Then the customer should see a list of search results
    And should be able to click on a search result to view detailed product information

    Examples:
      | search_query |
      | Model S      |
      | Explorer     |
      | X5           |

  Scenario Outline: Customer filters products based on criteria
    Given the customer is on the product listings page
    When the customer applies filters such as price range and category
    Then the customer should see a filtered list of products
    And the filtered list should match the specified criteria

    Examples:
      | price_range     | selected_category |
      | $40,000-$60,000 | SUVs              |
      | $60,000-$80,000 | Luxury Sedans     |
      | $80,000 and up  | Electric Vehicles |
