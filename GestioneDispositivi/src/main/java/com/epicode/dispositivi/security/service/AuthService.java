package com.epicode.dispositivi.security.service;

import com.epicode.dispositivi.security.payload.LoginDto;
import com.epicode.dispositivi.security.payload.RegisterDto;
import com.epicode.dispositivi.security.payload.RegisterResponse;

public interface AuthService {
    
	String login(LoginDto loginDto);
    
    RegisterResponse register(RegisterDto registerDto);
    
}
