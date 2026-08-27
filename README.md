Copilot Practice API

## Project Overview
This is a simple API testing project built as part of my QA Automation learning path. The project focuses on testing the OpenWeatherMap /weather endpoint using Java, RestAssured, and TestNG. The goal is to demonstrate core API testing skills suitable for a Junior QA Automation Engineer role.

Technologies Used
•	Java 17
•	RestAssured
•	TestNG
•	Maven
•	Allure Reporting

## What the Project Tests
The project includes both positive and negative API test scenarios.

## Positive Tests
•	Valid city request — verify status code 200 and correct name field
•	Weather description validation — ensure weather[0].description is non null
•	City ID validation — ensure id field is non null

## Negative Tests
•	Invalid city → expect 404
•	Missing API key → expect 401
•	Invalid API key → expect 401
•	Invalid endpoint → expect 404
These tests validate status codes and JSON response fields to ensure correct API behavior.

## Project Structure
Cod
src/test/java/
├── base/          # Base test configuration (baseURI, API key)
├── endpoints/     # Optional endpoint helper classes
└── tests/         # Positive and negative test classes

## CI/CD (GitHub Actions)
This project includes a simple CI/CD pipeline using GitHub Actions. The workflow automatically runs all API tests on every push or pull request to the main branch.
The pipeline uses:
•	Ubuntu runner
•	Java 17 (Temurin)
•	Maven for test execution
This setup demonstrates basic CI/CD skills suitable for a Junior QA Automation Engineer.

## Allure Report Integration
This project includes Allure reporting for all REST API tests.
Each test generates:
•	Detailed steps using Allure.step()
•	Response body attachments using Allure.addAttachment()
•	Clean RestAssured chain style extraction (.then().extract().body().asPrettyString())
•	Metadata annotations such as Epic, Feature, Story, and Description

## Generate and open the Allure report:
Cod
mvn clean test
mvn allure:serve
Allure results are stored in:
Cod
target/allure-results/

## How to Run the Tests
Run all tests:
Cod
mvn clean test
Generate and open the Allure report:
Cod
mvn allure:serve

## Notes
•	This project is intentionally simple and focused on one endpoint, making it ideal for a Junior QA Automation portfolio.
•	All tests use real OpenWeather API responses.
•	Tests follow RestAssured chain only style, with Allure steps and clean extraction.
•
## Purpose
To demonstrate:
•	API testing fundamentals
•	Request/response validation
•	Positive & negative testing
•	Use of RestAssured + TestNG
•	Reporting with Allure
•	CI/CD integration with GitHub Actions