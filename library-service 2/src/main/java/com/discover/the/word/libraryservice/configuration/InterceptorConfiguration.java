package com.discover.the.word.libraryservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        try {
//            registry.addInterceptor(new LibraryInterceptor()).addPathPatterns("/**");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
