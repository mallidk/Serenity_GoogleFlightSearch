# Serenity Google Flight Search

A project to automate the searching for round-trip and Multi-city trip flights on Google Flights using Serenity, Cucumber, and the Screenplay pattern.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Tests](#running-the-tests)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project automates the process of searching for round-trip and Multi-city trip flights on Google Flights using the Serenity framework along with Cucumber for BDD and the Screenplay pattern for a clear, maintainable approach to test automation.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 8 or higher
- Maven 3.6 or higher
- An IDE (such as IntelliJ IDEA or Eclipse)
- Google Chrome and ChromeDriver

## Installation

Follow these steps to set up the project:

1. **Clone the repository**:
    ```sh
    git clone https://github.com/mallidk/Serenity_GoogleFlightSearch
    cd Serenity_GoogleFlightSearch
    ```

2. **Install dependencies**:
    ```sh
    mvn clean install
    ```

## Running the Tests

To execute the tests, you can use the following Maven command:

```sh
mvn clean verify
___________________________________________________________________________________________
Key Files and Directories
src/test/resources/features: Contains the Cucumber feature files.
src/test/java/starter: Contains the implementation of the Screenplay tasks and page objects.
src/test/java/stepdefinitions: Contains the step definition classes for Cucumber.
pom.xml: Maven configuration file, managing dependencies and build settings.
__________________________________________________________________________________________________
GoogleFlightSearch.feature
Feature: Google flight search

  Background: User starts from the Google Flights search website
    Given Sally is on the Google Flights search website

  @roundtrip
  Scenario Outline: Sally searches for a round trip
    When Sally searches for round trip flight
      | Origin        | Destination   | Departure Day | Return Day   |
      | <origin>      | <destination> | <departureDay> | <returnDay> |
    Then Sally should see flights results page with "Best departing flights"
    When Sally selects the first flight under best flights
    Then Sally should see flights results page with "Returning flights"
    When Sally selects the first flight under best flights
    Then Sally should see flights results page with "Booking options"
    And Sally should see the corresponding flight information for flights selected

    Examples:
      | origin    | destination | departureDay  | returnDay    |
      | Sydney    | New York    | 10 days later | 30 days later |
      | Singapore | Sydney      | 7 days later  | 21 days later |

  @multicity
  Scenario Outline: Sally searches for a multi-city trip
    When Sally searches for multi-city flight
      | Origin          | Destination 1   | Departure Day 1 | Destination 2   | Departure Day 2 | Destination 3   | Departure Day 3 |
      | <origin>        | <destination1> | <departureDay1> | <destination2> | <departureDay2> | <destination3> | <departureDay3> |
    Then Sally should see flights results page with "Best flights to <destination1>"
    When Sally selects the first flight under best flights
    Then Sally should see flights results page with "Best flights to <destination2>"
    When Sally selects the first flight under best flights
    Then Sally should see flights results page with "Best flights to <destination3>"
    When Sally selects the first flight under best flights
    Then Sally should see the corresponding flight information for flights selected
    Examples:
      | origin | destination1 | departureDay1 | destination2 | departureDay2 | destination3 | departureDay3 |
      | Sydney | Singapore    | 7 days later  | New York     | 14 days later | Los Angeles  | 28 days later |

  ___________________________________________________________________________________________________________________________________________________
Contributing
To contribute to this project, follow these steps:

Fork this repository.
Create a branch: git checkout -b feature/your-feature-name.
Make your changes and commit them: git commit -m 'Add some feature'.
Push to the original branch: git push origin feature/your-feature-name.
Create a pull request.


### Explanation of the Sections

1. **Introduction**: Provides a brief description of the project and its purpose.
2. **Prerequisites**: Lists the tools and environments required to run the project.
3. **Installation**: Step-by-step instructions to set up the project locally.
4. **Running the Tests**: Instructions to run the tests and where to find the test reports.
5. **Project Structure**: Overview of the directory structure, key files, and their purposes.
6. **Example Feature File**: Example of a Cucumber feature file used in the project.
7. **Contributing**: Guidelines for contributing to the project.

This `README.md` should provide a comprehensive guide for anyone looking to understand, set up, and contribute to your Serenity Google Flight Search project.
