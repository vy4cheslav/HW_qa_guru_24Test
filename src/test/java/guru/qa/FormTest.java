package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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



        $(By.className("modal-open")).shouldBe(Condition.visible);
        $(By.className("table-responsive")).shouldHave(Condition.text("Bill Klinton"));
        $(By.className("table-responsive")).shouldHave(Condition.text("BKlinton@mail.ru"));
        $(By.className("table-responsive")).shouldHave(Condition.text("Male"));
        $(By.className("table-responsive")).shouldHave(Condition.text("9131234567"));
        $(By.className("table-responsive")).shouldHave(Condition.text("15 July,2001"));
        $(By.className("table-responsive")).shouldHave(Condition.text("Sports"));
        $(By.className("table-responsive")).shouldHave(Condition.text("Music"));
        $(By.className("table-responsive")).shouldHave(Condition.text("Reading"));
        $(By.className("table-responsive")).shouldHave(Condition.text("Kutuzovsky Ave, 32"));
        $(By.className("table-responsive")).shouldHave(Condition.text("qa-guru.jpg"));
        $(By.className("table-responsive")).shouldHave(Condition.text("NCR"));
        $(By.className("table-responsive")).shouldHave(Condition.text("Noida"));

    }
}
