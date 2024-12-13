package com.ecommerce.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	private final JwtAuthentificationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf(AbstractHttpConfigurer::disable)
			.cors(Customizer.withDefaults())
			.headers(headers -> headers.frameOptions(frame -> frame.disable()))
			.authorizeHttpRequests(req -> 
			req.requestMatchers("/auth").permitAll()
			.requestMatchers(HttpMethod.POST, "/user").permitAll()
			.requestMatchers(HttpMethod.POST, "/user/seller").permitAll()
			.requestMatchers(HttpMethod.POST, "/user/forgot-password").permitAll()
			.requestMatchers("/h2-console","/h2-console/**").permitAll()
			.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()			
			.anyRequest().authenticated()
			)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authenticationProvider(authenticationProvider)
			.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
			
			
		
		return http.build();
	}

}
