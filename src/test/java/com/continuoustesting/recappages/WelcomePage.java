package com.continuoustesting.recappages;

import com.continuoustesting.basepage.BasePage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class WelcomePage extends BasePage {
    By searchContentTab = By.id("search-content-tab");
    By fieldValue = By.id("fieldValue");
    By allFields = By.id("allfields");
    By search = By.id("search");
    By resetSearch = By.id("resetSearch");
    By showFacets = By.id("showFacets");
    By help = By.id("help");
    By logOut = By.id("logout");

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(searchContentTab)) &&
                webElement.canWeSee(webBrowser.find(fieldValue)) &&
                webElement.canWeSee(webBrowser.find(allFields)) &&
                webElement.canWeSee(webBrowser.find(search)) &&
                webElement.canWeSee(webBrowser.find(resetSearch)) &&
                webElement.canWeSee(webBrowser.find(showFacets)) &&
                webElement.canWeSee(webBrowser.find(help)) &&
                webElement.canWeSee(webBrowser.find(logOut));
    }

    public
    void logOut() {
        webElement.clickOn(webBrowser.find(logOut));
    }
}