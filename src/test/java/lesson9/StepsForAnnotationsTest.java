package lesson9;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForAnnotationsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUENUMBER = "#80";
    @Step("Open main page")
    public void openMainPage(){
        open("https://github.com/");
    }
    @Step("Find repository " + REPOSITORY)
    public void findRepository(){
        $("[data-test-selector='nav-search-input']").setValue(REPOSITORY).pressEnter();
    }
    @Step("Click on repository " + REPOSITORY + " link")
    public void clickOnRepository(){
        $(By.linkText(REPOSITORY)).click();
    }
    @Step("Open tab issues")
    public void openTabIssues(){
        $("#issues-tab").click();
    }
    @Step("Assert issue with number " + ISSUENUMBER)
    public void assertIssueWithNumber(){
        $(withText(ISSUENUMBER)).should(Condition.exist);
    }
}
