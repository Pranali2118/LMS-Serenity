package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static org.openqa.selenium.By.*;

public class Login implements Task {
    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Step("{0} logs in with username #username and password #password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(xpath("/html/body/div/div/div/div[3]/div/div/a/b")),
                Enter.theValue(username).into(id("exampleInputEmail1")),
                Enter.theValue(password).into(id("exampleInputPassword1")),
                Click.on(xpath("/html/body/div/section/div[1]/div/div[2]/form/button")),
                // Wait until the alert is present
                WaitFor.alertToBePresent(),

                // Click on the alert
                ClickOnAlert.accept()

        );
    }

    public static Login withCredentials(String username, String password) {
        return new Login(username, password);
    }
}