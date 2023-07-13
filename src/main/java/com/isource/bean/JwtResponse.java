package com.isource.bean;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class JwtResponse implements Serializable{
	
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtResponse() {
		this.jwttoken = "";
	}
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getToken() {
		return this.jwttoken;
	}
}
