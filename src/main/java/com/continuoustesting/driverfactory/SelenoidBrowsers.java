package com.continuoustesting.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import com.continuoustesting.helpers.Utilities;
import com.continuoustesting.properties.SelenoidDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Lazy
@Configuration
@Profile("selenoid")
public class SelenoidBrowsers {

        @Autowired
        private SelenoidDetails selenoid;

        @Lazy
        @Bean
        @ConditionalOnProperty(name = "browser", havingValue = "chrome")
        public WebDriver selenoidChrome() throws MalformedURLException {
                var capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", selenoid.getVersion());
                capabilities.setCapability("enableVNC", selenoid.isEnableVNC());
                capabilities.setCapability("enableVideo", selenoid.isEnableVideo());
                capabilities.setCapability("videoName", selenoid.getVideoFile() + "_" + Utilities.currentDateTime()
                                + selenoid.getVideoFormat());
                capabilities.setCapability("enableLog", selenoid.isEnableLog());
                capabilities.setCapability("logName",
                                selenoid.getLogFile() + "_" + Utilities.currentDateTime() + selenoid.getLogFormat());
                return new RemoteWebDriver(new URL(selenoid.getProtocol() + "://" + selenoid.getHost() + ":"
                                + selenoid.getPort() + selenoid.getEndpoint()), capabilities);
        }

        @Lazy
        @Bean
        @ConditionalOnProperty(name = "browser", havingValue = "firefox")
        public WebDriver selenoidFirefox() throws MalformedURLException {
                var capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", selenoid.getVersion());
                capabilities.setCapability("enableVNC", selenoid.isEnableVNC());
                capabilities.setCapability("enableVideo", selenoid.isEnableVideo());
                capabilities.setCapability("videoName", selenoid.getVideoFile() + "_" + Utilities.currentDateTime()
                                + selenoid.getVideoFormat());
                capabilities.setCapability("enableLog", selenoid.isEnableLog());
                capabilities.setCapability("logName",
                                selenoid.getLogFile() + "_" + Utilities.currentDateTime() + selenoid.getLogFormat());
                return new RemoteWebDriver(new URL(selenoid.getProtocol() + "://" + selenoid.getHost() + ":"
                                + selenoid.getPort() + selenoid.getEndpoint()), capabilities);
        }

        @Lazy
        @Bean
        @ConditionalOnProperty(name = "browser", havingValue = "edge")
        public WebDriver selenoidEdge() throws MalformedURLException {
                var capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "MicrosoftEdge");
                capabilities.setCapability("browserVersion", selenoid.getVersion());
                capabilities.setCapability("enableVNC", selenoid.isEnableVNC());
                capabilities.setCapability("enableVideo", selenoid.isEnableVideo());
                capabilities.setCapability("videoName", selenoid.getVideoFile() + "_" + Utilities.currentDateTime()
                                + selenoid.getVideoFormat());
                capabilities.setCapability("enableLog", selenoid.isEnableLog());
                capabilities.setCapability("logName",
                                selenoid.getLogFile() + "_" + Utilities.currentDateTime() + selenoid.getLogFormat());
                return new RemoteWebDriver(new URL(selenoid.getProtocol() + "://" + selenoid.getHost() + ":"
                                + selenoid.getPort() + selenoid.getEndpoint()), capabilities);
        }
}