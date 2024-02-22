package com.example.creating_questionnaires.config;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.FormContentFilter;
@Configuration
public class FormUrlEncodedConfig {
    @Bean
    public FilterRegistrationBean<FormContentFilter> formContentFilter() {
        FilterRegistrationBean<FormContentFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FormContentFilter());
        registration.addUrlPatterns("/*");
        registration.setName("formContentFilter");
        registration.setOrder(1);
        return registration;
    }
}
