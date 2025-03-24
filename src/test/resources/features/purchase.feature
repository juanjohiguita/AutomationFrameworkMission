Feature: Purchase

  @this
  Scenario: Purchase
    When I fill login with valid credentials
    Then The inventory page is displayed
    When I select the item with the lower price
    Then I click on checkout button
    Then I fill the checkout information
    When I finish the checkout information

