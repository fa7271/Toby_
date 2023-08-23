package com.tobyspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Type 은 클래스, 인터페이스, 이넘
@Configuration
@ComponentScan
@EnableAutoConfiguration
public @interface MySpringBootApplication {
}
