package com.continuoustesting.testcases;

import java.util.concurrent.TimeUnit;

import com.continuoustesting.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class VisaRegistration extends BaseTest {
    @Test
    public void visaRegistration() {
        browser.manage().window().maximize();
        browser.get(app.getAppUrl());
        browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        System.out.println("Page Title:" + browser.getTitle());

        WebElement header = browser.findElement(By.id("header_1"));
        WebElement subHeader = browser.findElement(By.id("subHeader_1"));

        wait.until(ExpectedConditions.elementToBeClickable(subHeader));

        System.out.println("Header:" + header.getText().trim());
        System.out.println("Sub-Header:" + subHeader.getText().trim());

        assertThat(browser.getTitle()).isEqualTo(app.getAppTitle());
        assertThat(header.getText().trim()).isEqualTo(app.getHeader());
        assertThat(subHeader.getText().trim()).isEqualTo(app.getSubHeader());

        browser.quit();
    }
}