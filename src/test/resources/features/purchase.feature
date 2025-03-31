Feature: Purchase

  Scenario: Purchase
    When I fill login with valid credentials
    Then The inventory page is displayed
    When I select the item with the lower price
    And I click on checkout button
    And I fill the checkout information
    Then I finish the checkout information

