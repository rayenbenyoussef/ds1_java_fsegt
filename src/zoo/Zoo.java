package src.zoo;

import java.util.HashMap;

import src.exceptions.AnimalNotFoundException;
import src.exceptions.DeplacementImpossibleException;
import src.exceptions.EnclosNotFoundException;
import src.exceptions.FullEnclosureException;
import src.zoo.animals.Animal;

public class Zoo {
    private HashMap<String,Enclos> enclos;

    public Zoo(){
        this.enclos=new HashMap<String,Enclos>();
    }
    public void ajouterEnclos(Enclos e){
        this.enclos.put("E0"+this.enclos.size(), e);
    }
    public void deplacerAnimal(String id,String oldEn,String newEn) throws AnimalNotFoundException, DeplacementImpossibleException, FullEnclosureException{
        if(oldEn==newEn){
            throw new DeplacementImpossibleException();
        }else{
            Animal a=this.enclos.get(oldEn).getAniamlById(id);
            if(a==null){throw new AnimalNotFoundException();}
            this.enclos.get(newEn).ajouterAnimal(a);
            this.enclos.get(oldEn).enleverAnimal(a);
        }
        
    }
    public void afficherTousLesAnimaux(){
        for (String i : this.enclos.keySet()) {
            System.out.println("enclos id: "+i+" "+this.enclos.get(i));  
        }
    }

    public Enclos getEnclos(String id) throws EnclosNotFoundException {
        if (this.enclos.get(id)==null) {throw new EnclosNotFoundException();}
        return this.enclos.get(id);
    }

    public HashMap<String,Enclos> getEnclos(){
        return this.enclos;
    }
}
