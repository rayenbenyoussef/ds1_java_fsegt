package src;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import src.exceptions.AnimalNotFoundException;
import src.exceptions.DeplacementImpossibleException;
import src.exceptions.FullEnclosureException;
import src.zoo.Enclos;
import src.zoo.Zoo;
import src.zoo.animals.Animal;
import src.zoo.animals.Mammifere;
import src.zoo.animals.Oiseau;
import src.zoo.animals.Reptile;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String MYELLOW = "\u001B[43m";
    public static final String WHITE = "\u001B[37m";
    public static LocalDate dateInput(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        return date ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo zoo_fsegt=new Zoo();
        System.out.println("  ______                 _        ______              _   \n" + //
                        " |___  /                | |      |  ____|            | |  \n" + //
                        "    / / ___   ___     __| | ___  | |__ ___  ___  __ _| |_ \n" + //
                        "   / / / _ \\ / _ \\   / _` |/ _ \\ |  __/ __|/ _ \\/ _` | __|\n" + //
                        "  / /_| (_) | (_) | | (_| |  __/ | |  \\__ \\  __/ (_| | |_ \n" + //
                        " /_____\\___/ \\___/   \\__,_|\\___| |_|  |___/\\___|\\__, |\\__|\n" + //
                        "                                                 __/ |    \n" + //
                        "                                                |___/     ");
        int c=0;
        do{
        System.out.println("----------------------------------------------------------");
        System.out.println(YELLOW+"1."+GREEN+" Ajouter un enclos.");
        System.out.println(YELLOW+"2."+GREEN+" Ajouter un animal.");
        System.out.println(YELLOW+"3. Déplacer un animal.");
        System.out.println(YELLOW+"4."+RED+" Supprimer un animal.");
        System.out.println(YELLOW+"5."+GREEN+" Afficher tous les animaux.");
        System.out.println(YELLOW+"6."+GREEN+" Rechercher un animal par ID.");
        System.out.println(RED+"0. Quitter l’application.");
        System.out.print(YELLOW+"Choose: "+RESET);
        try {
            c = sc.nextInt();
            switch (c) {
            case 1:
                Enclos enc=new Enclos();
                System.out.println("donner enclos nom: ");
                String nom=sc.nextLine();
                enc.setNom(nom);
                System.out.println("donner enclos localite: ");
                String loc=sc.nextLine();
                enc.setLoc(loc);
                System.out.println("donner enclos capacite max: ");
                int max=sc.nextInt();
                enc.setMax(max);
                System.out.println("donner enclos superficie: ");
                float sup=sc.nextFloat();
                enc.setSup(sup);
                
                zoo_fsegt.ajouterEnclos(enc);
                break;
            case 2:
                System.out.print("donner enclos id: ");
                String id=sc.nextLine();

                System.out.print("donner animal nom: ");
                nom=sc.nextLine();

                System.out.print("donner animal date de naissance(d M yyyy): ");
                LocalDate date=dateInput(sc.nextLine());

                String type;
                do{
                    System.out.print("donner type de animal(1.Mammifere, 2.Oiseau, 3.Reptile): ");
                    type=sc.nextLine();
                }while(type!="1"&&type!="2"&&type!="3");

                
                Animal a;
                switch (type) {
                    case "1":
                        a=new Mammifere();
                        a.setNom(nom);
                        a.setDateN(date);

                        System.out.print("donner animal espece: ");
                        ((Mammifere)a).setEspece(sc.nextLine());
                        break;
                    case "2":
                        a=new Oiseau();
                        a.setNom(nom);
                        a.setDateN(date);

                        System.out.print("donner animal envergure: ");
                        ((Oiseau)a).setEnvergure(sc.nextLine());
                        break;
                    case "3":
                        a=new Reptile();
                        a.setNom(nom);
                        a.setDateN(date);

                        System.out.print("donner animal venimeux(1:oui, 0:non): ");
                        ((Reptile)a).setVenimeux(sc.nextInt());
                        break;
                    default:
                        a=new Mammifere();
                }
                try {
                    zoo_fsegt.getEnclos(id).ajouterAnimal(a);
                } catch (FullEnclosureException e) {
                    System.err.println(e);
                }
            case 3:
                System.out.print("donner animal id: ");
                String ida=sc.nextLine();

                System.out.print("donner old enlos id: ");
                String ide1=sc.nextLine();
                System.out.print("donner new enclos id: ");
                String ide2=sc.nextLine();
                try {
                    zoo_fsegt.deplacerAnimal(ida,ide1,ide2);
                } catch (FullEnclosureException e) {
                    System.err.println(e);
                }
                catch (DeplacementImpossibleException e) {
                    System.err.println(e);
                }
                catch (AnimalNotFoundException e) {
                    System.err.println(e);
                }
                
                break;
            case 4:
                System.out.print("donner animal id: ");
                ida=sc.nextLine();

                System.out.print("donner enclos id: ");
                String ide=sc.nextLine();

                try {
                    zoo_fsegt.getEnclos(ide).enleverAnimal(zoo_fsegt.getEnclos(ida).getAniamlById(ida));
                } catch (AnimalNotFoundException e) {
                    System.err.println(e);
                }
                
                break;
            case 5:
                zoo_fsegt.afficherTousLesAnimaux();
                break;
            case 6:
                System.out.print("donner animal id: ");
                ida=sc.nextLine();
                for (String i : zoo_fsegt.getEnclos().keySet()) {
                    if(zoo_fsegt.getEnclos().get(i).getAniamlById(ida)==null){
                        System.err.println("animal not found");
                    }else{
                        zoo_fsegt.getEnclos().get(i).getAniamlById(ida).afficherInfos();
                    }
                }
                break;
            case 0:
                break;
            default: System.out.println("Invalid choice."); break;
            } 
        } catch (NumberFormatException e) {
            System.err.println("invalid input.");
        }
        }while(c!=0);
    
    }
}
