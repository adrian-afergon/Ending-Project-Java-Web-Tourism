<%@page import="java.sql.Blob"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Controller.Recorridos"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="java.util.List"%>
<%@page import="Model.TbRecorrido"%>
<%@page import="Controller.EntityMan"%>
<%@page import="Controller.TbRecorridoJpaController"%>
<%@page import="Controller.TbRecorridoJpaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Próximos Eventos:</h2>
<% 
    /*
        Esta vista nos mostrará los próximos eventos que realizará la empresa. Si ya hemos definido
        un perfil de reserva, aparecerán los eventos con esas características.
    */
        //Detectamos si recibe una fecha
        if (session.getAttribute("fecha") == null)
        {
            //Llamamos al controlador que nos devolverá los proximos eventos
            List<TbRecorrido> recorrido = Recorridos.findProximos();
            for (TbRecorrido a :recorrido)//Recorremos la lista que nos devuelve y los visualizamos
            {
                out.println("<form action='functions/alta.jsp?idRecorrido="+a.getIdRecorrido()+"' method='POST'>");
                out.println("<img src='serveletImagen?id="+a.getIdRecorrido()+"'class='imgRecorrido'/>");
                out.println("<label>Lugar:</label>");
                out.println(""+a.getLugar()+"");
                out.println("<label>Fecha Inicio:</label>");
                out.println(""+a.getFechaInicio()+"");
                out.println("<label>Fecha Fin:</label>");
                out.println(""+a.getFechaFin()+"");
                out.println("<label>Descripción:</label>");
                out.println(""+a.getDescripcion()+"");
                out.println("<input class='boton' type='submit' value='Reservar'>");
                out.println("</form>");
            }
        }
        else//De haber recibido una fecha
        {
            //Parseamos la fecha
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ROOT);
            Date newDate = new Date();
            newDate = sdf.parse(session.getAttribute("fecha").toString());
            String zona = session.getAttribute("lugar").toString();
            //Llamamos al controlador y le pasamos los parámetros
            List<TbRecorrido> recorrido = Recorridos.findProximosLugar(newDate,zona);
            if (recorrido.size() > 0)//Si existen elementos
            {    
                for (TbRecorrido a :recorrido)//Visualiza la lista
                {
                    out.println("<form action='functions/alta.jsp?idRecorrido="+a.getIdRecorrido()+"' method='POST'>");
                    out.println("<img src='serveletImagen?id="+a.getIdRecorrido()+"'class='imgRecorrido'/>");
                    out.println("<label>Lugar:</label>");
                    out.println("<label>"+a.getLugar()+"</label>");
                    out.println("<label>Fecha Inicio:</label>");
                    out.println("<label>"+a.getFechaInicio()+"</label>");
                    out.println("<label>Fecha Fin:</label>");
                    out.println("<label>"+a.getFechaFin()+"</label>");
                    out.println("<label>Descripción:</label>");
                    out.println("<label>"+a.getDescripcion()+"</label>");
                    out.println("<input class='boton' type='submit' value='Reservar'>");
                    out.println("</form>");
                }
            }
            else//Si no tiene elementos devuelve un "error"
            {
                out.println("Lo sentimos, no estan disponibles actividades con estas careacterísticas, le recomendamos que visite nuestros próximos eventos");
                session.setAttribute("fecha", null);
                session.setAttribute("lugar", null);
                session.setAttribute("niños", null);
                session.setAttribute("adultos",null);
            }
        }
        
%>