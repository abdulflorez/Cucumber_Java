@login
Feature: Webdriver University - Login feature
  Scenario: User logs in with valid credentials
    Given I access the webdriver university login page
    When I enter username webdriver
    And I enter password webdriver123
    And I click on the login button
    Then I should be presented with the corresponding login message "validation succeeded"

  Scenario: User logs in with invalid credentials
    Given I access the webdriver university login page
    When I enter username WrongUsername
    And I enter password WrongPassword
    And I click on the login button
    Then I should be presented with the corresponding login message "validation failed"