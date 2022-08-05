package africa.semicolon.soroSoke.services;

import africa.semicolon.soroSoke.data.models.User;
import africa.semicolon.soroSoke.data.repository.UserRepository;
import africa.semicolon.soroSoke.dto.request.LoginRequest;
import africa.semicolon.soroSoke.dto.request.RegisterUserRequest;
import africa.semicolon.soroSoke.dto.response.LoginResponse;
import africa.semicolon.soroSoke.dto.response.RegisterUserResponse;
import africa.semicolon.soroSoke.exceptions.UserExistException;
import africa.semicolon.soroSoke.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) throws UserExistException {
        verify(request,userRepository);
        User user = new User();
        Mapper.map(request,user);
        userRepository.save(user);

        RegisterUserResponse registerResponse = new RegisterUserResponse();
        registerResponse.setMessage (String.format("%s Registered! ", request.getEmail()));

        return registerResponse;
    }

    @Override
    public LoginResponse userLogin(LoginRequest loginRequest) {
        User user = new User();
      Mapper.map(loginRequest, user);
      LoginResponse response = new LoginResponse();
      response.setMessage(String.format("%s Welcome back" + user.getEmail()));
        return response;
    }

    private void verify(RegisterUserRequest request, UserRepository userRepository) {
        User savedUser = userRepository.findUserByEmail(request.getEmail());
        if (savedUser != null) { throw new UserExistException(request.getEmail() + " this email is already used");
        }
    }

}
