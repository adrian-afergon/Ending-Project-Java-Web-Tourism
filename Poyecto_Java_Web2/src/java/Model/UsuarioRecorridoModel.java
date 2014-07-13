/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class UsuarioRecorridoModel {
    private int id;
    private int idRecorrido;
    private final int adultos;
    private final int niños;
    private final String descripcion;
    private final String lugar;
    private final Date fecha_inicio;
    private final Date fecha_fin;

    public UsuarioRecorridoModel(int _id,int _idRecorrido, int _adultos, int _niños, String _descripcion, String _lugar, Date _fechaInicio, Date _fechaFin) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        id = _id;
        idRecorrido = _idRecorrido;
        adultos = _adultos;
        niños = _niños;
        descripcion = _descripcion;
        lugar= _lugar;
        fecha_inicio = _fechaInicio;
        fecha_fin = _fechaFin;
        
    }
    
    public int getId()
    {
        return this.id;
    }
    public int getIdRecorrido()
    {
        return this.idRecorrido;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getAdultos()
    {
        return this.adultos;
    }
    public int getNiños()
    {
        return this.niños;
    }
    public String getDescripcion()
    {
        return this.descripcion;
    }
    public String getLugar()
    {
        return this.lugar;
    }
    public Date getFechaInicio()
    {
        return this.fecha_inicio;
    }
    public Date getFechaFin()
    {
        return this.fecha_fin;
    }    
}
