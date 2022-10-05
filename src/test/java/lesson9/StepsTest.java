package lesson9;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUENUMBER = "#80";
    @Test
    void stepLambdaTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com/");
        });
        step("Find repository" + REPOSITORY, () -> {
            $("[data-test-selector='nav-search-input']").setValue(REPOSITORY).pressEnter();
        });
        step("Click on repository" + REPOSITORY + "link", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open tab issues", () -> {
            $("#issues-tab").click();
        });
        step("Assert issue with number" + ISSUENUMBER, () -> {
            $(withText(ISSUENUMBER)).should(Condition.exist);
        });
    }
}
