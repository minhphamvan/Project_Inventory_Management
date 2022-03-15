package inventory.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // mvc:annotation-driven
@ComponentScan("inventory") // trỏ đến packet chứa các Controller
@EnableTransactionManagement
public class SpringConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	Environment enviroment;

	/*-- Định nghĩa nơi chứa các file view --*/
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/*-- Cấu hình static resource --*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// đường dẫn trên website /static/** sẽ trỏ đến thư mục /static/
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	/*-- Cấu hình để đọc các property trong file message.properties --*/
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:message");

		return bundleMessageSource;
	}

	/*-- Tạo cấu hình kết nối tới CSDL --*/
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/inventory_management");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("inventory.entity");

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);

		return hibernateTransactionManager;
	}
}
