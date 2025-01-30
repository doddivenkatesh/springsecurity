package com.springsecurity.springsecurity.service;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.entity.Users;
import com.springsecurity.springsecurity.repo.UserRepo;


@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	 @Autowired
	    private JWTService jwtService;

	    @Autowired
	    AuthenticationManager authManager;

	    @Autowired
	    private UserRepo repo;


	    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	    public Users register(Users user) {
	        user.setPassword(encoder.encode(user.getPassword()));
	        repo.save(user);
	        return user;
	    }

	    public String verify(Users user) {
	    	
	    	try {
	    	    Authentication authentication = authManager.authenticate(
	    	        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
	    	    ); 
	    	} catch (Exception ex) {
	    	    Throwable cause = ex.getCause();
	    	    LOGGER.error("Authentication error: {}", cause != null ? cause.getMessage() : ex.getMessage(), ex);
	    	    throw new RuntimeException("Token generation failed", ex);
	    	}
	        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(user.getUsername());
	        } else {
	            return "fail";
	        }
	    }

		public List<Users> getAllRegisterUsers() {
			
			return repo.findAll();
		}
}
