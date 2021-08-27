package com.continuoustesting.helpers;

import com.continuoustesting.constants.ByAttribute;
import com.continuoustesting.constants.ByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public
class ElementActions {
    @Autowired
    private WebDriverWait wait;

    public
    boolean canWeSee(WebElement element) {
        return element.isDisplayed();
    }

    public
    boolean canWeClickOn(WebElement element) {
        return element.isEnabled();
    }

    public
    boolean canWeSelect(WebElement element) {
        return element.isSelected();
    }

    public
    WebElement find(ByLocator by, String locator, WebElement element) {
        switch (by) {
            case ID:
                return element.findElement(By.id(locator));
            case NAME:
                return element.findElement(By.name(locator));
            case CLASSNAME:
                return element.findElement(By.className(locator));
            case LINKTEXT:
                return element.findElement(By.linkText(locator));
            case PARTIALLINKTEXT:
                return element.findElement(By.partialLinkText(locator));
            case TAGNAME:
                return element.findElement(By.tagName(locator));
            case XPATH:
                return element.findElement(By.xpath(locator));
            case CSS:
                return element.findElement(By.cssSelector(locator));
        }
        return null;
    }

    public
    List<WebElement> findAll(ByLocator by, String locator, WebElement element) {
        switch (by) {
            case ID:
                return element.findElements(By.id(locator));
            case NAME:
                return element.findElements(By.name(locator));
            case CLASSNAME:
                return element.findElements(By.className(locator));
            case LINKTEXT:
                return element.findElements(By.linkText(locator));
            case PARTIALLINKTEXT:
                return element.findElements(By.partialLinkText(locator));
            case TAGNAME:
                return element.findElements(By.tagName(locator));
            case XPATH:
                return element.findElements(By.xpath(locator));
            case CSS:
                return element.findElements(By.cssSelector(locator));
        }
        return null;
    }

    public
    void clickOn(WebElement element) {
        if (isElementClickable(element)) {
            element.click();
        }
    }

    public
    void clear(WebElement element) {
        if (isElementClickable(element)) {
            element.clear();
        }
    }

    public
    void type(String text, WebElement element) {
        if (isElementClickable(element)) {
            element.sendKeys(text);
        }
    }

    public
    String getTextFrom(WebElement element) {
        if (isElementDisplayed(element)) {
            return element.getText().trim();
        }
        return null;
    }

    public
    void select(String value, WebElement element, ByAttribute type) {
        if (isElementClickable(element)) {
            Select dropDown = new Select(element);
            switch (type) {
                case TEXT:
                    dropDown.selectByVisibleText(value);
                    break;
                case VALUE:
                    dropDown.selectByValue(value);
                    break;
                case INDEX:
                    dropDown.selectByIndex(Integer.parseInt(value));
                    break;
            }
        }
    }

    private
    boolean isElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return canWeClickOn(element);
    }

    private
    boolean isElementDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return canWeSee(element);
    }
}