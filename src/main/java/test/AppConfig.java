package test;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import filter.TransactionFilter;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"test", "restController", "endpoints", "endpoints.impl", "services","filter"})
@EnableJpaRepositories(basePackages = {"services.repository"})
@PropertySource("classpath:config.properties")
public class AppConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println("Entering entityManagerFactory() bean........");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setShowSql(true);
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("test");
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		System.out.println("Exiting entityManagerFactory() bean........");
		return em;
	}
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("hibernate.connection.driver_class"));
			dataSource.setJdbcUrl(env.getProperty("hibernate.connection.url"));
			dataSource.setUser(env.getProperty("hibernate.connection.username"));
			dataSource.setPassword(env.getProperty("hibernate.connection.password"));
			dataSource.setTestConnectionOnCheckin(Boolean.parseBoolean(env.getProperty("hibernate.c3p0.testConnectionOnCheckin")));
			dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.min_size")));
			dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.max_size")));
			dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.initialPoolSize")));
			dataSource.setAcquireIncrement(Integer.parseInt(env.getProperty("hibernate.c3p0.acquire_increment")));
			dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("hibernate.c3p0.timeout")));
			dataSource.setIdleConnectionTestPeriod(Integer.parseInt(env.getProperty("hibernate.c3p0.idle_test_period")));
			dataSource.setMaxStatements(Integer.parseInt(env.getProperty("hibernate.c3p0.max_statements")));
			dataSource.setMaxIdleTimeExcessConnections(Integer.parseInt(env.getProperty("hibernate.c3p0.maxIdleTimeExcessConnections")));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.isolation", env.getProperty("hibernate.connection.isolation"));
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		return properties;
	}
	
	
	// URL type filter added
/*	@Bean
	public FilterRegistrationBean<TransactionFilter> loggingFilter() {
		   FilterRegistrationBean<TransactionFilter> filterRegBean = new FilterRegistrationBean<>();
		   filterRegBean.setFilter(new TransactionFilter());
		   filterRegBean.addUrlPatterns("/test/*");
		   filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -1);
		   return filterRegBean;
	 }*/
}
