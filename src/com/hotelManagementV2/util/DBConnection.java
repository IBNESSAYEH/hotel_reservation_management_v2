package com.hotelManagementV2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection connectionInstance = null;


    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "admin";

    private DBConnection() {
        try {
             Connection connection;
            connection = DriverManager.getConnection(url, user, password);
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





}
