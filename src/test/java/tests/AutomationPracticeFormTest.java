package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form ");
        $("#uploadPicture").uploadFromClasspath("11.png");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Alex");
        $("#userEmail").setValue("alex@egorov.com");
        $x("//*[contains(text(),'Male')]/..").click();
        $("#userNumber").setValue("2145421454");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2012");
        $$(".react-datepicker__day").findBy(text("4")).click();
        $x("//*[contains(text(),'Sports')]/..").click();
        $("#currentAddress").setValue("Some street 1");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $x("//*[contains(text(),'Select State')]").click();
        $x("//*[contains(text(),'NCR')]").click();
        $x("//*[contains(text(),'Select City')]").click();
        $x("//*[contains(text(),'Delhi')]").click();
        $("#submit").click();


        assertTrue($x("//table/descendant::td[contains (text(), 'Alex Alex')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), 'alex@egorov.com')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), 'Male')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), '2145421454')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), '04 April,2012')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), 'Maths')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), 'Sports')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), 'Some street 1')]").exists());
        assertTrue($x("//table/descendant::td[contains (text(), 'v')]").exists());
        sleep(3000);
    }
}
