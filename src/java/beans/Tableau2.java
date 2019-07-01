/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author iuli
 */
public class Tableau2 implements Serializable{
    
    
    
    private Vector tab2;
   
   
    // de retinut important tragi tabloul unde vrei tu
    public Tableau2() {
        tab2 = new Vector();
        
    }
    
    
    
    
    public Vector getTab() {
        return tab2;
    }
    
    
    
    
    public void setTab(Vector a){
        tab2=a;
    }
    
    
    
    
    public Vector sortTab(){
      
    Collections.sort(tab2);
      
               
     return tab2;   
    }
     
      
    
    
    
   public void sortClear(){
      
    tab2.clear();
               
       
    }
 
   
               
       
    
    
    
}
