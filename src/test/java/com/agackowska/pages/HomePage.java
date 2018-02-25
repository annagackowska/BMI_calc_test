package com.agackowska.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//label[@for='bmi_gender_f']")
    WebElement femaleButton;

    @FindBy(xpath = "//label[@for='bmi_gender_m']")
    WebElement maleButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement weightField;

    @FindBy(xpath = "//input[@type='text']")
    WebElement heightField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//h5[@class='result-v1__title']")
    WebElement result;

    public void inputInformationForm(String gender, String weight, String height) {
        weightField.sendKeys(weight);
        heightField.sendKeys(height);
        if (gender.equals("M")) {
            maleButton.click();
        } else if (gender.equals("K")) {
            femaleButton.click();
        }

    }

    public void clickOnFemaleButton() {
        femaleButton.click();
    }

    public void clickOnMaleButton() {
        maleButton.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public String getResultMessage() {
        return result.getText();
    }


}
