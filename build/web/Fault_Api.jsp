<%-- 
    Document   : Fault_Api
    Created on : May 2, 2021, 9:37:08 PM
    Author     : anapat
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Fault"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="apicontroller.ApiController"  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fault API</title>
    </head>
    <%
        List<Fault> faultList = ApiController.FaultAPI();
        Iterator<Fault> itr = faultList.iterator();
    %>
    <body>
        <a href="index.html">Back to Menu</a>
        <center>
        <h1>Fault Top 100 List</h1>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>faultName</th>
            <th>typeOfFault</th>
            <th>fault_Length</th>
          </tr>
          <%
              
               while(itr.hasNext()) {
                   Fault fault = itr.next();
                   out.println("<tr>");
                   out.println("<td> "+ fault.getNo() + "</td>");
                   out.println("<td> "+ fault.getFaultName() + "</td>");
                   out.println("<td> "+ fault.getTypeOfFault() + "</td>");
                   out.println("<td> "+ fault.getFault_Length() + "</td>");
                   out.println("<tr>");
               }
          %>
    </table>
 </center>
    </body>
</html>
