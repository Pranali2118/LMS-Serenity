package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class WaitFor implements Interaction {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());


    }

    public static WaitFor alertToBePresent() {
        return Tasks.instrumented(WaitFor.class);
    }

    public static WaitFor waiting() throws InterruptedException {
        System.out.println("Waitinggg");

         Thread.sleep(5000);
        System.out.println("After Waitinggg");

        return Tasks.instrumented(WaitFor.class);
    }


}