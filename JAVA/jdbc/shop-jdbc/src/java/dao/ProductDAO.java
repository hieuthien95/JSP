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
import java.util.Collections;
import model.Category;
import model.Product;

/**
 *
 * @author hieut
 */
public class ProductDAO {

    //lấy ds  sản phẩm theo danh mục
    public ArrayList<Product> getListProduct(long category_id) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM product WHERE category_id = '" + category_id + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getLong("product_id"));
            product.setCategoryID(rs.getLong("category_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDesciption(rs.getString("product_description"));
            list.add(product);
        }
        return list;
    }

    // lấy sản phẩm
    public Product getProduct(long ProductID) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM product WHERE product_id = '" + ProductID + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while (rs.next()) {
            product.setProductID(rs.getLong("product_id"));
            product.setCategoryID(rs.getLong("category_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDesciption(rs.getString("product_description"));
        }
        return product;
    }

    // lấy ds sản phẩm phân trang
    public ArrayList<Product> getListProductByPages(long categoryID, int firstResult, int maxResult) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM product WHERE category_id = '" + categoryID + "' limit ?,?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, firstResult);
        ps.setInt(2, maxResult);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getLong("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDesciption(rs.getString("product_description"));
            list.add(product);
        }
        return list;
    }
    
    // lấy ds sản phẩm
    public ArrayList<Product> getListProduct() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM product";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setCategoryID(rs.getLong("category_id"));
            product.setProductID(rs.getLong("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDesciption(rs.getString("product_description"));
            list.add(product);
        }
        Collections.reverse(list);
        return list;
    }
    
    public int countProductByCategory(long categoryID) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT COUNT(product_id) FROM product WHERE category_id = '" + categoryID + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    // thêm sản phẩm
    public boolean insertProduct(Product p) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT INTO product(category_id, product_name, product_image, product_price, product_description) VALUE(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, p.getCategoryID());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getProductImage());
            ps.setDouble(4, p.getProductPrice());
            ps.setString(5, p.getProductDescription());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // xóa sản phẩm
    public boolean deleteProduct(long product_id) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "DELETE FROM product WHERE product_id = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, product_id);
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // sửa sản phẩm
    public boolean updateProduct(Product p) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "UPDATE product SET category_id=?, product_name=?, product_image=?, product_price=?, product_description=? WHERE product_id=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, p.getCategoryID());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getProductImage());
            ps.setDouble(4, p.getProductPrice());
            ps.setString(5, p.getProductDescription());
            ps.setLong(6, p.getProductID());
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println(new ProductDAO().getListProduct());
    }
}
