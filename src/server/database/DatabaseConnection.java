/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import server.utilities.ServerConfigurationProps;

/**
 *
 * @author tbcabagay
 */
public class DatabaseConnection {

    public DatabaseConnection() {
        username = ServerConfigurationProps.DB_USERNAME;
        password = ServerConfigurationProps.DB_PASSWORD;
        hostname = ServerConfigurationProps.DB_HOSTNAME;
        port = ServerConfigurationProps.DB_PORT;
        name = ServerConfigurationProps.DB_NAME;
        connection = null;

        String connectionURL = "jdbc:mysql://" + hostname + ":" + port + "/" + name;

        try {
            System.out.print("Loading database connection...");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, username, password);
            System.out.println(" done.");
        } catch (Exception ex) {
            System.err.println("Error in " + DatabaseConnection.class.getName() + ": " + ex.toString());
            System.exit(1);
        }

        System.out.println("Initializing models...");
        Student student = new Student();
    }

    public static Connection getConnection() {
        return connection;
    }

    private static String username;
    private static String password;
    private static String hostname;
    private static String port;
    private static String name;
    private static Connection connection;
}
