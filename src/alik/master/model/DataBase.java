package alik.master.model;

import alik.master.db.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase implements Config {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE +
                "?useUnicode=true" +
                "&serverTimezone=UTC" +
                "&useSSL=true" +
                "&verifyServerCertificate=false";

        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}
