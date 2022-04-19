package com.bah.mcc.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();

		String tokenheader = req.getHeader("tokencheck");
		if (tokenheader != null && !tokenheader.equalsIgnoreCase("true")) {
			chain.doFilter(request, response);
			return;
		}

		if (!uri.startsWith("/api/events") && !uri.startsWith("/api/registrations") && !uri.equals("/api/customers")) {
			chain.doFilter(request, response);
			return;
		} else {
			String authheader = req.getHeader("authorization");
			if (authheader != null && authheader.length() > 7 && authheader.startsWith("Bearer")) {
				String jwt_token = authheader.substring(7, authheader.length());
				if (JWTHelper.verifyToken(jwt_token)) {
					chain.doFilter(request, response);
					return;
				}
			}
		}
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");

	}

}