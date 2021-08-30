package com.continuoustesting.visapages;

import com.continuoustesting.basepage.BasePage;
import com.continuoustesting.constants.ByAttribute;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class CountryDetails extends BasePage {
    By fromCountry = By.id("input_46");
    By toCountry = By.id("input_47");

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(fromCountry)) &&
                webElement.canWeSee(webBrowser.find(toCountry));
    }

    public
    void fill(String fCountry, String tCountry) {
        webElement.select(fCountry, webBrowser.find(fromCountry), ByAttribute.VALUE);
        webElement.select(tCountry, webBrowser.find(toCountry), ByAttribute.VALUE);
    }
}