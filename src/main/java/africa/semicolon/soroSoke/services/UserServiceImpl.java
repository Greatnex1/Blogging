package africa.semicolon.soroSoke.services;

import africa.semicolon.soroSoke.data.models.User;
import africa.semicolon.soroSoke.data.repository.UserRepository;
import africa.semicolon.soroSoke.dto.request.LoginRequest;
import africa.semicolon.soroSoke.dto.request.RegisterUserRequest;
import africa.semicolon.soroSoke.dto.response.LoginResponse;
import africa.semicolon.soroSoke.dto.response.RegisterUserResponse;
import africa.semicolon.soroSoke.exceptions.InvalidUserException;
import africa.semicolon.soroSoke.exceptions.UserExistException;
import africa.semicolon.soroSoke.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) throws UserExistException {
        verify(request, userRepository);
        User user = new User();
        Mapper.map(request, user);
        userRepository.save(user);

        RegisterUserResponse registerResponse = new RegisterUserResponse();
        registerResponse.setMessage(String.format("%s Registered! ", request.getEmail()));

        return registerResponse;
    }

    @Override
    public LoginResponse userLogin(LoginRequest loginRequest) throws InvalidUserException {
        validate(loginRequest, userRepository);
        User user = new User();
        Mapper.approve(loginRequest, user);
        userRepository.save(user);
        LoginResponse login = new LoginResponse();
        if(!Objects.equals(user.getPassword(),loginRequest.getPassword())){
            throw new InvalidUserException(loginRequest.getPassword() + "Incorrect username or password");
        }
        else{
            login.setMessage("Welcome " + loginRequest.getUsername());
        }
        login.setMessage(String.format("User is Active"));

        return login;
    }

    private void validate(LoginRequest loginRequest, UserRepository userRepository) {
        User user = userRepository.findUserByEmail(loginRequest.getEmail());
        if (user == null) {
            throw new InvalidUserException(loginRequest.getUsername() + " Enter your password or username correctly ");
        }


    }

    private void verify(RegisterUserRequest request, UserRepository userRepository) {
        User savedUser = userRepository.findUserByEmail(request.getEmail());
        if (savedUser != null) { throw new UserExistException(request.getEmail() + " this email is already used");
        }
    }

}
