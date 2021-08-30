package com.continuoustesting.visapages;

import com.continuoustesting.basepage.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class RegistrationForm extends BasePage {
    By additionalComments = By.id("input_45");
    By submitApplication = By.id("submitBtn");

    @Autowired
    UserDetails userDetails;
    @Autowired
    CountryDetails countryDetails;
    @Autowired
    BirthDetails birthDetails;
    @Autowired
    ContactDetails contactDetails;

    public
    void fill(String firstName, String middleName, String lastName, String fromCountry, String toCountry
            , String birthMonth, String birthDay, String birthYear, String areaCode, String phoneNumber) {
        userDetails.verifyPageElements();
        userDetails.fill(firstName, middleName, lastName);
        countryDetails.verifyPageElements();
        countryDetails.fill(fromCountry, toCountry);
        birthDetails.verifyPageElements();
        birthDetails.fill(birthMonth, birthDay, birthYear);
        contactDetails.verifyPageElements();
        contactDetails.fill(areaCode, phoneNumber);
    }

    public
    void fill(String comments) {
        webElement.type(comments, webBrowser.find(additionalComments));
    }

    public
    void submit() {
        webElement.clickOn(webBrowser.find(submitApplication));
    }
}