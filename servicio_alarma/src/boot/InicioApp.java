package boot;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@EnableJpaRepositories(basePackages= {"modelo.dao"})
@ComponentScan(basePackages= {"servicios", "modelo.dao", "modelo.service"})
public class InicioApp {
	
	public static void main(String[] args) {
		SpringApplication.run(InicioApp.class, args);
	}
		
	@Bean
	public HibernateJpaVendorAdapter adp() {
		HibernateJpaVendorAdapter ap=new HibernateJpaVendorAdapter();
		ap.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return ap;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("alarma_PU");
		factory.setJpaVendorAdapter(adp());
		factory.setDataSource(data());
		factory.setPackagesToScan("entidades");
		return factory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getNativeEntityManagerFactory());
	}
	
	@Bean
	public DataSource data() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/segurjava");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
}
