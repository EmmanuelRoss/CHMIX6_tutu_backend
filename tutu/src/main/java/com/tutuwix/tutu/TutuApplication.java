package com.tutuwix.tutu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.tutuwix.tutu.jwt.config.JwtFilter;

@SpringBootApplication
public class TutuApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutuApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter() );
		registrationBean.addUrlPatterns("/api/usuarios/*");
		//registrationBean.addUrlPatterns("/api/administradores/*");
		//registrationBean.addUrlPatterns("/api/productos/*");
		return registrationBean;
	}
	

}
