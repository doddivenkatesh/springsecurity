package com.springsecurity.springsecurity.newconfig;
/*
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class JwtUtil {

	 private final String SECRET_KEY = "secret"; // Change this in production

	    public String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour validity
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
	                .compact();
	    }

	    public String extractUsername(String token) {
	        return Jwts.parser()
	                .setSigningKey(SECRET_KEY)
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
	    }

	    public boolean validateToken(String token, UserDetails userDetails) {
	        return extractUsername(token).equals(userDetails.getUsername());
	    }
}
*/