package src.zoo.animals;
import java.time.LocalDate;

public abstract class Animal {
    private String id ;
    private String nom;
    private LocalDate dateN;

    public Animal(String id){
        this.id=id;
        this.nom="";
        this.dateN=null;
        
    }
    public abstract void crier();
    public abstract void manger();
    public abstract void afficherInfos();
    
    public int calculAge(){
        return LocalDate.now().getYear()-this.dateN.getYear();
    }

    public String getId(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    public LocalDate getDareN(){
        return this.dateN;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setDateN(LocalDate date){
        this.dateN=date;
    }
}
