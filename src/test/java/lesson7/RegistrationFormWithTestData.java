package lesson7;

import com.codeborne.selenide.Configuration;
import lesson7.pages.RegistrationFormPage;
import lesson7.pages.components.TableResults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithTestData {
    RegistrationFormPage homeWorkPage = new RegistrationFormPage();
    TableResults tableResults = new TableResults();

    @BeforeAll
    static void preConditions(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1600";
        Configuration.browserPosition = "1x1";

    }

    @Test
    void checkPractiseForm(){
        homeWorkPage.openPage()
                .setUsername("Nick")
                .setLastname("Kudryavtsev")
                .setUserEmail("nick@ya.ru")
                .setGender("Male")
                .setPhone("8800555353")
                .setBirthday("18", "July", "1997")
                .setSubject("Math")
                .setRadio()
                .uploadImg("lesson.png")
                .setAddress("Smth")
                .setState("NCR")
                .setCity("Delhi")
                .clickOnSubmit();

        tableResults.isModalAppear()
                .checkResults("Nick")
                .checkResults("Kudryavtsev")
                .checkResults("nick@ya.ru")
                .checkResults("8800555353");
    }




}