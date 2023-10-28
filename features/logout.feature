Feature: Admin logout
  Description: The admin logs out from resturant app
  Actor: Admin

  Scenario: Admin logs out
    Given that the admin is loged in
    When the admin logs out
    Then the admin is  logged out