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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "REKAP_INVENTORI_DEPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RekapInventoriDept.findAll", query = "SELECT r FROM RekapInventoriDept r")
    , @NamedQuery(name = "RekapInventoriDept.findById", query = "SELECT r FROM RekapInventoriDept r WHERE r.id = :id")
    , @NamedQuery(name = "RekapInventoriDept.findByJumlahKeluar", query = "SELECT r FROM RekapInventoriDept r WHERE r.jumlahKeluar = :jumlahKeluar")
//    , @NamedQuery(name = "RekapInventoriDept.findByJumlahDeptMasuk", query = "SELECT r FROM RekapInventoriDept r WHERE r.jumlahDeptMasuk = :jumlahDeptMasuk")
    , @NamedQuery(name = "RekapInventoriDept.findByJumlahDeptTerpakai", query = "SELECT r FROM RekapInventoriDept r WHERE r.jumlahDeptTerpakai = :jumlahDeptTerpakai")
    , @NamedQuery(name = "RekapInventoriDept.findByKeterangan", query = "SELECT r FROM RekapInventoriDept r WHERE r.keterangan = :keterangan")
    , @NamedQuery(name = "RekapInventoriDept.findByStatus", query = "SELECT r FROM RekapInventoriDept r WHERE r.status = :status")})
public class RekapInventoriDept implements Serializable {

    @Column(name = "TGL_MASUK")
    @Temporal(TemporalType.DATE)
    private Date tglMasuk;
    @Column(name = "TGL_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date tglUpdate;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REKAP_ID_GEN")
    @SequenceGenerator(name = "REKAP_ID_GEN", sequenceName = "REKAP_ID_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "JUMLAH_KELUAR")
    private BigInteger jumlahKeluar;
//    @Column(name = "JUMLAH_DEPT_MASUK")
//    private BigInteger jumlahDeptMasuk;
    @Column(name = "JUMLAH_DEPT_TERPAKAI")
    private BigInteger jumlahDeptTerpakai;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @Column(name = "STATUS")
    private Short status;
    @JoinColumn(name = "ID_DEPARTEMEN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departemen idDepartemen;
    @JoinColumn(name = "ID_INVENTORI", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inventori idInventori;

    public RekapInventoriDept() {
    }

    public RekapInventoriDept(BigDecimal id, Departemen idDepartemen, Inventori idInventori, Date tglMasuk, Date tglUpdate, BigInteger jumlahKeluar, BigInteger jumlahDeptTerpakai, String keterangan, Short status) {
        this.tglMasuk = tglMasuk;
        this.tglUpdate = tglUpdate;
        this.id = id;
        this.jumlahKeluar = jumlahKeluar;
        this.jumlahDeptTerpakai = jumlahDeptTerpakai;
        this.keterangan = keterangan;
        this.status = status;
        this.idDepartemen = idDepartemen;
        this.idInventori = idInventori;
    }

    public RekapInventoriDept(BigDecimal id, Departemen idDepartemen, Inventori idInventori, Date tglMasuk, Date tglUpdate, BigInteger jumlahKeluar, String keterangan, Short status) {
        this.tglMasuk = tglMasuk;
        this.id = id;
        this.jumlahKeluar = jumlahKeluar;
        this.keterangan = keterangan;
        this.status = status;
        this.idDepartemen = idDepartemen;
        this.idInventori = idInventori;
        this.tglUpdate = tglUpdate;
    }

    public RekapInventoriDept(Departemen idDepartemen, Inventori idInventori, BigInteger jumlahKeluar, Date tglMasuk, String keterangan, Short status) {
        this.tglMasuk = tglMasuk;
        this.jumlahKeluar = jumlahKeluar;
        this.keterangan = keterangan;
        this.status = status;
        this.idDepartemen = idDepartemen;
        this.idInventori = idInventori;
    }

    public RekapInventoriDept(Departemen idDepartemen, Inventori idInventori, BigInteger jumlahKeluar, BigInteger jumlahDeptTerpakai, Date tglMasuk, Date tglUpdate, String keterangan, Short status) {
        this.idDepartemen = idDepartemen;
        this.idInventori = idInventori;
        this.jumlahKeluar = jumlahKeluar;
        this.jumlahDeptTerpakai = jumlahDeptTerpakai;
        this.tglMasuk = tglMasuk;
        this.tglUpdate = tglUpdate;
        this.keterangan = keterangan;
        this.status = status;
    }
    public RekapInventoriDept(BigDecimal id, Departemen idDepartemen, Inventori idInventori, BigInteger jumlahKeluar, BigInteger jumlahDeptTerpakai, Date tglMasuk, Date tglUpdate, String keterangan, Short status) {
        this.id = id;
        this.idDepartemen = idDepartemen;
        this.idInventori = idInventori;
        this.jumlahKeluar = jumlahKeluar;
        this.jumlahDeptTerpakai = jumlahDeptTerpakai;
        this.tglMasuk = tglMasuk;
        this.tglUpdate = tglUpdate;
        this.keterangan = keterangan;
        this.status = status;
    }

    public RekapInventoriDept(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getJumlahKeluar() {
        return jumlahKeluar;
    }

    public void setJumlahKeluar(BigInteger jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

//    public BigInteger getJumlahDeptMasuk() {
//        return jumlahDeptMasuk;
//    }
//
//    public void setJumlahDeptMasuk(BigInteger jumlahDeptMasuk) {
//        this.jumlahDeptMasuk = jumlahDeptMasuk;
//    }

    public BigInteger getJumlahDeptTerpakai() {
        return jumlahDeptTerpakai;
    }

    public void setJumlahDeptTerpakai(BigInteger jumlahDeptTerpakai) {
        this.jumlahDeptTerpakai = jumlahDeptTerpakai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Departemen getIdDepartemen() {
        return idDepartemen;
    }

    public void setIdDepartemen(Departemen idDepartemen) {
        this.idDepartemen = idDepartemen;
    }

    public Inventori getIdInventori() {
        return idInventori;
    }

    public void setIdInventori(Inventori idInventori) {
        this.idInventori = idInventori;
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
        if (!(object instanceof RekapInventoriDept)) {
            return false;
        }
        RekapInventoriDept other = (RekapInventoriDept) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RekapInventoriDept[ id=" + id + " ]";
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public Date getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }
    
}
