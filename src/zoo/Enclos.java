package src.zoo;

import java.util.ArrayList;
import src.zoo.animals.Animal;
import src.zoo.exceptions.AnimalNotFoundException;
import src.zoo.exceptions.FullEnclosureException;

public class Enclos  {
        private String nom,localite;
        private int capaciteMax;
        private ArrayList <Animal> animaux;
        private float superficie;
    public Enclos(){
        this.nom="";
        this.capaciteMax=0;
        this.animaux=new ArrayList<Animal>(capaciteMax);
        this.superficie=0;
        this.localite="";
    }
    public void ajouterAnimal(Animal a)  throws FullEnclosureException{
        this.animaux.add(a);
    }
    public void enleverAnimal(Animal a) throws AnimalNotFoundException{
        this.animaux.remove(a);
    }

    public String toString(){
        String animS="";
        for (Animal a : this.animaux) {
                animS+=a.getNom()+"\n";
            }
        return "nom enclos: "+this.nom+" localite: "+this.localite+" superficie: "+this.superficie+" animals list: "+animS;
    }
}
