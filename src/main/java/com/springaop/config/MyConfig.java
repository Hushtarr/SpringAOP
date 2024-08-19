package com.springaop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan(basePackages = "com.springaop")
@EnableAspectJAutoProxy
public class MyConfig {

}
