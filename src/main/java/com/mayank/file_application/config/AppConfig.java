package com.mayank.file_application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayank.file_application.dao.FileDetailsFields;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public FileDetailsFields fileDetailsFields() {
        return new FileDetailsFields();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}
