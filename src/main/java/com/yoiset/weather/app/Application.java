package com.yoiset.weather.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yoisetlopez on 8/21/17.
 */
    @SpringBootApplication
    public class Application extends SpringBootServletInitializer {

        public static void main(String[] args) {
            // required for spring-boot plugin
            SpringApplication.run(Application.class, args);
        }

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            // used when deploying to a standalone servlet container, i.e. tomcat
            return application.sources(Application.class);
        }
    }
