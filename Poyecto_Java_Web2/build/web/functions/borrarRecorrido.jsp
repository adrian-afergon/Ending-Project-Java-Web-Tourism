<%-- 
    Document   : borrarRecorrido
    Created on : 24-feb-2014, 17:54:11
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
	Proyecto_Java_Web2.artifacts.Datos_Service service = new Proyecto_Java_Web2.artifacts.Datos_Service();
	Proyecto_Java_Web2.artifacts.Datos port = service.getDatosPort();
	 // TODO initialize WS operation arguments here
	int idRecorrido = Integer.parseInt(request.getParameter("idRecorrido").toString());
	int idUsuario = Integer.parseInt(session.getAttribute("idUsuario").toString());
	// TODO process result here
	java.lang.String result = port.borrarRecorrido(idRecorrido, idUsuario);
	out.println(result);
        response.sendRedirect("../index.jsp?title=Menu&page=menu");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
%>
