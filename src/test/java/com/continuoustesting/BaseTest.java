package com.continuoustesting;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    @BeforeClass
    public void setUp() {
        System.out.println("Before every Test class");
    }

    @AfterMethod
    public void after_every_testCase() {
        System.out.println("Before every Test case");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After every Test class");
    }
}