import java.time.*;
import java.time.format.DateTimeFormatter;

public class Don {
    private Association Association;
    private Donneur Donneur;
    private int ID_Don;
    private String Type;
    private String Remarque;
    private float Montant;
    private int Quantité;
    private String Date;


        //Pour chaque constructeur : preciser l'association et le donneur concernés

        //Constructeur pour : type + quantité || monnaie + montant 
        Don(int id, String type, int QM, String Remarque, Donneur donneur,Association association)throws Exception{
            this(id,type,QM,QM,Remarque,donneur,association);
            if(Type.compareTo("MONNAIE")!=0) setMontant(0);
        }

        //Constructeur génèrale 
        Don(int id, String tp,int quantité, int montant, String Remarque, Donneur donneur,Association association) {
            try{
                setType(tp);
                setMontant(montant);
                setQte(quantité);
                setDonneur(donneur);
                setID_Don(id);
                setRemarque(Remarque);
                
                //Formatage de la date et heure:
                LocalDateTime Current_DT = LocalDateTime.now();
                DateTimeFormatter DT_Format = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
                Date = Current_DT.format(DT_Format);

                setAssociation(association);
                this.Association.Ajouter_Don(this);
                this.Association.Ajouter_Donneur(donneur);
                donneur.Ajouter_Don(this);
            }
            catch(ValueException e){
                System.out.println("Le Don ayant l'ID "+id+" Est Rejeté");
            }
    
        }

        //Setters

        //C'est le type qui va determiner les autres attributs
        public void setType(String tp) throws ValueException{
        if(tp.length()==0) throw new ValueException("Type");
        Type=tp.toUpperCase();
        }

        public void setMontant (float mt)throws ValueException{
         if(mt>0) Montant = mt;
         else if((mt <0) || ((mt ==0)&&(Type.compareTo("MONNAIE")==0))) throw new ValueException("Montant"); 
         else Montant = mt;
        }

        public void setQte(int nb) throws ValueException{
         if(Type.compareTo("MONNAIE")==0) Quantité=0;
         else if (nb<=0) throw new ValueException("Quantité");
         else Quantité=nb;
        }

        public void setRemarque(String Rem){
        if(Rem.length()==0) Remarque="Pas de remarque";
        else Remarque=Rem;
    }
        public void setID_Don(int id){
            ID_Don=id;
            //for (Don i: this.asso.getDons())
    }
        public void setDonneur(Donneur x){
            Donneur=x; 
    }
        public void setAssociation(Association association ){
            this.Association=association;
        }
        //Getters
        public float getMontant(){ return Montant ;}
        public String getType(){ return Type ; }
        public int getQte(){ return Quantité ;}
        public int getId_Don(){ return ID_Don ;}
        public Association getAsso(){return Association ;}
        public Donneur getDonneur(){return Donneur ;}
        public String getRemarque(){ return Remarque ; }

        public void Supprimer_Don(){
            Donneur.Supprimer_Don(this);
            Association.Supprimer_Don(this);
        }

        public String toString(){
            StringBuilder build = new StringBuilder();
            build.append("\nDate:"+Date+"\nID: "+ID_Don+"\nDonneur : "+Donneur.getNom()+" "+Donneur.getPrenom()+"\nType: "+Type +"\nMontant: "+Montant );
        
            if (Type.compareTo("MONNAIE")==0)
            return( build.append("\nRemarque: "+Remarque)).toString();
            else
            return (build.append("\nQuantité: "+Quantité+"\nRemarque: "+Remarque)).toString();
        }
        
    }