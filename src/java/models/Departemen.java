/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "DEPARTEMEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departemen.findAll", query = "SELECT d FROM Departemen d")
    , @NamedQuery(name = "Departemen.findById", query = "SELECT d FROM Departemen d WHERE d.id = :id")
    , @NamedQuery(name = "Departemen.findByNama", query = "SELECT d FROM Departemen d WHERE d.nama = :nama")})
public class Departemen implements Serializable {

    @OneToMany(mappedBy = "idDepartemen", fetch = FetchType.LAZY)
    private List<RekapInventoriDept> rekapInventoriDeptList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPT_ID_GEN")
    @SequenceGenerator(name = "DEPT_ID_GEN", sequenceName = "DEPARTEMEN_ID_SEQ", allocationSize = 1)

    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAMA")
    private String nama;
    @JoinColumn(name = "ID_DIVISI", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Divisi idDivisi;

    public Departemen() {
    }

    public Departemen(BigDecimal id, String nama, Divisi idDivisi) {
        this.id = id;
        this.nama = nama;
        this.idDivisi = idDivisi;
    }
    
    public Departemen(String nama, Divisi idDivisi) {
        this.nama = nama;
        this.idDivisi = idDivisi;
    }

    public Departemen(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Divisi getIdDivisi() {
        return idDivisi;
    }

    public void setIdDivisi(Divisi idDivisi) {
        this.idDivisi = idDivisi;
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
        if (!(object instanceof Departemen)) {
            return false;
        }
        Departemen other = (Departemen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+"";
    }


    @XmlTransient
    public List<RekapInventoriDept> getRekapInventoriDeptList() {
        return rekapInventoriDeptList;
    }

    public void setRekapInventoriDeptList(List<RekapInventoriDept> rekapInventoriDeptList) {
        this.rekapInventoriDeptList = rekapInventoriDeptList;
    }

}
