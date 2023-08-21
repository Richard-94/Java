package com.epicode.prenotazione.security.service;

import com.epicode.prenotazione.security.payload.LoginDto;
import com.epicode.prenotazione.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
