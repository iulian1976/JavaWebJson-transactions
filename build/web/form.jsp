<%-- 
    Document   : form
    Created on : 28 mars. 2018, 10:06:56
    Author     : iuli
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ZOO</title>
    </head>
    <body>
        <fieldset> 
        Path pour: "transactions_mock.json" <br:>
       ---->  /IZYCASH_IulianAMARIEI/web/jsonFiles/transactions_mock.json        
         </fieldset>
        <fieldset>
       <form name="Creation" action="Controleur" method="POST" enctype="multipart/form-data">
           JSON File<input type="file" name="jsonFile"  value="1"><br>
                <p> <input type="submit" value="liste de transactions " name="operation"  /></p>
         </form>
        </fieldset>
      
        <fieldset>
         <form name="Creation" action="Controleur2" method="POST" enctype="multipart/form-data">
           JSON File<input type="file" name="jsonFile"  ><br>
           
           
           <p> <input type="submit" value="5 événements avec plus de transactions" name="operation"  /></p>
        </fieldset>   
       
        
    </body>
</html>
