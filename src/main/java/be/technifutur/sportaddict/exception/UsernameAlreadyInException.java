package be.technifutur.sportaddict.exception;

public class UsernameAlreadyInException extends RuntimeException{

    private final String username;
    private final Class<?> clas;
    public UsernameAlreadyInException(String username, Class<?> clas) {
        super("user "+username+" already exist");
        this.username = username;
        this.clas = clas;
    }
}
