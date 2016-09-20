package com.netease.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 
 * @ClassName: AppConfig
 * @Description: 应用的入口处，这边定义整个包扫描范围，以及需要扫描的基础类和过滤不需要扫描的类
 * @author:JonneyZhang
 * @date: 2016年5月20日 下午7:26:22
 */
//@Configuration 告诉spring这个类是一个配置类
@Configuration
//basePackages配置：spring会扫描"com.netease.*"下所有用@Configuration, @Service, @Repository, @Component注解的类并注册为bean
//excludeFileters排除
@ComponentScan(basePackages = "com.netease", 
        excludeFilters = {
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebConfig.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = SecurityConfig.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = DatabaseConfig.class)
        })
public class AppConfig {
    
}



