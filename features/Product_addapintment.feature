Feature: add appointment
  You can reserve a product

  Scenario Outline: add appointment successfully
    Given that the user is logged in
    And the product not reseved
    When add appointment
    Then the product reserved by user
    Examples: Add Appointment Successfully
      | user_status | product_status | reservation_status | success_message                  |
      | logged_in   | not_reserved   | not_reserved       | "Product reserved by user"       |
      | logged_in   | not_reserved   | not_reserved       | "Product reserved successfully"  |
      | logged_in   | not_reserved   | not_reserved       | "Appointment added successfully" |

  Scenario Outline: failed because user not log in
    Given that the user is not logged in
    And the product not reseved
    When add appointment
    Then the message "cant because user not log in" is given
    Examples: Failed Add Appointment - User Not Logged In
      | user_status   | product_status | reservation_status | error_message                               |
      | not_logged_in | not_reserved   | not_reserved       | "Can't add appointment, user not logged in" |
      | not_logged_in | not_reserved   | not_reserved       | "Please log in to reserve a product"        |
      | not_logged_in | not_reserved   | not_reserved       | "User authentication required"              |


  Scenario Outline: no product found
    Given that the user is logged in
    And the product  reseved
    When add appointment
    Then the message "No product found" is given
    Examples: No Product Found
      | user_status | product_status | reservation_status | error_message                             |
      | logged_in   | reserved       | reserved           | "Can't add appointment, no product found" |
      | logged_in   | reserved       | reserved           | "Product is already reserved"             |
      | logged_in   | reserved       | reserved           | "Product not available for appointment"   |
