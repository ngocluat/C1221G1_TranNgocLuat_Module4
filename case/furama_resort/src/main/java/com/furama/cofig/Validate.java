package com.furama.cofig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class Validate {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("validate");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        return bundleMessageSource;
    }
}
