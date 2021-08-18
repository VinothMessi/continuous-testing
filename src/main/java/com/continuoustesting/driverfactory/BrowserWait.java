package com.continuoustesting.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class BrowserWait {
    @Value("${timeOut}")
    private long timeOut;

    @Bean
    public WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, timeOut);
    }
}