package com.continuoustesting.testcases;

import com.continuoustesting.BaseTest;

import org.testng.annotations.Test;

public class VisaRegistration extends BaseTest {
    @Test
    public void visaRegistration() {
        browser.manage().window().maximize();
        browser.get(app.getAppUrl());
        System.out.println("Page Title:" + browser.getTitle());
        browser.quit();
    }
}