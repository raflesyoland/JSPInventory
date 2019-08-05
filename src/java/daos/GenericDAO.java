/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IGenericDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import models.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author RRAAAA
 */
public class GenericDAO<T> implements IGenericDAO<T> {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;
    private Class general = null;

    public GenericDAO(Class general, SessionFactory sessionFactory) {
        this.general = general;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<T> getAll() {
        List<T> listData = new ArrayList<T>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            listData = session.createQuery("FROM " + general.getSimpleName() + "").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listData;
    }

    @Override
    public List<T> getByName(Object key) {
        List<T> listData = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            listData = session.createQuery("FROM " + general.getSimpleName()
                    + " WHERE lower(nama) like lower (concat('%', :keyword,'%'))")
                    .setParameter("keyword", key).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listData;
    }

    @Override
    public boolean insertUpdate(T model) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(model);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(T model) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(model);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Admin loginAuth(String username) {
        Admin admin = new Admin();
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            con.createStatement().execute("alter session set current_schema=INVENTORY");
            CallableStatement cs = con.prepareCall("{Call getforlog(?,?)}");
            cs.setString(1, username);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            admin = new Admin(cs.getString(1), cs.getString(2));
        } catch (Exception e) {
            System.out.println(e);
        }
        return admin;
    }

}
