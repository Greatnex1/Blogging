package africa.semicolon.soroSoke.services;

import africa.semicolon.soroSoke.data.repository.UserRepository;
import africa.semicolon.soroSoke.dto.request.LoginRequest;
import africa.semicolon.soroSoke.dto.request.RegisterUserRequest;
import africa.semicolon.soroSoke.dto.response.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
           void up (){
        RegisterUserRequest registerUserForm = new RegisterUserRequest();
        registerUserForm.setUsername("dove");
        registerUserForm.setEmail("dow");
        registerUserForm.setPassword("dowex");
        userServiceImpl.registerUser(registerUserForm);

    }

    @Test
    public void registerUser_repositorySizeIsOneTest(){
              assertEquals(1L,userRepository.count());
//      asserThat(userRepository.count(), is(1l));

    }
    @Test
    public void loginUserTest(){

        LoginRequest loginUser = new LoginRequest();
        loginUser.setEmail("dow");
        loginUser.setPassword("dowex");
        loginUser.setUsername("dove");
       userServiceImpl.userLogin(loginUser);
        assertEquals("dow",loginUser.getEmail());



    }


}