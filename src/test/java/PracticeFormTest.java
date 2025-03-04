import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    private String firstName = "test";
    private String lastName = "user";
    private String email = "test@test.ru";
    private String number = "0123456789";
    private String birthYear = "1993";
    private String birthMonth = "July";
    private String subjects = "Science";
    private String currentAddress = "33321 Gr.Drive";
    private String fileToUpload = "cat.jpeg";
    private String state = "Haryana";
    private String city = "Karnal";

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practiceFormTst(){
        open("/automation-practice-form");
        // Закрываем баннеры на странице
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        // Проверка заголовка страницы
        $(".text-center").shouldHave(text("Practice Form"));
        // Ввод фамилию, имя, пол, почту и номер телефона
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(number);
        // Выбор даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__day--019").click();
        // Выбор предмета и хобби
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        // Загрузка изображения
        $("#uploadPicture").uploadFromClasspath(fileToUpload);
        // Ввод текущего адреса
        $("#currentAddress").setValue(currentAddress);
        // Выбор штата и города
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        // Подтверждаем форму
        $("#submit").click();
        // Проверка введеных полей
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName),
                text(lastName),
                text(email),
                text(birthYear),
                text(birthMonth),
                text(number),
                text(subjects),
                text(fileToUpload),
                text(currentAddress),
                text(state),
                text(city));

    }
}
