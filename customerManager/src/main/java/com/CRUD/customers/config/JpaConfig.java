package com.CRUD.customers.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = {"com.CRUD.customers"})
public class JpaConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("Customers");
	  return factoryBean;
	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager transationManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory);
	  return transactionManager; 
	}
}
