<%-- 
    Document   : invalidate
    Created on : 18-feb-2014, 19:55:44
    Author     : Usuario
--%>
<%
    /*
        Se ejecuta cuando cerramos sesi�n. Lo que hace es invalidar todas
        las variables de sesi�n y nos reenviar� al login.
    */
            session.invalidate();
            response.sendRedirect("../login.jsp");
%>
