package com.continuoustesting.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@ConfigurationProperties("testdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public
class TestDataDetails {
    private String path;
    private String name;
}