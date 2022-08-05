package africa.semicolon.soroSoke.services;

import africa.semicolon.soroSoke.data.repository.UserRepository;
import africa.semicolon.soroSoke.dto.request.LoginRequest;
import africa.semicolon.soroSoke.dto.request.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUser_repositorySizeIsOneTest(){

        RegisterUserRequest registerUserForm = new RegisterUserRequest();
        registerUserForm.setEmail("dow");
        registerUserForm.setPassword("dowex");
        userServiceImpl.registerUser(registerUserForm);
        assertEquals(1L,userRepository.count());
//      asserThat(userRepository.count(), is(1l));

    }
    @Test
    public void loginUserTest(){
        RegisterUserRequest registerUserForm = new RegisterUserRequest();
        registerUserForm.setEmail("dow");
        registerUserForm.setPassword("dowex");
        userServiceImpl.registerUser(registerUserForm);
        LoginRequest loginUser = new LoginRequest();
        loginUser.setEmail("dow");
        loginUser.setPassword("dowex");
        userServiceImpl.userLogin(loginUser);
        assertEquals(1L,userRepository.count());



    }


}