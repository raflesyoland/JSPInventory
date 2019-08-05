/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.RekapInventoriDept;

/**
 *
 * @author RRAAAA
 */
public interface IRekapInvDeptController {

    public List<RekapInventoriDept> getAll();

    public String insertupdate(String idDepartemen, String idInventori, String jumlahKeluar, String jumlahDeptTerpakai, String tglMasuk, String tglUpdate, String keterangan, String status);

    public String insertupdate(String idDepartemen, String idInventori, String jumlahKeluar, String tglMasuk, String keterangan, String status);

    public String insertApprove(String id, String idDepartemen, String idInventori, String tglMasuk, String tglUpdate, String jumlahKeluar, String keterangan, String status);

    public String insertupdate(String id, String idDepartemen, String idInventori, String tglMasuk, String tglUpdate, String jumlahKeluar, String jumlahDeptTerpakai, String keterangan, String status);

//    public String insertupdate(String id, String idDepartemen, String idInventori, String jumlahKeluar, String jumlahDeptTerpakai, String tglMasuk, String tglUpdate, String keterangan, String status);
    public String delete(String id);
}
