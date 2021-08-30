package com.continuoustesting.visapages;

import com.continuoustesting.basepage.BasePage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class UserDetails extends BasePage {
    By firstName = By.id("first_4");
    By middleName = By.id("middle_4");
    By lastName = By.id("last_4");

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(firstName)) &&
                webElement.canWeSee(webBrowser.find(middleName)) &&
                webElement.canWeSee(webBrowser.find(lastName));
    }

    public
    void fill(String fName, String mName, String lName) {
        webElement.type(fName, webBrowser.find(firstName));
        webElement.type(mName, webBrowser.find(middleName));
        webElement.type(lName, webBrowser.find(lastName));
    }
}