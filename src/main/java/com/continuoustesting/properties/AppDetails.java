package com.continuoustesting.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy
@Configuration
@ConfigurationProperties("app")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppDetails {
    String url;
}