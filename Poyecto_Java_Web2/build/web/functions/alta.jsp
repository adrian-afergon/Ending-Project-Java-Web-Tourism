<%-- 
    Document   : alta
    Created on : 18-feb-2014, 21:48:10
    Author     : Usuario
--%>
<%  
    /*
        La p�gina alta.jsp funcionar� de controlador, en funci�n de los par�metros que reciba
        y de los que le falten para la inserci�n, nos redirigir� a una p�gina o a otra. De tener
        todos los valores dar� de alta.
    */
    if(request.getParameter("lugar") == "-1" || request.getParameter("fecha")=="-1" )
    {
        response.sendRedirect("../index.jsp?title=Reserva&page=reserva");
    }
    /*Comprueba si se recibi� alg�n par�metro y lo almacena en la variable de sesi�n*/
    if(request.getParameter("idRecorrido") != null)
    {
        session.setAttribute("idRecorrido",request.getParameter("idRecorrido"));
    }
    /*Comprueba si se recibi� alg�n par�metro y lo almacena en la variable de sesi�n*/
    if(request.getParameter("adults") != null)
    {
        session.setAttribute("lugar", request.getParameter("lugar"));
        session.setAttribute("fecha",request.getParameter("fecha"));
        session.setAttribute("ni�os", request.getParameter("childrens"));
        session.setAttribute("adultos",request.getParameter("adults"));
    }
    /*verificamos los casos y redireccionamos...*/
    if(session.getAttribute("adultos") == null)//adultos
    {
        response.sendRedirect("../index.jsp?title=Reserva&page=reserva");
    }
    else if (session.getAttribute("idRecorrido") == null)
    {
        response.sendRedirect("../index.jsp?title=Proximos&page=proximos");
    }
    /*...o damos de alta si tenemos todos los valores*/
    else
    {
        /*
            Para dar de alta llamamos al servicio web del proyecto "ServicioWebDB2"
            a la funci�n altaRecorrido y le pasamos los par�metros almacenados en las
            variables de sesi�n.
        */
        try {
            Proyecto_Java_Web2.artifacts.Datos_Service service = new Proyecto_Java_Web2.artifacts.Datos_Service();
            Proyecto_Java_Web2.artifacts.Datos port = service.getDatosPort();
            int idUsuario = Integer.parseInt(session.getAttribute("idUsuario").toString());
            int idRecorrido = Integer.parseInt(session.getAttribute("idRecorrido").toString());
            int ni�os = Integer.parseInt(session.getAttribute("ni�os").toString());
            int adultos = Integer.parseInt(session.getAttribute("adultos").toString());
            java.lang.String result = port.altaRecorrido(idUsuario, idRecorrido, ni�os, adultos);
            out.println(result);
            response.sendRedirect("../index.jsp?title=Menu&page=menu");
        } catch (Exception ex) {
            out.println(ex);
        }
    }
%>
