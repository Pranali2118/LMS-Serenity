package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.Dashboard;
import tasks.Login;
import tasks.NavigateTo;
import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StudentLogin {

    @Given("The User is one the home Page of LMS")
    public void theUserIsOneTheHomePageOfLMS() {
        OnStage.theActorCalled("Student").attemptsTo(NavigateTo.theApplication("https://rococo-pudding-77e95e.netlify.app/"));
    }

    @When("The User clicks on login button and logs in with role {string} ,email {string} and password {string}")
    public void theUserClicksOnLoginButtonAndLogsInWithEmailAndPassword(String role,String username, String password) {

        theActorInTheSpotlight().attemptsTo(Login.withCredentials(role,username, password));

    }

    @Then("The User should see the dashboard")
    public void theUserShouldSeeTheDashboard() {
        OnStage.theActorInTheSpotlight().should(seeThat(Dashboard.isVisible(), is(true)));
    }



}
