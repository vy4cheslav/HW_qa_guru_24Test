package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.*;


public class FormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void firstTest() {
        open("/automation-practice-form"); // открываем форму для ввода данных
        $(By.id("firstName")).setValue("Bill");  // Заполняем поле firstName
        $(By.id("lastName")).setValue("Klinton"); // Заполнеяем поле lastName
        $(By.id("userEmail")).setValue("BKlinton@mail.ru");  // Заполняем поле userEmail
        $x("//*[text()='Male']").click();  // Нажимаем радио баттон
        $(By.id("userNumber")).setValue("9131234567");  // Заполняем поле userNumber
        $(By.id("dateOfBirthInput")).click();  // Клик по полю дата рождения
        $(By.className("react-datepicker__month-select")).selectOption(6); // Выбираем месяц
        $(By.className("react-datepicker__year-select")).selectOption("2001"); // Выбираем год
        $(".react-datepicker__day--015").click();  // Выбираем день
        $("[id=subjectsInput]").setValue("d").sendKeys(Keys.ENTER); // Заполняем поле Subject
        $x("//*[text()='Sports']").click();  // Выбираем хобби
        $x("//*[text()='Music']").click();  // Выбираем хобби
        $x("//*[text()='Reading']").click();  // Выбираем хобби
        $("#uploadPicture").uploadFromClasspath("qa-guru.jpg");  // Загружаем картинку
        $("#currentAddress").setValue("Kutuzovsky Ave, 32");  // Заполняем адрес
        $("#state").click();  // Выбираем штат
        $x("//*[text()='NCR']").click();  // Выбираем штат
        $("#city").click(); // Выбираем город
        $x("//*[text()='Noida']").click();  // Выбираем город
        $("#submit").click(); // Подтверждаем форму ввода

        // Проверки заполнения формы

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
