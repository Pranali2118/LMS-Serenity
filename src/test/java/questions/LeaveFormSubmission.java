package questions;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


import static models.LeavePage.SUCCESS_MESSAGE;

public class LeaveFormSubmission {

    public static Question<Boolean> wasSuccessful() {
        return actor -> SUCCESS_MESSAGE.resolveFor(actor).getText().contains("Leave successfully applied");
    }
}