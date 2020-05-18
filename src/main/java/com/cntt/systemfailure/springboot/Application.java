package com.cntt.systemfailure.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class Application {

    public static void main( String[] args) {

        SpringApplication.run( Application.class, args );
    }

    /*
    @Bean
    public InternalResourceViewResolver setupViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix( "/resources/templates" );
        resolver.setSuffix( ".html" );
        return resolver;
    }
    */
}
