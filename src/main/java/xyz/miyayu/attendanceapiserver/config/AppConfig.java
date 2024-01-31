package xyz.miyayu.attendanceapiserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    ConfigProperties properties(){
        return new ConfigProperties();
    }

    @ConfigurationProperties()
    @Data
    public static class ConfigProperties {
        private String webSource;
    }
}
