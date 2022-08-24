package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class PageObjectsPatternRegistrationFormFakerTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillRegistrationFormTest() {
        Faker faker = new Faker();
        registrationFormPage
                .openPage()
                .removeGarbageElements()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setGender("Male")
                .setPhoneNumber(faker.phoneNumber().phoneNumber())
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
