/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IInventoriController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Inventori;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author RRAAAA
 */
public class InventoriController implements IInventoriController {

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public InventoriController() {
        iGenericDAO = new GenericDAO(Inventori.class, sessionFactory);
    }

    @Override
    public List<Inventori> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public List<Inventori> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String id, String nama, String tglInput, String tglUpdate, String jumlahMasuk, String jumlahKeluar) {
        String result = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date dateUp = null;
        try {
            date = formatter.parse(tglInput);
            dateUp = formatter.parse(tglUpdate);
        } catch (ParseException e) {
        }
        Inventori inventori = new Inventori(new BigDecimal(id), nama, date, dateUp, new BigInteger(jumlahMasuk), new BigInteger(jumlahKeluar));
        if (iGenericDAO.insertUpdate(inventori)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }
    @Override
    public String insertUpdate(String id, String nama, String tglInput, String tglUpdate, String jumlahMasuk) {
        String result = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date dateUp = null;
        BigInteger jm = new BigInteger(jumlahMasuk);
        try {
            date = formatter.parse(tglInput);
            dateUp = formatter.parse(tglUpdate);
        } catch (ParseException e) {
        }
        Inventori inventori = new Inventori(new BigDecimal(id), nama, date, dateUp, jm);
        if (iGenericDAO.insertUpdate(inventori)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String insertUpdate(String nama, String tglInput) {
        String result = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(tglInput);
        } catch (ParseException e) {
        }
        Inventori inventori = new Inventori(nama, date);
        if (iGenericDAO.insertUpdate(inventori)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }
    @Override
    public String insertUpdate(String id, String nama, String tglInput) {
        String result = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(tglInput);
        } catch (ParseException e) {
        }
        Inventori inventori = new Inventori(new BigDecimal(id), nama, date);
        if (iGenericDAO.insertUpdate(inventori)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

//    @Override
//    public String insertItem(String id, String tglUpdate, String jumlahMasuk) {
//        String result = "";
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        try {
//            date = formatter.parse(tglUpdate);
//        } catch (ParseException e) {
//        }
//        Inventori inventori = new Inventori(new BigDecimal(id), date, new BigInteger(jumlahMasuk));
//        if (iGenericDAO.insertUpdate(inventori)) {
//            result = "Data berhasil disimpan";
//        } else {
//            result = "Maaf data gagal disimpan";
//        }
//        return result;
//    }
    @Override
    public String delete(String id) {
        String result = "";
        Inventori inventori = new Inventori(new BigDecimal(id));
        if (iGenericDAO.delete(inventori)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }


}
