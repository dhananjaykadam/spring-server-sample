package org.server.web.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.server.core.entities.user.User;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

/**
 * Configuration for web application context
 * 
 * @author Dhananjay Kadam
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.realx.rest.resources", "org.realx.web", "org.realx.services",
		"org.realx.core", "org.realx.security", "org.realx.filestore" })
@PropertySource({ "classpath:application.properties", "classpath:foneverify.properties",
		"classpath:pushnotification.properties" })
@EnableJpaRepositories(basePackages = { "org.realx.core.repositories", "org.realx.security.repositories",
		"org.realx.filestore.repositories" })
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
@Import(value = SpringMailConfig.class)
public class ApplicationContext {

	@Resource
	private Environment environment;

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String MAX_UPLOAD_SIZE_ALLOWED = "spring.http.multipart.max-file-size";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_PHYSICAL_NAMING_STRATEGY = "hibernate.physical_naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String[] PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = { "org.realx.core.entities",
			"org.realx.core.db", "org.realx.security.entities", "org.realx.filestore.entities" };
	private static final String PROPERTY_NAME_DB_URL = "db.url";
	private static final String PROPERTY_NAME_DB_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DB_USERNAME = "db.username";
	private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_ENVERS_AUDIT_TABLE_SUFFIX = "org.hibernate.envers.audit_table_suffix";

	@Bean
	public ContentNegotiatingViewResolver getContentNegotiatingViewResolver(
			ContentNegotiationManager contentNegotiationManager) {
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
		List<View> views = new ArrayList<View>();
		views.add(new MappingJackson2JsonView());
		views.add(new MarshallingView());
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setDefaultViews(views);
		resolver.setContentNegotiationManager(contentNegotiationManager);
		resolver.setViewResolvers(viewResolvers);
		resolver.setOrder(1);
		return viewResolver;
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DB_DRIVER));
		dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DB_URL));
		dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DB_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setMaxIdle(0);
		return dataSource;
	}

	/**
	 * Create entity manager bean for data access.
	 * 
	 * @return entity manager factory
	 * @throws ClassNotFoundException
	 *             exception
	 */
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(getDataSource());
		entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
		entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);

		HibernateJpaVendorAdapter hpVA = new HibernateJpaVendorAdapter();
		hpVA.setDatabase(Database.MYSQL);
		entityManagerFactoryBean.setJpaVendorAdapter(hpVA);

		Properties jpaProterties = new Properties();
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_PHYSICAL_NAMING_STRATEGY,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_PHYSICAL_NAMING_STRATEGY));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_ENVERS_AUDIT_TABLE_SUFFIX,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_ENVERS_AUDIT_TABLE_SUFFIX));
		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}

	/**
	 * Returns transaction manager
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	@Bean
	public JpaTransactionManager transactionManager() throws ClassNotFoundException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

		return transactionManager;
	}

	@Bean
	public AuditorAware<User> auditorProvider() {
		return new SpringSecurityAuditorAware();
	}

	/**
	 * Spring AOP Trace Intercepter to trace the entry/exit methods in the logs.
	 * 
	 * @return Trace Intercepter
	 */
	@Bean(name = "traceMonitor")
	public CustomizableTraceInterceptor customizableTraceInterceptor() {
		CustomizableTraceInterceptor traceMonitor = new CustomizableTraceInterceptor();
		traceMonitor.setEnterMessage("Entering $[targetClassName] $[methodName]($[arguments])");
		traceMonitor.setExitMessage("Leaving  $[targetClassName] $[methodName](), returned $[returnValue]");
		return traceMonitor;
	}

	/**
	 * Spring AOP Performance Intercepter to trace the method execution time in
	 * the logs.
	 * 
	 * @return Trace Intercepter
	 */
	@Bean(name = "performanceMonitor")
	public PerformanceMonitorInterceptor performanceMonitor() {
		PerformanceMonitorInterceptor perfMonitor = new PerformanceMonitorInterceptor();
		return perfMonitor;
	}

	/**
	 * AOP point cut for tracing entry and exit of methods.
	 * 
	 * @return advisor.
	 */
	@Bean
	@Order(1)
	public Advisor controllerAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* org.realx.*.controller.*.*(..)) "
				+ "|| execution(* org.realx.*.service.*.*(..))");
		return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
	}

	/**
	 * AOP point cut for measuring performance of each methods.
	 * 
	 * @return advisor.
	 */
	@Bean(name = "allServiceMethods")
	@Order(2)
	public Advisor allServiceMethods() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* org.realx.*.service.*.*(..))");
		return new DefaultPointcutAdvisor(pointcut, performanceMonitor());
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver CommonsMultipartResolverBean() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setMaxInMemorySize(Integer.parseInt(environment.getRequiredProperty(MAX_UPLOAD_SIZE_ALLOWED)));
		cmr.setMaxUploadSize(Integer.parseInt(environment.getRequiredProperty(MAX_UPLOAD_SIZE_ALLOWED)));
		return cmr;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages");
		return messageSource;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*");
			}
		};
	}

}
