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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "ADMIN_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminRole.findAll", query = "SELECT a FROM AdminRole a")
    , @NamedQuery(name = "AdminRole.findById", query = "SELECT a FROM AdminRole a WHERE a.id = :id")
    , @NamedQuery(name = "AdminRole.findByRole", query = "SELECT a FROM AdminRole a WHERE a.role = :role")})
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "ROLE")
    private String role;
    @OneToMany(mappedBy = "roleId", fetch = FetchType.LAZY)
    private List<Admin> adminList;

    public AdminRole() {
    }

    public AdminRole(BigDecimal id) {
        this.id = id;
    }

    public AdminRole(BigDecimal id, String role) {
        this.id = id;
        this.role = role;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
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
        if (!(object instanceof AdminRole)) {
            return false;
        }
        AdminRole other = (AdminRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.AdminRole[ id=" + id + " ]";
    }
    
}
