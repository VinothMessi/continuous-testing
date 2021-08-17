package com.continuoustesting.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy
@Configuration
@ConfigurationProperties("selenoid")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelenoidDetails {
    String protocol;
    private String version;
    private String host;
    private int port;
    String endpoint;
    private boolean enableVNC;
    private boolean enableVideo;
    private String videoFile;
    private String videoFormat;
    private boolean enableLog;
    private String logFile;
    private String logFormat;
}