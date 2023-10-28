Feature: Search product

  Background: The menu has many product
    Given that the admin is logged in
    And these products in the menu
      | Steering | internal | 20 | 65 |
      | wheels | external | 40 | 65 |
      | air condition | electronics | 10 | 50 |
      | led | electronics |25 | 60 |
      | tiers | external | 30 | 100 |
      | brake car | internal | 30 | 50 |
      |  Battery car| internal | 10 | 65 |
      | Glass  | external | 50 | 65 |
    And the admin loggs out




  Scenario: Searching for product by name
    Given  the admin is not  logged in
    When the user search for the text "Stee"
    Then the meal with name " Steering" is found


  Scenario: Searching  when the adminis logged in
    Given that the admin is logged in
    When the user search for the text "ai"
    Then the meal with name "air condition" is found

  Scenario: No product found
    When the user search for the text "Security"
    Then no product found
    And enter the name again

  Scenario: find more than one product
    When the user search for the text "car"
    Then the product with name "Battery car" and "brake car" are found