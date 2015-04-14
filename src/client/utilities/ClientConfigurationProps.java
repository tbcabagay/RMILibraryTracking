/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.utilities;

import java.util.Properties;

/**
 *
 * @author tbcabagay
 */
public class ClientConfigurationProps {

    public ClientConfigurationProps(Properties properties) {
        System.out.println("Loading client configuration");
        
        SERVER_NAME = properties.getProperty("server.name");
        SERVER_PORT = Integer.parseInt(properties.getProperty("server.rmi.port"));
        REMOTE_OBJECT_NAME = properties.getProperty("remote.object.name");
    }

    public static String SERVER_NAME;
    public static int SERVER_PORT;
    public static String REMOTE_OBJECT_NAME;

}
