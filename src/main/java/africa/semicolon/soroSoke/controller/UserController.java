package africa.semicolon.soroSoke.controller;

import africa.semicolon.soroSoke.dto.request.LoginRequest;
import africa.semicolon.soroSoke.dto.request.RegisterUserRequest;
import africa.semicolon.soroSoke.dto.response.LoginResponse;
import africa.semicolon.soroSoke.dto.response.RegisterUserResponse;
import africa.semicolon.soroSoke.exceptions.UserExistException;
import africa.semicolon.soroSoke.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            RegisterUserResponse serviceResponse = userService.registerUser(request);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } catch (UserExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequest request) {
        try {
            LoginResponse serviceResponse = userService.userLogin(request);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } catch (UserExistException err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
