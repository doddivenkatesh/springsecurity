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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecurity.springsecurity.kovela.security.AuthEntryPointJwt;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthEntryPointJwt authEntryPointJwt;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(requests -> requests
	            .requestMatchers(
	                "/register",
	                "/api/register",
	                "/api/login",
	                "/pdf/generate",
	                "/api/courses/**" // Allow all under /api/courses
	            ).permitAll()
	            .anyRequest().authenticated()
	        )
	        .exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPointJwt))
	        .httpBasic(Customizer.withDefaults())
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	        .build();
	}


	/*@Bean   it is also used 
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.requestMatchers( "/register", 
						"/pdf/generate",
						"/api/register",
						  "/api/courses/**" // Allow all endpoints under /api/courses
						)
						.permitAll().requestMatchers
						( "register",
						"/api/register",
						"/api/login")
						.permitAll().anyRequest().authenticated())
				.exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPointJwt))
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).build();

	}
*/
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

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);

		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

//	    @Bean
//	    public UserDetailsService userDetailsService() {
	//
//	        UserDetails user1 = User
//	                .withDefaultPasswordEncoder()
//	                .username("kiran")
//	                .password("k@123")
//	                .roles("USER")
//	                .build();
	//
//	        UserDetails user2 = User
//	                .withDefaultPasswordEncoder()
//	                .username("harsh")
//	                .password("h@123")
//	                .roles("ADMIN")
//	                .build();
//	        return new InMemoryUserDetailsManager(user1, user2);
//	    }

	/*@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);

		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();

	}*/
}
