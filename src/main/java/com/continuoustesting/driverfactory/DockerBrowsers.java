package com.continuoustesting.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

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
@Profile("docker")
public class DockerBrowsers {
    @Autowired
    private HubDetails hub;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chrome() throws MalformedURLException {
        return new RemoteWebDriver(
                new URL(hub.getProtocol() + "://" + hub.getHost() + ":" + hub.getPort() + hub.getEndpoint()),
                DesiredCapabilities.chrome());
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefox() throws MalformedURLException {
        return new RemoteWebDriver(
                new URL(hub.getProtocol() + "://" + hub.getHost() + ":" + hub.getPort() + hub.getEndpoint()),
                DesiredCapabilities.firefox());
    }
}