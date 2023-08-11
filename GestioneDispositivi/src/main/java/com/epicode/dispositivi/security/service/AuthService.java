package com.epicode.dispositivi.security.service;

import com.epicode.dispositivi.security.payload.LoginDto;
import com.epicode.dispositivi.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
