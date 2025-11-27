package src.zoo.animals;
public class Oiseau extends Animal implements Herbivore,Carnivore{
    private String envergure;
    public static int nbM=0;
    public Oiseau(){
        super("O0"+nbM);
        this.envergure="";
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
        System.out.println("id: "+getId()+" nom: "+getNom()+"\nage: "+calculAge()+" envergure: "+this.envergure);
    }

    public void setEnvergure(String envergure){
        this.envergure=envergure;
    }
}
