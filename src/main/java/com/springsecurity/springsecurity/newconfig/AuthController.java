package com.springsecurity.springsecurity.newconfig;
/*
import java.util.Collections;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.repo.CustomerDao;
@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final CustomerDao customerDao;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService, CustomerDao customerDao) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.customerDao = customerDao;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.get("emailAddress"), request.get("password"))
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.get("emailAddress"));
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return Collections.singletonMap("token", token);
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Customer user) {
        user.setPassword(user.getPassword()); // Encode the password properly in production
        return customerDao.save(user);
    }
}*/
