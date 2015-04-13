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
        this.username = ServerConfigurationProps.DB_USERNAME;
        this.password = ServerConfigurationProps.DB_PASSWORD;
        this.hostname = ServerConfigurationProps.DB_HOSTNAME;
        this.port = ServerConfigurationProps.DB_PORT;
        this.name = ServerConfigurationProps.DB_NAME;
        this.connection = null;

        String connectionURL = "jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.name;

        try {
            System.out.print("Loading database connection...");
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(connectionURL, this.username, this.password);
            System.out.println(" done.");
        } catch (Exception ex) {
            System.err.println("Error in " + DatabaseConnection.class.getName() + ": " + ex.toString());
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private String username;
    private String password;
    private String hostname;
    private String port;
    private String name;
    private Connection connection;
}
