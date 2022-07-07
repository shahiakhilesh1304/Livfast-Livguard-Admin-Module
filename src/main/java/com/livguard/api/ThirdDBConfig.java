//package com.livguard.api;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//  entityManagerFactoryRef = "tertiaryEntityManagerFactory",
//  transactionManagerRef = "tertiaryTransactionManager",
//  basePackages = { "com.dsc.repository" }
//)
//public class ThirdDBConfig {
//	
//	@Bean(name="tertiaryDataSource")
//	@ConfigurationProperties(prefix="spring.thirddatasource")
//	public DataSource tertiaryDataSource() {
//	    return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "tertiaryEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean tertiaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("tertiaryDataSource") DataSource tertiaryDataSource) {
//		return builder
//				.dataSource(tertiaryDataSource)
//				.packages("com.dsc.model")
//				.build();
//	}
//
//	@Bean(name = "tertiaryTransactionManager")
//	public PlatformTransactionManager tertiaryTransactionManager(
//			@Qualifier("tertiaryEntityManagerFactory") EntityManagerFactory tertiaryEntityManagerFactory) {
//		return new JpaTransactionManager(tertiaryEntityManagerFactory);
//	}
//}