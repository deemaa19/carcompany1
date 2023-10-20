Feature:login
  the user can be Admin or Customer or installer when he chose to login then
  he should enter the correct email & password to be on log in page

  Scenario Outline: login success or fail
    Given that the user is not logged in
    When the user  enter email "<email>"
    And the enter password "<password>"
    And the rul is "<rul>"
    Then the message will be display "<result>"
    And  the user move to the "<page>"

    Examples:
      | email                | password       | rul      | result                 | page         |
      | adminClean@gmail.com | adminCSS       | admin    | Admin login success    | adminPage    |
      | alaa@gmail.com       | alaa20         | customer | Customer login success | customerPage |
      | deem@gmail.com       |deem27         | installer | installer login success | installerPage |
      | another email        | wrong password | none     | login fail             | LoginPage    |

  Scenario: Successful log out
    Given that the user is logged out
    Then the user log out succeeds