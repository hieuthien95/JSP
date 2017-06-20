/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Users;

/**
 *
 * @author hieut
 */
public class UsersDAO {

    public boolean checkEmail(String email) throws SQLException {
        Connection connection = DBConnect.getConnection();

        String sql = "SELECT * FROM users WHERE user_email ='" + email + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            connection.close();
            return true;
        }
        return false;
    }

    public boolean insertUser(Users u) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO users VALUES(?,?,?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setLong(1, u.getUserID());
        ps.setString(2, u.getUserEmail());
        ps.setString(3, u.getUserPass());
        ps.setBoolean(4, u.isUserRole());
        ps.execute();
        return true;
    }

    public Users login(String email, String password) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM users WHERE user_email='" + email + "' AND user_pass='" + password + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Users users = new Users(rs.getLong("user_id"), rs.getString("user_email"), rs.getString("user_pass"), rs.getBoolean("user_role"));
            connection.close();
            return users;
        }
        return null;
    }

}
