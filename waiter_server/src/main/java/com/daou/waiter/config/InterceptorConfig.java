package com.daou.waiter.config;

import com.daou.waiter.interceptor.PageParameterResolver;
import com.daou.waiter.interceptor.ParameterResolver;
import com.daou.waiter.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    ParameterResolver parameterResolver;
    @Autowired
    PageParameterResolver pageParamaeterResolver;
    @Autowired
    SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(securityInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // TODO Auto-generated method stub
        argumentResolvers.add(parameterResolver);
        argumentResolvers.add(pageParamaeterResolver);

    }


}