Feature: customer-login
  Background:
    Given the login page is open

   Scenario: Successful customer Login
   When I submit user name"subhiah" and password "000" and should enter to customer page
   Then I should be logged in to customer page
