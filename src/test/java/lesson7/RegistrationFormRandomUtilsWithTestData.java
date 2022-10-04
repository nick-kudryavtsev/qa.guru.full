package lesson7;

import com.github.javafaker.Faker;
import lesson7.pages.RegistrationFormPage;
import lesson7.pages.components.TableResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static lesson7.TestData.lastname;
import static lesson7.TestData.username;
import static lesson7.randomUtils.RandomUtils.*;

public class RegistrationFormRandomUtilsWithTestData extends TestBase {
    Faker faker = new Faker();

    RegistrationFormPage homeWorkPage = new RegistrationFormPage();
    TableResults tableResults = new TableResults();

    String username,
            lastname,
            email,
            phone;

    @BeforeEach
    void preparedTestData(){
        username = faker.name().firstName();
        lastname = faker.name().lastName();
        email = String.format("%s@ya.ru", faker.name().lastName());
        phone = getRandomNumber(10);
    }

    @Test
    void checkPractiseForm() throws InterruptedException {
        homeWorkPage.openPage()
                .setUsername(username)
                .setLastname(lastname)
                .setUserEmail(email)
                .setGender("Male")
                .setPhone(phone)
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
                .checkResults(email)
                .checkResults(phone);
    }
}