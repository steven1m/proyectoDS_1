/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rzagza
 */
public class Conexion {
    
    
     private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/proyectoDSI";
    private final String USER = "postgres";
    private final String PASSWORD = "steven52";
    private Connection con;

    public Connection conectar () {
        
        
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
              e.printStackTrace();
        }
        return con;
    }
    
}
