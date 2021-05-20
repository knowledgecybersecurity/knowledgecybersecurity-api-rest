package com.bitcollege.knowledgecybersecuritywebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().configurationSource(request -> corsConfiguration())
			.and()
			.csrf().disable()
			//.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/**").permitAll()
			.antMatchers(HttpMethod.DELETE, "/**").permitAll()
			.antMatchers(HttpMethod.PUT, "/**").permitAll()
			.antMatchers(HttpMethod.GET, "/**").permitAll()
			.anyRequest().authenticated();
	}
	
	@Bean
	CorsConfiguration corsConfiguration() {
		CorsConfiguration corsConf = new CorsConfiguration().applyPermitDefaultValues();

		corsConf.addAllowedMethod(HttpMethod.DELETE);
		corsConf.addAllowedMethod(HttpMethod.PUT);
		
		return corsConf;
	}

}