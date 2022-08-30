package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.data.TestData;
import com.demoqa.pages.RegistrationFormPageAllure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithAllureTests {

    RegistrationFormPageAllure registrationFormPageAllure = new RegistrationFormPageAllure();
    TestData testData = new TestData();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillRegistrationFormAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationFormPageAllure.openPage();
        registrationFormPageAllure.removeGarbageElements();
        registrationFormPageAllure.setFirstName(testData.firstName);
        registrationFormPageAllure.setLastName(testData.lastName);
        registrationFormPageAllure.setEmail(testData.email);
        registrationFormPageAllure.setGender(testData.gender);
        registrationFormPageAllure.setPhoneNumber(testData.phoneNumber);
        registrationFormPageAllure.setBirthDate(testData.day, testData.month, testData.year);
        registrationFormPageAllure.setSubject(testData.subjects);
        registrationFormPageAllure.setHobbies(testData.firstHobby);
        registrationFormPageAllure.setHobbies(testData.secondHobby);
        registrationFormPageAllure.setPicture(testData.fileName);
        registrationFormPageAllure.setAddress(testData.address);
        registrationFormPageAllure.setState(testData.state);
        registrationFormPageAllure.setCity(testData.city);
        registrationFormPageAllure.submit();

        registrationFormPageAllure.checkResultsTableVisible();
        registrationFormPageAllure.checkResult("Student Name", testData.firstName + " " + testData.lastName);
        registrationFormPageAllure.checkResult("Student Email", testData.email);
        registrationFormPageAllure.checkResult("Gender", testData.gender);
        registrationFormPageAllure.checkResult("Mobile", testData.phoneNumber);
        registrationFormPageAllure.checkResult("Date of Birth", testData.day + " "
                + testData.month + "," + testData.year);
        registrationFormPageAllure.checkResult("Subjects", testData.subjects);
        registrationFormPageAllure.checkResult("Hobbies", testData.firstHobby + ", " + testData.secondHobby);
        registrationFormPageAllure.checkResult("Picture", testData.fileName);
        registrationFormPageAllure.checkResult("Address", testData.address);
        registrationFormPageAllure.checkResult("State and City", testData.state + " " + testData.city);
    }
}
