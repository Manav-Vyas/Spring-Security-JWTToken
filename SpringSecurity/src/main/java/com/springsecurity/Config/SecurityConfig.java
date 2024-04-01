package com.springsecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecurity.JWTAuthentication.JwtAuthenticationEntryPoint;
import com.springsecurity.JWTAuthentication.JwtAuthenticationFilter;

//import com.springsecurity.JWTAuthentication.JwtAuthenticationEntryPoint;
//import com.springsecurity.JWTAuthentication.JwtAuthenticationFilter;


@Configuration
//@EnableMethodSecurity
public class SecurityConfig {
	
//	@Autowired
//	private JwtAuthenticationFilter filter;
//	
//	@Autowired
//	private JwtAuthenticationEntryPoint point;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		http.csrf(csrf -> csrf.disable()).cors(cors->cors.disable())
//		.authorizeHttpRequests(authorize->authorize.requestMatchers("/secure/**").authenticated()
//		.requestMatchers("/auth/login").permitAll().anyRequest().authenticated())
//		.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		
//		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//		return http.build();
//	}
	

	

	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails user = User.builder().username("Manav").password(passwordEncoder().encode("Manav@123")).roles("USER").build();
		UserDetails admin = User.builder().username("man").password(passwordEncoder().encode("man@123")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }
}

