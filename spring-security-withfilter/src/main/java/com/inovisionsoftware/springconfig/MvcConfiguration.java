package com.inovisionsoftware.springconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		//super.configureContentNegotiation(configurer);
		configurer.ignoreAcceptHeader(false)
		.useJaf(false)
		.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/pages", ".jsp").viewClass(JstlView.class);
	}
}
