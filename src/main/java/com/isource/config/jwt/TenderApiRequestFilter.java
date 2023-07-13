package com.isource.config.jwt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.isource.dto.user.User_Dto;

import io.jsonwebtoken.ExpiredJwtException;

@Component
@Configuration
@Lazy
public class TenderApiRequestFilter extends OncePerRequestFilter {

	private TenderApiTokenUtil tenderApiTokenUtil;
	private Logger logger = null;

	public TenderApiRequestFilter(TenderApiTokenUtil tenderApiTokenUtil) {
		this.tenderApiTokenUtil = tenderApiTokenUtil;
		logger = Logger.getLogger(TenderApiRequestFilter.class);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		
		logger.info("requestTokenHeader : " + requestTokenHeader);
		
		String userInfo = null;    //username in refered task
		String jwtToken = null;

		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				userInfo = tenderApiTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				logger.info("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				logger.info("Tender Data API Token has expired");
			}
		} else {
			logger.info("Tender Data API Token does not begin with Bearer String");
		}

		// Once we get the token validate it.
		if (userInfo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			Gson g = new Gson();
			
			User_Dto user_Dto = g.fromJson(userInfo, User_Dto.class);
			

			UserDetails userDetails = new org.springframework.security.core.userdetails.User(userInfo,
					String.valueOf(user_Dto.getUser_id()), new ArrayList<>());
			
							
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			// After setting the Authentication in the context, we specify
			// that the current user is authenticated. So it passes the
			// Spring Security Configurations successfully.
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	
		
		}
		//By calling the doFilter() method, you are essentially delegating the request and response objects to the next component in the chain, 
		//which could be another filter or the servlet handling the actual request.
		chain.doFilter(request, response);
	}
	
	
	
	
}