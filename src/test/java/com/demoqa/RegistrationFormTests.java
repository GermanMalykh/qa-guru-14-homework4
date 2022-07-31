package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {

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
        $(".modal-header").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text("German Malykh"));
        $(".table-responsive").shouldHave(Condition.text("gnmalykh@gmail.com"));
        $(".table-responsive").shouldHave(Condition.text("Male"));
        $(".table-responsive").shouldHave(Condition.text("8001000800"));
        $(".table-responsive").shouldHave(Condition.text("17 March,2000"));
        $(".table-responsive").shouldHave(Condition.text("Physics"));
        $(".table-responsive").shouldHave(Condition.text("Sports, Music"));
        $(".table-responsive").shouldHave(Condition.text("avatar.jpg"));
        $(".table-responsive").shouldHave(Condition.text("Russia, Cherepovets"));
        $(".table-responsive").shouldHave(Condition.text("Haryana Karnal"));

        //Close
        $("#closeLargeModal").click();
    }
}
