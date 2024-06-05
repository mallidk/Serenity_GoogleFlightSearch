package starter.search;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleFlightSearchPage extends PageObject {

    public static final Target ORIGIN_FIELD = Target.the("Origin field").located(By.xpath("(//input[contains(@aria-label,'Where from?')])[1]"));
    public static final Target DESTINATION_FIELD = Target.the("Destination field").located(By.xpath("(//input[contains(@aria-label,'Where to?')])[1]"));
    public static final Target DEPARTURE_DAY_FIELD = Target.the("Departure day field").located(By.xpath("(//input[contains(@aria-label,'Departure')])[1]"));
    public static final Target RETURN_DAY_FIELD = Target.the("Return day field").located(By.xpath("(//input[contains(@aria-label, 'Return')])[1]"));
    public static final Target SEARCH_BUTTON = Target.the("Search button").located(By.xpath("(//button//span[text()='Search'])[1]"));

    public static final Target BEST_DEPARTING_FLIGHTS_SECTION = Target.the("Best departing flights section").located(By.xpath("//h3[contains(text(), 'Best departing flights')]"));
    public static final Target RETURNING_FLIGHTS_SECTION = Target.the("Returning flights section").located(By.xpath("//h3[contains(text(), 'Returning flights')]"));
    public static final Target BOOKING_OPTIONS_SECTION = Target.the("Booking options section").located(By.xpath("//h3[contains(text(), 'Booking options')]"));
}

