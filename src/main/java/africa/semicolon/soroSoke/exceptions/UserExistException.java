package africa.semicolon.soroSoke.exceptions;

public class UserExistException extends RuntimeException{

    public  UserExistException(String message){
        super(message);
    }
}
