package africa.semicolon.soroSoke.services;

import africa.semicolon.soroSoke.dto.request.LoginRequest;
import africa.semicolon.soroSoke.dto.request.RegisterUserRequest;
import africa.semicolon.soroSoke.dto.response.LoginResponse;
import africa.semicolon.soroSoke.dto.response.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);



    LoginResponse userLogin(LoginRequest loginRequest);
}
