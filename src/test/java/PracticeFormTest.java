import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practiceFormTst(){
        open("/automation-practice-form");
        // Проверка заголовка страницы
        $(".text-center").shouldHave(text("Practice Form"));
        // Ввод фамилию, имя, пол, почту и номер телефона
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Pronin");
        $("#userEmail").setValue("test@test.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("0123456789");
        // Выбор даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--019").click();
        // Выбор предмета
        $("#subjectsInput").setValue("Science").pressEnter();
        // Выбор хобби
        $("[for=hobbies-checkbox-2]").click();
        // Загрузка изображения
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpeg"));
        // Ввод текущего адреса
        $("#currentAddress").setValue("33321 Gr.Drive");
        // Выбор штата
        $("#state").click();
        // Выбор города
        // Подтверждаем форму
        // Проверка введеных полей

        sleep(5000);

    }
}
