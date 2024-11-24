package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Subject("Scroll to the bottom of the page")
public class ScrollBottom implements Interaction {

    private final Target scrollToElementLocator;


    // Constructor accepts the XPath or any other selector for the element to scroll to
    public ScrollBottom(Target scrollToElementLocator) {
        this.scrollToElementLocator = scrollToElementLocator;

    }

//    Target ScrollElement=Target.the("Warden Scroller").locatedBy("/html/body/div/table/tbody/tr[last()]/td[last()-1]/a/button");
//         //   : Target.the("Hod Scroller").locatedBy("/html/body/div/table/tbody/tr[last()]/td[last()]/a/button");

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = ThucydidesWebDriverSupport.getDriver();

        // Wait until the element is visible
        By byLocator = By.xpath(scrollToElementLocator.getCssOrXPathSelector());
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));



        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static ScrollBottom ofPage(Target scrollToElementLocator) {
        return instrumented(ScrollBottom.class,scrollToElementLocator);
    }
}
