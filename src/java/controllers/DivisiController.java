/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IDivisiController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Divisi;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author RRAAAA
 */
public class DivisiController implements IDivisiController {

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public DivisiController() {
        iGenericDAO = new GenericDAO(Divisi.class, sessionFactory);
    }

    @Override
    public List<Divisi> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public List<Divisi> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String nama) {
        String result = "";
        Divisi divisi = new Divisi(nama);
        if (iGenericDAO.insertUpdate(divisi)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Divisi divisi = new Divisi(new BigDecimal(id));
        if (iGenericDAO.delete(divisi)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

}
