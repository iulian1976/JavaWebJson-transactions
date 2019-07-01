/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.annotation.WebServlet;
import Model.Transaction;
import beans.Tableau;
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
public class Controleur extends HttpServlet {
     private static final long serialVersionUID=1L;
     private static final String UPLOAD_DIR="jsonFiles";
     
     Tableau tab;// un javabean care este initializat in beans
     
    
    
     
     public Controleur(){
         
       super();  
     }
     
     
    public void init(){
      
        tab = new Tableau();
        
    }
    
    // meth 
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
            throws ServletException, IOException {}

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
           response.setContentType("text/html;charset=UTF-8");        
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controleur</title>");            
            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("/form.jsp").forward(request, response);
            out.println("</body>");
            out.println("</html>");
        }
        
      
     //aici il trece prin controler 
      
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
            out.println("Bubu");
         
        String jsonPath =  request.getServletContext().getRealPath(File.separator+UPLOAD_DIR+File.separator);
        out.println(jsonPath);    
        
        JSONParser parser=new   JSONParser();             
            try{
                
       //---> parse+path        
            
             // JSONArray a = (JSONArray) parser.parse(new FileReader("/home/iulidora/NetBeansProjects/Animaux_2_MVC(analizat)_modif/web/jsonFiles/T.json"));
               JSONArray a = (JSONArray) parser.parse(new FileReader(jsonPath+"/transactions_mock.json"));
               //pour path
    //iteration --->         
    
  for (Object o : a)
  {
    JSONObject person = (JSONObject) o;
    
   Long id1= (long)person.get("id");
   int id=id1.intValue();
   
    String event_name = (String) person.get("event_name");
    String  merchant = (String) person.get("merchant");
    String  terminal = (String) person.get("terminal");
    boolean  status = (boolean) person.get("status");
    String  card_id = (String) person.get("card_id");
    String  card_type = (String) person.get("card_type");
    String  amount = (String) person.get("amount");
    String  currency = (String) person.get("currency");
    String  country = (String) person.get("country");
    String  created = (String) person.get("created");
    
   
    Transaction b =new Transaction(id,event_name,merchant,terminal,status,card_id, card_type,amount,currency,country,created);
    tab.getTab().add(b);   
    //request.setAttribute("animal",b);       
    }                      
  
  
                    
  }                       
            
            catch(FileNotFoundException a) {a.printStackTrace();}
            catch(IOException a) {a.printStackTrace();} 
            catch(Exception a) {a.printStackTrace();} 
            
            
            
       
       
       // ce primeste asta,aici imparte form  
       
        
            
       synchronized(this){
                 getServletContext().setAttribute("monbean", tab); // tab transf in monbean
                 request.getRequestDispatcher("/affichage.jsp").forward(request,response);
                 // vers---> jsp
             }     
       
      
               
            out.println("</body>");//<--------pour test 
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
