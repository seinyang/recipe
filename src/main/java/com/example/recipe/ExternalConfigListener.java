package com.example.recipe;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class ExternalConfigListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ConfigurableEnvironment environment = (ConfigurableEnvironment) event.getApplicationContext().getEnvironment();

        try (FileInputStream fileInputStream = new FileInputStream("config/application-external.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            PropertiesPropertySource propertySource = new PropertiesPropertySource("external-config", properties);
            environment.getPropertySources().addFirst(propertySource);
        } catch (IOException e) {
            System.err.println("External configuration file not found: " + e.getMessage());
        }
    }
}
