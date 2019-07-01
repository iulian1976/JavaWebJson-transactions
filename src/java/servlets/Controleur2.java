/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Model.EventAbs;
import javax.servlet.annotation.WebServlet;
import Model.Transaction;
import Model.Event;
import beans.Tableau;
import beans.Tableau2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
//import org.json.JSONObject;
import java.io.Serializable;
import java.util.*;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.io.File;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



/**
 *
 * @author iuli
 */
public class Controleur2 extends HttpServlet {
    
    private static final long serialVersionUID=1L;
     private static final String UPLOAD_DIR="jsonFiles";
     
     // un javabean care este initializat in beans
     Tableau2 tab2;
    
     Vector v1= new  Vector();
    // metoda 
     
     public Controleur2(){
         
       super();  
     }
     
     
    public void init(){
      
       
        tab2= new Tableau2();
        
    }
    
    // metoda 
    public void destroy(){
         
        
    }


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controleur2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try (PrintWriter out = response.getWriter()) {
       out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controleur</title>");            
            out.println("</head>");
            out.println("<body>");
           
            //pour test
         
        String jsonPath =  request.getServletContext().getRealPath(File.separator+UPLOAD_DIR+File.separator);
            
        
        JSONParser parser=new   JSONParser();             
            try{
                
               
            
             
               JSONArray a = (JSONArray) parser.parse(new FileReader(jsonPath+"/transactions_mock.json"));
               //pour path
               
 //---> extraire unique event              
               
     Vector vectorEVUN=new  Vector(); 
     int flag=0;
     int flag2=0;
     String event_name=" ";
     String stringTab=" ";
       for (Object o : a)
       {
    JSONObject person = (JSONObject) o;
    
    Long id1= (long)person.get("id");
    int id=id1.intValue();
    event_name = (String) person.get("event_name");
    String  merchant = (String) person.get("merchant");
    String  terminal = (String) person.get("terminal");
    boolean  status = (boolean) person.get("status");
    String  card_id = (String) person.get("card_id");
    String  card_type = (String) person.get("card_type");
    String  amount = (String) person.get("amount");
    String  currency = (String) person.get("currency");
    String  country = (String) person.get("country");
    String  created = (String) person.get("created");
    
      
       
     for(int i=0;i<vectorEVUN.size();i++){
       stringTab=vectorEVUN.elementAt(i).toString();
         
          if(stringTab.equals(event_name)){
             
           flag=flag+1;
          }
          
          
     }
     if(flag==0){
     vectorEVUN.add(event_name); 
     
     }
     
   flag=0;  
   
  }           
   //<----ok extraire
       
   
   
   //----> 
   
    int nrtrans=0;           
    String  event_nameT=" "; 
    String  stringv="";
    Vector vectorT=new  Vector(); 
    
    int i=0;
    event_name=" ";
    
    for(i=0;i<vectorEVUN.size();i++){
          
    for (Object q : a)
    {
       
    JSONObject person2 = (JSONObject) q;
    
    
    Long id1= (long)person2.get("id");
    int id=id1.intValue();
    event_name = (String) person2.get("event_name");
    String  merchant = (String) person2.get("merchant");
    String  terminal = (String) person2.get("terminal");
    boolean  status = (boolean) person2.get("status");
    String  card_id = (String) person2.get("card_id");
    String  card_type = (String) person2.get("card_type");
    String  amount = (String) person2.get("amount");
    String  currency = (String) person2.get("currency");
    String  country = (String) person2.get("country");
    String  created = (String) person2.get("created");
    
    
   
    stringv=vectorEVUN.elementAt(i).toString();
    
    
    
           if(stringv.equals(event_name)){  
       
               
              nrtrans=nrtrans+1; 
               // compte chaque transaction :)
              
                
               event_nameT= event_name; 
               //compte chaque ecent unique
               
               
            } 
    
            
    }
    
    // --> decharge
          Event d =new Event(event_nameT,nrtrans);
          tab2.getTab().add(d);
          vectorT.add(event_nameT);
        
     //<--- decharge important et instanc vers class et lieson tabbeans  
       
         nrtrans=0; // reini fin etape 1,2,3 recherche 
         event_nameT= " ";        
  }            
               
  
   

  }                       
            
            catch(FileNotFoundException a) {a.printStackTrace();}
            catch(IOException a) {a.printStackTrace();} 
            catch(Exception a) {a.printStackTrace();} 
   
            
       synchronized(this){
           
           
                 getServletContext().setAttribute("monbean2",tab2); // tab transf in monbean
                request.getRequestDispatcher("/affcrea.jsp").forward(request,response);
            // env vers affcrea
       
       }    
                         
            out.println("</body>");
            out.println("</html>"); 
            
            
            
            
            
        }   
        
        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
