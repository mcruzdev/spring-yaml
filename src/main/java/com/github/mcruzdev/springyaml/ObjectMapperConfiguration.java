package com.github.mcruzdev.springyaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapperConfiguration {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        return objectMapper;
    }

    @Bean
    public ObjectMapper objectMapperYAML() {
        var objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper;
    }
}
