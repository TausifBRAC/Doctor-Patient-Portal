/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tausif Nazim71
 */
public class ConnectionClass {
    public Connection connection;
    
    public Connection getConnectio(){
        String dbname= "Doctor and Patient";
        String username="root";
        String password="";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            connection=DriverManager.getConnection("jdbc:mysql://localhost/"+dbname,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return connection;
        
    }
    
}
