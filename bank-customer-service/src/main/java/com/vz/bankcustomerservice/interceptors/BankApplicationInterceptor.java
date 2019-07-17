package com.vz.bankcustomerservice.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.vz.bankcustomerservice.RequestHeaderValidator;

@SuppressWarnings("deprecation")
@Component
public class BankApplicationInterceptor extends WebMvcConfigurerAdapter{

	@Autowired
	RequestHeaderValidator headerValidator;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerValidator);
	}
	

}
