package src.exceptions;

public class AnimalNotFoundException extends Exception{
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public String toString(){
        return RED+"Animal not found please check the ID."+RESET;
    }
}
