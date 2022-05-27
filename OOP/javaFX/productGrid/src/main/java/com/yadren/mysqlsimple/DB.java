package com.yadren.mysqlsimple;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    // Данные для подключения к локальной базе данных
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "productsDB";
    private final String LOGIN = "admin"; // Если OpenServer, то здесь mysql напишите
    private final String PASS = "qwerty"; // Если OpenServer, то здесь mysql напишите
    private Connection dbConn = null;

    // Метод для подключения к БД с использованием значений выше
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    // Метод для получения всех заданий из таблицы todo
    public ArrayList<String[]> getTasks() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Service ORDER BY `ID` DESC";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String[]> tasks = new ArrayList<String[]>();
        while(res.next()) {
            String title = res.getString("Title");
            int cost = res.getInt("Cost");
            String costStr = Integer.toString(cost);
            int discount = res.getInt("Discount");
            String discountStr = Integer.toString(discount);

            tasks.add(new String[]{title, costStr, discountStr});
        }

        return tasks;
    }

    public ArrayList<String[]> getProducts(int limit, int offset) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Product LIMIT " + limit + " OFFSET " + offset;

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String[]> products = new ArrayList<String[]>();
        while(res.next()) {
            String title = res.getString("Title");
            int cost = res.getInt("Cost");
            String costStr = Integer.toString(cost);
            String isActive = res.getString("isActive");

            products.add(new String[]{title, costStr, isActive});
        }

        return products;
    }
}
