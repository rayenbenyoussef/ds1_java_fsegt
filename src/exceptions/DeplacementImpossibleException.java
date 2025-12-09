package src.exceptions;

public class DeplacementImpossibleException extends Exception{
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public String toString(){
        return RED+"Can't deplace the animal check ur inputs."+RESET;
    }
}
