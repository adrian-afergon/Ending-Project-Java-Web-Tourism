/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tb_recorrido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRecorrido.findAll", query = "SELECT t FROM TbRecorrido t"),
    @NamedQuery(name = "TbRecorrido.findByIdRecorrido", query = "SELECT t FROM TbRecorrido t WHERE t.idRecorrido = :idRecorrido"),
    @NamedQuery(name = "TbRecorrido.findByLugar", query = "SELECT t FROM TbRecorrido t WHERE t.lugar = :lugar"),
    @NamedQuery(name = "TbRecorrido.findByFechaInicio", query = "SELECT t FROM TbRecorrido t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TbRecorrido.findProximos", query = "SELECT t FROM TbRecorrido t WHERE t.fechaInicio > :fechaInicio"),
    @NamedQuery(name = "TbRecorrido.findProximosLugar", query = "SELECT t FROM TbRecorrido t WHERE t.fechaInicio >= :fechaInicio AND t.lugar LIKE :lugar"),
    @NamedQuery(name = "TbRecorrido.findByFechaFin", query = "SELECT t FROM TbRecorrido t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TbRecorrido.findByDescripcion", query = "SELECT t FROM TbRecorrido t WHERE t.descripcion = :descripcion")})
public class TbRecorrido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recorrido")
    private Integer idRecorrido;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @OneToMany(mappedBy = "idRecorrido")
    private List<TbRecorridoActividad> tbRecorridoActividadList;
    @OneToMany(mappedBy = "idRecorrido")
    private List<TbUsuarioRecorrido> tbUsuarioRecorridoList;

    public TbRecorrido() {
    }

    public TbRecorrido(Integer idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public Integer getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(Integer idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @XmlTransient
    public List<TbRecorridoActividad> getTbRecorridoActividadList() {
        return tbRecorridoActividadList;
    }

    public void setTbRecorridoActividadList(List<TbRecorridoActividad> tbRecorridoActividadList) {
        this.tbRecorridoActividadList = tbRecorridoActividadList;
    }

    @XmlTransient
    public List<TbUsuarioRecorrido> getTbUsuarioRecorridoList() {
        return tbUsuarioRecorridoList;
    }

    public void setTbUsuarioRecorridoList(List<TbUsuarioRecorrido> tbUsuarioRecorridoList) {
        this.tbUsuarioRecorridoList = tbUsuarioRecorridoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecorrido != null ? idRecorrido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRecorrido)) {
            return false;
        }
        TbRecorrido other = (TbRecorrido) object;
        if ((this.idRecorrido == null && other.idRecorrido != null) || (this.idRecorrido != null && !this.idRecorrido.equals(other.idRecorrido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbRecorrido[ idRecorrido=" + idRecorrido + " ]";
    }
    
}
