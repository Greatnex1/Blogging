package africa.semicolon.soroSoke.utils;

import africa.semicolon.soroSoke.data.models.User;
import africa.semicolon.soroSoke.dto.request.LoginRequest;
import africa.semicolon.soroSoke.dto.request.RegisterUserRequest;

public class Mapper {
    public static void map(RegisterUserRequest request, User user) {
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }

    public static void map(LoginRequest loginRequest, User user){
        user.setEmail(loginRequest.getEmail());
        user.setPassword(loginRequest.getPassword());


    }
}
