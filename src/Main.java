package src;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.exceptions.AnimalNotFoundException;
import src.exceptions.AnimalNotIncludedException;
import src.exceptions.DeplacementImpossibleException;
import src.exceptions.EnclosNotFoundException;
import src.exceptions.FullEnclosureException;
import src.exceptions.TypeAnimalNotValidException;
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
    public static final String PURPLE = "\u001B[35m";

    public static final String datasform="d M yyyy";
    public static LocalDate dateInput(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datasform);
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        return date ;
    }

    public static void logo(){
        System.out.println(PURPLE+"  ______                 _        ______              _   \n" + //
                        " |___  /                | |      |  ____|            | |  \n" + //
                        "    / / ___   ___     __| | ___  | |__ ___  ___  __ _| |_ \n" + //
                        "   / / / _ \\ / _ \\   / _` |/ _ \\ |  __/ __|/ _ \\/ _` | __|\n" + //
                        "  / /_| (_) | (_) | | (_| |  __/ | |  \\__ \\  __/ (_| | |_ \n" + //
                        " /_____\\___/ \\___/   \\__,_|\\___| |_|  |___/\\___|\\__, |\\__|\n" + //
                        "                                                 __/ |    \n" + //
                        "                                                |___/     "+RESET);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo zoo_fsegt=new Zoo();
        logo();
        int c=0;
        do{
        System.out.println("----------------------------------------------------------");
        System.out.println(YELLOW+"1."+GREEN+" Ajouter un enclos.");
        System.out.println(YELLOW+"2."+GREEN+" Ajouter un animal.");
        System.out.println(YELLOW+"3. Déplacer un animal.");
        System.out.println(YELLOW+"4."+RED+" Supprimer un animal.");
        System.out.println(YELLOW+"5."+GREEN+" Afficher tous les animaux.");
        System.out.println(YELLOW+"6."+GREEN+" Rechercher un animal par ID.");
        System.out.println(RED+"0. Quitter l'application.");
        System.out.print(YELLOW+"Choose: "+RESET);

        try {
            c = sc.nextInt();
            sc.nextLine();
            clearScreen();
            logo();
            System.out.println("----------------------------------------------------------");
            switch (c) {
            case 1:
                try {
                    System.out.println(GREEN+"----Ajouter un enclos----"+RESET);
                    Enclos enc=new Enclos();
                    System.out.print("    donner enclos nom: ");
                    String nom=sc.nextLine();
                    enc.setNom(nom);
                    System.out.print("    donner enclos localite: ");
                    String loc=sc.nextLine();
                    enc.setLoc(loc);
                    System.out.print("    donner enclos capacite max: ");
                    int max=sc.nextInt();
                    enc.setMax(max);
                    System.out.print("    donner enclos superficie: ");
                    float sup=sc.nextFloat();
                    enc.setSup(sup);
                
                    zoo_fsegt.ajouterEnclos(enc);
                } catch (TypeAnimalNotValidException e) {
                    System.err.println(e);
                } catch (FileNotFoundException e) {
                    System.err.println(e);
                }catch(InputMismatchException e){
                    System.err.println(e);
                    sc.nextLine();
                }
                
                break;
            case 2:
                try {
                    System.out.println(GREEN+"----Ajouter un animal----"+RESET);
                    System.out.print("    donner enclos id: ");
                    String id=sc.nextLine();

                    System.out.print("    donner animal nom: ");
                    String nom=sc.nextLine();

                    System.out.print("    donner animal date de naissance("+datasform+"): ");
                    LocalDate date=dateInput(sc.nextLine());

                    int type;
                    do{
                        System.out.print("    donner type de animal(1.Mammifere, 2.Oiseau, 3.Reptile): ");
                        type=sc.nextInt();
                        sc.nextLine();
                    }while(type!=1&&type!=2&&type!=3);

                
                    Animal a;
                    switch (type) {
                        case 1:
                            a=new Mammifere();
                            a.setNom(nom);
                            a.setDateN(date);

                            System.out.print("    donner animal espece: ");
                            ((Mammifere)a).setEspece(sc.nextLine());
                            break;
                        case 2:
                            a=new Oiseau();
                            a.setNom(nom);
                            a.setDateN(date);

                            System.out.print("    donner animal envergure: ");
                            ((Oiseau)a).setEnvergure(sc.nextLine());
                            break;
                        case 3:
                            a=new Reptile();
                            a.setNom(nom);
                            a.setDateN(date);

                            System.out.print("    donner animal venimeux(1:oui, 0:non): ");
                            ((Reptile)a).setVenimeux(sc.nextInt());
                            break;
                        default:
                            a=new Mammifere();
                    }
                
                    zoo_fsegt.getEnclos(id).ajouterAnimal(a);
                }catch (DateTimeParseException e) {
                    System.err.println(RED+"Not valid date"+RESET);
                } catch (FullEnclosureException e) {
                    System.err.println(e);
                } catch (InputMismatchException e) {
                    System.err.println(e);
                }catch(EnclosNotFoundException e){
                    System.err.println(e);

                }catch(AnimalNotIncludedException e){
                    System.err.println(e);

                }
                break;
            case 3:
                System.out.println(YELLOW+"----Déplacer un animal----"+RESET);
                System.out.print("    donner animal id: ");
                String ida=sc.nextLine();

                System.out.print("    donner old enlos id: ");
                String ide1=sc.nextLine();
                System.out.print("    donner new enclos id: ");
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
                catch (AnimalNotIncludedException e) {
                    System.err.println(e);
                }catch(EnclosNotFoundException e){
                    System.err.println(e);
                }
                
                break;
            case 4:
                System.out.println(RED+"----Supprimer un animal----"+RESET);
                System.out.print("    donner animal id: ");
                ida=sc.nextLine();

                System.out.print("    donner enclos id: ");
                String ide=sc.nextLine();

                try {
                    zoo_fsegt.getEnclos(ide).enleverAnimal(zoo_fsegt.getEnclos(ide).getAniamlById(ida));
                } catch (AnimalNotFoundException e) {
                    System.err.println(e);
                }catch(EnclosNotFoundException e){
                    System.err.println(e);

                }
                
                break;
            case 5:
                System.out.println(GREEN+"----Affiche tous les animaux----"+RESET);
                zoo_fsegt.afficherTousLesAnimaux();
                break;
            case 6:
                System.out.println(GREEN+"----Rechercher un animal par ID----"+RESET);
                System.out.print("    donner animal id: ");
                ida=sc.nextLine();
                for (String i : zoo_fsegt.getEnclos().keySet()) {
                    if(zoo_fsegt.getEnclos().get(i).getAniamlById(ida)==null){
                        continue;
                    }else{
                        System.out.println("Animal found in enclos: id="+i+" nom="+zoo_fsegt.getEnclos().get(i).getNom());
                        System.out.println(zoo_fsegt.getEnclos().get(i).getAniamlById(ida).toString());
                        break;
                    }
                }
                System.out.println(YELLOW+" Animal not found."+RESET);
                break;
            case 0:
                break;
            default: System.out.println(RED+"Invalid choice."+RESET); break;
            } 
            } catch (InputMismatchException e) {
                System.err.println(RED+"Invalid input."+RESET);
                sc.nextLine();
                c=7;
            }
        }while(c!=0);
    sc.close();
    }
}
