/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Divisi;

/**
 *
 * @author RRAAAA
 */
public interface IDivisiController {

    public List<Divisi> getAll();

    public List<Divisi> getByName(String name);

    public String insertUpdate(String nama);

    public String delete(String id);
}
