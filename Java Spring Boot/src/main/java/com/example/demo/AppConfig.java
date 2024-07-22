package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Autowired private AppProperties appProperties;

    @Bean
    public JdbcTemplate restTemplate() throws Exception {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() throws Exception {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername(appProperties.getDb().getUsername());
        dataSource.setDefaultAutoCommit(true);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setUrl(appProperties.getDb().getUrl());
        dataSource.setPassword(appProperties.getDb().getPassword());
        return dataSource;
    }
}
