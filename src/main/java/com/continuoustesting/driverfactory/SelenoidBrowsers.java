package com.continuoustesting.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import com.continuoustesting.constants.Selenoid;
import com.continuoustesting.helpers.Utilities;
import com.continuoustesting.properties.HubDetails;

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
        private HubDetails hub;

        @Lazy
        @Bean
        @ConditionalOnProperty(name = "browser", havingValue = "chrome")
        public WebDriver selenoidChrome() throws MalformedURLException {
                var capabilities = new DesiredCapabilities();
                capabilities.setCapability(Selenoid.BROWSER.label, "chrome");
                capabilities.setCapability(Selenoid.VERSION.label, hub.getVersion());
                capabilities.setCapability(Selenoid.VNC.label, hub.isEnableVNC());
                capabilities.setCapability(Selenoid.VIDEO.label, hub.isEnableVideo());
                capabilities.setCapability(Selenoid.VIDEO_NAME.label,
                                hub.getVideoFile() + "_" + Utilities.currentDateTime() + hub.getVideoFormat());
                capabilities.setCapability(Selenoid.LOG.label, hub.isEnableLog());
                capabilities.setCapability(Selenoid.LOG_NAME.label,
                                hub.getLogFile() + "_" + Utilities.currentDateTime() + hub.getLogFormat());
                return new RemoteWebDriver(new URL(
                                hub.getProtocol() + "://" + hub.getHost() + ":" + hub.getPort() + hub.getEndpoint()),
                                capabilities);
        }

        @Lazy
        @Bean
        @ConditionalOnProperty(name = "browser", havingValue = "firefox")
        public WebDriver selenoidFirefox() throws MalformedURLException {
                var capabilities = new DesiredCapabilities();
                capabilities.setCapability(Selenoid.BROWSER.label, "firefox");
                capabilities.setCapability(Selenoid.VERSION.label, hub.getVersion());
                capabilities.setCapability(Selenoid.VNC.label, hub.isEnableVNC());
                capabilities.setCapability(Selenoid.VIDEO.label, hub.isEnableVideo());
                capabilities.setCapability(Selenoid.VIDEO_NAME.label,
                                hub.getVideoFile() + "_" + Utilities.currentDateTime() + hub.getVideoFormat());
                capabilities.setCapability(Selenoid.LOG.label, hub.isEnableLog());
                capabilities.setCapability(Selenoid.LOG_NAME.label,
                                hub.getLogFile() + "_" + Utilities.currentDateTime() + hub.getLogFormat());
                return new RemoteWebDriver(new URL(
                                hub.getProtocol() + "://" + hub.getHost() + ":" + hub.getPort() + hub.getEndpoint()),
                                capabilities);
        }

        @Lazy
        @Bean
        @ConditionalOnProperty(name = "browser", havingValue = "edge")
        public WebDriver selenoidEdge() throws MalformedURLException {
                var capabilities = new DesiredCapabilities();
                capabilities.setCapability(Selenoid.BROWSER.label, "MicrosoftEdge");
                capabilities.setCapability(Selenoid.VERSION.label, hub.getVersion());
                capabilities.setCapability(Selenoid.VNC.label, hub.isEnableVNC());
                capabilities.setCapability(Selenoid.VIDEO.label, hub.isEnableVideo());
                capabilities.setCapability(Selenoid.VIDEO_NAME.label,
                                hub.getVideoFile() + "_" + Utilities.currentDateTime() + hub.getVideoFormat());
                capabilities.setCapability(Selenoid.LOG.label, hub.isEnableLog());
                capabilities.setCapability(Selenoid.LOG_NAME.label,
                                hub.getLogFile() + "_" + Utilities.currentDateTime() + hub.getLogFormat());
                return new RemoteWebDriver(new URL(
                                hub.getProtocol() + "://" + hub.getHost() + ":" + hub.getPort() + hub.getEndpoint()),
                                capabilities);
        }
}