package com.continuoustesting.visapages;

import com.continuoustesting.basepage.BasePage;
import com.continuoustesting.constants.ByAttribute;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class BirthDetails extends BasePage {
    By birthMonth = By.id("input_24_month");
    By birthDay = By.id("input_24_day");
    By birthYear = By.id("input_24_year");

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(birthMonth)) &&
                webElement.canWeSee(webBrowser.find(birthDay)) &&
                webElement.canWeSee(webBrowser.find(birthYear));
    }

    public
    void fill(String bMonth, String bDay, String bYear) {
        webElement.select(bMonth, webBrowser.find(birthMonth), ByAttribute.VALUE);
        webElement.select(bDay, webBrowser.find(birthDay), ByAttribute.VALUE);
        webElement.select(bYear, webBrowser.find(birthYear), ByAttribute.VALUE);
    }
}