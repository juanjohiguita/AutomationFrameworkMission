Feature: Search for Pokémon by name

  As a user of the Pokémon API
  I want to search for a Pokémon using its name
  To obtain information about the Pokémon
  @this
  Scenario: Search for an existing Pokémon by its name
    Given the Pokémon name is "charmander"
    When I make a GET request
    Then the response should have a status code of 200
    And the response should contain the name "charmander"