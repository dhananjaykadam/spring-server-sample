package org.realx.web.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.realx.web.security.SecurityConfig;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final String SERVLET_NAME = "dispatcher.access";

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		registerOpenEntityManagerInViewFilter(servletContext);
	}

	protected void registerOpenEntityManagerInViewFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic registration = servletContext.addFilter("openEntityManagerInView",
				new OpenEntityManagerInViewFilter());
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false, "/*");
	}

	@Override
	protected String getServletName() {
		return SERVLET_NAME;
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationContext.class, SecurityConfig.class };
	}
}
