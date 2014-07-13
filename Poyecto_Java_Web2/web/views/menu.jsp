<%@page import="Model.UsuarioRecorridoModel"%>
<%@page import="Controller.UsuariosRecorridos"%>
<%@page import="Model.TbUsuarioRecorrido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%
        /*
            Esta vista nos permitirá visualizar el menú, en el cual podremos ver la información
            de nuestro perfil, cerrar sesión y ver los recorridos turísticos a los que nos hemos
            suscrito.
        */
        //Visualizamos el nombre y el apellido, almacenado en variables de sesión cuando nos logueamos
        out.println("<h3>"+session.getAttribute("nombre")+" "+session.getAttribute("apellidos")+"</h3>");
    %>
    <a href="functions/invalidate.jsp"><input type="button" class="boton" value="Cerrar Sesión" onClick="close()"/></a>
    <h2>Sus reservas:</h2>
    <%
        //Llamamos al controlador, pasandole el id de usuario, para que nos devuelva una lista
        int idUsuario = Integer.parseInt(session.getAttribute("idUsuario").toString());
        List<UsuarioRecorridoModel> usuarioRecorrido = UsuariosRecorridos.findRecorridosDeUsuario(idUsuario);
        //Si tiene elemenots recorrerá la lista visualizando los datos.
        if (usuarioRecorrido.size() > 0)
        {
            for (UsuarioRecorridoModel a :usuarioRecorrido)
            {
                out.println("<form action='functions/borrarRecorrido.jsp?idRecorrido="+a.getIdRecorrido()+"' method='POST'>");
                out.println("<h4>Descripción:</h4>"+a.getDescripcion()+"<br/>");
                out.println("<label>Fecha Inicio:</label> "+a.getFechaInicio()+"<br/>");
                out.println("<label>Fecha Fin:</label> "+a.getFechaFin()+"<br/>");
                out.println("<label>Niños:</label> "+a.getNiños()+"<br/>");
                out.println("<label>Adultos:</label> "+a.getAdultos()+"<br/>");
                out.println("<input type='submit' class='boton' value='Borrar'/>");
                out.println("</form>");
            }
        }
        else//De no tener datos, nos dirá que aún no hemos hecho reservas
        {
            out.println("Lo sentimos, usted no tiene ninguna reserva");
        }
    %>
