/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Departemen;

/**
 *
 * @author RRAAAA
 */
public interface IDepartemenController {

    public List<Departemen> getAll();

    public List<Departemen> getByName(String name);

    public String insertUpdate(String nama, String idDivisi);
    public String insertUpdate(String id, String nama, String idDivisi);

    public String delete(String id);
}
