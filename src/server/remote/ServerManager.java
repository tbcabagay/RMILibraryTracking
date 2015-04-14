/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.remote;

import remote.LibraryTrackingServerRemote;
import server.database.Student;

/**
 *
 * @author tbcabagay
 */
public class ServerManager implements LibraryTrackingServerRemote {

    @Override
    public boolean doLogin(String username, String password) {
        return Student.checkLogin(username, password);
    }
    
}
