package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static org.openqa.selenium.By.*;

public class NavigateTo implements Task {
    private String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    @Step("{0} navigates to the application URL")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static NavigateTo theApplication(String url) {
        return new NavigateTo(url);
    }
}