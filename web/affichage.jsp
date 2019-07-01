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
            <TR><TH>ID</TH>
                <TH>EVENT</TH>
                <TH>MERCHANT</TH>
                <TH>TERMINAL</TH>
                 <TH>STATUS</TH>
                <TH>CARD_ID</TH>
                <TH>CARD_TYPE</TH>
                 <TH>AMOUNT</TH>
                <TH>CURRENCY</TH>
                <TH>COUNTRY</TH>
                <TH>CREATED</TH>
            </TR>
            <jsp:useBean id="monbean" class="beans.Tableau" scope="application"/>
             <%--id=monbean   getServletContext().setAttribute("monbean", tab);      si scope ?-->
            <%--jsp:getProperty name="monbean" property="tab"/>affichage direct du tableau--%>
          
            <%
              
            for(int i=0;i<monbean.getTab().size();i++){
                    
            out.println("<TR><TD>"+ ((Model.TransactionAbs)monbean.sortTab().elementAt(i)).getId()+"</TD>");   
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getE()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getM()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getT()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getS()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getCID()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getTYPE()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getAM()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getCURR()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getCO()+"</TD>");
            out.println("<TD>"+((Model.TransactionAbs)monbean.getTab().elementAt(i)).getCR()+"</TD></TR>");
            }
            monbean.sortClear();
            %>          
        </table>          
    </body>
</html>
