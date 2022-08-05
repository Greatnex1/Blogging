package africa.semicolon.soroSoke.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RegisterUserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
