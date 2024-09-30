package com.jwt.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class CustomInMemoryUserDetails extends InMemoryUserDetailsManager {

    UserDetails loadUserByUserName(String name){
        return User.builder()
                .username(name)
                .password("password")
                .credentialsExpired(false)
                .accountExpired(false).build();

    }
}
