package africa.semicolon.soroSoke.data.repository;

import africa.semicolon.soroSoke.data.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    // only spring-bin can be autowired
    @Autowired
    private UserRepository userRepository;
    @Test
    public void saveTest(){
        User user = new User();
        var savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());


    }



}