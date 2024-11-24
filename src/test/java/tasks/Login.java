package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.*;

public class Login implements Task {
    private final String username;
    private final String password;
    private final String role;

    public Login(String role,String username, String password) {
        this.username = username;
        this.password = password;
        this.role=role;
    }

    @Step("{0} logs in with username #username and password #password")
    public <T extends Actor> void performAs(T actor) {

        Target loginButton = role.equalsIgnoreCase("Student")
                ? Target.the("Student login button").locatedBy("//html/body/div/div/div/div[3]/div/div/a/b")
                : role.equalsIgnoreCase("Warden")
                ? Target.the("Warden login button").locatedBy("/html/body/div/div/div/div[2]/div/div/a/b")
                : Target.the("HOD login button").locatedBy("/html/body/div/div/div/div[1]/div/div/a/b");


        Target usernameField = role.equalsIgnoreCase("Student")
                ? Target.the("Student username field").locatedBy("#exampleInputEmail1")
                : role.equalsIgnoreCase("Warden")
                ? Target.the("Warden username field").locatedBy("#exampleInputEmail1")
                : Target.the("HOD login button").locatedBy("#exampleInputEmail1");


        Target passwordField = role.equalsIgnoreCase("Student")
                ? Target.the("Student password field").locatedBy("#exampleInputPassword1")
                : role.equalsIgnoreCase("Warden")
                ? Target.the("Warden password field").locatedBy("#exampleInputPassword1")
                : Target.the("HOD login button").locatedBy("#exampleInputPassword1");

        Target submitButton = role.equalsIgnoreCase("Student")
                ? Target.the("Student submit button").locatedBy("//html/body/div/section/div[1]/div/div[2]/form/button")
                : role.equalsIgnoreCase("Warden")
                ? Target.the("Warden submit button").locatedBy("//html/body/div/section/div[1]/div/div[2]/form/button")
                : Target.the("HOD login button").locatedBy("//html/body/div/section/div[1]/div/div[2]/form/button");


        try {
            actor.attemptsTo(
                    Click.on(loginButton),
                    Enter.theValue(username).into(usernameField),
                    Enter.theValue(password).into(passwordField),
                    Click.on(submitButton),
                    WaitFor.waiting(),
                    WaitFor.alertToBePresent(),
                    ClickOnAlert.accept()
            );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Login withCredentials(String role,String username, String password) {
        return new Login(role,username, password);
    }
}