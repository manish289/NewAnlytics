package com.isource.config.jwt;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
@Configuration 
@Lazy                                  //AuthenticationEntryPoint used to send an HTTP response that requests credentials from a client.
public class TenderApiAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable{   
	//It is recommended to assign a unique value to this variable for each serializable class, 
	//as changes to the class structure can affect the deserialization process.
	private static final long serialVersionUID = 1L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}
}