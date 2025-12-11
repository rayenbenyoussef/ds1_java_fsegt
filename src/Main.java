package src;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.exceptions.AnimalNotFoundException;
import src.exceptions.AnimalNotIncludedException;
import src.exceptions.DeplacementImpossibleException;
import src.exceptions.EnclosNotFoundException;
import src.exceptions.FullEnclosureException;
import src.exceptions.NotValidCapaciteException;
import src.exceptions.NotValidEnvergureException;
import src.exceptions.NotValidSuperficieException;
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
        System.out.println(YELLOW+"7."+GREEN+" Auto fill.");
        System.out.println(YELLOW+"8."+RED+" Clear all data.");
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
                break;
            case 2:
                Animal a;
                System.out.println(GREEN+"----Ajouter un animal----"+RESET);
                System.out.print("    donner enclos id: ");
                String id=sc.nextLine();

                int type;
                do{
                    System.out.print("    donner type de animal(1.Mammifere, 2.Oiseau, 3.Reptile): ");
                    type=sc.nextInt();
                    sc.nextLine();
                }while(type!=1&&type!=2&&type!=3);

                switch (type) {
                    case 1:
                        a=new Mammifere();
                        System.out.print("    donner animal espece: ");
                        ((Mammifere)a).setEspece(sc.nextLine());
                        break;
                    case 2:
                        a=new Oiseau();
                        System.out.print("    donner animal envergure: ");
                        ((Oiseau)a).setEnvergure(sc.nextFloat());
                        break;
                    case 3:
                        a=new Reptile();
                        System.out.print("    donner animal venimeux(1:oui, 0:non): ");
                        ((Reptile)a).setVenimeux(sc.nextInt());
                        break;
                    default:
                        a=new Mammifere();
                }

                System.out.print("    donner animal nom: ");
                nom=sc.nextLine();
                a.setNom(nom);

                System.out.print("    donner animal date de naissance("+datasform+"): ");
                String date=sc.nextLine();
                a.setDateN(date);

                zoo_fsegt.getEnclos(id).ajouterAnimal(a);
                
                break;
            case 3:
                System.out.println(YELLOW+"----Déplacer un animal----"+RESET);
                System.out.print("    donner animal id: ");
                String ida=sc.nextLine();

                System.out.print("    donner old enlos id: ");
                String ide1=sc.nextLine();
                System.out.print("    donner new enclos id: ");
                String ide2=sc.nextLine();

                zoo_fsegt.deplacerAnimal(ida,ide1,ide2);
                break;
            case 4:
                System.out.println(RED+"----Supprimer un animal----"+RESET);
                System.out.print("    donner animal id: ");
                ida=sc.nextLine();

                System.out.print("    donner enclos id: ");
                String ide=sc.nextLine();

                zoo_fsegt.getEnclos(ide).enleverAnimal(zoo_fsegt.getEnclos(ide).getAniamlById(ida));
                
                break;
            case 5:
                System.out.println(GREEN+"----Affiche tous les animaux----"+RESET);
                zoo_fsegt.afficherTousLesAnimaux();
                break;
            case 6:
                System.out.println(GREEN+"----Rechercher un animal par ID----"+RESET);
                System.out.print("    donner animal id: ");
                ida=sc.nextLine();
                boolean t=false;
                for (String i : zoo_fsegt.getEnclos().keySet()) {
                    if(zoo_fsegt.getEnclos().get(i).getAniamlById(ida)==null){
                        t=false;
                        continue;
                    }else{
                        System.out.println(GREEN+" Animal found in enclos: id="+i+" nom="+zoo_fsegt.getEnclos().get(i).getNom()+RESET);
                        System.out.println(zoo_fsegt.getEnclos().get(i).getAniamlById(ida).toString());
                        t=true;
                        break;
                    }
                }
                if(!t)System.out.println(YELLOW+" Animal not found."+RESET);
                break;
            case 7:
                Mammifere a1=new Mammifere();
                a1.setNom("cat");
                a1.setEspece("orange");
                a1.setDateN("1 10 2005");

                Mammifere a2=new Mammifere();
                a2.setNom("cat");
                a2.setEspece("blue");
                a2.setDateN("2 10 2012");

                Reptile a3=new Reptile();
                a3.setNom("snake");
                a3.setVenimeux(1);
                a3.setDateN("11 1 2005");

                Oiseau a4=new Oiseau();
                a4.setNom("bird");
                a4.setEnvergure(12);
                a4.setDateN("3 1 2005");

                Enclos e1=new Enclos();
                e1.setNom("cat");
                e1.setMax(1);
                e1.setLoc("tunis");
                e1.setSup(10);

                Enclos e2=new Enclos();
                e2.setNom("cat");
                e2.setMax(2);
                e2.setLoc("tunis");
                e2.setSup(10);
                e2.ajouterAnimal(a1);e2.ajouterAnimal(a2);

                Enclos e3=new Enclos();
                e3.setNom("snake");
                e3.setMax(2);
                e3.setLoc("tunis");
                e3.setSup(10);
                e3.ajouterAnimal(a3);

                Enclos e4=new Enclos();
                e4.setNom("bird");
                e4.setMax(2);
                e4.setLoc("tunis");
                e4.setSup(10);
                e4.ajouterAnimal(a4);

                zoo_fsegt.ajouterEnclos(e1);
                zoo_fsegt.ajouterEnclos(e2);
                zoo_fsegt.ajouterEnclos(e3);
                zoo_fsegt.ajouterEnclos(e4);
                System.out.println(GREEN+"Data loaded."+RESET);
                break;
            case 8:
                System.out.print(RED+"!!WARNING!! \nAll the data will be completly deleted.\n Are u sure ?(yes/no): "+RESET);
                String ch=sc.nextLine();
                if(ch.equalsIgnoreCase("yes")){
                    zoo_fsegt.getEnclos().clear();
                    System.out.println(RED+"Data deleted."+RESET);
                }else if(ch.equalsIgnoreCase("no")) {
                    System.out.println(YELLOW+"Stoping the process."+RESET);
                    break;
                }else{
                    System.out.println(YELLOW+"No clear answer, stoping the process automatically."+RESET);
                }
                
                break;
            case 0:
                break;
            default: 
                System.out.println(RED+"Invalid choice."+RESET); 
                break;
            } 
            } catch (InputMismatchException e) {
                System.err.println(RED+"Invalid input."+RESET);
                sc.nextLine();
                c=-1;
            }catch (AnimalNotFoundException e) {
                System.err.println(e);
            }catch(EnclosNotFoundException e){
                System.err.println(e);
            }catch (FullEnclosureException e) {
                System.err.println(e);
            }catch (DeplacementImpossibleException e) {
                System.err.println(e);
            }catch (AnimalNotIncludedException e) {
                System.err.println(e);
            }catch (DateTimeParseException e) {
                System.err.println(RED+"Not valid date"+RESET);
            }catch (TypeAnimalNotValidException e) {
                System.err.println(e);
            }catch (FileNotFoundException e) {
                System.err.println(e);
            }catch (NotValidCapaciteException e) {
                System.err.println(e);
            }catch (NotValidSuperficieException e) {
                System.err.println(e);
            }catch (NotValidEnvergureException e) {
                System.err.println(e);
            }
        }while(c!=0);
    sc.close();
    }
}
