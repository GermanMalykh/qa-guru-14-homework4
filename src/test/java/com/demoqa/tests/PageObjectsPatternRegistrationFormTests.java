package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.*;

public class PageObjectsPatternRegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillRegistrationFormTestPageObjects() {
        registrationFormPage
                .openPage()
                .removeGarbageElements()
                .setFirstName("German")
                .setLastName("Malykh")
                .setEmail("gnmalykh@gmail.com")
                .setGender("Male")
                .setPhoneNumber("8001000800")
                .setBirthDate("01", "February", "2007")
                .setSubject("Physics")
                .setHobbies("Sports")
                .setHobbies("Music")
                .setPicture("avatar.jpg")
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
