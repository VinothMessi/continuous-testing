package com.continuoustesting.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy
@Configuration
@ConfigurationProperties("project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetails {
    String name;
    String appUrl;
    String appTitle;
    String header;
    String subHeader;
}