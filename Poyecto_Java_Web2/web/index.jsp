<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    /*
        Esta es la plantilla que usaremos para generar las demás páginas de nuestra web.
        Esta debe recibir como parámetros el título y la página a la que se desea acceder
        para poder generar nuestra pantalla.
    */
    /*Comprobamos que el usuario se ha logueado, de no ser así, nos redirecciona a la 
    página de login nuevamente. Dicha validación se almacena en una variable de sesión*/
    Boolean login = (Boolean)session.getAttribute("login");
    out.println(login);
    if (login == null || login == false)
    {
        response.sendRedirect("login.jsp");
    }
%>

<%
  // define el titulo a mostrar en la pagina.
  String sTitle = "Principal";
  if (request.getParameter("title") != null) { 
    sTitle = request.getParameter("title").toString();
  }
 
  // define la pagina a desplegar de acuerdo al parametro "page" del request.
  String sUrlPage = "views/index.jsp";
  if (request.getParameter("page") != null) {
    sUrlPage = "views/"+request.getParameter("page").toString()+".jsp";
  }
%>
  
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/flaticon.css" />
        <title><%=sTitle%> - Web Turismo</title>
    </head>
<body>
  <jsp:include page="layout/header.jsp" />
  <div id="cuerpo">
    <jsp:include page="<%=sUrlPage%>" />
  </div>
</body>
</html>
