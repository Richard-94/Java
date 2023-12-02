package com.epicode.dispositivi.security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.dispositivi.security.entity.User;
import com.epicode.dispositivi.security.model.ErrorPassword;
import com.epicode.dispositivi.security.model.ErrorResponse;
import com.epicode.dispositivi.security.payload.JWTAuthResponse;
import com.epicode.dispositivi.security.payload.LoginDto;
import com.epicode.dispositivi.security.payload.RegisterDto;
import com.epicode.dispositivi.security.payload.RegisterResponse;
import com.epicode.dispositivi.security.payload.updateUserDto;
import com.epicode.dispositivi.security.repository.UserRepository;
import com.epicode.dispositivi.security.service.AuthService;
import com.epicode.dispositivi.security.service.AuthServiceImpl;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired private UserRepository userRepo;
	
	@Autowired  AuthServiceImpl authServ;
	
	

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            Optional<User> userOptional = userRepo.findByUsername(loginDto.getUsername());

            if (userOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Invalid username"));
            }

            // User exists, proceed with authentication
            String token = authService.login(loginDto);

            JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
            jwtAuthResponse.setUsername(loginDto.getUsername());
            jwtAuthResponse.setAccessToken(token);

            return ResponseEntity.ok(jwtAuthResponse);
        } catch (AuthenticationException e) {
            // Authentication failure (password error)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorPassword("Password sbagliata"));
        }
    }
    
    @PatchMapping(value = {"/updatepassword"})
    public ResponseEntity<?> update(@RequestBody updateUserDto updateDto){
    	User response = authServ.updatePassword(updateDto);
        return new ResponseEntity<User>(response, HttpStatus.OK);
    }
    
    
    



    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
    	RegisterResponse response = authService.register(registerDto);
        return new ResponseEntity<RegisterResponse>(response, HttpStatus.CREATED);
    }
    
    // JSON inviato dal Client
    /*{
        "name": "Giuseppe",
        "lastname": "Verdi",
        "username": "giuseppevardi",
        "email": "g.verdi@example.com",
        "password": "qwerty",
        "roles": ["MODERATOR", "ADMIN"]
    }*/
}
