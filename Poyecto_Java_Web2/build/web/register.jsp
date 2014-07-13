<%-- 
    Document   : register
    Created on : 18-feb-2014, 12:17:40
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Registrar - Web Turismo</title>
    </head>
    <body>
        <header>
            <ul>
                <li><a href="login.jsp">Login</a></li>
                <li>My Web</li>
            </ul>
        </header>
        <div id="cuerpo">
            <%
                /*
                    Detecta si ha ocurrido un error para visualizarlo
                */
                session.setAttribute("login",null);
                try{
                    if (session.getAttribute("errorRegistro").equals("true"))
                    {
                    out.println("<br/><label class='error'>Error, contraseña equivocada o ya existe el correo</label>");
                    }
                }
                catch(Exception e)
                {}
            %>
            <h2>Registro:</h2>
            <form action="functions/register.jsp" method="POST">
                <label>Nombre:</label>
                <input type="text" placeholder="Nombre" name="nombre" class="formElement" required=""/>
                <label>Apellidos:</label>
                <input type="text" placeholder="Apellidos" name="apellidos" class="formElement" required=""/>
                <label>Mail:</label>
                <input type="mail" placeholder="Mail" name="mail" class="formElement" required=""/>
                <label>Password:</label>
                <input type="password" placeholder="Password" name="password" class="formElement" required=""/>
                <label>Repita Password:</label>
                <input type="password" placeholder="Password" name="password2" class="formElement" required=""/>
                <input type="submit" value="Registrar" class="boton"/>
            </form>
        </div>
    </body>
</html>
