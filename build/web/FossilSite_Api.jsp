<%-- 
    Document   : FossilSite_Api
    Created on : May 2, 2021, 10:01:23 PM
    Author     : anapat
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.FossilSite"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="apicontroller.ApiController"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%
        List<FossilSite> fsList = ApiController.FossilSiteAPI();
        Iterator<FossilSite> itr = fsList.iterator();
    %>
    <body>
        <a href="index.html">Back to Menu</a>
        <center>
        <h1>19 Fossil Site List</h1>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Site Name</th>
            <th>Local Name</th>
            <th>Local Address</th>
          </tr>
          <%
              
               while(itr.hasNext()) {
                   FossilSite fs = itr.next();
                   out.println("<tr>");
                   out.println("<td> "+ fs.getNo() + "</td>");
                   out.println("<td> "+ fs.getSiteName() + "</td>");
                   out.println("<td> "+ fs.getLocalName() + "</td>");
                   out.println("<td> "+ fs.getLocalAddress() + "</td>");
                   out.println("<tr>");
               }
          %>
    </table>
 </center>
    </body>
</html>
