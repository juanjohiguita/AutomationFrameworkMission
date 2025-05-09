package api.questions;

import api.models.PokemonListResponse;
import api.models.Request;
import api.models.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

import static core.utils.TestContextManager.getTestContext;

public class pokemonQuestions {

    public void theResponseShouldHaveAStatusCodeOf(int statusCodeExpected) {
        String pokemonName = getTestContext().get("pokemonName");
        Response response = getPokemonByName(pokemonName);
        Assert.assertEquals(response.getResponse().statusCode(), statusCodeExpected);
    }

    public void theResponseShouldContainTheName(String inputPokemon) {
        PokemonListResponse.Pokemon pokemon = findPokemonByName();
        assert Objects.requireNonNull(pokemon).getName().equalsIgnoreCase(inputPokemon);
        Allure.addAttachment("pokemonName", pokemon.getName());
    }

    public static PokemonListResponse.Pokemon findPokemonByName() {
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

    public static List<PokemonListResponse.Pokemon> findAllPokemones() {
        Response response = getAllPokemones();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PokemonListResponse pokemonListResponse = objectMapper.readValue(response.getBody().asString(), PokemonListResponse.class);
            return pokemonListResponse.getResults();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Request createBaseRequest() {
        return new Request()
                .baseUri(RestAssured.baseURI = "https://pokeapi.co/api/v2/")
                .contentType(ContentType.JSON);
    }

    @Step("GET - https://pokeapi.co/api/v2/")
    protected static Response getAllPokemones() {
        Request request = createBaseRequest();
        return request.get("pokemon/");
    }

    @Step("GET - https://pokeapi.co/api/v2/")
    public static Response getPokemonByName(String pokemonName) {
        Request request = createBaseRequest();
        return request.get("pokemon/" + pokemonName);
    }
}
