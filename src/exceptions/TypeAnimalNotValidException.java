package src.exceptions;

public class TypeAnimalNotValidException extends Exception {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public String toString(){
        return RED+"This is not an animal please choose valid one."+RESET;
    }
}
