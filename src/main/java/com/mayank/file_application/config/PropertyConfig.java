package com.mayank.file_application.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@Getter
@Setter
public class PropertyConfig {

    @Value("${max.size}")
    public Long maxSize;
}


