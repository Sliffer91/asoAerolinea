/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lichita
 */
@Entity
@Table(name = "transaccion_aerolinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionAerolinea.findAll", query = "SELECT t FROM TransaccionAerolinea t"),
    @NamedQuery(name = "TransaccionAerolinea.findByTraCodigo", query = "SELECT t FROM TransaccionAerolinea t WHERE t.traCodigo = :traCodigo"),
    @NamedQuery(name = "TransaccionAerolinea.findByVueCodigo", query = "SELECT t FROM TransaccionAerolinea t WHERE t.vueCodigo = :vueCodigo"),
    @NamedQuery(name = "TransaccionAerolinea.findByAsiCodigo", query = "SELECT t FROM TransaccionAerolinea t WHERE t.asiCodigo = :asiCodigo"),
    @NamedQuery(name = "TransaccionAerolinea.findByPersona", query = "SELECT t FROM TransaccionAerolinea t WHERE t.persona = :persona"),
    @NamedQuery(name = "TransaccionAerolinea.findByPaquete", query = "SELECT t FROM TransaccionAerolinea t WHERE t.paquete = :paquete")})
public class TransaccionAerolinea implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tra_codigo")
    private Integer traCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vue_codigo")
    private BigInteger vueCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asi_codigo")
    private BigInteger asiCodigo;
    @Column(name = "persona")
    private BigInteger persona;
    @Column(name = "paquete")
    private BigInteger paquete;
    @JoinColumn(name = "aer_codigo", referencedColumnName = "aer_codigo")
    @ManyToOne
    private Aerolinea aerCodigo;

    public TransaccionAerolinea() {
    }

    public TransaccionAerolinea(Integer traCodigo) {
        this.traCodigo = traCodigo;
    }

    public TransaccionAerolinea(Integer traCodigo, BigInteger vueCodigo, BigInteger asiCodigo) {
        this.traCodigo = traCodigo;
        this.vueCodigo = vueCodigo;
        this.asiCodigo = asiCodigo;
    }

    public Integer getTraCodigo() {
        return traCodigo;
    }

    public void setTraCodigo(Integer traCodigo) {
        this.traCodigo = traCodigo;
    }

    public BigInteger getVueCodigo() {
        return vueCodigo;
    }

    public void setVueCodigo(BigInteger vueCodigo) {
        this.vueCodigo = vueCodigo;
    }

    public BigInteger getAsiCodigo() {
        return asiCodigo;
    }

    public void setAsiCodigo(BigInteger asiCodigo) {
        this.asiCodigo = asiCodigo;
    }

    public BigInteger getPersona() {
        return persona;
    }

    public void setPersona(BigInteger persona) {
        this.persona = persona;
    }

    public BigInteger getPaquete() {
        return paquete;
    }

    public void setPaquete(BigInteger paquete) {
        this.paquete = paquete;
    }

    public Aerolinea getAerCodigo() {
        return aerCodigo;
    }

    public void setAerCodigo(Aerolinea aerCodigo) {
        this.aerCodigo = aerCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traCodigo != null ? traCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionAerolinea)) {
            return false;
        }
        TransaccionAerolinea other = (TransaccionAerolinea) object;
        if ((this.traCodigo == null && other.traCodigo != null) || (this.traCodigo != null && !this.traCodigo.equals(other.traCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.asoaerolineas.entities.TransaccionAerolinea[ traCodigo=" + traCodigo + " ]";
    }
    
}
