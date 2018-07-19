/**
 * 
 */
package com.sample.rbac.configuration;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Nishigandha Omanwar
 *
 */

@Configuration
@ComponentScan({"com.sample.rbac"})
@EnableWebMvc
public class LEDWebConfiguration extends WebMvcAutoConfiguration {

	
	public LEDWebConfiguration(){
		super();
	}
	
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(etagFilter());
	    registration.addUrlPatterns("/api/*");
	    registration.setName("etagFilter");
	    registration.setOrder(1);
	    return registration;
	}
	
	@Bean(name = "etagFilter")
	    public ShallowEtagHeaderFilter etagFilter() {
	    return new ShallowEtagHeaderFilter();
	}
}
