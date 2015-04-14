/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tbcabagay
 */
public class Student {

    public Student() {
        connection = DatabaseConnection.getConnection();
        tableName = "tbl_students";
    }

    public static boolean checkLogin(String username, String password) {
        boolean result = false;

        try {
            String query = "SELECT number FROM `" + tableName + "` WHERE `number` = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = true;
            }
        } catch (Exception ex) {
            System.err.println("Error in " + Student.class.getName() + ": " + ex.toString());
            result = false;
        }
        return result;
    }

    private static String number;
    private static String name;
    private static Connection connection;
    private static String tableName;
}
