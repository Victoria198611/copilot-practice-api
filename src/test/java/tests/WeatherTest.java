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
import static org.hamcrest.Matchers.notNullValue;

// Agent instruction:
// Generate REST API tests using RestAssured chain style only (no Response objects).
// Add Allure.step() for each action and Allure.addAttachment() using extracted response body.
// Extract response body with .then().extract().body().asPrettyString().
// Keep tests simple and clean, without enterprise patterns.
// Use TestNG @Test and validate status codes and JSON fields.


public class WeatherTest extends BaseTest {

    @Epic("Weather API Tests")
    @Feature("Weather Data Retrieval")
    @Story("Retrieve weather data for a valid city")
    @Description("This test retrieves the weather data for a valid city and validates the response.")
    @Test
    public void testGetWeatherForValidCity() {
        String city = "London";

        Allure.step("Sending GET request to retrieve weather data for city: " + city);
        String responseBody = given()
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .body("name", equalTo(city))
                .extract()
                .body()
                .asPrettyString();

        Allure.addAttachment("Response Body", responseBody);
    }

// TestNG test: send GET request to /weather with a valid city, expect status code 200 and non-null weather description.
    @Epic("Weather API Tests")
    @Feature("Weather Data Retrieval")
    @Story("Retrieve weather data and validate weather description")
    @Description("This test retrieves the weather data for a valid city and validates that the weather description is not null.")
    @Test
    public void testGetWeatherDescriptionForValidCity() {
        String city = "New York";

        Allure.step("Sending GET request to retrieve weather data for city: " + city);
        String responseBody = given()
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .body("weather[0].description", notNullValue()) // Validate that the weather description is not null
                .extract()
                .body()
                .asPrettyString();

        Allure.addAttachment("Response Body", responseBody);
    }

// TestNG test: send GET request to /weather with a valid city, expect status code 200 and valid non-null latitude and longitude fields.
    @Epic("Weather API Tests")
    @Feature("Weather Data Retrieval")
    @Story("Retrieve weather data and validate coordinates")
    @Description("This test retrieves the weather data for a valid city and validates that the latitude and longitude fields are not null.")
    @Test
    public void testGetWeatherCoordinatesForValidCity() {
        String city = "Tokyo";

        Allure.step("Sending GET request to retrieve weather data for city: " + city);
        String responseBody = given()
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .body("coord.lat", notNullValue()) // Validate that the latitude is not null
                .body("coord.lon", notNullValue()) // Validate that the longitude is not null
                .extract()
                .body()
                .asPrettyString();

        Allure.addAttachment("Response Body", responseBody);
    }
}