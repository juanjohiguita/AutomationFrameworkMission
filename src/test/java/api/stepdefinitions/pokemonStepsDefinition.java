package api.stepdefinitions;

import api.models.PokemonListResponse;
import api.models.Request;
import api.models.Response;
import api.questions.pokemonQuestions;
import api.tasks.pokemonTasks;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static api.questions.pokemonQuestions.createBaseRequest;
import static api.questions.pokemonQuestions.getPokemonByName;
import static core.utils.TestContextManager.getTestContext;

public class pokemonStepsDefinition {
    pokemonTasks pokemonTasks = new pokemonTasks();
    pokemonQuestions pokemonQuestions = new pokemonQuestions();


    @Given("the Pokémon name is {string}")
    public void thePokemonNameIs(String pokemonName) {
        getTestContext().set("pokemonName", pokemonName);
    }

    @When("I make a GET request")
    public void iMakeAGETRequestTo() {
        String pokemonName = getTestContext().get("pokemonName");
        getTestContext().set("pokemonResponse", getPokemonByName(pokemonName));
    }

    @Then("the response should have a status code of {int}")
    public void theResponseShouldHaveAStatusCodeOf(int statusCodeExpected) {
        pokemonQuestions.theResponseShouldHaveAStatusCodeOf(statusCodeExpected);
    }

    public static PokemonListResponse.Pokemon findPokemonByName(String pokemonName) {
        Response response = getTestContext().get("pokemonResponse");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PokemonListResponse.Pokemon pokemon = objectMapper.readValue(response.getBody().asString(), PokemonListResponse.Pokemon.class);
            return pokemon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @And("the response should contain the name {string}")
    public void theResponseShouldContainTheName(String inputPokemon) {
        pokemonQuestions.theResponseShouldContainTheName(inputPokemon);
    }
}
