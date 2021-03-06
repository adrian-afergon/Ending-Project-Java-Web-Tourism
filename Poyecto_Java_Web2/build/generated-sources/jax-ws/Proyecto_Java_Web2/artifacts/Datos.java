
package Proyecto_Java_Web2.artifacts;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "datos", targetNamespace = "http://proyecto.ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Datos {


    /**
     * 
     * @param idUsuario
     * @param idRecorrido
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "BorrarRecorrido")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "BorrarRecorrido", targetNamespace = "http://proyecto.ws/", className = "Proyecto_Java_Web2.artifacts.BorrarRecorrido")
    @ResponseWrapper(localName = "BorrarRecorridoResponse", targetNamespace = "http://proyecto.ws/", className = "Proyecto_Java_Web2.artifacts.BorrarRecorridoResponse")
    @Action(input = "http://proyecto.ws/datos/BorrarRecorridoRequest", output = "http://proyecto.ws/datos/BorrarRecorridoResponse")
    public String borrarRecorrido(
        @WebParam(name = "idRecorrido", targetNamespace = "")
        int idRecorrido,
        @WebParam(name = "idUsuario", targetNamespace = "")
        int idUsuario);

    /**
     * 
     * @param adultos
     * @param idUsuario
     * @param idRecorrido
     * @param niños
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "AltaRecorrido")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "AltaRecorrido", targetNamespace = "http://proyecto.ws/", className = "Proyecto_Java_Web2.artifacts.AltaRecorrido")
    @ResponseWrapper(localName = "AltaRecorridoResponse", targetNamespace = "http://proyecto.ws/", className = "Proyecto_Java_Web2.artifacts.AltaRecorridoResponse")
    @Action(input = "http://proyecto.ws/datos/AltaRecorridoRequest", output = "http://proyecto.ws/datos/AltaRecorridoResponse")
    public String altaRecorrido(
        @WebParam(name = "idUsuario", targetNamespace = "")
        int idUsuario,
        @WebParam(name = "idRecorrido", targetNamespace = "")
        int idRecorrido,
        @WebParam(name = "ni\u00f1os", targetNamespace = "")
        int niños,
        @WebParam(name = "adultos", targetNamespace = "")
        int adultos);

    /**
     * 
     * @param nombre
     * @param email
     * @param apellidos
     * @param password
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Register")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Register", targetNamespace = "http://proyecto.ws/", className = "Proyecto_Java_Web2.artifacts.Register")
    @ResponseWrapper(localName = "RegisterResponse", targetNamespace = "http://proyecto.ws/", className = "Proyecto_Java_Web2.artifacts.RegisterResponse")
    @Action(input = "http://proyecto.ws/datos/RegisterRequest", output = "http://proyecto.ws/datos/RegisterResponse")
    public String register(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "apellidos", targetNamespace = "")
        String apellidos,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "password", targetNamespace = "")
        String password);

}
