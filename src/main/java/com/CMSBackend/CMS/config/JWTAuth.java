package com.CMSBackend.CMS.config;

import java.io.IOException;import java.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.CMSBackend.CMS.model.User;
import com.CMSBackend.CMS.service.JWTUtils;
import com.CMSBackend.CMS.service.UserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuth extends OncePerRequestFilter {

	@Autowired
	private JWTUtils jwtUtils;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		final String authHeader = request.getHeader("Authorization");
		final String jwtToken;
		final String userName;
		if (authHeader == null || authHeader.isBlank()) {
			filterChain.doFilter(request, response);
			return;
		}
		jwtToken = authHeader.substring(7);
		userName = jwtUtils.extractUsername(jwtToken);
		if (userName !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			
			if (jwtUtils.isTokenValid(jwtToken, userDetails)) {
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
						userDetails,null,userDetails.getAuthorities()
						);
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				securityContext.setAuthentication(token);
				SecurityContextHolder.setContext(securityContext);
				
			}
		}
		filterChain.doFilter(request, response);
		
	}

	
}
