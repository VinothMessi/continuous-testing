package com.continuoustesting.testcases;

import com.continuoustesting.BaseTest;
import com.continuoustesting.entities.Users;
import com.continuoustesting.repository.UsersRepository;
import com.continuoustesting.visapages.RegistrationConfirmation;
import com.continuoustesting.visapages.RegistrationForm;
import com.continuoustesting.visapages.VisaHomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public
class Visa extends BaseTest {
    @Autowired
    private
    UsersRepository users;
    @Autowired
    private VisaHomePage homePage;
    @Autowired
    private RegistrationForm form;
    @Autowired
    private RegistrationConfirmation confirmation;

    @Test(dataProvider = "visa")
    public
    void visaRegistration(Users u) {
        homePage.visit(app.getUrl());
        homePage.verifyPageElements();
        homePage.fetchPageTitle();
        homePage.fetchHeader();
        homePage.fetchSubHeader();
        form.fill(u.getFirstName(), u.getMiddleName(), u.getLastName(), u.getFromCountry(),
                u.getToCountry(), u.getBirthMonth(), u.getBirthDay(), u.getBirthYear(),
                u.getAreaCode(), u.getPhoneNumber());
        form.fill(u.getFirstName() + " " + u.getLastName() + " " + "visa registration form filled");
        form.submit();
        confirmation.verifyPageElements();
        System.out.println(confirmation.getMessage());
    }

    @DataProvider(name = "visa")
    public
    java.lang.Object[] getData1() {
        return users.findAll().stream().collect(Collectors.toList()).toArray();
    }
}