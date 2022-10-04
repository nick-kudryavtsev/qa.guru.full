package lesson7.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TableResults {
    //  elements
    private SelenideElement
            modalDialog = $(".modal-dialog"),
            tableResults = $(".table-responsive table");

    //  actions
    public TableResults isModalAppear(){
        this.modalDialog.should(Condition.appear);
        return this;
    }
    public TableResults checkResults(String value){
        this.tableResults.shouldHave(Condition.text(value));
        return this;
    }
}
