package com.hotelManagementV2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection connectionInstance = null;
    private Connection connection;



    private DBConnection() {
         final String url = "jdbc:postgresql://localhost:5433/hotel_postgres_db";
         final String user = "admin";
         final String password = "admin";
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie avec succès à PostgreSQL !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à PostgreSQL : " + e.getMessage());
        }
         }

    public static DBConnection getConnectionInstance() {
        if (connectionInstance == null) {
            connectionInstance = new DBConnection();
        }
        return connectionInstance;
    }

    public Connection getConnection() {
        return connection;
    }


}
