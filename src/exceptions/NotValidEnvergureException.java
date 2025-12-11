package src.exceptions;

public class NotValidEnvergureException extends Exception {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public String toString(){
        return RED+"Not valid Number, its negatif or massive."+RESET;
    }
}
