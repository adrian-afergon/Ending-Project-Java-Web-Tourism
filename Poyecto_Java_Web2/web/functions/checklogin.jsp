<%-- 
    Document   : checklogin
    Created on : 18-feb-2014, 13:02:31
    Author     : Usuario
--%>

<%@page import="Controller.Usuarios"%>
<%@page import="Model.TbUsuarios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
        /*
            Esta página verificará el emeail y la contraseña, para iniciar sesión.
            Si es correcto el login, nos dará acceso a la web, de lo cotnrario nos
            reenviará a la pantalla de login nuevamente.
        */
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //Llamamos al controlador que buscará el usuario y la contraseña indicadas
        List<TbUsuarios> usuario = Usuarios.findLogin(username,password);
        if (usuario.size() > 0)//Si encuentra el usuario
        {
            for (TbUsuarios a :usuario)
            {//Comparará nuevamente las variables recibidas con las obtenidas de la base de datos
                String emailValidar=a.getEmail();
                String passValidar=a.getPassword();
                out.println(emailValidar);
                out.println(passValidar);
                if((username.equals(emailValidar) && password.equals(passValidar)))
                {//Si coinciden, almacena los valores en una variable de sesión
                    session.setAttribute("idUsuario",a.getIdUsuario());
                    session.setAttribute("nombre",a.getNombre());
                    session.setAttribute("apellidos",a.getApellidos());
                    session.setAttribute("username",username);
                    session.setAttribute("login", true);
                    response.sendRedirect("../index.jsp");    
                }
                else//si no nos devolverá al login
                {
                    session.setAttribute("login", false);
                    response.sendRedirect("../login.jsp");
                } 
            }
        }
        else//nos devolverá al login
        {
             session.setAttribute("login", false);
             response.sendRedirect("../login.jsp");
        }

        %>