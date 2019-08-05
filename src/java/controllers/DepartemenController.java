/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IDepartemenController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Departemen;
import models.Divisi;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author RRAAAA
 */
public class DepartemenController implements IDepartemenController {

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public DepartemenController() {
        iGenericDAO = new GenericDAO(Departemen.class, sessionFactory);
    }

    @Override
    public List<Departemen> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public List<Departemen> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String nama, String idDivisi) {
        String result = "";
        Divisi div = new Divisi(new BigDecimal(idDivisi));
        Departemen dept = new Departemen(nama, div);
        if (iGenericDAO.insertUpdate(dept)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }
    @Override
    public String insertUpdate(String id, String nama, String idDivisi) {
        String result = "";
        Divisi div = new Divisi(new BigDecimal(idDivisi));
        Departemen dept = new Departemen(new BigDecimal(id), nama, div);
        if (iGenericDAO.insertUpdate(dept)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Departemen dept = new Departemen(new BigDecimal(id));
        if (iGenericDAO.delete(dept)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

}
