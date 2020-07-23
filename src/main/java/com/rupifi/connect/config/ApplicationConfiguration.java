package com.rupifi.connect.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
@PropertySource("classpath:application.yml")
public class ApplicationConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Autowired
    Environment environment;

    @Value("${custom-property}")
    private String customProperty;

    @Bean
    public void setUp() {
        logger.info("custom value: {}", customProperty);
        logger.info("db url: {}, {}", environment.getProperty("spring.datasource.url"), environment.getProperty("spring.datasource.driverClassName"));
    }
}
