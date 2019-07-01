package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
/**
 *
 * @author iuli
 */
public abstract class TransactionAbs implements Serializable,Comparable {
   
    int id;
    String event_name;
    String merchant;
    String terminal;
    boolean status;
    
    String card_id;
    String card_type;
    String amount;
    String currency;
    String country;
    String created;
    
    
    
    public TransactionAbs(){}
    
    public int getId(){return id;}
    public String getE(){return event_name;}
    public String getM(){return merchant;}
    public String getT(){return terminal;}
    public boolean getS(){return status;}
    
    public String getCID(){return card_id;}
    public String getTYPE(){return card_type;}
    public String getAM(){return amount;}
    public String getCURR(){return currency;}
    public String getCO(){return country;}
    public String getCR(){return created;}
    
    public TransactionAbs(int _id,String _event_name,String _merchant,String _terminal,boolean _status ,String _card_id,String _card_type,String _amount,String _currency,String _country,String _created ){
        id=_id;
        event_name=_event_name;
        merchant=_merchant;
        terminal=_terminal;
        status=_status;
        
        card_id=_card_id;
       card_type=_card_type;
       amount= _amount;
       currency=_currency;
       country= _country;
       created=_created;
      
    }
    
    
    
    public String toString(){return this.id+" "+this.event_name+" "+this.merchant+" "+this.terminal+" "+this.status /*+" "+card_id+" "+card_type+" "+amount+" "+currency+" "+country+" "+created */;}
    public abstract String cri();
    
    public int compareTo(Object a){
      
    
 /*Employe temp = (Employe) a; 
 return  Double.valueOf(this.paie).compareTo(Double.valueOf(temp.paie)); */
/*
   String pass1=String.valueOf(this.event_name);
   String pass2=String.valueOf(a.event_name);
 
        return pass1.compareTo(pass2); 
*/

TransactionAbs n1 = this;
TransactionAbs n2 =(TransactionAbs)a;
if (n1.id  < n2.id ) return -1;
if (n1.id== n2.id) return 0;
return 1;

// Employe n1 = this;
//Employe n2 = (Employe)a;

//if (n1. paie < n2. paie) return -1;
//if (n1. paie == n2. paie) return 0;
//return 1;
}

    
    
    
    
    
}
