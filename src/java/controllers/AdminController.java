/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IAdminController;
import idaos.IGenericDAO;
import models.Admin;
import models.Divisi;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author RRAAAA
 */
public class AdminController implements IAdminController {

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public AdminController() {
        iGenericDAO = new GenericDAO(Admin.class, sessionFactory);
    }

    @Override
    public boolean validatePass(String username, String password) {
        boolean result = false;
        String passwordHash = iGenericDAO.loginAuth(username).getPassword();
        String usernameHash = iGenericDAO.loginAuth(username).getUsername();
        if (password.equals(passwordHash) && username.equals(usernameHash)) {
            result = true;
        } else {
            result = false;
        }
        System.out.println("result :" + result);
        return result;
    }

}
