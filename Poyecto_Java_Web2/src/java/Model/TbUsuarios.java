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
@Table(name = "tb_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuarios.findAll", query = "SELECT t FROM TbUsuarios t"),
    @NamedQuery(name = "TbUsuarios.findLogin", query = "SELECT t FROM TbUsuarios t WHERE t.email = :email AND t.password = :password"),
    @NamedQuery(name = "TbUsuarios.findByIdUsuario", query = "SELECT t FROM TbUsuarios t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TbUsuarios.findByNombre", query = "SELECT t FROM TbUsuarios t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TbUsuarios.findByApellidos", query = "SELECT t FROM TbUsuarios t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TbUsuarios.findByEmail", query = "SELECT t FROM TbUsuarios t WHERE t.email = :email"),
    @NamedQuery(name = "TbUsuarios.findByPassword", query = "SELECT t FROM TbUsuarios t WHERE t.password = :password")})
public class TbUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "idUsuario")
    private List<TbUsuarioRecorrido> tbUsuarioRecorridoList;

    public TbUsuarios() {
    }

    public TbUsuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuarios)) {
            return false;
        }
        TbUsuarios other = (TbUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbUsuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
