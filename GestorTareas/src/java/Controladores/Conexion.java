/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class Conexion {
    private Connection con = null;

 public Conexion() {
  try {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_de_tareas", "root","admin");
  } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 public Connection getConexion(){
  return con;
 }
 
 public void cerrarConexion(){
  try {
   con.close();
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }
    
}
