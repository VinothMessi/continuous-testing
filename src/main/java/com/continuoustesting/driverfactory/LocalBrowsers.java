package com.continuoustesting.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import io.github.bonigarcia.wdm.WebDriverManager;

@Lazy
@Configuration
@Profile("local")
public class LocalBrowsers {
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headlessChrome")
    public WebDriver headlessChrome() {
        WebDriverManager.chromedriver().setup();
        var options = new ChromeOptions();
        options.setHeadless(true);
        return new ChromeDriver(options);
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headlessFirefox")
    public WebDriver headlessFirefox() {
        WebDriverManager.firefoxdriver().setup();
        var options = new FirefoxOptions();
        options.setHeadless(true);
        return new FirefoxDriver(options);
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edge() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}