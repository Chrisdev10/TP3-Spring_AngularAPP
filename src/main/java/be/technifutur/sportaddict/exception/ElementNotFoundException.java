package be.technifutur.sportaddict.exception;

public class ElementNotFoundException extends RuntimeException{

    private final Object id;
    private final Class<?> clas;

    public ElementNotFoundException(Object id, Class<?> clas) {
        super("Element of id ["+id+"] not found");
        this.id = id;
        this.clas = clas;
    }
}
