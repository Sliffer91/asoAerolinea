/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lichita
 */
@Entity
@Table(name = "aerolinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aerolinea.findAll", query = "SELECT a FROM Aerolinea a"),
    @NamedQuery(name = "Aerolinea.findByAerCodigo", query = "SELECT a FROM Aerolinea a WHERE a.aerCodigo = :aerCodigo"),
    @NamedQuery(name = "Aerolinea.findByNombre", query = "SELECT a FROM Aerolinea a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aerolinea.findByTelefono", query = "SELECT a FROM Aerolinea a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Aerolinea.findByDescripcion", query = "SELECT a FROM Aerolinea a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Aerolinea.findByContacto", query = "SELECT a FROM Aerolinea a WHERE a.contacto = :contacto")})
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "aer_codigo")
    private Integer aerCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 150)
    @Column(name = "contacto")
    private String contacto;
    @OneToMany(mappedBy = "aerCodigo")
    private List<TransaccionAerolinea> transaccionAerolineaList;

    public Aerolinea() {
    }

    public Aerolinea(Integer aerCodigo) {
        this.aerCodigo = aerCodigo;
    }

    public Aerolinea(Integer aerCodigo, String nombre, String telefono, String descripcion) {
        this.aerCodigo = aerCodigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public Integer getAerCodigo() {
        return aerCodigo;
    }

    public void setAerCodigo(Integer aerCodigo) {
        this.aerCodigo = aerCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @XmlTransient
    public List<TransaccionAerolinea> getTransaccionAerolineaList() {
        return transaccionAerolineaList;
    }

    public void setTransaccionAerolineaList(List<TransaccionAerolinea> transaccionAerolineaList) {
        this.transaccionAerolineaList = transaccionAerolineaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aerCodigo != null ? aerCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aerolinea)) {
            return false;
        }
        Aerolinea other = (Aerolinea) object;
        if ((this.aerCodigo == null && other.aerCodigo != null) || (this.aerCodigo != null && !this.aerCodigo.equals(other.aerCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.asoaerolineas.entities.Aerolinea[ aerCodigo=" + aerCodigo + " ]";
    }
    
}
