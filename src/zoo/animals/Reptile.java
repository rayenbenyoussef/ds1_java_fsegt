package src.zoo.animals;

import java.util.InputMismatchException;

public class Reptile extends Animal implements Herbivore,Carnivore{
    private Boolean venimeux;
    public static int nbM=0;
    public Reptile(){
        super("R0"+nbM);
        this.venimeux=null;
        nbM++;
    }

    public void chasser(){
        System.out.println("run");
    }
    
    public void brouter(){
        System.out.println("i eat grass");
    }

    public void crier(){
        System.out.println("je crie");
    }
    public void manger(){
        System.out.println("je mange");
    }
    public void afficherInfos(){
        System.out.println("id: "+getId()+" nom: "+getNom()+"\nage: "+calculAge()+" venimeux: "+this.venimeux);
    }

    public void setVenimeux(int venimeux) throws InputMismatchException{
        if(venimeux!=1 || venimeux!=0)throw new InputMismatchException();
        this.venimeux=venimeux==1;
    }
}
