Feature: Login

  Scenario: Login with valid credentials
    When I fill login with valid credentials
    Then The inventory page is displayed

  Scenario: Login with invalid credentials
    When I fill login with invalid credentials
    Then I expect a error message
