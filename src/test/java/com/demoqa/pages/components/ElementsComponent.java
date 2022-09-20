package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ElementsComponent {

    private SelenideElement
            pictureInput = $("#uploadPicture"),
            submit = $("#submit"),
            subjects = $("#subjectsInput");

    public ElementsComponent pictureLoader(String fileName) {
        pictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public ElementsComponent submitButton() {
        submit.click();

        return this;
    }

    public ElementsComponent subjectsInsert(String value) {
        subjects.setValue(value).pressEnter();

        return this;
    }
}
