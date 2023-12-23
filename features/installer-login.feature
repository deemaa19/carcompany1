Feature: installer-login
  Background:
    Given the login page is open
  Scenario: Successful Installer Login
    When I submit user name "deema" and password"2369" and should enter to installer page
    Then I should be logged in to installer page