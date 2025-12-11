package src.zoo.animals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Animal {
    private String id ;
    private String nom;
    private LocalDate dateN;
    public static final String datasform="d M yyyy";

    public Animal(String id){
        this.id=id;
        this.nom="";
        this.dateN=null;
        
    }

    public abstract void crier();
    public abstract void manger();
    public abstract String toString();
    
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
    public void setDateN(String sdate){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datasform);
        LocalDate date = LocalDate.parse(sdate, dateFormat);
        this.dateN=date;
    }
}
