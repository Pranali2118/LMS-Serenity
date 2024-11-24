package tasks;

import models.LeavePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LeaveRequest implements Task {

    private final String role;

    public LeaveRequest(String role) {

        this.role=role;
    }


    @Step("{0} Clicks the leave request button")
    public <T extends Actor> void performAs(T actor) {

        Target LeaveRequestButton = role.equalsIgnoreCase("Warden")
                ? Target.the("Warden Leave Request button").locatedBy("/html/body/div/nav/div/div/ul/li[3]/a")
                : Target.the("Hod leave Request button").locatedBy("/html/body/div/nav/div/div/ul/li[2]/a");

        Target ScrollElement = role.equalsIgnoreCase("Warden")
                ? Target.the("Warden Scroller").locatedBy("/html/body/div/table/tbody/tr[last()]/td[last()-1]/a/button")
                : Target.the("Hod Scroller").locatedBy("/html/body/div/table/tbody/tr[last()]/td[last()]/a/button");

        Target UpdateButton = role.equalsIgnoreCase("Warden")
                ? Target.the("Warden Update button").locatedBy("/html/body/div/table/tbody/tr[last()]/td[last()-1]/a/button")
                : Target.the("Hod Update button").locatedBy("/html/body/div/table/tbody/tr[last()]/td[last()]/a/button");

        Target InputUpdate = role.equalsIgnoreCase("Warden")
                ? Target.the("Warden Update leave field").locatedBy("/html/body/div/section/div/div/div/div/div/div/form/div[6]/input")
                : Target.the("Hod Update leave field").locatedBy("/html/body/div/section/div/div/div/div/div/div/form/div[6]/input");

        Target SubmitReq = role.equalsIgnoreCase("Warden")
                ? Target.the("Warden Submit Button").locatedBy("/html/body/div/section/div/div/div/div/div/div/form/center/div/button")
                : Target.the("Hod Submit Button").locatedBy("/html/body/div/section/div/div/div/div/div/div/form/center/div/button");


//        try {
            actor.attemptsTo(
                    Click.on(LeaveRequestButton),

                    ScrollBottom.ofPage(ScrollElement),
                   // WaitFor.waiting(),
                    Click.on(UpdateButton),
                    Clear.field(InputUpdate),
                    Enter.theValue("approved").into(InputUpdate),
                    Click.on(SubmitReq)
                    );
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


      //  actor.attemptsTo(MaximizeBrowser.window());


    }

    public static LeaveRequest ClickLeaveRequest(String role) {
        return new LeaveRequest(role);
    }
}