package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Alex");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Male")).click();
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


        $(".modal-body").shouldHave(text("Alex Alex"));
        $(".modal-body").shouldHave(text("alex@egorov.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("2145421454"));
        $(".modal-body").shouldHave(text("04 April,2012"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("Some street 1"));
        $(".modal-body").shouldHave(text("v"));
        sleep(3000);
    }
}
