package africa.semicolon.soroSoke.exceptions;

public class InvalidUserException extends RuntimeException{
    String message;

    public InvalidUserException(String messages) {
        super(messages);
    }
}
