package Controller;

import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */

/*
    Define una función que será llamada desde otros controladores para realizar la conexión a la base de datos
    y nos devuelve dicha conexión
*/
public class conexionBD {
    
    public static java.sql.Connection fConectar()
    {
        java.sql.Connection conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/db_turismo_tenerife","root","");
        }
        catch(Exception e){
        }
        return conexion;
    }
}
