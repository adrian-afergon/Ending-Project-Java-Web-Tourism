<%-- 
    Document   : invalidate
    Created on : 18-feb-2014, 19:55:44
    Author     : Usuario
--%>
<%
    /*
        Se ejecuta cuando cerramos sesión. Lo que hace es invalidar todas
        las variables de sesión y nos reenviará al login.
    */
            session.invalidate();
            response.sendRedirect("../login.jsp");
%>
