package lesson8;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    @Disabled
    @ValueSource(strings = {"selenide", "allure"})
    @ParameterizedTest(name = "Результаты поиска не пустые для запроса {0}")
    void commonSearchTest(String testData){
        open("https://ya.ru");
        $("#text").setValue(testData).pressEnter();
        $$(".serp-item").shouldBe(CollectionCondition.sizeGreaterThan(0));

        sleep(5000);
    }

    @Disabled
    @CsvSource(value = {
            "Selenide|Selenide - это фреймворк для автоматизированного тестирования веб-приложений",
            "Allure java|Allure integrations for Java test frameworks.",
    }, delimiter = '|')
    @ParameterizedTest(name = "Search results have text \"{1}\" for request \"{0}\"")
    void commonSearchComplexTest(String testData, String exprectedResult){
        open("https://ya.ru");
        $("#text").setValue(testData).pressEnter();
        $$(".serp-item").first().should(Condition.text(exprectedResult));

        sleep(5000);
    }

    static Stream<Arguments> selenideSiteMenuTest(){
        return Stream.of(
                Arguments.of("RU", List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")),
                Arguments.of("EN", List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "For locale {0} rendered buttons {1}")
    void selenideSiteMenuTest(String lang, List<String> expectedButtons){
        open("https://selenide.org/");
        $$("#languages a").find(Condition.text(lang)).click();
        $$(".main-menu-pages a").filter(Condition.visible).shouldHave(CollectionCondition.texts(expectedButtons));
    }
}
