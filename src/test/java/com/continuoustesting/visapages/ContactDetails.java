package com.continuoustesting.visapages;

import com.continuoustesting.basepage.BasePage;
import com.continuoustesting.constants.ByAttribute;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class ContactDetails extends BasePage {
    By areaCode = By.id("input_27_area");
    By phoneNumber = By.id("input_27_phone");

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(areaCode)) &&
                webElement.canWeSee(webBrowser.find(phoneNumber));
    }

    public
    void fill(String aCode, String phNumber) {
        webElement.type(aCode, webBrowser.find(areaCode));
        webElement.type(phNumber, webBrowser.find(phoneNumber));
    }
}