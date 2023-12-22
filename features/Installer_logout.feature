Feature: Installer Logout for Car Company
  Description: Installers should be able to log out from their accounts on the car company's website.

  Background:
    Given the installer is logged into their account

  Scenario: Installer logs out
    When the installer clicks the logout button
    Then the installer should be logged out successfully
    And should be redirected to the login page
    And should see a logout confirmation message
