package main.service;

import main.api.response.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    AuthResponse authResponse = new AuthResponse();

    public AuthResponse getAuthResponse() {
        authResponse.setResult(true);
        authResponse.setUserResponse(authResponse.getUserResponse());
        return authResponse;
    }
}
