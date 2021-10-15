/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rzagza
 */
public class ProductoDAO implements CRUD{
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listarID(int id){
        Producto p = new Producto();
      String sql = "select * from producto where id=?";
      
      try{
       con = cn.conectar();
       ps = con.prepareStatement(sql);
       ps.setInt(1,id);
       rs = ps.executeQuery();
       while(rs.next()){
          p.setId(rs.getInt(1));
          p.setNombre(rs.getString(2));
          p.setPrecio(rs.getDouble(3));
          p.setCantidad(rs.getInt(4));
          p.setEstado(rs.getString(5));
          
       }
      }
      catch(Exception e){}
      return p;
    }

    public List listar() {
        List<Producto>lista = new ArrayList<>();
        String sql = "select * from producto";
        
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
             Producto p = new Producto();
             p.setId(rs.getInt(1));
             p.setNombre(rs.getString(2));
             p.setPrecio(rs.getDouble(3));
             p.setCantidad(rs.getInt(4));
     
             
             lista.add(p);
            }
            
        }
        catch(Exception e){
        }
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
        String sql = "insert into producto(id,nombre,precio,cantidad,estado) values(?,?,?,?,?) ";
        int respuesta = 0;
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
           
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
             ps.setObject(5, o[4]);
            
            respuesta = ps.executeUpdate();
        }
        catch(Exception e){
        }
         
        return respuesta;
    }

    @Override
    public int actualizar(Object[] o) {
        String sql = "update producto set id=?, nombre=?, precio=?, cantidad=?, estado=? where id=?";
        int res = 0;
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            
            res = ps.executeUpdate();
        }
        catch(Exception e){
        }
         
        return res;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from producto where id=?";
       
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
