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
