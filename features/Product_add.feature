Feature: Product_add

  Description:you can add if the admin login


  Scenario Outline: add product successfully
    Given that the admin is logged in
    And there is a product with name "Steering" , type "internal" , and the price "20", amount "2"
    When the meal is added to the menu
    Then the meal with name "Steering" ,type "internal" , and the price "20", amount "2" inside the listing
    Examples: Add Product Successfully
      | admin_status | product_name | product_type | product_price | product_amount |
      | logged_in    | Steering     | internal     | 20            | 2              |
      | logged_in    | Tires        | external     | 50            | 4              |
      | logged_in    | Brakes       | internal     | 30            | 3              |


  Scenario Outline: add product and admin is not logged in
    Given that the admin is not logged in
    And there is a meal with name "Steering" , type "internal" , and the price "20", amount "2"
    When the meal is added to the menu
    Then the error message "cant add because admin is not log in" is given
    Examples: Add Product - Admin Not Logged In
      | admin_status  | product_name | product_type | product_price | product_amount | error_message                              |
      | not_logged_in | Steering     | internal     | 20            | 2              | "Can't add because admin is not logged in" |
      | not_logged_in | Lights       | external     | 15            | 5              | "Can't add because admin is not logged in" |
      | not_logged_in | Battery      | internal     | 40            | 1              | "Can't add because admin is not logged in" |