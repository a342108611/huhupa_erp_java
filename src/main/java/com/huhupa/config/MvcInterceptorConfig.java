package com.huhupa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.huhupa.core.intercepter.CommonIntercepter;

@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private CommonIntercepter commonIntercepter;

    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonIntercepter).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
