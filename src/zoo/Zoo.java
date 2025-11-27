package src.zoo;

import java.util.HashMap;
import src.zoo.animals.Animal;
import src.zoo.exceptions.AnimalNotFoundException;
import src.zoo.exceptions.DeplacementImpossibleException;
import src.zoo.exceptions.FullEnclosureException;

public class Zoo {
    private HashMap<String,Enclos> enclos;

    public Zoo(){
        this.enclos=new HashMap<String,Enclos>();
    }
    public void ajouterEnclos(String nom,Enclos e) throws FullEnclosureException{
        this.enclos.put(nom, e);
    }
    public void deplacerAnimal(Animal a,String oldEn,String newEn) throws AnimalNotFoundException, DeplacementImpossibleException, FullEnclosureException{
        this.enclos.get(newEn).ajouterAnimal(a);
        this.enclos.get(oldEn).enleverAnimal(a);
    }
    public void afficherTousLesAnimaux(){
        for (String i : this.enclos.keySet()) {
            System.out.println(this.enclos.get(i));  
        }
    }
}
