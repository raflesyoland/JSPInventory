/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Admin;

/**
 *
 * @author RRAAAA
 */
public interface IGenericDAO<T> {

    public List<T> getAll();

    public List<T> getByName(Object key);

    public boolean insertUpdate(T model);

    public boolean delete(T model);

    public Admin loginAuth(String username);

}
