/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_bd.connectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class SingleConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/crud_bd";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private static Connection connection = null;

    static {
        conectar();
    }

    public static Connection getConnection() {
        return connection;
    }
    
    private static void conectar() {
        
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println("Erro forName");
        } catch (SQLException e2) {
            e2.printStackTrace();
            System.out.println("Erro sql");
        }
        
    }
}
