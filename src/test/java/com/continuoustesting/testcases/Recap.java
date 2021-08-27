package com.continuoustesting.testcases;

import com.continuoustesting.BaseTest;
import com.continuoustesting.recappages.RecapHomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public
class Recap extends BaseTest {
    @Autowired
    private RecapHomePage homePage;

    @Test
    public
    void login() {
        homePage.visit(app.getUrl());
        homePage.verifyPageElements();
        homePage.fetchPageTitle();
        homePage.fetchPageHeader();
        homePage.loginAs(app.getCollege());
    }
}