/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdk.nashorn.internal.ir.Statement; */
import java.sql.*;

/**
 *
 * @author Pacheco AngelesMaria Fernanda
 * TIC03SM-17
 * 3-JULIO-2018
 */
public class Conexion {
    Connection con;
    Statement smt;
    ResultSet rs;
    
    public Connection ConectarBD(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tic03", "root", "root");
        }
        catch(ClassNotFoundException error){
            System.out.println("Error en la Conexión ->" + error.getMessage());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
      public void Conectar(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tic03", "root", "root");
        }
        catch(ClassNotFoundException error){
            System.out.println("Error en la Conexión ->" + error.getMessage());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
     public void Desconectar(){
         try{
             con.close();
         }
         catch(SQLException error){
             System.out.println("Error al desconectar la Base de Datos" + error.getMessage());
         }
     }
     
     
     public ResultSet busqueda(String consulta){
         Conectar();
         
         try{
             smt = con.createStatement();
             rs = smt.executeQuery(consulta);
         }
         catch(SQLException e){
             System.out.println("Error en la consulta" + e.getMessage());
         }
         return rs;
     }
     
     public int Insertar(String consulta){
         int resultado = 0;
         
         try{
             smt = con.createStatement();
             resultado = smt.executeUpdate(consulta);
         }
         catch(SQLException e){
             System.out.println("Error en la consulta " + e.getMessage());
         }
         Desconectar();
         return resultado;
     }
}
