package com.springsecurity.springsecurity.newconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;
/*@Configuration
@EnableWebSecurity
public class SecurityConfigs {

	 @Bean
	    public AuthenticationManager authenticationManager(CustomCustomerDetailsService userDetailsService) {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userDetailsService);
	        provider.setPasswordEncoder(passwordEncoder());
	        return new ProviderManager(Collections.singletonList(provider));
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
		/*
		 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
		 * throws Exception {
		 * 
		 * return http.csrf(customizer -> customizer.disable())
		 * .authorizeHttpRequests(request -> request.requestMatchers("/login",
		 * "/register", "/pdf/generate") .permitAll().requestMatchers("login",
		 * "register").permitAll().anyRequest().authenticated())
		 * .httpBasic(Customizer.withDefaults()) .sessionManagement(session ->
		 * session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		 * .addFilterBefore(jwtFilter,
		 * UsernamePasswordAuthenticationFilter.class).build();
		 * 
		 * }*/
