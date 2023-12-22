Feature: Customer View Order History for Car Company
  Description: Customers should be able to view their order history on the car company's website.

  Background:
    Given the following products are available for purchase:
      | product_name       | model          | price  | category         |
      | Tesla Model S       | Model S         | 80000  | Electric Vehicles|
      | Ford Explorer       | Explorer        | 45000  | SUVs             |
      | BMW X5              | X5              | 60000  | SUVs             |

    And the customer has made the following purchases:
      | purchased_product  | purchase_date |
      | Tesla Model S      | 2023-05-01    |
      | Ford Explorer      | 2023-05-10    |
      | BMW X5             | 2023-06-05    |

  Scenario Outline: Customer views their order history
    Given the customer is logged into their account
    When the customer navigates to the order history page
    Then the customer should see a list of their past orders

    Examples:
      | order_number | purchased_product | purchase_date | total_price |
      | #12345       | Tesla Model S     | 2023-05-01    | 80000       |
      | #12346       | Ford Explorer     | 2023-05-10    | 45000       |
      | #12347       | BMW X5            | 2023-06-05    | 60000       |
