package com.example.multidatasourcepoc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.multidatasourcepoc.interceptor.TenantInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    public InterceptorConfig() {
        super();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new TenantInterceptor());
    }
}
