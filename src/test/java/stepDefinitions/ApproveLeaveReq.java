package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;
import tasks.LeaveRequest;

import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ApproveLeaveReq  {

    @When("The role {string} clicks on any leave request and updates the status from pending to approved")
    public void theWardenClicksOnAnyLeaveRequestAndUpdatesTheStatusFromPendingToApproved(String role) {
        theActorInTheSpotlight().attemptsTo(LeaveRequest.ClickLeaveRequest(role));
    }

    @Then("The User should be able to update the status")
    public void theUserShouldBeAbleToUpdateTheStatus() {

        theActorInTheSpotlight().should(
                seeThat(Text.of(By.xpath("/html/body/div/table/tbody/tr[11]/td[5]/p")), equalTo("Approved"))
        );
    }
}
