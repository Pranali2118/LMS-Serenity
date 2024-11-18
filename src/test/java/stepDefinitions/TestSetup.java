package stepDefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class TestSetup {

    @Before
    public void set_the_stage() {
        // Set the stage for actors before each test
        OnStage.setTheStage(new OnlineCast());
    }
}
