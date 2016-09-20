package com.netease.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * webXML资源文件Bean化处理
 * @ClassName: WebConfig
 * @Description: TODO
 * @author:JonneyZhang
 * @date: 2016年5月13日 下午3:43:36
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.netease",excludeFilters = {
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = AppConfig.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = SecurityConfig.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = DatabaseConfig.class)
        })
//@ComponentScan(basePackages = "com.netease.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
        configurer.setCheckRefresh(true);
        return configurer;
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");   
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
}
