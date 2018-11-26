/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.Web.dao;

import com.cibt.Web.entity.Employee;
import java.util.List;


/**
 *
 * @author ideapad-520S
 */
public interface EmployeeDAO {
    List<Employee> getAll() throws Exception;
    
}
