package com.usta.cafesua;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/admin/home").setViewName("adminhome");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/accessDenied").setViewName("403");
    }
    @Bean
    public SpringSecurityDialect securityDialect(){
        return new SpringSecurityDialect();
    }
}
