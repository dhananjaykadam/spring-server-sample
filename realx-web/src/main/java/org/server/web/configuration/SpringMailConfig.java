package org.server.web.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;

import org.server.core.config.freemaker.FreemakerTemplateConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateExceptionHandler;

@Configuration
@PropertySource(value = { "classpath:emailconfig.properties", "classpath:javamail.properties" })
public class SpringMailConfig {
	private static final String HOST = "mail.server.host";
	private static final String PORT = "mail.server.port";
	private static final String PROTOCOL = "mail.server.protocol";
	private static final String USERNAME = "mail.server.username";
	private static final String PASSWORD = "mail.server.password";
	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	private static final String MAIL_SMTP_STARTTTLS_ENABLE = "mail.smtp.starttls.enable";
	private static final String MAIL_SMTP_QUITWAIT = "mail.smtp.quitwait";
	@Resource
	private Environment environment;

	@Bean
	public JavaMailSenderImpl mailSender() throws IOException {
		final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.environment.getProperty(HOST));
		mailSender.setPort(Integer.parseInt(this.environment.getProperty(PORT)));
		mailSender.setProtocol(this.environment.getProperty(PROTOCOL));
		mailSender.setUsername(this.environment.getProperty(USERNAME));
		mailSender.setPassword(this.environment.getProperty(PASSWORD));

		final Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.smtp.auth", this.environment.getProperty(MAIL_SMTP_AUTH));
		javaMailProperties.setProperty("mail.smtp.starttls.enable",
				this.environment.getProperty(MAIL_SMTP_STARTTTLS_ENABLE));
		javaMailProperties.setProperty("mail.smtp.quitwait", this.environment.getProperty(MAIL_SMTP_QUITWAIT));
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

	@Bean
	public FreemakerTemplateConfig getFreemaketTemplateConfiguration() {
		FreemakerTemplateConfig configuration = new FreemakerTemplateConfig(FreemakerTemplateConfig.VERSION_2_3_25);
		configuration.setDefaultEncoding("UTF-8");
		DefaultObjectWrapperBuilder bd = new DefaultObjectWrapperBuilder(FreemakerTemplateConfig.VERSION_2_3_25);
		configuration.setObjectWrapper(bd.build());
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		configuration.setLogTemplateExceptions(false);
		return configuration;
	}
}
