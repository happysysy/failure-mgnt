package com.cntt.systemfailure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main( String[] args) {

        SpringApplication.run( WebApplication.class, args );
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
