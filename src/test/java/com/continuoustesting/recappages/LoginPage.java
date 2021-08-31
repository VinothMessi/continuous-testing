package com.continuoustesting.recappages;

import com.continuoustesting.basepage.BasePage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class LoginPage extends BasePage {
    By htcLogo = By.id("logo");
    By casLogo = By.xpath("//h1[text()='HTC ReCAP CAS']");
    By serviceUi = By.id("serviceui");
    By userName = By.id("username");
    By passWord = By.id("password");
    By logIn = By.name("submit");
    By forgotPassword = By.xpath("//a[contains(text(),'Forgot your password?')]");
    By newUser = By.xpath("//a[contains(text(),'New User?')]");
    By errorMsg = By.xpath("//span[text()='Invalid credentials.']");

    public
    String fetchPageTitle() {
        return webBrowser.getPageTitle();
    }

    public
    boolean verifyPageElements() {
        return webElement.canWeSee(webBrowser.find(htcLogo)) &&
                webElement.canWeSee(webBrowser.find(casLogo)) &&
                webElement.canWeSee(webBrowser.find(serviceUi)) &&
                webElement.canWeSee(webBrowser.find(userName)) &&
                webElement.canWeSee(webBrowser.find(passWord)) &&
                webElement.canWeSee(webBrowser.find(logIn)) &&
                webElement.canWeSee(webBrowser.find(forgotPassword)) &&
                webElement.canWeSee(webBrowser.find(newUser));
    }

    public
    void loginAs(String uName, String pWord) {
        webElement.type(uName, webBrowser.find(userName));
        webElement.type(pWord, webBrowser.find(passWord));
        webElement.clickOn(webBrowser.find(logIn));
    }

    public
    boolean verifyErrorMessage() {
        return webElement.canWeSee(webBrowser.find(errorMsg)) &&
                webElement.canWeClickOn(webBrowser.find(errorMsg));
    }
}