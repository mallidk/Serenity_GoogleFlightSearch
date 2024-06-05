package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import starter.navigation.NavigateTo;
import starter.search.GoogleFlightSearchPage;

import java.util.Map;

public class FlightSearchStepDefinitions {

    @Given("{actor} is on the Google Flights search website")
    public void sallyIsOnGoogleFlightsSearchWebsite(Actor actor) {
        actor.wasAbleTo(NavigateTo.googleFlightsSearch());
    }


    @When("{actor} searches for round trip flight")
    public void sallySearchesForRoundTripFlight(Actor actor, DataTable dataTable) {
        Map<String, String> cityData = dataTable.asMaps(String.class, String.class).get(0);

        String origin = cityData.get("Origin");
        String destination = cityData.get("Destination");
        String departureDay = cityData.get("Departure Day");
        String returnDay = cityData.get("Return Day");

        actor.attemptsTo(
                Enter.theValue(origin).into(GoogleFlightSearchPage.ORIGIN_FIELD),
                Click.on(By.xpath("(//ul/li//div[contains(text(),'"+origin+"')])[1]")),

                Enter.theValue(departureDay).into(GoogleFlightSearchPage.DEPARTURE_DAY_FIELD).thenHit(Keys.ENTER),

                Enter.theValue(destination).into(GoogleFlightSearchPage.DESTINATION_FIELD),
                Click.on(By.xpath("(//ul/li//div[contains(text(),'"+destination+"')])[1]")),

                Enter.theValue(returnDay).into(GoogleFlightSearchPage.RETURN_DAY_FIELD).thenHit(Keys.ENTER)
        );

        Serenity.setSessionVariable("origin").to(origin);
        Serenity.setSessionVariable("destination").to(destination);
        Serenity.setSessionVariable("departureDay").to(departureDay);
        Serenity.setSessionVariable("returnDay").to(returnDay);

        actor.attemptsTo(Click.on(GoogleFlightSearchPage.SEARCH_BUTTON));
    }

    @Then("{actor} should see flights results page with {string}")
    public void sallyShouldSeeFlightsResultsPageWith(Actor actor, String sectionTitle) {
        Target sectionTitleElement = Target.the("Section title: " + sectionTitle).located(By.xpath("//h3[contains(text(), '" + sectionTitle + "')]"));
        actor.attemptsTo(
                Ensure.that(sectionTitleElement).isDisplayed()
        );
    }

    @When("{actor} selects the first flight under best flights")
    public void sallySelectsTheFirstFlightUnderBestFlights(Actor actor) {
        Target firstFlight = Target.the("First flight under best flights").locatedBy(".best-flights-list .flight-card");
        actor.attemptsTo(
                Ensure.that(firstFlight).isDisplayed(),
                Click.on(firstFlight)
        );
    }

    @Then("{actor} should see the corresponding flight information for flights selected")
    public void sallyShouldSeeTheCorrespondingFlightInformationForFlightsSelected(Actor actor) {
        String origin = Serenity.sessionVariableCalled("origin");
        String destination = Serenity.sessionVariableCalled("destination");
        String departureDay = Serenity.sessionVariableCalled("departureDay");
        String returnDay = Serenity.sessionVariableCalled("returnDay");

        // Perform verification of flight information using Selenium or Serenity Screenplay
        // You can use assertions or further interactions with page elements to verify flight information
    }
}
