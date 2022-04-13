package be.technifutur.sportaddict.exception;

public class EmailAlreadyInException extends RuntimeException{

    private final String mail;
    private final Class<?> clas;
    public EmailAlreadyInException(String mail, Class<?> clas) {
        super("mail ["+mail+"] already exist");
        this.mail = mail;
        this.clas = clas;
    }


}
