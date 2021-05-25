package com.octopusthu.javaengineering.samples.jakartaee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author octopusthu@gmail.com
 */
@SpringBootApplication
public class JakartaEeSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JakartaEeSampleApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<HelloWorldServlet> helloWorldServlet() {
        return new ServletRegistrationBean<>(new HelloWorldServlet(), "/hello/1");
    }

    @Bean
    public ServletRegistrationBean<HelloWorldHttpServlet> helloWorldHttpServlet() {
        return new ServletRegistrationBean<>(new HelloWorldHttpServlet(), "/hello/2");
    }

    @Bean
    public FilterRegistrationBean<SampleLoginFilter> sampleLoginFilter() {
        FilterRegistrationBean<SampleLoginFilter> registrationBean = new FilterRegistrationBean<>();
        SampleLoginFilter filter = new SampleLoginFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(0);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SampleAccessControlFilter> sampleAccessControlFilter() {
        FilterRegistrationBean<SampleAccessControlFilter> registrationBean = new FilterRegistrationBean<>();
        SampleAccessControlFilter filter = new SampleAccessControlFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(100);
        return registrationBean;
    }
}
