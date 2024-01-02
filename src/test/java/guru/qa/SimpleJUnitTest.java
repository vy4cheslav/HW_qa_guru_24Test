package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class SimpleJUnitTest {

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
    open("/automation-practice-form");
    $(By.id("firstName")).setValue("Bill");
    $(By.id("lastName")).setValue("Klinton");
    $(By.id("userEmail")).setValue("BKlinton@mail.ru");
    $x("//*[text()='Male']").click();
    $(By.id("userNumber")).setValue("9131234567");
    $(By.id("dateOfBirthInput")).click();
    $(By.className("react-datepicker__month-select")).selectOption(6);
    $(By.className("react-datepicker__year-select")).selectOption("2001");
    $(".react-datepicker__day--015").click();




  }
}