/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws.proyecto;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "datos")
public class datos {

    /**
     * Web service operation
     */
    /*Definimos la funcion de conexion que llamaremos desde los métodos*/
    private java.sql.Connection fConexion()
    {
        java.sql.Connection conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
            "jdbc:mysql://localhost/db_turismo_tenerife","root","");
        }
        catch (Exception e)
        {
        }
        return conexion;
    }
    //Esta funcion recibe los parámetros y realiza un insert sobre la tabla de usuarios
    @WebMethod(operationName = "Register")
    public String Register(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        String resultado;
        try{
            java.sql.Connection conexion = fConexion(); 
            PreparedStatement pstmt;
            String query="Insert into tb_Usuarios(nombre, apellidos, email, password) values(?,?,?,?)";
            pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            
            pstmt.executeUpdate();
            conexion.close();
            resultado = "true";
        }
        catch(Exception e)
        {
            resultado= e.getMessage().toString();
        }
        return resultado;
    }

    /**
     * Web service operation
     */
    //Esta función recibe los parámetros y realiza un update poniendo el campo activo a falso de
    //la tabla tb_usuario_recorrido
    @WebMethod(operationName = "BorrarRecorrido")
    public String BorrarRecorrido(@WebParam(name = "idRecorrido") int idRecorrido, @WebParam(name = "idUsuario") int idUsuario) {
        //TODO write your implementation code here:
        
        String resultado;
        try{

            java.sql.Connection conexion = fConexion(); 
            PreparedStatement pstmt;
            String query="Update tb_usuario_recorrido set activo = false where id_usuario =? AND id_recorrido=?";
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idRecorrido);
            
            pstmt.executeUpdate();
            conexion.close();
            resultado = "true";
        }
        catch(Exception e)
        {
            resultado= e.getMessage().toString();
        }
        return resultado;
    }

    /**
     * Web service operation
     */
    //Esta función realiza el alta de un usuario a un recorrido determinado
    @WebMethod(operationName = "AltaRecorrido")
    public String AltaRecorrido(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idRecorrido") int idRecorrido, @WebParam(name = "ni\u00f1os") int niños, @WebParam(name = "adultos") int adultos) {
        //TODO write your implementation code here:
        String resultado;
        try{

            java.sql.Connection conexion = fConexion(); 
            PreparedStatement pstmt;
            String query="Insert into tb_usuario_recorrido(id_usuario, id_recorrido, niños, adultos) values(?,?,?,?)";
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idRecorrido);
            pstmt.setInt(3, niños);
            pstmt.setInt(4, adultos);
            
            pstmt.executeUpdate();
            conexion.close();
            resultado = "true";
        }
        catch(Exception e)
        {
            resultado= e.getMessage().toString();
        }
        return resultado;
    }
}
