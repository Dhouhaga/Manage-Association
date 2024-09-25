import java.util.*;

public class Donneur {
    private int ID_Donneur;
    private String Nom;
    private String Prenom;
    private String Contact;
    private ArrayList<Don> Liste_Dons =  new ArrayList<>();

    public Donneur() {}
    public Donneur(int id, String nom, String prenom, String cont){
        setID(id);
        setNom(nom);
        setPrenom(prenom);
        setContact(cont);
    }
    public void setID(int id){
        ID_Donneur=id;
    }
    public void setNom(String nom){
        if (nom.length()==0) this.Nom="Inconnue";
        else this.Nom=nom;
    }
    public void setPrenom(String prenom){
        if (prenom.length()==0) this.Prenom="Inconnue";
        else this.Prenom=prenom;
    }
    public void setContact(String contact){
        if (contact.length()==0) this.Contact = "Pas de contact";
        else this.Contact=contact;
    }
    
    public int getID(){ return ID_Donneur;}
    public String getNom(){ return Nom ;}
    public String getPrenom(){ return Prenom ;}
    public String getContact(){ return Contact ;}
    public List<Don> getListDon(){return Liste_Dons;}   //retourn la liste des dons 

    //supprimer ou ajouter un don a la liste
    public int Supprimer_Don(int ID_Don ){
        for (Don i:Liste_Dons){
            if(i.getId_Don()==ID_Don){
                this.Liste_Dons.remove(i);
                Liste_Dons.trimToSize();
                return 0;
            }
        }
        return -1;
    }

    public int Supprimer_Don(Don d){
        return Supprimer_Don(d.getId_Don());
        
    }
    
    public void Ajouter_Don(Don d){
        this.Liste_Dons.add(d);
        d.setDonneur(this);
    }

    public int Nombre_Dons(int ID_association){
        int n=0;
        for(Don i: Liste_Dons){
            if (i.getAsso().getID_A()==ID_association) n++;
        }
        return n;
    }
    //lister toutes les dons associés à un donneur qq soit l'association concernée
    public void Afficher_ListDon(){
        System.out.println("\nNombre de dons: "+Liste_Dons.size());
        for (Don i: Liste_Dons){
            if (i.getType().compareTo("MONNAIE")==0){
                System.out.println("\n>ID don: " + i.getId_Don() + "\nAssociation: "+ i.getAsso().getName()+ "\nType don: "+ i.getType()+ "\nMontant: "+i.getMontant()+"\nRemarque: "+i.getRemarque());
            }
            else{
                System.out.println("\n>ID don: " + i.getId_Don() + "\nAssociation: "+ i.getAsso().getName()+ "\nType don: "+ i.getType()+ "\nQuantité: "+i.getQte()+"\nMontant: "+i.getMontant()+"\nRemarque: "+i.getRemarque());
            }
            
        }
    }
    public String toString(){
        return "\nID : " + ID_Donneur +"\nNom : " + Nom + "\nPrenom : " + Prenom +"\nNombre de dons: " +Liste_Dons.size()+"\nContact : " + Contact;
    }
    

}
