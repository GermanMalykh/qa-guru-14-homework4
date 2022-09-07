package com.demoqa.tests;

import com.demoqa.data.TestData;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class PageObjectsPatternRegistrationFormFakerDataTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    void fillRegistrationFormTestFaker() {
        registrationFormPage
                .openPage()
                .removeGarbageElements()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setBirthDate(testData.day, testData.month, testData.year)
                .setSubject(testData.subjects)
                .setHobbies(testData.firstHobby)
                .setHobbies(testData.secondHobby)
                .setPicture(testData.fileName)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit()

                .checkResultsTableVisible()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.firstHobby + ", " + testData.secondHobby)
                .checkResult("Picture", testData.fileName)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }
}
