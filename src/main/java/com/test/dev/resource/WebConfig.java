package com.test.dev.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/js/**")
//                .addResourceLocations("classpath:/js/")
//                
//                .setCachePeriod(20)
//                ;
    	
    	registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
