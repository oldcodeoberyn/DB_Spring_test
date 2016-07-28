/*
 * Copyright (c) 2016 Nokia Solutions and Networks. All rights reserved.
 */

package com.nsn.aswu.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @author Yan Shanli
 * @date 7/28/2016
 */
@Configuration
@PropertySource( "classpath:config.properties" )
@ComponentScan( basePackages = { "com.nsn.aswu.test.service" } )
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = { "com.nsn.aswu.test.repository" } )
public class RootConfig
{
    private static final String ENTITY_PACKAGE = "com.nsn.aswu.test.entity";
    @Value( "${dataSource.driverClassName}" )
    private String driver;
    @Value( "${dataSource.url}" )
    private String url;
    @Value( "${dataSource.username}" )
    private String username;
    @Value( "${dataSource.password}" )
    private String password;
    @Value( "${hibernate.dialect}" )
    private String dialect;
    @Value( "${hibernate.hbm2ddl.auto}" )
    private String hbm2ddlAuto;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() throws PropertyVetoException
    {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setDriverClass( driver );
        pool.setJdbcUrl( url );
        pool.setUser( username );
        pool.setPassword( password );
        pool.setMinPoolSize( 1 );
        pool.setAcquireIncrement( 2 );
        pool.setMaxPoolSize( 20 );
        return pool;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory( DataSource dataSource )
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
            new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource( dataSource );

        String converters = ClassUtils.getPackageName( Jsr310JpaConverters.class );
        entityManagerFactoryBean.setPackagesToScan( ENTITY_PACKAGE, converters );

        entityManagerFactoryBean.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );

        Properties properties = new Properties();
        properties.put( Environment.DIALECT, dialect );
        properties.put( Environment.HBM2DDL_AUTO, hbm2ddlAuto );
        properties.put( Environment.SHOW_SQL, true );

        entityManagerFactoryBean.setJpaProperties( properties );

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager( EntityManagerFactory entityManagerFactory )
    {
        return new JpaTransactionManager( entityManagerFactory );
    }
}
