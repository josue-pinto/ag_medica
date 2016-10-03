<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <c:forEach var="lista" items="${lista}">
          
                        <tr><th>Nome</th><th>Telefone</th><th>Email</th></tr>
                        <%                  
                        Vector p = (Vector) request.getAttribute("p");
                        
                        
                            out.println("<tr><td>"+p.getNm_Pac()+"</td>");                            
                            out.println("<td>"+p.getTel_Pac()+"</td>");
                            out.println("<td>"+p.getEmail_Pac()+"</td></tr>");
                        
                        out.println("</table>");
                        %>    
                        </c:forEach>              
    
</table>
        
       
    </body>
</html>



