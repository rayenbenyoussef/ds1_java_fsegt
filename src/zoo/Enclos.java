package src.zoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import src.exceptions.AnimalNotFoundException;
import src.exceptions.AnimalNotIncludedException;
import src.exceptions.FullEnclosureException;
import src.exceptions.TypeAnimalNotValidException;
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

    public boolean validAnimal(String nom) throws FileNotFoundException{
        File myObj = new File("src/zoo/animals.txt");
        Scanner myReader = new Scanner(myObj);
        String data="";
        while (myReader.hasNextLine()&& !nom.toLowerCase().equals(data.toLowerCase())) {
            data = myReader.nextLine();
        }
        myReader.close();
        
        return nom.toLowerCase().equals(data.toLowerCase());
    }

    public void setNom(String nom) throws TypeAnimalNotValidException,FileNotFoundException{
        if (!validAnimal(nom)) {
            throw new TypeAnimalNotValidException();
        }
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
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    public void ajouterAnimal(Animal a)  throws FullEnclosureException,AnimalNotIncludedException{
        if (this.animaux.size()==this.capaciteMax){
            throw new FullEnclosureException();
            
        }else if(!a.getNom().toLowerCase().equals(this.nom.toLowerCase())){
            throw new AnimalNotIncludedException();
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

    public String getNom(){
        return this.nom;
    }

    public String toString(){
        String animS="";
        for (Animal a : this.animaux) {
                animS+=a.toString()+"\n";
            }
        return "Nom enclos: "+this.nom+" | Localite: "+this.localite+" | superficie: "+this.superficie+"m² \n Animals list:\n "+animS;
    }
}
