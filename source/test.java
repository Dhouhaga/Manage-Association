import java.util.ArrayList;
import java.util.*;

// Let's test the system !!

public class test {
   
    static List<Association> Liste_Association = new ArrayList<>();
    static Scanner input = new Scanner (System.in);

    public static void main(String args[]) throws Exception{

        // Creating associations instances
        Association association1 =  new Association(10,"Acting for life","Humanitaire","97885216");
        System.out.println("\n"+"\t------Association1------\n"+association1.toString());
        Association association2 =  new Association(11,"Vélo Cité","Sport","Quelque part","VeloCite@gmail.com");
        System.out.println("\n"+"\t------Association2------\n"+association2.toString());

        // Creating donors instances
        Donneur donneur1 = new Donneur(20,"Rolland","Luc","RolandLuc@gmail");
        System.out.println("\n"+"\t>>>> donneur1 <<<<\n"+donneur1.toString());
        Donneur donneur2 = new Donneur(21,"Prevost","Marine","65200200");
        Donneur donneur3 = new Donneur(22,"Lefort","Joseph","84112113");

       // Creating donations instances 
        Don donA = new Don(30, "MONNAIE",180,"Priorité pour les enfants", donneur1, association1);
        System.out.println("\n"+"---> Don A \n"+donA.toString());
        Don donB = new Don(31, "Casque",80,200, "", donneur1, association2);
        System.out.println("\n"+"---> Don B \n"+donB.toString());
        Don donC= new Don(32, "Manteau ",100, "", donneur2, association1);
        Don donD = new Don(33, "Monnaie",10,"Pour la protection", donneur2, association2);
        Don donE = new Don(34, "Nourriture",10,"", donneur3, association2);
        
       // The following sections allow to perform tasks to verify the functionning of each part of 
       // this program, including:
       
       //   0. Creating new donation instance 
       //   1. Display donors list of a given association
       //   2. Display donations list of a given association
       //   3. Display donations list of a given donor
       //   4. Deleting a donation
       
        int part=0;
        while (part<5){
                System.out.print("\n>Next part: "); 
                part = input.nextInt(); 
                switch (part){
                    
                    case 0:
                        Don donX = new Don(34, "Monnaie",0,"", donneur1, association1);
                        Don donY = new Don(35, "Chaussure",0,"", donneur1, association1);
                        break;
                    
                    case 1:
                    //Affichage de la liste des donneurs de l'association 1 et 2:
                        System.out.println("\n~~~~ Liste des donneurs de l'association1 ~~~~");
                        association1.Afficher_ListDnr();
                        System.out.println("\n~~~~ Liste des donneurs de l'association2 ~~~~");
                        association2.Afficher_ListDnr();
                        break;
                    
                    case 2:
                    //Affichage de la liste des dons de l'association 1 et 2:
                        System.out.println("\n~~~~ Liste des Dons de l'association1 ~~~~");
                        association1.Afficher_ListDon();
                        System.out.println("\n~~~~ Liste des Dons de l'association2 ~~~~");
                        association2.Afficher_ListDon();
                        break;
                    case 3:
                    //Affichage de la liste des dons des donneurs:
                        System.out.println("\n---- Liste des Dons du Donneur1 ----");
                        donneur1.Afficher_ListDon();
                        System.out.println("\n---- Liste des Dons du Donneur2 ----");
                        donneur2.Afficher_ListDon();
                        System.out.println("\n---- Liste des Dons du Donneur3 ----");
                        donneur2.Afficher_ListDon();
                        break;
                    case 4:
                    //Suppression du donA qui concerne le donneur1 et l'association1
                        donA.Supprimer_Don();
                        //Resultat:
                        System.out.println("\n~~~~ Liste des dons de l'association1 ~~~~");
                        System.out.println("Nombre de donneurs: "+association1.Nombre_donneurs());
                        association1.Afficher_ListDon();
                        System.out.println("\n---- Liste des dons du donneur1 ----");
                        donneur1.Afficher_ListDon();
                        break;

                    default:

                }

        }
        
    }


    
}
