package com.flyaway.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.flyaway")
@PropertySource("classpath:connection.properties")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
    private Environment environment;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {  
       
        ResourceHandlerRegistration resourceRegistration = registry.addResourceHandler("resources/**");
        registry.addResourceHandler("/Image/**").addResourceLocations("/Image/");
	}
	
	
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=FlyAway");
        dataSource.setUsername("pooja");
        dataSource.setPassword("pooja");
        System.out.println(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
	
	
	  private Properties hibernateProperties() { 
		  Properties properties = new
	  Properties(); properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
	  properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	  properties.put("hibernate.format_sql",environment.getRequiredProperty("hibernate.format_sql"));
	  properties.put("hibernate.hbm2ddl.auto",environment.getRequiredProperty("hibernate.hbm2ddl.auto")); 
	  return properties; 
	  }
	  
	  @Bean public LocalSessionFactoryBean sessionFactory() {
	  LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	  sessionFactory.setDataSource(dataSource());
	  sessionFactory.setPackagesToScan(new String[] { "com.flyaway.model" });
	  sessionFactory.setHibernateProperties(hibernateProperties()); 
	  return sessionFactory; }
	  
	  @Bean public HibernateTransactionManager getTransactionManager() {
	  HibernateTransactionManager transactionManager = new
	  HibernateTransactionManager();
	  transactionManager.setSessionFactory(sessionFactory().getObject()); 
	  return transactionManager; }
	 
}
