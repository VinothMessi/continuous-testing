package com.continuoustesting.helpers;

import com.continuoustesting.constants.ByLocator;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public
class WebActions {
    @Value("${timeOut}")
    private int timeOut;

    private WebDriver driver;
    private WebDriverWait wait;

    public
    WebActions(@NotNull WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, timeOut);
    }

    public
    void quit() {
        this.driver.quit();
    }

    public
    void close() {
        this.driver.close();
    }

    public
    void goTo(@NotNull String url) {
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    public
    void navigateTo(@NotNull String url) {
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    public
    WebElement find(@NotNull ByLocator by, @NotNull String locator) {
        switch (by) {
            case ID:
                return this.driver.findElement(By.id(locator));
            case NAME:
                return this.driver.findElement(By.name(locator));
            case CLASSNAME:
                return this.driver.findElement(By.className(locator));
            case LINKTEXT:
                return this.driver.findElement(By.linkText(locator));
            case PARTIALLINKTEXT:
                return this.driver.findElement(By.partialLinkText(locator));
            case TAGNAME:
                return this.driver.findElement(By.tagName(locator));
            case XPATH:
                return this.driver.findElement(By.xpath(locator));
            case CSS:
                return this.driver.findElement(By.cssSelector(locator));
        }
        return null;
    }

    public
    List<WebElement> findAll(@NotNull ByLocator by, @NotNull String locator) {
        switch (by) {
            case ID:
                return this.driver.findElements(By.id(locator));
            case NAME:
                return this.driver.findElements(By.name(locator));
            case CLASSNAME:
                return this.driver.findElements(By.className(locator));
            case LINKTEXT:
                return this.driver.findElements(By.linkText(locator));
            case PARTIALLINKTEXT:
                return this.driver.findElements(By.partialLinkText(locator));
            case TAGNAME:
                return this.driver.findElements(By.tagName(locator));
            case XPATH:
                return this.driver.findElements(By.xpath(locator));
            case CSS:
                return this.driver.findElements(By.cssSelector(locator));
        }
        return null;
    }

    public
    @NotNull
    WebElement find(@NotNull By by) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return this.driver.findElement(by);
    }

    public
    @NotNull
    List<WebElement> findAll(@NotNull By by) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return this.driver.findElements(by);
    }

    public
    @NotNull
    String getPageTitle() {
        return this.driver.getTitle().trim();
    }

    public
    @NotNull
    String getCurrentUrl() {
        return this.driver.getCurrentUrl().trim();
    }

    public
    @NotNull
    String getPageSource() {
        return this.driver.getPageSource().trim();
    }
}