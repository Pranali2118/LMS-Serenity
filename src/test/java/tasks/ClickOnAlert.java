package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class ClickOnAlert implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        Alert alert = driver.switchTo().alert(); // Switch to the alert
        alert.accept(); // Click "OK" on the alert
    }

    public static ClickOnAlert accept() {
        return Tasks.instrumented(ClickOnAlert.class);
    }
}