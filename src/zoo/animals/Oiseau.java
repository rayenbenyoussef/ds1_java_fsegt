package src.zoo.animals;

import src.exceptions.NotValidEnvergureException;

public class Oiseau extends Animal implements Herbivore,Carnivore{
    private float envergure;
    public static int nbM=0;
    public Oiseau(){
        super("O0"+nbM);
        this.envergure=0;
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
    public String toString(){
        return "   id: "+getId()+" | nom: "+getNom()+" | age: "+calculAge()+" | envergure: "+this.envergure+"m";
    }

    public void setEnvergure(float envergure) throws NotValidEnvergureException{
        if(envergure<0)throw new NotValidEnvergureException();
        this.envergure=envergure;
    }
}
