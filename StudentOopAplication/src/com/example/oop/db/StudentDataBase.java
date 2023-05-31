/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oop.db;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class StudentDataBase {
   static Connection conector;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/studentdb";
    static String uname = "root";
    static String pass = "P4r0l4m34mysql";
  
    
    public static Connection getConnection() throws Exception{
        if(conector == null){
            Class.forName(driver);
            conector = DriverManager.getConnection(url,uname, pass);
        }
        return conector;
    } 
}
