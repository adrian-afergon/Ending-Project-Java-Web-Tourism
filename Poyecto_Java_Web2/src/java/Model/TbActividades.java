/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tb_actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbActividades.findAll", query = "SELECT t FROM TbActividades t"),
    @NamedQuery(name = "TbActividades.findByIdActividad", query = "SELECT t FROM TbActividades t WHERE t.idActividad = :idActividad"),
    @NamedQuery(name = "TbActividades.findByNombre", query = "SELECT t FROM TbActividades t WHERE t.nombre = :nombre")})
public class TbActividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idActividad")
    private List<TbRecorridoActividad> tbRecorridoActividadList;

    public TbActividades() {
    }

    public TbActividades(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<TbRecorridoActividad> getTbRecorridoActividadList() {
        return tbRecorridoActividadList;
    }

    public void setTbRecorridoActividadList(List<TbRecorridoActividad> tbRecorridoActividadList) {
        this.tbRecorridoActividadList = tbRecorridoActividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbActividades)) {
            return false;
        }
        TbActividades other = (TbActividades) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbActividades[ idActividad=" + idActividad + " ]";
    }
    
}
