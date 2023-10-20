Feature: signup

  Scenario: Successful sign-up
    Given I have chosen to sign up
    When I sign up with valid details
    Then I should receive a confirmation email
    And I should see a personalized greeting message

  Scenario: Duplicate email
    Given I have chosen to sign up
    When I sign up with an email address that has already registered
    Then I should be told that the