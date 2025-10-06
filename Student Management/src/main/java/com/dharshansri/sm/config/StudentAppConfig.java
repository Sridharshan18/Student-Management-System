package com.dharshansri.sm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Date;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.dharshansri.sm"})
public class StudentAppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }

    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return  new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Smartsri18@");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/studentmanagement");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return driverManagerDataSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/URLToReachResourcesFolder/**").addResourceLocations("/resources/");
    }
}
