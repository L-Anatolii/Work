//package com.mycompany.mywebapp.Вита;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import org.sqlite.JDBC;
//
//public class DbHandler {
//    private static final String CON_STR = "jdbc:mysql://localhost:3306/mysql";
//
//
//    private static DbHandler instsnte = null;
//
//    public static synchronized DbHandler getInstance() throws SQLException {
//        if (instsnte == null)
//            instsnte = new DbHandler();
//        return instsnte;
//    }
//
//    private Connection connection;
//
//    private DbHandler() throws SQLException {
//        DriverManager.registerDriver(new org.mysql.Driver());
//        this.connection = DriverManager.getConnection(CON_STR);
//    }
//
//    public List<Product> getAllProducts() throws Exception{
//        try (Statement statement = this.connection.createStatement()) {
//            List<Product> products = new ArrayList<Product>();
//            ResultSet resultSet = statement.executeQuery("SELECT id, good, price, category_name FROM products");
//
//            while (resultSet.next()) {
//                products.add(new Product(
//                    resultSet.getInt("id"),
//                    resultSet.getString("good"),
//                    resultSet.getDouble("price"),
//                    resultSet.getString("category_name")));
//                };
//                return products;
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return Collections.emptyList();
//            }
//        }
//
//    public void addProduct(Product product) {
//        try (PreparedStatement statement = this.connection.prepareStatement(
//                "INSERT INTO products (good,price,categori_name)" +
//                        "VALUES(?, ?, ?)")) {
//            statement.setObject(1, product.good);
//            statement.setObject(2, product.prise);
//            statement.setObject(3, product.categori_name);
//            statement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteProduct(int id) {
//        try (PreparedStatement statement = this.connection.prepareStatement(
//                "DELETE FROM products WHERE id = ?")) {
//            statement.setObject(1, id);
//            statement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}