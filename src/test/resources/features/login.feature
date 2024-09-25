@login
Feature: Webdriver University - Login feature

  Background:
    Given I access the webdriver university login page

  Scenario: User logs in with valid credentials
    When I enter username webdriver
    And I enter password webdriver123
    And I click on the login button
    Then I should be presented with the corresponding login message "validation succeeded"

  Scenario: User logs in with invalid credentials
    When I enter username WrongUsername
    And I enter password WrongPassword
    And I click on the login button
    Then I should be presented with the corresponding login message "validation failed"

  Scenario Outline: Validate Successful and Unsuccessful Login
    When I enter username <username>
    And I enter password <password>
    And I click on the login button
    Then I should be presented with the corresponding login message "<loginValidationText>"

    Examples:
      | username      | password      | loginValidationText  |
      | webdriver     | webdriver123  | validation succeeded |
      | WrongUsername | WrongPassword | validation failed    |