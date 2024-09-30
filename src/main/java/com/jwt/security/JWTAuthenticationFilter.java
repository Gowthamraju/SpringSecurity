package com.jwt.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter  extends OncePerRequestFilter {

    private JWTTokenProvider jwtTokenProvider;

    private UserDetailsService userDetails;

    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     String token = getToken(request);
        System.out.println(request);
     if(StringUtils.hasText(token) && jwtTokenProvider.validate(token)){
         String name = jwtTokenProvider.getUsername(token);

         UserDetails details = inMemoryUserDetailsManager.loadUserByUsername(name);
         System.out.println("Username "+details.getUsername()+" Password : "+details.getPassword());
        /* UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(details,
                 null,
                 details.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
         SecurityContextHolder.createEmptyContext().setAuthentication(authToken);*/
     }
     filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");
        System.out.println("BearerToken "+bearerToken);
        if(StringUtils.hasText(bearerToken) && StringUtils.startsWithIgnoreCase(bearerToken,"Basic ")){
            return  bearerToken.substring(7);
        }
        return null;
    }
}
