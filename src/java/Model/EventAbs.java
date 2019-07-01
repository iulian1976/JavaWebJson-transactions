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
public abstract class EventAbs implements Serializable,Comparable {
   
    String event;
    int nrT;
    
   
    public EventAbs(){}
    
    public String getEV(){return event;}
    public int getNRT(){return  nrT;}
    
    public EventAbs(String _event,int _nrT ){
       
        event=_event;
        nrT=_nrT;
        
      
    }
    
    
    
    public String toString(){return this.event+" "+this.nrT;}
    public abstract String cri();
    
    public int compareTo(Object a){
      
    
 /*Employe temp = (Employe) a; 
 return  Double.valueOf(this.paie).compareTo(Double.valueOf(temp.paie)); */
/*
   String pass1=String.valueOf(this.event_name);
   String pass2=String.valueOf(a.event_name);
 
        return pass1.compareTo(pass2); 
*/

EventAbs n1 = this;
EventAbs n2 =(EventAbs)a;
if (n1.nrT  > n2.nrT ) return -1;
if (n1.nrT== n2.nrT) return 0;
return 1;


}

    
    
    
    
    
}
