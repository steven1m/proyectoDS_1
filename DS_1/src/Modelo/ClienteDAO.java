/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rzagza
 */
public class ClienteDAO implements CRUD {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Cliente listarID(String cedula){
        Cliente c = new Cliente();
      String sql = "select * from cliente where cedula=?";
      
      try{
       con = cn.conectar();
       ps = con.prepareStatement(sql);
       ps.setString(1,cedula);
       rs = ps.executeQuery();
       while(rs.next()){
          c.setId(rs.getInt(1));
          c.setNombre(rs.getString(2));
          c.setApellido(rs.getString(3));
          c.setCedula(rs.getString(4));
          c.setTelefono(rs.getString(5));
          c.setDireccion(rs.getString(6));
          c.setEstado(rs.getString(7));
       }
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
      return c;
    }

    public List listar() {
        List<Cliente>lista = new ArrayList<>();
        String sql = "select * from cliente";
        
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
             Cliente c = new Cliente();
             c.setId(rs.getInt(1));
             c.setNombre(rs.getString(2));
             c.setApellido(rs.getString(3));
             c.setCedula(rs.getString(4));
             c.setTelefono(rs.getString(5));
             c.setDireccion(rs.getString(6));
             c.setEstado(rs.getString(7));
             
             lista.add(c);
            }
            
        }
        catch(Exception e){
        }
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
        String sql = "insert into cliente(id,nombre,apellido,cedula,telefono,direccion,estado) values(?,?,?,?,?,?,?) ";
        int respuesta = 0;
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
           
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            
            respuesta = ps.executeUpdate();
        }
        catch(Exception e){
        }
         
        return respuesta;
    }

    @Override
    public int actualizar(Object[] o) {
        String sql = "update cliente set id=?, nombre=?, apellido=?, cedula=?, telefono=?, direccion=?, estado=? where id=?";
        int res = 0;
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            
            res = ps.executeUpdate();
        }
        catch(Exception e){
        }
         
        return res;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from cliente where id=?";
       
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id );
            ps.executeUpdate();
        }
        catch(Exception e){
        }
    }
    }

    
    
    
    

