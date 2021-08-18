package com.continuoustesting;

import com.continuoustesting.properties.ProjectDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected WebDriver browser;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected ProjectDetails app;
}