package com.jwt.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {
 private AuthenticationManager authenticationManager;

 private JWTTokenProvider jwtTokenProvider;

 public String login(AuthDTO auth){
     /*Authentication authentication = authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(auth.getUser(),auth.getPassword()));
     SecurityContextHolder.createEmptyContext().setAuthentication(authentication);*/
     System.out.println("Inside login ");
     String token = jwtTokenProvider.generate(auth.getUser());
     System.out.println("token generated : "+token);
     return token;
 }

}
