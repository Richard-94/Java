package com.epicode.dispositivi.security.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.entity.ERole;
import com.epicode.dispositivi.security.entity.Role;
import com.epicode.dispositivi.security.exception.MyAPIException;
import com.epicode.dispositivi.security.model.ErrorResponse;
import com.epicode.dispositivi.security.payload.LoginDto;
import com.epicode.dispositivi.security.payload.RegisterDto;
import com.epicode.dispositivi.security.payload.RegisterResponse;
import com.epicode.dispositivi.security.payload.updateUserDto;
import com.epicode.dispositivi.security.repository.RoleRepository;
import com.epicode.dispositivi.security.repository.UserRepository;
import com.epicode.dispositivi.security.security.JwtTokenProvider;
import com.epicode.dispositivi.security.entity.User;





@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired private UserRepository userRepo;

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        
    	Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(
        				loginDto.getUsername(), loginDto.getPassword()
        		)
        ); 
    	
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
    

    

    @Override
    public RegisterResponse register(RegisterDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }
        
        // add check for secretCode exists in database
//        if(userRepository.existsBySecretCode(registerDto.getSecretCode())){
//            throw new MyAPIException(HttpStatus.BAD_REQUEST, "SecretCode is already exists!.");
//        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        //user.setDate(LocalDateTime.now());
        //user.setSecretCode(registerDto.getSecretCode());
        //user.setCreditCard(registerDto.getCreditCard());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        
        if(registerDto.getRoles() != null) {
	        registerDto.getRoles().forEach(role -> {
	        	Role userRole = roleRepository.findByRoleName(getRole(role)).get();
	        	roles.add(userRole);
	        });
        } else {
        	Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER).get();
        	roles.add(userRole);
        }
        
        user.setRoles(roles);
        System.out.println(user);
        userRepository.save(user);
        
        return new RegisterResponse(
				registerDto.getName(), 
				registerDto.getUsername(), 
				registerDto.getEmail(), 
				"User registered successfully!.");
    }
    
    public User updatePassword(updateUserDto updateDto) {
    	
    		Optional<User> userOptional = userRepo.findByUsername(updateDto.getUsername());
    		

    	    if (userOptional.isEmpty()) {
    	        throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username non esiste");
    	    }

           
            User user = userOptional.get();
            if (!user.getUsername().equals(updateDto.getUsername())) {
                throw new MyAPIException(HttpStatus.BAD_REQUEST, "Provided username doesn't match existing user");
            }
            
            
            
            user.setPassword(passwordEncoder.encode(updateDto.getPassword()));
            return userRepository.save(user);
    }
    
    public ERole getRole(String role) {
    	if(role.equals("ADMIN")) return ERole.ROLE_ADMIN;
    	else if(role.equals("MODERATOR")) return ERole.ROLE_MODERATOR;
    	else return ERole.ROLE_USER;
    }
    
}
