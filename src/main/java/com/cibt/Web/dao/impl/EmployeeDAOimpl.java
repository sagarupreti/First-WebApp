/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.Web.dao.impl;

import com.cibt.Web.dao.EmployeeDAO;
import com.cibt.Web.entity.Employee;
import com.cibt.Web.entity.Employee;
import com.mysql.cj.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ideapad-520S
 */
public class EmployeeDAOimpl implements EmployeeDAO {

    @Override
    public List<Employee> getAll() throws Exception {
         List<Employee> employees = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/sje001";
        String user = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(url,
                user, password);
        String sql = "select * from employees";
        PreparedStatement stmt;
        stmt=(PreparedStatement) conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Employee employee=new Employee(); 
            employee.setId(rs.getInt("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setContactNo(rs.getString("Contact_no"));
            employee.setStatus(rs.getBoolean("status"));
            
            employees.add(employee);
        }
        conn.close();
        return employees;
    }

}
    

