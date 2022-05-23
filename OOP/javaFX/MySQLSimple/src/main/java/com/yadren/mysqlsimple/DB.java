package com.yadren.mysqlsimple;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    // Данные для подключения к локальной базе данных
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "main";
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

    // Метод для добавления новых заданий внуть таблицы todo
    public void insertTask(String task) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `Service` (Title) VALUES (?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, task);

        prSt.executeUpdate();

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
}
