package com.animal.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiKeyAuthManager implements AuthenticationManager {
    private final String key;
    
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        if (!key.equals(principal)) {
            throw new BadCredentialsException(
                    "The API key was not found or not the expected value.");
        } else {
            authentication.setAuthenticated(true);
            return authentication;
        }
    }
}
