/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package server.utilities;

import java.util.Properties;

/**
 *
 * @author tbcabagay
 */
public class ServerConfigurationProps {

    public ServerConfigurationProps(Properties properties) {
        System.out.println("Loading server configuration.");

        DB_HOSTNAME = properties.getProperty("database.hostname");
        DB_PORT = properties.getProperty("database.port");
        DB_NAME = properties.getProperty("database.name");
        DB_USERNAME = properties.getProperty("database.username");
        DB_PASSWORD = properties.getProperty("database.password");

        SERVER_ID = properties.getProperty("server.name");
        SERVER_PORT = properties.getProperty("server.rmi.port");
        REMOTE_OBJECT_NAME = properties.getProperty("remote.object.name");
    }

    public static String DB_HOSTNAME;
    public static String DB_PORT;
    public static String DB_NAME;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;
    public static String SERVER_ID;
    public static String SERVER_PORT;
    public static String REMOTE_OBJECT_NAME;
}
