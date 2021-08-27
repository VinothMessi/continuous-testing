package com.continuoustesting.helpers;

import com.continuoustesting.constants.ByAttribute;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

public
class ElementActions {
    @Value("${timeOut}")
    private int timeOut;

    private WebDriver driver;
    private WebDriverWait wait;

    public
    ElementActions(@NotNull WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, timeOut);
    }

    public
    boolean canWeSee(@NotNull WebElement element) {
        return element.isDisplayed();
    }

    public
    boolean canWeClickOn(@NotNull WebElement element) {
        return element.isEnabled();
    }

    public
    boolean canWeSelect(@NotNull WebElement element) {
        return element.isSelected();
    }

    public
    void clickOn(@NotNull WebElement element) {
        if (isElementClickable(element)) {
            element.click();
        }
    }

    public
    void clear(@NotNull WebElement element) {
        if (isElementClickable(element)) {
            element.clear();
        }
    }

    public
    void type(@NotNull String text, @NotNull WebElement element) {
        if (isElementClickable(element)) {
            element.sendKeys(text);
        }
    }

    public
    String getTextFrom(@NotNull WebElement element) {
        if (isElementDisplayed(element)) {
            return element.getText().trim();
        }
        return null;
    }

    public
    void select(@NotNull String value, @NotNull WebElement element, @NotNull ByAttribute type) {
        if (isElementClickable(element)) {
            Select dropDown = new Select(element);
            switch (type) {
                case TEXT:
                    dropDown.selectByVisibleText(value);
                case VALUE:
                    dropDown.selectByValue(value);
                case INDEX:
                    dropDown.selectByIndex(Integer.parseInt(value));
            }
        }
    }

    private
    boolean isElementClickable(@NotNull WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return canWeClickOn(element);
    }

    private
    boolean isElementDisplayed(@NotNull WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return canWeSee(element);
    }
}