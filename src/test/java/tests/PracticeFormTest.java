package tests;

import org.junit.jupiter.api.Test;

import pages.RegistrationPage;

public class PracticeFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationWithRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Testing")
                .setUserEmail("test@test.ru")
                .setPhoneNumber("0123456789")
                .setGender("Other")
                .submitClick().checkResult("Student Name", "Nikita Testing")
                .checkResult("Student Email", "test@test.ru").
                checkResult("Gender", "Other");
    }
    @Test
    void successfulRegistrationWithAllFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Testing")
                .setUserEmail("test@test.ru")
                .setGender("Male")
                .setPhoneNumber("0123456789")
                .setDateOfBirth("19", "July", "2000")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .uploadPicture("cat.jpeg")
                .setAddress("33321 Gr.Drive")
                .setState("Haryana")
                .setCity("Karnal")
                .submitClick()
                .checkResult("Student Name", "Nikita Testing")
                .checkResult("Student Email", "test@test.ru").
                checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "19 July,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "cat.jpeg")
                .checkResult("Address", "33321 Gr.Drive")
                .checkResult("State and City", "Karnal");
    }
    @Test
    void registrationFailsWithoutRequiredFieldsTest(){
        registrationPage.openPage().setUserEmail("example@gmail.com")
        .setPhoneNumber("0123456789")
        .submitClick().resultTableNotAppear().checkFirstNameBorderColor("rgb(220, 53, 69)");
    }
}
