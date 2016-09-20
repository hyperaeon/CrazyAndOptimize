package com.netease.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;


/**
 * DB连接池设置
 * @ClassName: DatabaseConfig
 * @Description: TODO
 * @author:JonneyZhang
 * @date: 2016年5月16日 下午3:42:25
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.netease.repositories")
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        final DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://10.9.30.185:3306/db_netease?characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("2013XinNian#*");

        
        
        
//        ds.setUrl("jdbc:mysql://10.120.153.150:3306/vstoredev3?characterEncoding=UTF-8");
//        ds.setUsername("vstoredev");
//        ds.setPassword("vstoredev");
        
        ds.setInitialSize(20);
        ds.setMinIdle(20);
        ds.setMaxActive(100);
        ds.setMaxWait(60000);
        ds.setTimeBetweenEvictionRunsMillis(60000);
        ds.setMinEvictableIdleTimeMillis(300000);
        ds.setValidationQuery("SELECT 1");
        ds.setTestWhileIdle(true);
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);
        ds.setPoolPreparedStatements(false);
        ds.setMaxPoolPreparedStatementPerConnectionSize(20);
        // try {
        // ds.setFilters("stat,slf4j");
        // } catch(Exception e){
        // e.printStackTrace();
        // }

        return ds;
    }

    @Bean
    @Autowired
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(false);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        vendorAdapter.setDatabase(Database.MYSQL);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.netease.domain");
        factory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.jdbc.batch_size", "50");
        properties.setProperty("hibernate.jdbc.fetch_size", "50");
        // properties.setProperty("hibernate.cache.use_second_level_cache",
        // "true");
        // properties.setProperty("hibernate.cache.region.factory_class",
        // "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        // properties.setProperty("hibernate.cache.use_query_cache", "true");
        // properties.setProperty("hibernate.generate_statistics", "true");

        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
