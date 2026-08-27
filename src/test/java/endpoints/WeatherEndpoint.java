package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * WetaherEndpoint is the agent class ressponsible for
 * communicating with the OpenWeatherMap API.
 * It contains static methods that send requests to the weather endpoind
 * using RestAssured and return the full response object.
 *
 * Benifits:
 * -Keeps test classes clean and readable.
 * -Centralizes request logig in one place.
 */
public class WeatherEndpoint {
    /**
     * Retrieves the weather data for given city.
     *
     * @param city   The name of the city for which to retrieve weather data.
     * @param apiKey The API key to authenticate the request.
     * @return The response object containing the weather data.
     */
    public static Response getWeather(String city, String apiKey) {
        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";
        return RestAssured.given()
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather");
    }
/**
 * Retrieves the weather data for a given Zip Code.
    *
    @param zipCode The Zip Code for which to retrieve weather data.
    @param apiKey  The API key to authenticate the request.
    @return The response object containing the weather data.
    */
    public static Response getWeatherByZipCode(String zipCode, String apiKey) {
        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";
        return RestAssured.given()
                .queryParam("zip", zipCode)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather");
    }
    }