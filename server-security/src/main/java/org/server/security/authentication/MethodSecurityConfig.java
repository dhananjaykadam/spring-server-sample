package org.server.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(proxyTargetClass = true, securedEnabled = true, prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
	@Autowired
	private CustomPermissionEvaluator customPermissionEvaluator;
	@Autowired
	private org.springframework.context.ApplicationContext context;

	@Override
	public MethodSecurityExpressionHandler createExpressionHandler() {
		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(customPermissionEvaluator);
		expressionHandler.setApplicationContext(context);
		return expressionHandler;
	}

	public CustomPermissionEvaluator getCustomPermissionEvaluator() {
		return customPermissionEvaluator;
	}

	public void setCustomPermissionEvaluator(CustomPermissionEvaluator customPermissionEvaluator) {
		this.customPermissionEvaluator = customPermissionEvaluator;
	}

}
