/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DepartemenController;
import controllers.InventoriController;
import controllers.RekapInvDeptController;
import daos.GenericDAO;
import icontrollers.IDepartemenController;
import icontrollers.IInventoriController;
import icontrollers.IRekapInvDeptController;
import idaos.IGenericDAO;
import models.Divisi;
import models.RekapInventoriDept;

/**
 *
 * @author RRAAAA
 */
public class ManualTest {

    public static void main(String[] args) {
        IGenericDAO<Divisi> igdao = new GenericDAO<>(Divisi.class, HibernateUtil.getSessionFactory());
        IInventoriController iic = new InventoriController();
        IDepartemenController idc = new DepartemenController();
        IRekapInvDeptController iridc = new RekapInvDeptController();
        
//        for (RekapInventoriDept rekapInventoriDept : iridc.getAll()) {
//            System.out.println(rekapInventoriDept.getId());
//        }
        
//        for (Admin adminRole : igdao.getAll()) {
//            System.out.println(adminRole.getId()+" "+adminRole.getRole());
//        }

        /**
         * Controller getAall
         */
//        for (Inventori inventori : iic.getAll()) {
//            System.out.println(inventori.getNama()+" "+inventori.getTglInput() );
//        }
        
        /**
         * Controller getByName
         */

//        for (Inventori inventori : iic.getByName("o")) {
//            System.out.println(inventori.getId()+" "+inventori.getNama());
//        }

        /**
         * Controller insertUpdate
         */
        System.out.println(iridc.insertupdate("1018", "10061", "10", "2019-08-01", "", "0"));
//        System.out.println(iridc.insertupdate("1018", "10046", "10", "2019-08-01", "", "0"));
//        System.out.println(iic.insertUpdate("PA", "26/07/2019", "26/07/2019", "40", "20"));
//        System.out.println(iic.insertUpdate("Kemben", "28/07/2019"));
//        System.out.println(iic.insertUpdate("Kemben", "28/07/2019", "", "", "", ""));
//        System.out.println(idc.insertUpdate("TestMan", "102"));
//System.out.println(idc.delete("1005"));
   
//        AdminRole ar = new AdminRole(new BigDecimal(1));
//        Admin admin = new Admin(new BigDecimal(11), "admin", "admin", ar);
//        System.out.println(igdao.insertUpdate(admin));
//        System.out.println(igdao.delete(admin));
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        Date date = null;
//        try {
//            date = dateFormat.parse("07/26/2019");
//        } catch (ParseException e) {
//        }
//        Inventori inventori = new Inventori(new BigDecimal(111), "Botol", date, date, BigInteger.valueOf(200), BigInteger.valueOf(0), BigInteger.valueOf(200));
//        System.out.println(igdao.insertUpdate(inventori));
//        for (Inventori inventori : igdao.getByName("b")) {
//            System.out.println(inventori.getId());
//        }
//        Divisi div = new Divisi("MSBU");
//        System.out.println(igdao.insertUpdate(div));


    }

}
