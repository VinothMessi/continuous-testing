package com.continuoustesting.visapages;

import com.continuoustesting.basepage.BasePage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class VisaHomePage extends BasePage {
    By header = By.id("header_1");
    By subHeader = By.id("subHeader_1");

    public
    void visit(String url) {
        webBrowser.navigateTo(url);
    }

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(header)) &&
                webElement.canWeSee(webBrowser.find(subHeader));
    }

    public
    String fetchPageTitle() {
        return webBrowser.getPageTitle();
    }

    public
    String fetchHeader() {
        return webElement.getTextFrom(webBrowser.find(header));
    }

    public
    String fetchSubHeader() {
        return webElement.getTextFrom(webBrowser.find(subHeader));
    }
}