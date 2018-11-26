/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.Web.dao.impl;

import com.cibt.Web.dao.StudentDAO;
import com.cibt.Web.entity.Student;
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
public class StudentDAOimpl implements StudentDAO {

    @Override
    public List<Student> getAll() throws Exception {
        List<Student> students = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/sje001";
        String user = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(url,
                user, password);
        String sql = "select * from students";
        PreparedStatement stmt;
        stmt=(PreparedStatement) conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Student student=new Student(); 
            student.setId(rs.getInt("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setContactNo(rs.getString("Contact_no"));
            student.setStatus(rs.getBoolean("status"));
            
            students.add(student);
        }
        conn.close();
        return students;
    }
}