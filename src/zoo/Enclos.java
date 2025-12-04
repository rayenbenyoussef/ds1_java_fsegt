package src.zoo;

import java.util.ArrayList;

import src.exceptions.AnimalNotFoundException;
import src.exceptions.FullEnclosureException;
import src.zoo.animals.Animal;

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

    public void setNom(String nom){
        this.nom=nom;
    }

    public void setLoc(String loc){
        this.localite=loc;
    }

    public void setMax(int max){
        this.capaciteMax=max;
    }

    public void setSup(float superficie){
        this.superficie=superficie;
    }

    public Animal getAniamlById(String id){
        for(Animal i : this.animaux){
            if(i.getId()==id){
                return i;
            }
        }
        return null;
    }

    public void ajouterAnimal(Animal a)  throws FullEnclosureException{
        if (this.animaux.size()==this.capaciteMax){
            throw new FullEnclosureException();
        }else{
            this.animaux.add(a);
        }
        
    }
    public void enleverAnimal(Animal a) throws AnimalNotFoundException{
        if(this.animaux.contains(a)){
            this.animaux.remove(a);
        }else{
            throw new AnimalNotFoundException();
        }
        
    }

    public String toString(){
        String animS="";
        for (Animal a : this.animaux) {
                animS+=a.getNom()+"\n";
            }
        return "nom enclos: "+this.nom+" localite: "+this.localite+" superficie: "+this.superficie+" animals list: "+animS;
    }
}
