package lesson8;

import com.codeborne.selenide.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class AutomationpracticeWebSiteTestSet {
    @ValueSource(strings = {
            "Faded Short Sleeve T-shirts", "Blouse"
    })
    @ParameterizedTest(name = "Category {0} has in navigator")
    void isClothesInPopular(String clothes){
        open("http://automationpractice.com/");
        $("#center_column").should(Condition.text(clothes));
    }

    static Stream<Arguments> selenideSiteMenuTest(){
        return Stream.of(
                Arguments.of("BEST SELLERS", List.of("Printed Chiffon Dress", "Faded Short Sleeve T-shirts", "Blouse", "Printed Summer Dress"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "For {0} rendered dresses {1}")
    void isDressesInBestSellers(String category, List<String> expectedDresses){
        open("http://automationpractice.com/");
        $(".blockbestsellers").click();
        $$("#blockbestsellers .ajax_block_product").first(4).shouldHave(CollectionCondition.texts(expectedDresses));
    }

    @CsvSource(value = {
            "hover,Add to cart",
            "hover,More"
    })
    @ParameterizedTest(name = "Action {1} accepted for {0}")
    void isFullRangeOfActionsAccessForUserWithHover(String action, String description){
        open("http://automationpractice.com/");
        $(".blockbestsellers").click();
        $("#blockbestsellers .ajax_block_product", 1).hover().shouldHave(Condition.text(description));
    }
}
