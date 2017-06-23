/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hieut
 */
public class DBConnect {
    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shop", "root", "123456789");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
    
    
 
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
