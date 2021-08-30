package com.continuoustesting.visapages;

import com.continuoustesting.basepage.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class RegistrationConfirmation extends BasePage {
    By panel = By.id("panel");
    By requestnumber = By.id("requestnumber");

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(panel)) &&
                webElement.canWeSee(webBrowser.find(requestnumber));
    }

    public
    String getMessage() {
        return webElement.getTextFrom(webBrowser.find(panel));
    }
}