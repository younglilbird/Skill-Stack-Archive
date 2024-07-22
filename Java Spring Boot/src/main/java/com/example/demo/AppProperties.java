package com.example.demo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "file:override.properties", ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "prop")
@Data
public class AppProperties {
    private DBProperties db;

    @Data
    public static class DBProperties {
        private String url;
        private String username;
        private String password;
        private String databaseName;
    }
}
