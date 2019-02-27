package com.capgemini.mvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.capgemini.mvc.model.DeptNameToDeptConverter;
import com.capgemini.mvc.service.DepartmentService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.capgemini.mvc")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private DepartmentService departmentService;

	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean 
	public MessageSource messageSource()
	{		
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("departmentService value--------"+departmentService);
		registry.addConverter(new DeptNameToDeptConverter(departmentService));
	}
	
}
