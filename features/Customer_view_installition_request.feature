Feature: Customer View Installation Request for Car Company
  Description: Customers should be able to view installation requests for products they have purchased.

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

  Scenario Outline: Customer views installation requests for purchased products
    Given the customer is logged into their account
    When the customer navigates to the installation requests page
    Then the customer should see a list of installation requests for their purchased products

    Examples:
      | purchased_product | installation_status | request_date | appointment_date | appointment_time |
      | Tesla Model S     | Pending             | 2023-05-02   | -                | -                |
      | Ford Explorer     | Scheduled           | 2023-05-12   | 2023-05-15       | 14:00            |
