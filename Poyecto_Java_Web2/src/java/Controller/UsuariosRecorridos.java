/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.UsuarioRecorridoModel;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */

/*
    Este controlador utilizará el modelo UsuarioRecorridoModel.java para tratar los datos que recibe
    y permitirnos devolverlo a la vista como un List de elementos "UsuarioRecorrido"
*/
public class UsuariosRecorridos {
    public static List<UsuarioRecorridoModel> findRecorridosDeUsuario(int idUsuario)
    {
        try {
            try
            {  
                java.sql.Connection conexion = conexionBD.fConectar();//Llamamos al controlador que realiza la conexion
                List TbRecorridoUsuario = new LinkedList();
                PreparedStatement pstmt;
                //Definimos la consulta y sus parámetros:
                String query = "select ur.id,ur.id_recorrido,ur.adultos,ur.niños,"
                        + "r.descripcion, r.lugar,"
                        + "r.fecha_inicio, r.fecha_fin "
                        + "from Tb_usuario_recorrido as ur "
                        + "INNER JOIN Tb_recorrido as r on ur.id_recorrido = r.id_recorrido "
                        + "WHERE ur.activo = true AND ur.id_usuario=?;";
                pstmt = conexion.prepareStatement(query);
                pstmt.setInt(1,idUsuario);
                ResultSet rs = pstmt.executeQuery();                
                //Recorremos los valores que nos devuelve la sentencia, creamos el objeto y lo añadimos a la lista
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int id_recorrido = rs.getInt("id_recorrido");
                    int adultos = rs.getInt("adultos");
                    int niños = rs.getInt("niños");
                    String descripcion = rs.getString("descripcion");
                    String lugar = rs.getString("lugar");
                    Date fechaInicio = rs.getDate("fecha_inicio");
                    Date fechaFin = rs.getDate("fecha_fin");
                    UsuarioRecorridoModel user = new UsuarioRecorridoModel(id,id_recorrido,adultos,niños,descripcion,lugar,fechaInicio,fechaFin);
                    TbRecorridoUsuario.add(user);
                }                
                rs.close();                
                conexion.close();
                return TbRecorridoUsuario;
            }
            catch (Exception e)
            {
                out.println(e.getMessage());
            }
        } 
        finally {            
            out.close();
        }
        return null;

    }
}
