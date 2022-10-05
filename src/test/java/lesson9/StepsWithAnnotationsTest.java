package lesson9;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class StepsWithAnnotationsTest {

    @Test
    public void stepAnnotationsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsForAnnotationsTest stepsForAnnotationsTest = new StepsForAnnotationsTest();

        stepsForAnnotationsTest.openMainPage();
        stepsForAnnotationsTest.findRepository();
        stepsForAnnotationsTest.clickOnRepository();
        stepsForAnnotationsTest.openTabIssues();
        stepsForAnnotationsTest.assertIssueWithNumber();
    }
}
