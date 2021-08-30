package com.continuoustesting;

import com.continuoustesting.properties.AppDetails;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;

@SpringBootTest
public
class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected
    WebDriver browser;
    @Autowired
    protected
    AppDetails app;

    @AfterClass
    public
    void tearDown() {
        browser.quit();
    }
}