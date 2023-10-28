Feature: addproduct

  Description:you can add if the admin login


  Scenario: add product successfully
    Given that the admin is logged in
    And there is a product with name "Steering" , type "internal" , and the price "20", amount "2"
    When the meal is added to the menu
    Then the meal with name "Steering" ,type "internal" , and the price "20", amount "2" inside the listing


  Scenario: add product and admin is not logged in
    Given that the admin is not logged in
    And there is a meal with name "Steering" , type "internal" , and the price "20", amount "2"
    When the meal is added to the menu
    Then the error message "cant add because admin is not log in" is given




