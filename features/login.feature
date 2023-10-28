Feature: login
  Description:you can login if the username and password is true



  Scenario: login
    Given the username is "deema"
    And the password is "de123"
    Then login is done
    And welcome

  Scenario:  Wrong login wrong pass
    Given the username is "besan"
    And the password is "be133"
    Then login failed
    And sorry

  Scenario:  Wrong login wrong usernam
    Given the username is "bess"
    And the password is "ss123"
    Then login failed
    And sorry

  Scenario:  Wrong login wrong usernam and wrong pass
    Given the username is "domdom"
    And the password is "dom133"
    Then login failed
    And sorry
