package com.jwt.security;

import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {
 //private UserDetailsService userDetailsService;
 private JWTAuthenticationFilter jwtAuthenticationFilter;
 private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

 @Bean
 public  static PasswordEncoder passwordEncoder(){
     return new BCryptPasswordEncoder();

 }
/*
 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http.csrf( csrf -> csrf.disable())
             .authorizeHttpRequests((auth)-> auth.anyRequest().permitAll());

     *//*http.exceptionHandling( exception -> exception
             .authenticationEntryPoint(jwtAuthenticationEntryPoint));

     http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
*//*
     return http.build();
 }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }*/
}
