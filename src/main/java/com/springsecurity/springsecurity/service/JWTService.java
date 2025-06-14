package com.springsecurity.springsecurity.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.document.exceptio.InvalidJwtException;
import io.jsonwebtoken.security.SignatureException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Service
public class JWTService {

	 private String secretkey = "";

	    public JWTService() {

	        try {
	            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
	            SecretKey sk = keyGen.generateKey();
	            secretkey = Base64.getEncoder().encodeToString(sk.getEncoded());
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public String generateToken(String username) {
	        Map<String, Object> claims = new HashMap<>();
	        return Jwts.builder()
	                .setClaims(claims) // Set the claims map here
	                .setSubject(username) // Set the subject (username)
	                .setIssuedAt(new Date(System.currentTimeMillis())) // Set the issued date
	                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 30 * 1000)) // Set the expiration (30 hours)
	                .signWith(getKey()) // Sign the token with the key
	                .compact(); // Generate the token

	    }

	    private SecretKey getKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(secretkey);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }

	    public String extractUserName(String token) {
	        // extract the username from jwt token
	        return extractClaim(token, Claims::getSubject);
	    }

	    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimResolver.apply(claims);
	    }

	    private Claims extractAllClaims(String token) {
	    	try {
	        return Jwts.parserBuilder()
	                .setSigningKey(getKey()) // Set the signing key
	                .build() // Build the parser
	                .parseClaimsJws(token) // Parse the token
	                .getBody(); // Extract the claims
	    	} catch(SignatureException e) {
	    		 //logger.error("Invalid JWT signature: {}", e.getMessage());
	    	        throw new InvalidJwtException("Invalid JWT signature");
	    	}
	    }

	    public boolean validateToken(String token, UserDetails userDetails) {
	        final String userName = extractUserName(token);
	        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

	    private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }
	   
}

/*
package com.springsecurity.springsecurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springsecurity.springsecurity.document.exception.InvalidJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
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
*/

/*
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public Claims extractAllClaims(String token) {
    try {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    } catch (SignatureException e) {  
        logger.error("Invalid JWT signature: {}", e.getMessage());
        throw new InvalidJwtException("Invalid JWT signature");  // Throws custom exception
    }
}
*/