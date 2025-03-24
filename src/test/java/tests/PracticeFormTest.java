package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String dayOfBirth = String.valueOf(faker.number().numberBetween(10, 31));
    String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2024));
    String subjects = faker.options().option("Maths", "English", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics");
    String hobbies = faker.options().option("Sports", "Reading", "Music");
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = faker.options().option("Delhi", "Agra", "Karnal", "Jaipur");
    String address = faker.address().fullAddress();
    String picture = "cat.jpeg";

    @Test
    void successfulRegistrationWithRequiredFieldsTest(){
        registrationPage.openPage().removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setPhoneNumber(phoneNumber)
                .setGender(gender)
                .submitClick().checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail).
                checkResult("Gender", gender);
    }
    @Test
    void successfulRegistrationWithAllFieldsTest(){
        registrationPage.openPage().removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitClick()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail).
                checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
    @Test
    void registrationFailsWithoutRequiredFieldsTest(){
        registrationPage.openPage().removeBanners().setUserEmail(userEmail)
        .setPhoneNumber(phoneNumber)
        .submitClick().resultTableNotAppear().checkFirstNameBorderColor("rgb(220, 53, 69)");
    }
}
