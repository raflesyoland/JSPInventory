/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Inventori;

/**
 *
 * @author RRAAAA
 */
public interface IInventoriController {
    public List<Inventori> getAll();
    public List<Inventori> getByName(String name);
//    public String insertUpdate(String nama, String tglInput, String tglUpdate, String jumlahMasuk, String jumlahKeluar);
    public String insertUpdate(String id,String nama, String tglInput, String tglUpdate, String jumlahMasuk, String jumlahKeluar);
    public String insertUpdate(String id,String nama, String tglInput, String tglUpdate, String jumlahMasuk);
    public String insertUpdate(String nama, String tglInput);
    public String insertUpdate(String id, String nama, String tglInput);
//    public String insertItem(String id, String tglUpdate, String jumlahMasuk);
    public String delete(String id);
}
