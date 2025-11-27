package src.zoo.animals;

public class Mammifere extends Animal implements Carnivore,Herbivore{
    private String espece;
    public static int nbM=0;
    public Mammifere(){
        super("M0"+nbM);
        this.espece="";
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
        System.out.println("id: "+getId()+" nom: "+getNom()+"\nage: "+calculAge()+" espece: "+this.espece);
    }

    public void setEspece(String espece){
        this.espece=espece;
    }
}
