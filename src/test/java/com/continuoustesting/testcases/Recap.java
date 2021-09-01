package com.continuoustesting.testcases;

import com.continuoustesting.BaseTest;
import com.continuoustesting.recappages.LoginPage;
import com.continuoustesting.recappages.RecapHomePage;
import com.continuoustesting.recappages.WelcomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public
class Recap extends BaseTest {
    @Autowired
    private RecapHomePage homePage;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private WelcomePage welcomePage;

    @BeforeClass
    public
    void initTestData() {
        yml.read(testdata.getPath(), testdata.getName());
    }

    @BeforeMethod
    public
    void setUp() {
        homePage.visit(app.getUrl());
        homePage.verifyPageElements();
        System.out.println("Page Title:" + homePage.fetchPageTitle());
        System.out.println("Page Header:" + homePage.fetchPageHeader());
        homePage.loginAs(app.getCollege());
        System.out.println("Page Title:" + loginPage.fetchPageTitle());
        loginPage.verifyPageElements();
    }

    @Test
    public
    void invalidLogin() {
        loginPage.loginAs(yml.get("invalid.username"),
                yml.get("invalid.password"));
        loginPage.verifyErrorMessage();
    }

    @Test
    public
    void validLogin() {
        loginPage.loginAs(yml.get("valid.username"),
                yml.get("valid.password"));
        welcomePage.verifyPageElements();
        welcomePage.logOut();
    }
}