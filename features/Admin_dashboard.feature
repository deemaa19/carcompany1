Feature: Admin Dashboard for Car Company
  Description: Admins in a car company should be able to manage various aspects of the business.

  Scenario Outline: Manage product categories
    Given the admin is logged in
    When the admin navigates to the product categories management section
    Then the admin should be able to add a new product category
    And should be able to edit an existing product category
    And should be able to delete an existing product category

    Examples:
      | category_name     | description                        |
      | Luxury Sedans     | Premium four-door passenger cars   |
      | SUVs              | Sport Utility Vehicles             |
      | Electric Vehicles | Environment-friendly electric cars |

  Scenario Outline: Add and update product listings
    Given the admin is logged in
    When the admin navigates to the product listings management section
    Then the admin should be able to add a new product listing
    And should be able to update an existing product listing

    Examples:
      | product_name  | model    | price | category          |
      | Tesla Model S | Model S  | 80000 | Electric Vehicles |
      | Ford Explorer | Explorer | 45000 | SUVs              |
      | BMW X5        | X5       | 60000 | SUVs              |

  Scenario Outline: View and manage customer accounts
    Given the admin is logged in
    When the admin navigates to the customer accounts section
    Then the admin should be able to view a list of customer accounts
    And should be able to view details of a specific customer account
    And should be able to deactivate a customer account

    Examples:
      | customer_username | customer_email             | status   |
      | carlover123       | carlover@example.com       | active   |
      | autoenthusiast456 | autoenthusiast@example.com | active   |
      | driver789         | driver@example.com         | inactive |

  Scenario Outline: Schedule and manage installation appointments
    Given the admin is logged in
    When the admin navigates to the installation appointments section
    Then the admin should be able to schedule a new installation appointment
    And should be able to update an existing installation appointment
    And should be able to cancel an installation appointment

    Examples:
      | customer_username | appointment_date | appointment_time | status      |
      | carlover123       | 2023-05-10       | 14:00            | scheduled   |
      | autoenthusiast456 | 2023-05-15       | 10:30            | in_progress |
      | driver789         | 2023-05-20       | 13:45            | completed   |


  Scenario: Admin logs out
    Given the admin is on the admin dashboard
    When the admin clicks the logout button
    Then the admin should be logged out successfully
    And redirected to the login page

