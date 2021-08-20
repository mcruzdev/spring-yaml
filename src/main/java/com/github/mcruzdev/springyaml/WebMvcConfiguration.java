package com.github.mcruzdev.springyaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    public static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("text/yaml");
    public static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("text/yml");

    @Autowired
    @Qualifier("objectMapperYAML")
    private ObjectMapper yamlObjectMapper;

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorPathExtension(true)
                .favorParameter(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .ignoreAcceptHeader(false)
                .mediaType(MediaType.APPLICATION_JSON.getSubtype(), MediaType.APPLICATION_JSON)
                .mediaType(MEDIA_TYPE_YAML.getSubtype(), MEDIA_TYPE_YAML)
                .mediaType(MEDIA_TYPE_YML.getSubtype(), MEDIA_TYPE_YML);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter yamlConverter =
                new MappingJackson2HttpMessageConverter(yamlObjectMapper);
        yamlConverter.setSupportedMediaTypes(
                Arrays.asList(MEDIA_TYPE_YML, MEDIA_TYPE_YAML)
        );
        converters.add(yamlConverter);
    }
}
