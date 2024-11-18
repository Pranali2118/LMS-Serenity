package models;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;



public class LeavePage {
    public static final Target APPLY_WORK_LEAVE_CARD = Target.the("Apply Work Leave Card")
            .located(By.xpath("/html/body/div/div/div[2]/div[1]/div"));

    public static final Target NAME_FIELD = Target.the("Name Field")
            .located(By.xpath("/html/body/div/section/div/div/div/div/div/div/form/div[1]/input"));
    public static final Target START_DATE_FIELD = Target.the("Start Date Field")
            .located(By.xpath("/html/body/div/section/div/div/div/div/div/div/form/div[2]/input"));
    public static final Target END_DATE_FIELD = Target.the("End Date Field")
            .located(By.xpath("/html/body/div/section/div/div/div/div/div/div/form/div[3]/input"));
    public static final Target REASON_FIELD = Target.the("Reason Field")
            .located(By.xpath("/html/body/div/section/div/div/div/div/div/div/form/div[4]/input"));
    public static final Target STUDENT_ID = Target.the("Student ID ")
            .located(By.xpath("/html/body/div/section/div/div/div/div/div/div/form/div[5]/input"));
    public static final Target SUBMIT_BUTTON = Target.the("Submit Button")
            .located(By.xpath("/html/body/div/section/div/div/div/div/div/div/form/center/button"));
    public static final Target SUCCESS_MESSAGE = Target.the("Success Message")
            .located(By.xpath("/html/body/div/nav/div/a/img"));

}