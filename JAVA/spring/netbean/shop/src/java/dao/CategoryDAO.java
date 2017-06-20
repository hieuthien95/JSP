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
import java.util.ArrayList;
import java.util.Date;
import model.Category;

/**
 *
 * @author hieut
 */
public class CategoryDAO {

    public ArrayList<Category> getListCategory() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM category";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getLong("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                list.add(category);
            }
            cons.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public Category getCategory(Long category_id) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM category WHERE category_id = " + category_id;
        ArrayList<Category> list = new ArrayList<>();
        
        
        Category category = new Category();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category.setCategoryID(rs.getLong("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                list.add(category);
            }
            cons.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    // thêm danh mục
    public boolean insertCategory(Category c) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT INTO category VALUE(?,?)";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, c.getCategoryID());
            ps.setString(2, c.getCategoryName());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    // sửa danh mục
    public boolean updateCategory(Category c) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "UPDATE category SET category_name = ? WHERE category_id = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, c.getCategoryName());
            ps.setLong(2, c.getCategoryID());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    // xóa danh mục
    public boolean deleteCategory(long category_id) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "DELETE FROM category WHERE category_id = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, category_id);
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
        CategoryDAO dao = new CategoryDAO();
        System.out.println(dao.updateCategory(new Category(1, "11111")));
    }
}
