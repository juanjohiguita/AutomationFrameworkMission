package api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import api.PokemonListResponse;
import api.Request;
import api.Response;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class APITest {

    @BeforeClass
    public void setup() {
    }

    /*
    @Test
    public void getAllPokemonList() {
        List<PokemonListResponse.Pokemon> pokemonList = findAllPokemones();
    }
     */

    //@Test
    public void getPokemon() {
        String pokemonName = "ditto";
        PokemonListResponse.Pokemon pokemon = findPokemonByName(pokemonName);
    }

    protected static Request createBaseRequest() {
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
    protected static Response getPokemonByName(String pokemonName) {
        Request request = createBaseRequest();
        return request.get("pokemon/" + pokemonName);
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

    public static PokemonListResponse.Pokemon findPokemonByName(String pokemonName) {
        Response response = getPokemonByName(pokemonName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PokemonListResponse.Pokemon pokemon = objectMapper.readValue(response.getBody().asString(), PokemonListResponse.Pokemon.class);
            return pokemon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
