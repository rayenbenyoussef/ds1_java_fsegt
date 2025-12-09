package src.zoo;

import java.io.FileNotFoundException;
import java.util.HashMap;


import src.exceptions.AnimalNotFoundException;
import src.exceptions.AnimalNotIncludedException;
import src.exceptions.DeplacementImpossibleException;
import src.exceptions.EnclosNotFoundException;
import src.exceptions.FullEnclosureException;
import src.exceptions.TypeAnimalNotValidException;
import src.zoo.animals.Animal;

public class Zoo {
    private HashMap<String,Enclos> enclos;

    public Zoo(){
        this.enclos=new HashMap<String,Enclos>();
    }

    
    public void ajouterEnclos(Enclos e)throws FileNotFoundException,TypeAnimalNotValidException{
        this.enclos.put("E0"+this.enclos.size(), e);

    }
    public void deplacerAnimal(String id,String oldEn,String newEn) throws AnimalNotIncludedException, AnimalNotFoundException, DeplacementImpossibleException, FullEnclosureException{
        if(oldEn==newEn || !this.enclos.get(oldEn).getNom().toLowerCase().equals(this.enclos.get(newEn).getNom().toLowerCase())){
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
