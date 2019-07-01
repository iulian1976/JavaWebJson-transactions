<%-- 
    Document   : affichage
    Created on : 26 mars. 2018, 00:28:33
    Author     : iulian
--%>

<%@page import="java.util.Collections"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste</title>
    </head>
    <body>
        
          <form name="form" action="Controleur" method="GET">
            <input type="submit" value="Return au menu" name="validation" />
        </form>
        
        
        <table border="1" cellpadding="10">
            <TR><TH>EVENT</TH>
                <TH>NR DES TRANSACTIONS</TH>
         </TR>
            <jsp:useBean id="monbean2" class="beans.Tableau2" scope="application"/>
             <%--id=monbean   getServletContext().setAttribute("monbean",tab2);-->
            <%--jsp:getProperty name="monbean2" property="tab2"/>affichage direct du tableau--%>
          
            <%
              
                
             int summe=0;   
                          //monbean2.getTab().size()---pour tous event
            for(int i=0;i<5;i++){
                    
            out.println("<TR><TD>"+ ((Model.EventAbs)monbean2.sortTab().elementAt(i)).getEV()+"</TD>");   
            out.println("<TD>"+((Model.EventAbs)monbean2.sortTab().elementAt(i)).getNRT()+"</TD></TR>");
            
           
            } 
              monbean2.sortClear();           
            %>          
        </table>
   
              
    </body>
</html>
