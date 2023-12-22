Feature: Customer Ratings and Reviews for Car Company Products
  Description: Customers should be able to provide ratings and reviews for products on the car company's website.

  Background:
    Given the following products are available:
      | product_name       | model          | price  | category         |
      | Tesla Model S       | Model S         | 80000  | Electric Vehicles|
      | Ford Explorer       | Explorer        | 45000  | SUVs             |
      | BMW X5              | X5              | 60000  | SUVs             |

  Scenario Outline: Customer views product details
    Given the customer is browsing product listings
    When the customer selects a specific product
    Then the customer should see detailed information about the selected product

    Examples:
      | selected_product_name |
      | Tesla Model S         |
      | Ford Explorer         |
      | BMW X5                |

  Scenario Outline: Customer provides a rating and review for a product
    Given the customer is on the product details page
    When the customer rates the product with a numerical score
    And writes a review in the text box
    And clicks the submit button
    Then the customer's rating and review should be recorded successfully
    And the overall product rating should be updated
    And the customer should see a confirmation message

    Examples:
      | selected_product_name | rating | review_text                        |
      | Tesla Model S         | 5      | "This car is amazing! I love it."  |
      | Ford Explorer         | 4      | "Great SUV for family adventures." |
      | BMW X5                | 4.5    | "Excellent performance and style." |

  Scenario Outline: Customer updates their rating and review for a product
    Given the customer has previously rated and reviewed a product
    When the customer revisits the product details page
    And updates their rating to a new score
    And edits their review
    And clicks the update button
    Then the customer's rating and review should be updated successfully
    And the overall product rating should be adjusted
    And the customer should see an update confirmation message

    Examples:
      | selected_product_name | current_rating | new_rating | updated_review_text                     |
      | Tesla Model S         | 5              | 4.8        | "Still love it, but with a few tweaks." |
      | Ford Explorer         | 4              | 3.5        | "Family-friendly, but not perfect."     |
      | BMW X5                | 4.5            | 4.7        | "Impressive improvements over time."    |
