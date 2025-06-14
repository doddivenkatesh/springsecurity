package com.springsecurity.springsecurity.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springsecurity.springsecurity.document.exceptio.InvalidJwtException;
import com.springsecurity.springsecurity.service.JWTService;
import com.springsecurity.springsecurity.service.MyCustomerDetailsService;

import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtFilter extends OncePerRequestFilter{

	 @Autowired
	    private JWTService jwtService;

	    @Autowired
	    ApplicationContext context;

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	//  Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraWxsIiwiaWF0IjoxNzIzMTgzNzExLCJleHAiOjE3MjMxODM4MTl9.5nf7dRzKRiuGurN2B9dHh_M5xiu73ZzWPr6rbhOTTHs
	        String authHeader = request.getHeader("Authorization");
	        String token = null;
	        String username = null;

	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	            token = authHeader.substring(7);
	            username = jwtService.extractUserName(token);
	        }

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = context.getBean(MyCustomerDetailsService.class).loadUserByUsername(username);
	            if (jwtService.validateToken(token, userDetails)) {
	                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                authToken.setDetails(new WebAuthenticationDetailsSource()
	                        .buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
	        }

	        filterChain.doFilter(request, response);
	    }
	    

	    
	    protected void doFilterInternals(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    FilterChain filterChain) throws ServletException, IOException {
	        try {
	            // Your existing JWT validation logic here
	            filterChain.doFilter(request, response);
	        } catch (SignatureException e) {
	            handleJwtException(response, "Invalid JWT signature");
	        } catch (InvalidJwtException e) {
	            handleJwtException(response, e.getMessage());
	        }
	    }

	    private void handleJwtException(HttpServletResponse response, String message) throws IOException {
	        response.setContentType("application/json");
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("status", 401);
	        errorDetails.put("error", "Unauthorized");
	        errorDetails.put("message", message);
	        errorDetails.put("path", "/api/your-endpoint"); // Update dynamically if needed

	        ObjectMapper objectMapper = new ObjectMapper();
	        response.getWriter().write(objectMapper.writeValueAsString(errorDetails));
	    }
}
