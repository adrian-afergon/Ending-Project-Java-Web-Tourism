/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tb_recorrido_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRecorridoActividad.findAll", query = "SELECT t FROM TbRecorridoActividad t"),
    @NamedQuery(name = "TbRecorridoActividad.findById", query = "SELECT t FROM TbRecorridoActividad t WHERE t.id = :id")})
public class TbRecorridoActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
    @ManyToOne
    private TbActividades idActividad;
    @JoinColumn(name = "id_recorrido", referencedColumnName = "id_recorrido")
    @ManyToOne
    private TbRecorrido idRecorrido;

    public TbRecorridoActividad() {
    }

    public TbRecorridoActividad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TbActividades getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(TbActividades idActividad) {
        this.idActividad = idActividad;
    }

    public TbRecorrido getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(TbRecorrido idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRecorridoActividad)) {
            return false;
        }
        TbRecorridoActividad other = (TbRecorridoActividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbRecorridoActividad[ id=" + id + " ]";
    }
    
}
