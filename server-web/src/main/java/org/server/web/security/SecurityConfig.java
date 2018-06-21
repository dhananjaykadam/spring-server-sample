package org.server.web.security;

import java.util.Arrays;

import javax.sql.DataSource;

import org.server.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Security Configuration Settings
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	@Autowired
	private UserService userDetailsService;
	// @Autowired
	// private SocialAuthenticationProvider socialAuthenticationProvider;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		// auth.authenticationProvider(socialAuthenticationProvider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/login.jsp");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/public/**").permitAll().antMatchers("/search/space/**")
				.permitAll().antMatchers("/files/images/**").permitAll().antMatchers("/address/**").permitAll()
				.antMatchers(HttpMethod.GET, "/spaces/*/foodspace/combos/**").permitAll()
				.antMatchers("/spaces/*/foodspace/combos/search/**").permitAll().antMatchers("/otp/**").permitAll()
				.antMatchers("/socialmedia/providers/single/*").permitAll().antMatchers("/login/social/**").permitAll()
				.antMatchers("/help/passwords/recover/**").permitAll().antMatchers("/contactus/**").permitAll()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll().antMatchers(HttpMethod.POST, "/customers/")
				.permitAll().antMatchers("/**").hasAnyRole("ADMIN,RETAIL_CUSTOMER,CORPORATE_CUSTOMER,SPACE_PROVIDER")
				.anyRequest().authenticated().and().cors().and().httpBasic().and().rememberMe();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		AuthenticationManager manager = super.authenticationManagerBean();
		return manager;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
