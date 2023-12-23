Feature: Admin-login
  Background:
    Given the login page is open

  Scenario: Successful Admin Login
    When I submit user name "sara" and password "111" and should enter to admin page
    Then I should be logged in to admin page
