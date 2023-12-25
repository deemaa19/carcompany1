Feature: signs_up

  Scenario: user sign up
    Given that the user is not signed up
    When  email is "deema@najah"
    And password is "111"
    And username is "deema"
    And type is "customer"
    Then the user will sign up and added to userslist

  Scenario: user failed sign up
    Given that the user2 is not signed up
    When  email2 is "besan@najah"
    And password2 is "222"
    And username2 is "besan"
    And type2 is "customer"
    Then the user2 will not signed up