package com.study.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kimtung on 1/27/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan( basePackages = "com.cloudteddy.gemcs01product")
public class SpringConfiguration {

}
