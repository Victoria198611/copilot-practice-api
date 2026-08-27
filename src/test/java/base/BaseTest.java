package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest sets up the common configuration for all API tests.
 *
 * It initializes the RestAssured baseURI and loads the API key
 * from the configuration file, so individual test classes remain clean.
 */
public class BaseTest {
    protected String apiKey;

    @BeforeClass
    public void setUp() {
        // Set the base URI for RestAssured
        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";

        // Load the API key from configuration (e.g., environment variable or config file)
        apiKey = System.getenv("OPENWEATHER_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("API key is not set. Please set the OPENWEATHER_API_KEY environment variable.");
        }
    }
}

