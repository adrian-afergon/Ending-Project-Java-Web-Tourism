<%-- 
    Document   : register
    Created on : 24-feb-2014, 17:45:00
    Author     : Usuario
--%>

<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*
        Este archivo comprobará que los valores son válidos y realizará el registro
        del nuevo usuario. De realizarse el registro nos redirigirá al login. De encontrarse
        un error, nos redirigirá al formulario de registro.
    */
    //Almacenamos los parámetros recibidos en variables
    java.lang.String nombre = request.getParameter("nombre");
    java.lang.String apellidos = request.getParameter("apellidos");
    java.lang.String email = request.getParameter("mail");
    java.lang.String password = request.getParameter("password");
    java.lang.String password2 = request.getParameter("password2");
    
    //Comrpobamos que los valores no son nulos
    if (nombre!="" || apellidos!="" || email!=""|| password!=""||password2!="")
    {
        //Una vez hecho esto, comprobamos que el email es válido
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(email);
        if (mat.find()) {
            //Si es válido procedemos a llamar al servicio web para realizar la inserción de datos.
            try {
                Proyecto_Java_Web2.artifacts.Datos_Service service = new Proyecto_Java_Web2.artifacts.Datos_Service();
                Proyecto_Java_Web2.artifacts.Datos port = service.getDatosPort();
                // TODO initialize WS operation arguments here

                if(password.equals(password2))//Comprobamos que las contraseñas son iguales
                {
                    // TODO process result here
                    java.lang.String result = port.register(nombre, apellidos, email, password);
                    out.println("Result = "+result);
                    if (result.equals("true"))//Si se ha registrado nos redirige al login
                    {
                        session.setAttribute("successRegistro",true);
                        response.sendRedirect("../login.jsp");
                    }
                    else//De no ser así devuelve un error
                    {
                        session.setAttribute("errorRegistro","true");
                        response.sendRedirect("../register.jsp");
                    }
                }
                else//De no ser así devuelve un error
                {
                    session.setAttribute("errorRegistro","true");
                    response.sendRedirect("../register.jsp");
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        }
        else{//De no ser así devuelve un error
            session.setAttribute("errorRegistro","true");
            response.sendRedirect("../register.jsp");
        }
    }
    else{//De no ser así devuelve un error
        session.setAttribute("errorRegistro","true");
        response.sendRedirect("../register.jsp");
    }
%>
