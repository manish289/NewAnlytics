package com.isource.handler.ip;

import javax.servlet.http.HttpServletRequest;

public class IpHandler {

	public static String getIp(HttpServletRequest request) throws Exception {
		return request.getRemoteAddr();
	}
}
