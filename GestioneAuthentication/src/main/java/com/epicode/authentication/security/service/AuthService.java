package com.epicode.authentication.security.service;

import com.epicode.authentication.security.payload.LoginDto;
import com.epicode.authentication.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
