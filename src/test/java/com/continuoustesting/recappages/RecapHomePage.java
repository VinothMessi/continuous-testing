package com.continuoustesting.recappages;

import com.continuoustesting.basepage.BasePage;
import com.continuoustesting.constants.ByAttribute;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class RecapHomePage extends BasePage {
    By logo = By.xpath("//img[@alt='ReCAP']");
    By header = By.xpath("//div[contains(@class,'recap-logo-container')]/div[2]");
    By twitter = By.xpath("//div[@class='twitter-block row']");
    By loginBlock = By.id("home_login");
    By institution = By.id("institution");
    By submit = By.id("submitBtn");
    By getInTouch = By.name("touch_us");

    public
    void visit(String url) {
        webBrowser.navigateTo(url);
    }

    public
    String fetchPageTitle() {
        return webBrowser.getPageTitle();
    }

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(logo)) &&
                webElement.canWeSee(webBrowser.find(header)) &&
                webElement.canWeSee(webBrowser.find(twitter)) &&
                webElement.canWeSee(webBrowser.find(loginBlock)) &&
                webElement.canWeSee(webBrowser.find(institution)) &&
                webElement.canWeSee(webBrowser.find(submit)) &&
                webElement.canWeSee(webBrowser.find(getInTouch));
    }

    public
    String fetchPageHeader() {
        return webElement.getTextFrom(webBrowser.find(header));
    }

    public
    void loginAs(String college) {
        webElement.select(college, webBrowser.find(institution), ByAttribute.VALUE);
        webElement.clickOn(webBrowser.find(submit));
    }
}