package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void afterEach(){
        closeWebDriver();
    }
}
