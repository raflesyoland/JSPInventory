/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IRekapInvDeptController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Departemen;
import models.Inventori;
import models.RekapInventoriDept;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author RRAAAA
 */
public class RekapInvDeptController implements IRekapInvDeptController {

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public RekapInvDeptController() {
        iGenericDAO = new GenericDAO(RekapInventoriDept.class, sessionFactory);
    }

    @Override
    public List<RekapInventoriDept> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public String insertupdate(String idDepartemen, String idInventori, String jumlahKeluar, String jumlahDeptTerpakai, String tglMasuk, String tglUpdate, String keterangan, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public String insertupdate(String id, String idDepartemen, String idInventori, String jumlahKeluar, String jumlahDeptTerpakai, String tglMasuk, String tglUpdate, String keterangan, String status) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertupdate(String idDepartemen, String idInventori, String jumlahKeluar, String tglMasuk, String keterangan, String status) {
        String result = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(tglMasuk);
        } catch (ParseException e) {
        }
        RekapInventoriDept rid = new RekapInventoriDept(new Departemen(new BigDecimal(idDepartemen)), new Inventori(new BigDecimal(idInventori)), new BigInteger(jumlahKeluar), date, keterangan, new Short(status));
        if (iGenericDAO.insertUpdate(rid)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }
    @Override
    public String insertupdate(String id, String idDepartemen, String idInventori, String tglMasuk, String tglUpdate, String jumlahKeluar, String jumlahDeptTerpakai, String keterangan, String status) {
        String result = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date dateUp = null;
        try {
            date = formatter.parse(tglMasuk);
            dateUp = formatter.parse(tglUpdate);
        } catch (ParseException e) {
        }
        RekapInventoriDept rid = new RekapInventoriDept(new BigDecimal(id), new Departemen(new BigDecimal(idDepartemen)), new Inventori(new BigDecimal(idInventori)), date, dateUp, new BigInteger(jumlahKeluar), new BigInteger(jumlahDeptTerpakai), keterangan, Short.valueOf(status));
        if (iGenericDAO.insertUpdate(rid)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String insertApprove(String id, String idDepartemen, String idInventori, String tglMasuk, String tglUpdate, String jumlahKeluar, String keterangan, String status) {
        String result = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date dateUp = null;
        try {
            date = formatter.parse(tglMasuk);
            dateUp = formatter.parse(tglUpdate);
        } catch (ParseException e) {
        }
        RekapInventoriDept rid = new RekapInventoriDept(new BigDecimal(id), new Departemen(new BigDecimal(idDepartemen)), new Inventori(new BigDecimal(idInventori)), date, dateUp, new BigInteger(jumlahKeluar), keterangan, Short.valueOf(status));
        if (iGenericDAO.insertUpdate(rid)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

}
