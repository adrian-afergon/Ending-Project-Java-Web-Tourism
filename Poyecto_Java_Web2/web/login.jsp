<%-- 
    Document   : login
    Created on : 18-feb-2014, 12:01:32
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Login - Web Turismo</title>
    </head>
    <body>
        <div id="formulario">
            <form action="functions/checklogin.jsp" method="POST">
                <h2>Login</h2>
                <% 
                    /*
                        Detectamos en las variables de sesión si ha ocurrido algun error o si se ha
                        registrado correctamente para visualizar el mensaje correspondiente.
                    */
                    Boolean register= (Boolean)session.getAttribute("successRegistro");
                    Boolean login = (Boolean)session.getAttribute("login");
                    if (register != null)
                    {
                        if (register == true)
                        {
                            out.println("<label class='success'>Registro realizado correctamente<label>");
                            session.setAttribute("successRegistro",null);
                        }
                    }
                    if (login != null)
                    {
                        if (login == false)
                        {
                            out.println("<label class='error'>Error, usuario y/o contraseña incorrecta<label>");
                            session.setAttribute("login",null);
                        }
                    }
                    %><center>
                <input type="text" placeholder="e-mail" name="username" class="formElement"/>
                <input type="password" placeholder="password" name="password" class="formElement"/>
                <input type="submit" class="boton" value="Login"/>
                    </center>
                <a href="register.jsp">Registrar</a>
            </form>
        </div>
    </body>
</html>
