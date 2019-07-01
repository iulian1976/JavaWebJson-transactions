package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author iuli
 */
public class Transaction extends TransactionAbs{
    public Transaction(int _id,String _event_name,String _merchant,String _terminal,boolean _status ,String _card_id,String _card_type,String _amount,String _currency,String _country,String _created){
        super(_id,_event_name,_merchant,_terminal,_status,_card_id,_card_type,_amount,_currency,_country,_created );
        //System.out.println("constructeur Transaction appelé");      
    }
   // public String cri(){return "(Transaction) : Aboiement";}
    public String cri(){return "Aboiement";}
    
    
}
