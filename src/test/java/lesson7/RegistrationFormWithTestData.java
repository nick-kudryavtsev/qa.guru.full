package lesson7;

import com.codeborne.selenide.Configuration;
import lesson7.pages.RegistrationFormPage;
import lesson7.pages.components.TableResults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lesson7.TestData.lastname;
import static lesson7.TestData.username;

public class RegistrationFormWithTestData extends TestBase {
    RegistrationFormPage homeWorkPage = new RegistrationFormPage();
    TableResults tableResults = new TableResults();

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
                .checkResults(username)
                .checkResults(lastname)
                .checkResults("nick@ya.ru")
                .checkResults("8800555353");
    }

    //  String formattedString = String.format("%s %s", var1, var2); - где %s - переменная с типом String




}