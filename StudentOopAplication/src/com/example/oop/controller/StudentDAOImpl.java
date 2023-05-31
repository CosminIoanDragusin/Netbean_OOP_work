/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oop.controller;

import com.example.oop.model.Student;
import com.example.oop.db.StudentDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class StudentDAOImpl implements StudentDAO{

    @Override
    public void save(Student students) {
 
         try {
            Connection con =  StudentDataBase.getConnection();
            String sql = "INSERT INTO student2(nume,prenume,curs,pret) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, students.getName());
            ps.setString(2, students.getPrenume());
            ps.setString(3, students.getCurs());
            ps.setInt(4, students.getPret());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
 
    @Override
    public void update(Student students) {
      
        
         try {
          
            Connection con = StudentDataBase.getConnection();
            String sql = "UPDATE student2 SET nume=?,prenume=?,curs=?,pret=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, students.getName());
            ps.setString(2, students.getPrenume());
            ps.setString(3, students.getCurs());
            ps.setInt(4, students.getPret());
            ps.setInt(5, students.getId());
            ps.executeUpdate();
 
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
 
    @Override
    public void delete(Student students) {
       try {
          
            Connection con = StudentDataBase.getConnection();
            String sql = "delete from student2  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, students.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
 
    @Override
    public Student get(int id) {
        
        
         Student st = new Student();
        try {
            Connection con = StudentDataBase.getConnection();
            String sql = "SELECT * FROM student2 WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("nume"));
                st.setPrenume(rs.getString("prenume"));
                st.setCurs(rs.getString("curs"));
                st.setPret(rs.getInt("pret"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }
 
    @Override
    public List<Student> list() {
      
          List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDataBase.getConnection();
            String sql = "SELECT * FROM student2 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("nume"));
                st.setPrenume(rs.getString("prenume"));
                st.setCurs(rs.getString("curs"));
                st.setPret(rs.getInt("pret"));
 
                list.add(st);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }
    
}
