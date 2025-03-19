package pages;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.SelenideElement;

import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();
    private SelenideElement firstNameField = $("#firstName");
    private SelenideElement lastNameField = $("#lastName");
    private SelenideElement userEmailField = $("#userEmail");
    private SelenideElement genderRadio = $("#genterWrapper");
    private SelenideElement phoneNumberField = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    private SelenideElement uploadPictureButton = $("#uploadPicture");
    private SelenideElement currentAddressField = $("#currentAddress");
    private SelenideElement stateFieldSelect = $("#react-select-3-input");
    private SelenideElement cityFieldSelect = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement resultTable =  $(".modal-content");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".text-center").shouldHave(text("Practice Form"));
        return this;
    } 
    
    public RegistrationPage setFirstName(String firstName){
        firstNameField.setValue(firstName);
        return this;
    }
    public RegistrationPage setLastName(String lastName){
        lastNameField.setValue(lastName);
        return this;
    }
    public RegistrationPage setUserEmail(String userEmail){
        userEmailField.setValue(userEmail);
        return this;
    }
    public RegistrationPage setGender(String gender){
        genderRadio.$(byText(gender)).click();
        return this;
    }
    public RegistrationPage setPhoneNumber(String phoneNumber){
        phoneNumberField.setValue(phoneNumber);
        return this;
    }
    public RegistrationPage setDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth){
        calendarComponent.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        return this;
    }
    public RegistrationPage setSubjects(String subjects){
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String hobbies){
        hobbiesCheckbox.$(byText(hobbies)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String picture){
        uploadPictureButton.uploadFromClasspath(picture);
        return this;
    }
    public RegistrationPage setAddress(String address){
        currentAddressField.setValue(address);
        return this;
    }
    public RegistrationPage setState(String state){
        stateFieldSelect.setValue(state).pressEnter();
        return this;
    }
    public RegistrationPage setCity(String city){
        cityFieldSelect.setValue(city).pressEnter();
        return this;
    }
    public RegistrationPage submitClick(){
        submitButton.click();
        return this;
    }
    public RegistrationPage checkResult(String key, String value){
        tableResultComponent.checkResultTable(key, value);
        return this;
    }
    public RegistrationPage resultTableNotAppear(){
        resultTable.shouldNotBe(visible);
        return this;
    }
    public RegistrationPage checkFirstNameBorderColor(String color){
        firstNameField.shouldHave(cssValue("border-color", color));
        return this;
    }

}
