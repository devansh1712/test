package com.BlogApp_With_Mircroservices.controller;

import com.BlogApp_With_Mircroservices.entity.User;
import com.BlogApp_With_Mircroservices.payload.Signup;
import com.BlogApp_With_Mircroservices.repository.UserRepository;
import com.BlogApp_With_Mircroservices.payload.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

      @Autowired
      private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder getpasswordEncoder;
//http://localhost:8080/api/auth/sign-up
@PostMapping("/sign-up")
    private ResponseEntity<String> createUSer( @RequestBody Signup signup){

        if(userRepository.existsByEmail(signup.getEmail())){
            return  new ResponseEntity<>("email id is already registered", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(userRepository.existsByUsername(signup.getEmail())){
            return  new ResponseEntity<>("user name is already registered ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        User user = new User();
        user.setId(signup.getId());
        user.setName(signup.getName());
        user.setEmail(signup.getEmail());
        user.setPassword(getpasswordEncoder.encode(signup.getPassword()));
        user.setUsername(signup.getUsername());

        userRepository.save(user);
        return  new ResponseEntity<>("user registered ",HttpStatus.CREATED);

    }

    //SIGNIN FEATURE
    @PostMapping("/sign-in")
    public  ResponseEntity<String> signIn(@RequestBody LoginDto loginDto){
    //1. Supply loginDto.getUsername()-username to loadByUser method in CustomUserDetail class
    //2. It will compare
    //Expected  Credentials - loginDto.getUsername(),loginDto.getPassword()
    //With Actual Credentials given by loadByUser method
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //Similar to session Variable
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("sign in successful",HttpStatus.OK);
    }
}
