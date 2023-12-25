Feature: log_in

  Scenario: Login as admin
    Given admin is not logged in
    When Admin eemail is "sara@najah"
    And Admin ppassword is "555"
    Then the admin login

  Scenario: Login as Customer
    Given customer is not logged in
    When Customer eemail is "yara@najah"
    And Customer ppassword is "555"
    Then the customer login

  Scenario: Login as Installer
    Given installer is not logged in
    When Installer eemail is "tala@najah"
    And Installer ppassword is "555"
    Then the installer login
