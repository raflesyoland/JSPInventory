/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "INVENTORI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventori.findAll", query = "SELECT i FROM Inventori i")
    , @NamedQuery(name = "Inventori.findById", query = "SELECT i FROM Inventori i WHERE i.id = :id")
    , @NamedQuery(name = "Inventori.findByNama", query = "SELECT i FROM Inventori i WHERE i.nama = :nama")
    , @NamedQuery(name = "Inventori.findByTglInput", query = "SELECT i FROM Inventori i WHERE i.tglInput = :tglInput")
    , @NamedQuery(name = "Inventori.findByTglUpdate", query = "SELECT i FROM Inventori i WHERE i.tglUpdate = :tglUpdate")
    , @NamedQuery(name = "Inventori.findByJumlahMasuk", query = "SELECT i FROM Inventori i WHERE i.jumlahMasuk = :jumlahMasuk")
    , @NamedQuery(name = "Inventori.findByJumlahKeluar", query = "SELECT i FROM Inventori i WHERE i.jumlahKeluar = :jumlahKeluar")})
//    , @NamedQuery(name = "Inventori.findByTotalBarang", query = "SELECT i FROM Inventori i WHERE i.totalBarang = :totalBarang")})
public class Inventori implements Serializable {

    @OneToMany(mappedBy = "idInventori", fetch = FetchType.LAZY)
    private List<RekapInventoriDept> rekapInventoriDeptList;

//    @Column(name = "TOTAL_BARANG")
//    private BigInteger totalBarang;

//    @Column(name = "TOTAL_BARANG")
//    private BigInteger totalBarang;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INV_ID_GEN")
    @SequenceGenerator(name = "INV_ID_GEN", sequenceName = "INVENTORI_ID_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "TGL_INPUT")
    @Temporal(TemporalType.DATE)
    private Date tglInput;
    @Column(name = "TGL_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date tglUpdate;
    @Column(name = "JUMLAH_MASUK")
    private BigInteger jumlahMasuk;
    @Column(name = "JUMLAH_KELUAR")
    private BigInteger jumlahKeluar;
//    @Column(name = "TOTAL_BARANG")
//    private BigInteger totalBarang;

    public Inventori() {
    }

    public Inventori(BigDecimal id, String nama, Date tglInput) {
        this.id = id;
        this.nama = nama;
        this.tglInput = tglInput;
    }
    
    public Inventori(String nama, Date tglInput, Date tglUpdate, BigInteger jumlahMasuk, BigInteger jumlahKeluar) {
        this.nama = nama;
        this.tglInput = tglInput;
        this.tglUpdate = tglUpdate;
        this.jumlahMasuk = jumlahMasuk;
        this.jumlahKeluar = jumlahKeluar;
    }

    public Inventori(BigDecimal id, Date tglUpdate, BigInteger jumlahMasuk) {
        this.id = id;
        this.tglUpdate = tglUpdate;
        this.jumlahMasuk = jumlahMasuk;
    }

    public Inventori(BigDecimal id, String nama, Date tglInput, Date tglUpdate, BigInteger jumlahMasuk) {
        this.id = id;
        this.nama = nama;
        this.tglInput = tglInput;
        this.tglUpdate = tglUpdate;
        this.jumlahMasuk = jumlahMasuk;
    }
    
    public Inventori(BigDecimal id, String nama, Date tglInput, Date tglUpdate, BigInteger jumlahMasuk, BigInteger jumlahKeluar) {
        this.id = id;
        this.nama = nama;
        this.tglInput = tglInput;
        this.tglUpdate = tglUpdate;
        this.jumlahMasuk = jumlahMasuk;
        this.jumlahKeluar = jumlahKeluar;
    }

    public Inventori(String nama, Date tglInput) {
        this.nama = nama;
        this.tglInput = tglInput;
    }

    public Inventori(BigDecimal id) {
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

    public Date getTglInput() {
        return tglInput;
    }

    public void setTglInput(Date tglInput) {
        this.tglInput = tglInput;
    }

    public Date getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }

    public BigInteger getJumlahMasuk() {
        return jumlahMasuk;
    }

    public void setJumlahMasuk(BigInteger jumlahMasuk) {
        this.jumlahMasuk = jumlahMasuk;
    }

    public BigInteger getJumlahKeluar() {
        return jumlahKeluar;
    }

    public void setJumlahKeluar(BigInteger jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

//    public BigInteger getTotalBarang() {
//        return totalBarang;
//    }
//
//    public void setTotalBarang(BigInteger totalBarang) {
//        this.totalBarang = totalBarang;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventori)) {
            return false;
        }
        Inventori other = (Inventori) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id +"" ;
    }

//    public BigInteger getTotalBarang() {
//        return totalBarang;
//    }
//
//    public void setTotalBarang(BigInteger totalBarang) {
//        this.totalBarang = totalBarang;
//    }


//    public BigInteger getTotalBarang() {
//        return totalBarang;
//    }
//
//    public void setTotalBarang(BigInteger totalBarang) {
//        this.totalBarang = totalBarang;
//    }

    @XmlTransient
    public List<RekapInventoriDept> getRekapInventoriDeptList() {
        return rekapInventoriDeptList;
    }

    public void setRekapInventoriDeptList(List<RekapInventoriDept> rekapInventoriDeptList) {
        this.rekapInventoriDeptList = rekapInventoriDeptList;
    }

}
