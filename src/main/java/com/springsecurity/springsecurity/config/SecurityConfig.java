package com.springsecurity.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Autowired
	    private JwtFilter jwtFilter;

	    @Autowired
	    private UserDetailsService userDetailsService;

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        return http.csrf(customizer -> customizer.disable()).
	                authorizeHttpRequests(request -> request
	                        .requestMatchers("/login", "/register", "/pdf/generate").permitAll()
	                        .anyRequest().authenticated()).
	                httpBasic(Customizer.withDefaults()).
	                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	                .build();


	    }


		/*
		 * @Bean public DaoAuthenticationProvider authenticationProvider() {
		 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		 * authProvider.setUserDetailsService(userDetailsService); // Your custom
		 * service authProvider.setPasswordEncoder(passwordEncoder()); return
		 * authProvider; }
		 * 
		 * @Bean public AuthenticationManager
		 * authenticationManager(AuthenticationConfiguration config) throws Exception {
		 * return config.getAuthenticationManager(); }
		 * 
		 * @Bean public PasswordEncoder passwordEncoder() { return new
		 * BCryptPasswordEncoder(); }
		 */
		
		  @Bean public AuthenticationProvider authenticationProvider() {
		  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		  provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		  provider.setUserDetailsService(userDetailsService);
		  
		  
		  return provider; }
		  
		  @Bean public AuthenticationManager
		  authenticationManager(AuthenticationConfiguration config) throws Exception {
		  return config.getAuthenticationManager();
		   }
		 
}
