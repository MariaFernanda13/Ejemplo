/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pacheco Angeles Maria Fernanda
 * TIC03SM-17
 * 3-JULIO-2018
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int cveCategoria;
    private int cantidad;
    private double precioC;
    private double precioV;
    private int cveProveedor;
    
    Conexion conn = new Conexion();
    
    public Producto(){
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String cod) {
        codigo = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desc) {
        descripcion = desc;
    }

    public int getCveCategoria() {
        return cveCategoria;
    }

    public void setCveCategoria(int cveCat) {
        cveCategoria = cveCat;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cant) {
        cantidad = cant;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double preC) {
       precioC = preC;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double preV) {
        precioV = preV;
    }

    public int getCveProveedor() {
        return cveProveedor;
    }

    public void setCveProveedor(int cvePro) {
        cveProveedor = cvePro;
    }
    
    
    public void buscarProducto(String cod){
        
        ResultSet rs;
        
        String consulta = "SELECT nombre, descripcion, cveCategoria, cantidad, precioCompra precioVenta, cveProveedor,  FROM" +
                          "producto WHERE codigo=" +
                          cod;
        
        rs = conn.busqueda(consulta);
        
        try{
        while(rs.next()){
            
            this.setNombre(rs.getString(1));
            this.setDescripcion(rs.getString(2));
            this.setCveCategoria(rs.getInt(3));
            this.setCantidad(rs.getInt(4));
            this.setPrecioC(rs.getDouble(5));
            this.setPrecioV(rs.getDouble(6));
            this.setCveProveedor(rs.getInt(7));
            
        }
        }
        catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
