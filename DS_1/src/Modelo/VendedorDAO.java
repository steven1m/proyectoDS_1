/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;

/**
 *
 * @author rzagza
 */
public class VendedorDAO implements CRUD{
    
    PreparedStatement ps;
    ResultSet rs;
    Vendedor vende = new Vendedor();

   Conexion con = new Conexion();
   Connection conn;
     
   public Vendedor Login(String cedula, String usuario){
       String sql = "select * from sistemaventas where cedula=?, usuario=? ";
       
       try{
          conn = con.conectar();
          ps = conn.prepareStatement(sql);
          ps.setString(7, cedula);
           ps.setString(5, usuario);
          rs = ps.executeQuery();
          while(rs.next()){
              vende.setId(rs.getInt(1));
              vende.setNombre(rs.getString(2));
              vende.setApellido(rs.getString(3));
              vende.setTelefono(rs.getString(4));
              vende.setUruario(rs.getString(5));
              vende.setEstado(rs.getString(6));
              vende.setCedula(rs.getString(7));
          }
          
       }
       catch(Exception e){
       }
       
      return vende; 
   }
   
    public Vendedor listarID(String cedula){
        Vendedor v = new Vendedor();
      String sql = "select * from cliente where cedula=?";
      
      try{
       conn = con.conectar();
       ps = conn.prepareStatement(sql);
       ps.setString(1,cedula);
       rs = ps.executeQuery();
       while(rs.next()){
          v.setId(rs.getInt(1));
          v.setNombre(rs.getString(2));
          v.setApellido(rs.getString(3));
          v.setTelefono(rs.getString(4));
          v.setUruario(rs.getString(5));
          v.setEstado(rs.getString(6));
          v.setCedula(rs.getString(7));
       }
      }
      catch(Exception e){}
      return v;
    }

    @Override
    public int agregar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
