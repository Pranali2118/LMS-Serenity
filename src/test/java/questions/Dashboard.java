package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.By;

public class Dashboard implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(By.xpath("/html/body/div/nav/div/a/img")).answeredBy(actor).isVisible();
    }

    public static Dashboard isVisible() {
        return new Dashboard();
    }
}