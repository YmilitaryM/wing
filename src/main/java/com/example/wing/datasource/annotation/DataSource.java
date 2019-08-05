package com.example.wing.datasource.annotation;

import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Document
@Inherited
public @interface DataSource {
    String value() default "";
}
