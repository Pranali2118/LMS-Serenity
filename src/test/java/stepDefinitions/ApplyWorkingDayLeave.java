package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LeavePage;
import net.serenitybdd.screenplay.actions.Click;
import questions.LeaveFormSubmission;
import tasks.FillOutLeaveForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;


public class ApplyWorkingDayLeave {

    @And("The student applies working day leave by entering the details in the form The leave should be applied successfully")
    public void theStudentAppliesWorkingDayLeaveByEnteringTheDetailsInTheFormTheLeaveShouldBeAppliedSuccessfully() {
        theActorInTheSpotlight().attemptsTo(Click.on(LeavePage.APPLY_WORK_LEAVE_CARD), // Click on the leave card
                FillOutLeaveForm.withDetails(
                        "Sirisha", // Example Name
                        "2024-11-20", // Start Date
                        "2024-11-22", // End Date
                        "Home inogration", // Reason
                        "1976"// studentid
                ),
                Click.on(LeavePage.SUBMIT_BUTTON) // Submit the leave request
        );

        theActorInTheSpotlight().should(
                seeThat(LeaveFormSubmission.wasSuccessful(), is(true)) // Validate success
        );
    }
}
