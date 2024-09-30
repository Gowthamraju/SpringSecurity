package com.jwt.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServiceController {
    private AuthServiceImpl authService;
    private CustomUserDetailService userDetailService;
    private JWTTokenProvider provider;
    @PostMapping("/login/token")
    public ResponseEntity<AuthReponse> loginUser(@RequestBody AuthDTO authDTO){
        String token = authService.login(authDTO);

        AuthReponse reponse  =new AuthReponse();

        reponse.setAccessToken(token);
  return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
   @GetMapping("/find")
    public User search(@PathVariable String name){
       User user = userDetailService.find(name);
        return new ResponseEntity<User>(user,HttpStatus.OK).getBody();
   }
}
