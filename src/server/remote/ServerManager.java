/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.remote;

import remote.LibraryTrackingRemote;
import server.database.Student;

/**
 *
 * @author tbcabagay
 */
public class ServerManager implements LibraryTrackingRemote {

    @Override
    public boolean doLogin(String student, String password, String clientIP) {
        return Student.checkLogin(student, password);
    }
    
    @Override
    public boolean doLogout(String student, String clientIP) {
        return false;
    }
    
}
