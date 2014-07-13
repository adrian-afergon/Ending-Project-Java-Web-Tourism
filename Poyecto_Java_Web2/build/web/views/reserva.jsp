<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.TbRecorrido"%>
<%@page import="java.util.List"%>
<%@page import="Controller.TbRecorridoJpaController"%>
<%@page import="Controller.EntityMan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="functions/alta.jsp" method="POST">

    <%
    /*
        En esta vista visualizaremos un formulario para realizar una reserva
    */    
    //Si no hemos definido aún un recorrido    
    if (session.getAttribute("idRecorrido") == null)
    {   //Llamamos al controlador que nos devolverá una lista de recorridos
        TbRecorridoJpaController recorridoController = new TbRecorridoJpaController(EntityMan.getInstance());
        List<TbRecorrido> recorrido=recorridoController.findTbRecorridoEntities();
        //Una ves hecho esto, generamos el HTML correspondiente con los valores rescatados de la BD.
    %>
    <label>Fecha:</label>
    <select name="fecha" class="formElement">
        <option value="-1">--Seleccione una fecha--</option>
        <%for (TbRecorrido a :recorrido){out.println("<option value='"+a.getFechaInicio()+"'>"+a.getFechaInicio()+"</option>");}%>
    </select>
    <label>Lugar:</label>
    <select name="lugar" class="formElement">
        <option value="-1">--Selecione un lugar--</option>
        <%for (TbRecorrido a :recorrido){out.println("<option value='"+a.getLugar()+"'>"+a.getLugar()+"</option>");}%>
    </select>
    <%}%>
    <label>Personas:</label>
    <label>Niños:</label>
    <!--<input type="number" name="childrens" min="0" max="5" class="formElement" value="0"/>-->
    <select name="childrens" class="formElement">
        <option value="0">Ninguno</option>
        <option value="1">1 niño</option>
        <option value="2">2 niños</option>
        <option value="3">3 niños</option>
        <option value="4">4 niños</option>
        <option value="5">5 niños</option>
    </select>
    <label>Adultos:</label>
    <!--<input type="number" name="adults" min="1" max="5" class="formElement" value="1"/>-->
    <select name="adults" class="formElement">
        <option value="1">1 adulto</option>
        <option value="2">2 adultos</option>
        <option value="3">3 adultos</option>
        <option value="4">4 adultos</option>
        <option value="5">5 adultos</option>
    </select>
    <input class="boton" type="submit" value="consultar"/>
</form>