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
        $(".text-center").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Pronin");
        $("#userEmail").setValue("test@test.ru");
        $("#firstName").setValue("Nikita");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("0123456789");
        // Выбираем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Science").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpeg"));
        $("#currentAddress").setValue("33321 Gr.Drive");
        $("#state").click();

        sleep(5000);





        sleep(2000);
    }
}
