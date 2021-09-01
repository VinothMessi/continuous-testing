package com.continuoustesting;

import com.continuoustesting.helpers.YmlOperations;
import com.continuoustesting.properties.AppDetails;
import com.continuoustesting.properties.TestDataDetails;
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
    YmlOperations yml;
    @Autowired
    protected
    AppDetails app;
    @Autowired
    protected
    TestDataDetails testdata;

    @AfterClass
    public
    void tearDown() {
        browser.quit();
    }
}