package com.springsecurity.springsecurity.service;

import java.util.List;

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
