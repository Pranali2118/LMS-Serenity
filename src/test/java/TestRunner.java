import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/01_applyworkleave.feature",
                "src/test/resources/features/02_WarddenAprroceeReq.feature",
                "src/test/resources/features/03_HodReqAprrove.feature"},
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"pretty"}
)



public class TestRunner {

}
