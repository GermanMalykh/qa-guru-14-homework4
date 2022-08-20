package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.*;

public class PageObjectsPatternRegistrationFormTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillRegistrationFormTest() {
        registrationFormPage
                .openPage()
                .removeGarbageElements()
                .setFirstName("German")
                .setLastName("Malykh")
                .setEmail("gnmalykh@gmail.com")
                .setGender("Male")
                .setPhoneNumber("8001000800")
                .setBirthDate("01", "February", "2007")
                .subjectInput("Physics")
                .setHobbies("Sports")
                .setHobbies("Music")
                .pictureInput("avatar.jpg")
                .setAddress("Russia, Cherepovets")
                .setState("Haryana")
                .setCity("Karnal")
                .submit()

                .checkResultsTableVisible()
                .checkResult("Student Name", "German Malykh")
                .checkResult("Student Email", "gnmalykh@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8001000800")
                .checkResult("Date of Birth", "01 February,2007")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "avatar.jpg")
                .checkResult("Address", "Russia, Cherepovets")
                .checkResult("State and City", "Haryana Karnal");
    }
}
