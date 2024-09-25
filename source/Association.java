import java.util.*;


class Association implements Organisation{
   
    private int ID_asso;
    private String Nom_Association;
    private String Secteur;
    private String Adresse;
    private String Contact;  
    private ArrayList<Donneur> Liste_Donneurs = new ArrayList<>();
    private ArrayList<Don> Liste_Dons = new ArrayList<>();

    //Constructeurs
    public Association(){}
    public Association(int id,  String n, String sec,String cont){
        this(id,n,sec,"",cont);
    }
    public Association(int id,  String n, String sec,String adr,String cont){
        setID_A(id);
        setTel(cont);
        setadress(adr);
        this.setname(n);
        this.setsecteur(sec);
    }
   
    //Setters
    public void setname(String n){
        try{
            if((n.length()==0) || ((n.length()==1) && (n.indexOf(" ")==0))) throw new LenException();
            Nom_Association = n;
        }
        catch(LenException e){System.out.println("Le nom de l'association est invalide"); }
    }
    public void setsecteur(String n){
        try{
            if((n.length()==0) || ((n.length()==1) && (n.indexOf(" ")==0))) throw new LenException();
            Secteur = n;
        }
        catch(LenException e){System.out.println("Le secteur de l'association est invalide"); }
    }
    public void setID_A(int id){ID_asso = id;}
    public void setadress(String m){
        if(m.length()==0){Adresse="Pas d'adresse";}
        else Adresse = m;
    }
    public void setTel(String n){Contact = n;   }
    public void setDnr(List<Donneur> dnr){
        for (Donneur i : dnr){
            this.Liste_Donneurs.add(i);
        }
    }
    public void setDons(List<Don> d){
        for (Don i : d){
            this.Liste_Dons.add(i);
        }
    }

    //Getters
    public String getName(){ return Nom_Association;}
    public String getSecteur(){ return Secteur;}
    public String getAdr(){ return Adresse;}
    public String getTel(){ return Contact;}
    public int getID_A(){ return ID_asso;}
    public List<Don> getDons(){return Liste_Dons;}

    public int Ajouter_Donneur(Donneur donneur){
        for ( Donneur i : this.Liste_Donneurs){
            if(i.getID()==donneur.getID()){
                   return -1;
            }
        }
        this.Liste_Donneurs.add(donneur);
        return 0;
    }

    public int Supprimer_Donneur(int ID_Donneur ){
        for (Donneur i:Liste_Donneurs){
            if(i.getID()==ID_Donneur){
                this.Liste_Donneurs.remove(i);
                Liste_Donneurs.trimToSize();
                System.out.println("nombre: "+Nombre_donneurs()+"!!!!!!!!!!");
                return 0;
            }
        }
        return -1;
    }
    
    public int Supprimer_Donneur(Donneur donneur){
        return Supprimer_Don(donneur.getID());
    }
    
    public void Ajouter_Don(Don don){
        this.Liste_Dons.add(don);
        don.setAssociation(this);
    }

    public int Supprimer_Don(int ID_Don ){
        for (Don i:Liste_Dons){
            if(i.getId_Don()==ID_Don){
                // si c'est le don unique pour un donneur donner, on le supprime 
                if((i.getDonneur().Nombre_Dons(this.ID_asso))==0){
                    Supprimer_Donneur(i.getDonneur().getID());
                }
                 
                this.Liste_Dons.remove(i);
                Liste_Dons.trimToSize();
                return 0;
            }
           
        }
        return -1;
    }

    public int Supprimer_Don(Don don){
        return Supprimer_Don(don.getId_Don());
    }
    
    //Affichage de la liste des Donneurs:
    public void Afficher_ListDnr(){
        System.out.println("Nombre des donneurs: "+Liste_Donneurs.size());
        for (Donneur i: this.Liste_Donneurs){
            System.out.println(">id: "+i.getID()+"\t|Donneur: "+i.getNom()+" "+i.getPrenom()+" |Nombre Dons: "+i.Nombre_Dons(this.ID_asso));
        }
    }

    //Affichage de la liste de tous les dons:
    public void Afficher_ListDon(){
        System.out.println("Nombre de dons: "+Liste_Dons.size());
        for(Don i : Liste_Dons){
            System.out.println(">>"+i.toString());
        }
    }
    public int Nombre_donneurs(){
        Liste_Donneurs.trimToSize();
        return Liste_Donneurs.size();
    }
    //Affichage de la liste des dons de l'un des donneur:
    public void Afficher_Dons(Donneur x){
        for (Don i: x.getListDon()){
            if(i.getAsso().ID_asso==this.ID_asso){
                System.out.println(i.toString());
            }
        }
    }
    

    public String toString(){
        return "\nID: "+ID_asso+"\nNom: "+Nom_Association+"\nSecteur: "+Secteur+"\nContact: "+Contact+"\nAdresse: "+Adresse;
    }
}