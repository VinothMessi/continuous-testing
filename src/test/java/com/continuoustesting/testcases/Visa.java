package com.continuoustesting.testcases;

import com.continuoustesting.BaseTest;
import com.continuoustesting.visapages.VisaHomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public
class Visa extends BaseTest {
    @Autowired
    private VisaHomePage homePage;

    @Test
    public
    void visaRegistration() {
        homePage.visit(app.getUrl());
        homePage.verifyPageElements();
        homePage.fetchPageTitle();
        homePage.fetchHeader();
        homePage.fetchSubHeader();
    }
}