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
@Table(name = "tb_usuario_recorrido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuarioRecorrido.findAll", query = "SELECT t FROM TbUsuarioRecorrido t"),
    @NamedQuery(name = "TbUsuarioRecorrido.findById", query = "SELECT t FROM TbUsuarioRecorrido t WHERE t.id = :id"),
    @NamedQuery(name = "TbUsuarioRecorrido.findByAdultos", query = "SELECT t FROM TbUsuarioRecorrido t WHERE t.adultos = :adultos"),
    @NamedQuery(name = "TbUsuarioRecorrido.findByNi\u00f1os", query = "SELECT t FROM TbUsuarioRecorrido t WHERE t.ni\u00f1os = :ni\u00f1os"),
    @NamedQuery(name = "TbUsuarioRecorrido.findByActivo", query = "SELECT t FROM TbUsuarioRecorrido t WHERE t.activo = :activo")})
public class TbUsuarioRecorrido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "adultos")
    private Integer adultos;
    @Column(name = "ni\u00f1os")
    private Integer niños;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_recorrido", referencedColumnName = "id_recorrido")
    @ManyToOne
    private TbRecorrido idRecorrido;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private TbUsuarios idUsuario;

    public TbUsuarioRecorrido() {
    }

    public TbUsuarioRecorrido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdultos() {
        return adultos;
    }

    public void setAdultos(Integer adultos) {
        this.adultos = adultos;
    }

    public Integer getNiños() {
        return niños;
    }

    public void setNiños(Integer niños) {
        this.niños = niños;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public TbRecorrido getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(TbRecorrido idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public TbUsuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TbUsuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof TbUsuarioRecorrido)) {
            return false;
        }
        TbUsuarioRecorrido other = (TbUsuarioRecorrido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbUsuarioRecorrido[ id=" + id + " ]";
    }
    
}
