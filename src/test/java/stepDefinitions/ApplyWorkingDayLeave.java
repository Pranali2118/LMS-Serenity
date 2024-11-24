package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LeavePage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.Dashboard;
import questions.LeaveFormSubmission;
import tasks.ClickOnAlert;
import tasks.FillOutLeaveForm;
import tasks.WaitFor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;


public class ApplyWorkingDayLeave {

    @And("The student applies working day leave by entering the details in the form The leave should be applied successfully")
    public void theStudentAppliesWorkingDayLeaveByEnteringTheDetailsInTheFormTheLeaveShouldBeAppliedSuccessfully() throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(Click.on(LeavePage.APPLY_WORK_LEAVE_CARD), // Click on the leave card
                FillOutLeaveForm.withDetails(
                        "Sirisha", // Example Name
                        "20/11/2024", // Start Date
                        "20-12-2024", // End Date
                        "Marriage", // Reason
                        "1976"// studentid
                ),
                Scroll.to(LeavePage.SUBMIT_BUTTON).andAlignToBottom(),
                Click.on(LeavePage.SUBMIT_BUTTON),
                WaitFor.alertToBePresent(),
                ClickOnAlert.accept()
               // WaitFor.waiting()// Submit the leave request
        );

     //   OnStage.theActorInTheSpotlight().should(seeThat(Dashboard.isVisible(), is(true)));

        System.out.println("ApplyleaveworkingleVEEEEEEEE");

//        theActorInTheSpotlight().should(
//                seeThat(LeaveFormSubmission.wasSuccessful(), is(true)) // Validate success
//        );
    }
}
