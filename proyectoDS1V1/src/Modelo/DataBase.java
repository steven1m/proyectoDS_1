/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    
     private final String driver = "org.postgresql.Driver";
     private final String url = "jdbc:postgresql://localhost:5432/almacen";
     private final String user = "postgres";
     private final String password = "1234" ;    
     private  Connection con;

    public DataBase() {
        
          try {
              Class.forName(driver);
              con = DriverManager.getConnection(url,user,password);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException e){
             e.printStackTrace();
          }
    }
     
    
    public int Actualizar(String sql){
        try {
            
        Statement st = con.createStatement();
             return st.executeUpdate(sql);
             
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return 0;
    }
    
    public List read (String sql){
        List resultado = new ArrayList();
        ResultSet rs = null;
        Statement st;
         try {
             st = con.createStatement();
             rs = st.executeQuery(sql);
             resultado = Arreglo(rs);
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
        return resultado;
    }
    
    private List Arreglo (ResultSet rs){ 
       
        List areglo = new ArrayList();
        
         try {
              int columnas = rs.getMetaData().getColumnCount();
             while(rs.next()){
                 Map<String,Object>filas = new HashMap();
                 for(int i = 1; i < columnas; i ++){
                    String nombre = rs.getMetaData().getColumnName(i);
                    Object valor = rs.getObject(nombre);
                    filas.put(nombre, valor);   
                 }
                 areglo.add(filas);
             }} catch (SQLException ex) {
             ex.printStackTrace();
         }
        return areglo;
    
    }
    
    public boolean LS (String nombre){
       
        try{
           CallableStatement cs = con.prepareCall("{call "+ nombre + "}");
           return cs.execute();
        } catch(SQLException ex){
          ex.printStackTrace();
        }
    return false;
    }
     
    public void cerrar(){
      
         try {
             con.close();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    
    }
    
}
