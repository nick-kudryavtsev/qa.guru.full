package lesson7.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lesson7.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    //  components
    CalendarComponent calendarComponent = new CalendarComponent();

    //  elements
    private SelenideElement
            username = $("#firstName"),
            lastname = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            phone = $("#userNumber"),
            subject = $("#subjectsInput"),
            radio = $(".custom-control.custom-checkbox.custom-control-inline:nth-child(1)"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    //  actions
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationFormPage setUsername(String username){
        this.username.setValue(username);
        return this;
    }
    public RegistrationFormPage setLastname(String lastname){
        this.lastname.setValue(lastname);
        return this;
    }
    public RegistrationFormPage setUserEmail(String email){
        this.userEmail.setValue(email);
        return this;
    }
    public RegistrationFormPage setGender(String value){
        this.gender.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setPhone(String value){
        this.phone.setValue(value);
        return this;
    }
    public RegistrationFormPage setBirthday(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationFormPage setSubject(String value){
        this.subject.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage setRadio(){
        this.radio.click();
        return this;
    }
    public RegistrationFormPage uploadImg(String value){
        this.picture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationFormPage setAddress(String value){
        this.address.setValue(value);
        return this;
    }
    public RegistrationFormPage setState(String value){
        this.state.click();
        this.stateWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setCity(String value){
        this.city.click();
        this.cityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage clickOnSubmit(){
        this.submit.click();
        return this;
    }
}