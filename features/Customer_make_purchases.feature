Feature: Customer Make Purchases for Car Company
  Description: Customers should be able to make purchases on the car company's website.

  Background:
    Given the following products are available:
      | product_name       | model          | price  | category         |
      | Tesla Model S       | Model S         | 80000  | Electric Vehicles|
      | Ford Explorer       | Explorer        | 45000  | SUVs             |
      | BMW X5              | X5              | 60000  | SUVs             |

  Scenario Outline: Customer adds products to the shopping cart
    Given the customer is logged into their account
    When the customer adds products to the shopping cart
    And the customer views the shopping cart
    Then the customer should see the added products
    And should see the total price

    Examples:
      | selected_products            |
      | Tesla Model S, Ford Explorer |
      | BMW X5, Ford Explorer        |
      | Tesla Model S, BMW X5        |

  Scenario: Customer proceeds to checkout
    Given the customer is on the shopping cart page
    When the customer clicks the checkout button
    Then the customer should be directed to the checkout page
    And should see a summary of the selected products and the total price

  Scenario Outline: Customer provides shipping information
    Given the customer is on the checkout page
    When the customer provides shipping information
    And clicks the next button
    Then the customer should proceed to the payment section

    Examples:
      | shipping_address | city         | zip_code |
      | 123 Main St      | Car City     | 12345    |
      | 456 Oak Ave      | Auto Town    | 56789    |
      | 789 Pine Blvd    | Vehicleville | 10111    |

  Scenario Outline: Customer provides payment information
    Given the customer is on the payment section
    When the customer provides payment information
    And clicks the complete purchase button
    Then the customer should see a purchase confirmation message
    And should receive a confirmation email
    And the purchased products should be removed from the inventory

    Examples:
      | payment_method   | card_number         | expiration_date | cvv |
      | Visa             | 1234 5678 9101 1121 | 12/24           | 123 |
      | MasterCard       | 5678 9012 3456 7890 | 06/23           | 456 |
      | American Express | 9876 5432 1098 7654 | 09/25           | 789 |
