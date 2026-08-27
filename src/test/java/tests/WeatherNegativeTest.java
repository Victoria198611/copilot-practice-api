package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

// Agent instruction:
// Generate REST API negative tests using RestAssured chain style only (no Response objects).
// Add Allure.step() for each action and Allure.addAttachment() using extracted response body.
// Extract response body with .then().extract().body().asPrettyString().
// Keep tests simple and clean, without enterprise patterns.
// Use TestNG @Test and validate status codes + JSON error fields.

public class WeatherNegativeTest extends BaseTest {

    @Epic("Weather API Negative Tests")
    @Feature("Weather Data Retrieval")
    @Story("Retrieve weather data for an invalid city")
    @Description("This test attempts to retrieve weather data for an invalid city and validates the error response.")
    @Test
    public void testGetWeatherForInvalidCity() {
        String invalidCity = "InvalidCityName";

        Allure.step("Sending GET request to retrieve weather data for invalid city: " + invalidCity);
        String responseBody = given()
                .queryParam("q", invalidCity)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather")
                .then()
                .statusCode(404)
                .body("message", equalTo("city not found"))
                .extract()
                .body()
                .asPrettyString();

        Allure.addAttachment("Response Body", responseBody);
    }

// TestNG test: send GET request to /weather invalid API key, expect status code 401 (Unauthorized)
    @Epic("Weather API Negative Tests")
    @Feature("Weather Data Retrieval")
    @Story("Retrieve weather data with an invalid API key")
    @Description("This test attempts to retrieve weather data using an invalid API key and validates the error response.")
    @Test
    public void testGetWeatherWithInvalidApiKey() {
        String city = "London";
        String invalidApiKey = "invalid_api_key";

        Allure.step("Sending GET request to retrieve weather data for city: " + city + " with invalid API key");
        String responseBody = given()
                .queryParam("q", city)
                .queryParam("appid", invalidApiKey)
                .when()
                .get("/weather")
                .then()
                .statusCode(401)
                .body("message", equalTo("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."))
                .extract()
                .body()
                .asPrettyString();

        Allure.addAttachment("Response Body", responseBody);
    }

// TestNG test: send GET request to /weather without API key, expect status code 401 (Unauthorized)
    @Epic("Weather API Negative Tests")
    @Feature("Weather Data Retrieval")
    @Story("Retrieve weather data without an API key")
    @Description("This test attempts to retrieve weather data without providing an API key and validates the error response.")
    @Test
    public void testGetWeatherWithoutApiKey() {
        String city = "London";

        Allure.step("Sending GET request to retrieve weather data for city: " + city + " without API key");
        String responseBody = given()
                .queryParam("q", city)
                .when()
                .get("/weather")
                .then()
                .statusCode(401)
                .body("message", equalTo("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."))
                .extract()
                .body()
                .asPrettyString();

        Allure.addAttachment("Response Body", responseBody);
    }

// TestNG test: send GET request to /weather invalid zip code, expect status code 404 (City not Found)
    @Epic("Weather API Negative Tests")
    @Feature("Weather Data Retrieval")
    @Story("Retrieve weather data for an invalid zip code")
    @Description("This test attempts to retrieve weather data for an invalid zip code and validates the error response.")
    @Test
    public void testGetWeatherForInvalidZipCode() {
        String invalidZipCode = "00000";

        Allure.step("Sending GET request to retrieve weather data for invalid zip code: " + invalidZipCode);
        String responseBody = given()
                .queryParam("zip", invalidZipCode)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather")
                .then()
                .statusCode(404)
                .body("message", equalTo("city not found"))
                .extract()
                .body()
                .asPrettyString();

        Allure.addAttachment("Response Body", responseBody);
    }
}
