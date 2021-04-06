/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;

import java.sql.*;


/**
 *
 * @author Chondromollika_Ahmed
 */
public class DatabaseConnect {
    // for getting connection of mysql database
    Connection con;
    //statement is used for connecting with database
    Statement st;
    
    PreparedStatement pst;
    ResultSet rs;

    public  DatabaseConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ca_bank", "root","");
            //con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12393275", "sql12393275","chondromollika");
            //st=con.createStatement();
            System.out.println("success");
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
   
    
}
