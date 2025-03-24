Feature: Search for Pokémon by name

  As a user of the Pokémon API
  I want to search for a Pokémon using its name
  To obtain information about the Pokémon

  Scenario: Search for an existing Pokémon by its name
    Given the Pokémon name is "charmander"
    When I make a GET request to "https://pokeapi.co/api/v2/pokemon/charmander/"
    Then the response should have a status code of 200
    And the response should contain the name "charmander"

  Scenario: Search for an existing Pokémon by its name in uppercase
    Given the Pokémon name is "CHARMANDER"
    When I make a GET request to "https://pokeapi.co/api/v2/pokemon/CHARMANDER/"
    Then the response should have a status code of 200
    And the response should contain the name "charmander"

  Scenario: Search for a non-existent Pokémon
    Given the Pokémon name is "non_existent_pokemon"
    When I make a GET request to "https://pokeapi.co/api/v2/pokemon/non_existent_pokemon/"
    Then the response should have a status code of 404