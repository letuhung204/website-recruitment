package com.corlogy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (httpServletRequest.getSession() == null || httpServletRequest.getSession().getAttribute("username") == null) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect("/login");
		} else {
			chain.doFilter(request, response);
		}
	}
	
	@Bean
	public FilterRegistrationBean<TransactionFilter> loggingFilter(){
	    FilterRegistrationBean<TransactionFilter> registrationBean = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new TransactionFilter());
	    registrationBean.addUrlPatterns("/admin/*");
	    registrationBean.setOrder(1);
	         
	    return registrationBean;    
	}
}
