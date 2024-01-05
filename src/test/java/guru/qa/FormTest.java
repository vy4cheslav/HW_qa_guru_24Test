package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    //    Configuration.holdBrowserOpen = true;
    //    Configuration.timeout = 5000; // default 4000
    }

    @Test
    void firstTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Bill");
        $("#lastName").setValue("Klinton");
        $("#userEmail").setValue("BKlinton@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9131234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(6);
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("d").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("qa-guru.jpg");
        $("#currentAddress").setValue("Kutuzovsky Ave, 32");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();



        $(".modal-open").shouldBe(Condition.visible);
        $(".table-responsive").shouldHave(Condition.text("Bill Klinton"));
        $(".table-responsive").shouldHave(Condition.text("BKlinton@mail.ru"));
        $(".table-responsive").shouldHave(Condition.text("Male"));
        $(".table-responsive").shouldHave(Condition.text("9131234567"));
        $(".table-responsive").shouldHave(Condition.text("15 July,2001"));
        $(".table-responsive").shouldHave(Condition.text("Sports"));
        $(".table-responsive").shouldHave(Condition.text("Music"));
        $(".table-responsive").shouldHave(Condition.text("Reading"));
        $(".table-responsive").shouldHave(Condition.text("Kutuzovsky Ave, 32"));
        $(".table-responsive").shouldHave(Condition.text("qa-guru.jpg"));
        $(".table-responsive").shouldHave(Condition.text("NCR"));
        $(".table-responsive").shouldHave(Condition.text("Noida"));

    }
}
