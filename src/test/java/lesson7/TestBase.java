package lesson7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void preConditions(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1600";
    }
}
