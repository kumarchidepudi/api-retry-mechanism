package com.kumar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {
    //create a rest template bean
    @Bean
    public RestTemplate templateBuilder(){
        RestTemplateBuilder builder=new RestTemplateBuilder();
        return builder.build();
    }
}
