Feature: add appointment
  You can reserve a product

  Scenario: add appointment successfully
    Given that the user is logged in
    And the product not reseved
    When add appointment
    Then the product reserved by user


  Scenario: failed because user not log in
    Given that the user is not logged in
    And the product not reseved
    When add appointment
    Then the message "cant because user not log in" is given



  Scenario: no product found
    Given that the user is logged in
    And the product  reseved
    When add appointment
    Then the message "No product found" is given