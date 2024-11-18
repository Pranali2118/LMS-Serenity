package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static models.LeavePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillOutLeaveForm implements Task {

    private final String name;
    private final String startDate;
    private final String endDate;
    private final String reason;
    private final String studentid;


    public FillOutLeaveForm(String name, String startDate, String endDate, String reason,
                            String studentid) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.studentid = studentid;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(NAME_FIELD),
                Enter.theValue(startDate).into(START_DATE_FIELD),
                Enter.theValue(endDate).into(END_DATE_FIELD),
                Enter.theValue(reason).into(REASON_FIELD),
                Enter.theValue(studentid).into(STUDENT_ID)

        );

    }

    public static FillOutLeaveForm withDetails(String name, String startDate, String endDate,
                                               String reason, String studentid) {
        return instrumented(FillOutLeaveForm.class, name, startDate, endDate, reason, studentid);
    }
}