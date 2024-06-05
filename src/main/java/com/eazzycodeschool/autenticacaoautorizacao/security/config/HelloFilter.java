package com.eazzycodeschool.autenticacaoautorizacao.security.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

class HelloFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		System.out.println("Hello Filter");
		if (!request.getHeader("x-robot").equals("yes")) {
			filterChain.doFilter(request, response);
			return;
		}
		var token = UsernamePasswordAuthenticationToken
				.authenticated("robot", "n/a", AuthorityUtils.createAuthorityList("ROLE_ROBOT"));
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(token);
		SecurityContextHolder.setContext(context);
		filterChain.doFilter(request, response);
	}

}
