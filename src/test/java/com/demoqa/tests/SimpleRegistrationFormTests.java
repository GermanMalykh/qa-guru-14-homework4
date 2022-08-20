package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleRegistrationFormTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "760x840";
    }

    @Test
    void fillRegistrationFormTest() {

        //Url
        open("/automation-practice-form");

        //Name
        $("#firstName").setValue("German");
        $("#lastName").setValue("Malykh");

        //Email
        $("#userEmail").setValue("gnmalykh@gmail.com");

        //Gender
        $(byText("Male")).click();

        //Mobile
        $("#userNumber").setValue("8001000800");

        //Date of Birth
        $("#dateOfBirthInput").click();

        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("2000");

        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");

        $(".react-datepicker__day--017").click();

        //Subjects
        $("#subjectsInput").setValue("Physics").pressEnter();

        //Hobbies
        $(byText("Sports")).click();
        $(byText("Music")).click();

        //Picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/avatar.jpg"));

        //Current Address
        $("#currentAddress").setValue("Russia, Cherepovets");

        //State and City
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        //Submit
        $("#submit").click();

        //Assertions
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("German Malykh"),
                text("gnmalykh@gmail.com"),
                text("Male"),
                text("8001000800"),
                text("17 March,2000"),
                text("Physics"),
                text("Sports, Music"),
                text("avatar.jpg"),
                text("Russia, Cherepovets"),
                text("Haryana Karnal")
        );
    }
}
