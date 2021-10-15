/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class VentasDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    int resultado;
    
    public String idVentas(){
        String idV = "";
        String sql = " select max(idVentas) from factura";
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            //ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next())
            {
               idV=rs.getString(1);
            }
        }catch(Exception e){
        
        }
        return idV;
    }
    
    public int guardarVentas(Ventas v){
        Ventas ventas = new Ventas();
        String sql = "insert into factura(cliente_idcliente, vendedor_idvendedor, "
                + "numeroventa, fecha, valor, estado) values(?,?,?,?,?,?)";
        
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1,v.getIdCliente());
            ps.setInt(2,v.getIdVendedor());
            ps.setString(3,v.getSerie());
            ps.setString(4,v.getFecha());
            ps.setDouble(5,v.getMonto());
            ps.setString(6,v.getEstado());
            
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        
        return resultado;
    }
    
    public int guardarDetalleVenta(DetalleVentas dv){
        
        String sql = "insert into detalleventa(factura_idfactura, producto_idproducto, "
                + "cantidad, precio) values(?,?,?,?)";
        
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1,dv.getIdVentas());
            ps.setInt(2,dv.getIdProducto());
            ps.setInt(3,dv.getCantidad());
            ps.setDouble(4,dv.getPreVenta());
            
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        
        return resultado;
    }
}
