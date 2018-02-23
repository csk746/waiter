package com.daou.waiter.annotation;

import java.lang.annotation.*;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamMapping {

    boolean required() default true;

    String charset() default "UTF-8";
}