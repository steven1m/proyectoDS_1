/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
public class DaoCliente {
    
    
    public Cliente insertar(String id, String nombre, String apellido, String direccion, String telefono, String correo, String razonSocial){
        String SQL = "INSERT INTO public.cliente VALUES('"+ id +"','"+ nombre +"','"+ apellido +"','"+ direccion +"','"+ telefono +"','"
                                                        + correo +"','"+ razonSocial +"')";
        
        if(new DataBase().Actualizar(SQL) > 0){
        Cliente c = new Cliente( id, nombre, apellido, direccion, telefono, correo, razonSocial);    
        return c;
        }
        return null;
    }
    
    public int actualizar(String id, String nombre, String apellido, String direccion, String telefono, String correo, String razonSocial){
        String SQL = "UPDATE public.cliente SET id='"
                                                        + id +"' , nombres='"
                                                        + nombre +"' ,apellido='"
                                                        + apellido +"' ,direccion='"
                                                        + direccion +"' ,telefono='"
                                                        + telefono +"' ,correo='"
                                                        + correo +"' ,razonsocial='"
                                                        + razonSocial +"'  WHERE id='"+ id +"'";
        return new DataBase().Actualizar(SQL);
    }
    
    public List listar(){
       
        String SQL = "SELECT id, nombres, apellido, direccion, telefono, correo, razonsocial FROM public.cliente ";
        
        List <Map>registros = new DataBase().read(SQL);
        List<Cliente>clientes = new ArrayList();
        
        for(Map registro: registros){
            Cliente cliente = new Cliente((String)registro.get("id"),(String)registro.get("nombres"),(String)registro.get("apellido"),(String)registro.get("direccion"),
                                          (String)registro.get("telefono"),(String)registro.get("correo"),(String)registro.get("razonsocial"));
            clientes.add(cliente);
        }
         return clientes;
    }
    public int borrar(String id){
    
        String SQL = "DELETE * FROM public.cliente WHERE id= '"+ id +"' ";
        
        return new DataBase().Actualizar(SQL);
    
    }
    
        
}
