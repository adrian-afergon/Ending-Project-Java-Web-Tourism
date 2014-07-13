<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*
        Es la plantilla por defecto de inicio, cada vez que accedemos a ella, 
        vaciamos las variables de sesión de las reservas.
    */
    session.setAttribute("fecha", null);
    session.setAttribute("lugar", null);
    session.setAttribute("niños", null);
    session.setAttribute("adultos",null);
    session.setAttribute("idRecorrido",null);
%>
<ul class="menu">
    <li><a href="index.jsp?title=Proximos&page=proximos">Próximos</a></li>
    <li><a href="index.jsp?title=Reserva&page=reserva">Reservar</a></li>
    <li><a href="index.jsp?title=Contacta&page=contacta">Contactar</a></li>
</ul>