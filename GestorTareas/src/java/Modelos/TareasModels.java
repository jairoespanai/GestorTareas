/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.Conexion;
import Entidades.TareasEntities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class TareasModels {

    public boolean agregar(TareasEntities tarea) {

        try {
            Conexion c = new Conexion();
            Connection conexion = c.getConexion();
            if (conexion != null) {
                Statement st;
                st = conexion.createStatement();
                st.executeUpdate("INSERT INTO tareas (nombre, descripcion, estado, inicio, fin, responsable) VALUES ('" + tarea.getNombre() + "', '" + tarea.getDescripcion() + "', 1, " + tarea.getInicio() + ", " + tarea.getFin() + ", '" + tarea.getResponsable() + "')");
                st.close();
                //System.out.println("hola aqui 1");                  
                return true;
            }
            //System.out.println("hola aqui 2");
            return false;
        } catch (SQLException e) {
            //System.out.println("hola aqui 3");
            System.out.println("" + e.getMessage() + " -- " + e.getErrorCode());
            return false;

        }

    }

    public boolean aprocesar(TareasEntities tarea) {

        try {
            Conexion c = new Conexion();
            Connection conexion = c.getConexion();
            if (conexion != null) {
                Statement st;
                st = conexion.createStatement();
                st.executeUpdate("UPDATE tareas SET inicio = '"+tarea.getInicio()+"', estado = "+tarea.getEstado()+", responsable = '"+tarea.getResponsable()+"' WHERE id = "+tarea.getId()+" ");
                st.close();
                //System.out.println("hola aqui 1");                  
                return true;
            }
            //System.out.println("hola aqui 2");
            return false;
        } catch (SQLException e) {
            //System.out.println("hola aqui 3");
            System.out.println("" + e.getMessage() + " -- " + e.getErrorCode());
            return false;

        }

    }
    
    public boolean afinalizar(TareasEntities tarea) {

        try {
            Conexion c = new Conexion();
            Connection conexion = c.getConexion();
            if (conexion != null) {
                Statement st;
                st = conexion.createStatement();
                st.executeUpdate("UPDATE tareas SET fin = '"+tarea.getFin()+"', estado = "+tarea.getEstado()+" WHERE id = "+tarea.getId()+" ");
                st.close();
                //System.out.println("hola aqui 1");                  
                return true;
            }
            //System.out.println("hola aqui 2");
            return false;
        } catch (SQLException e) {
            //System.out.println("hola aqui 3");
            System.out.println("" + e.getMessage() + " -- " + e.getErrorCode());
            return false;

        }

    }

    public boolean aeliminar(TareasEntities tarea) {

        try {
            Conexion c = new Conexion();
            Connection conexion = c.getConexion();
            if (conexion != null) {
                Statement st;
                st = conexion.createStatement();
                st.executeUpdate("UPDATE tareas SET estado = "+tarea.getEstado()+" WHERE id = "+tarea.getId()+" ");
                st.close();
                //System.out.println("hola aqui 1");                  
                return true;
            }
            //System.out.println("hola aqui 2");
            return false;
        } catch (SQLException e) {
            //System.out.println("hola aqui 3");
            System.out.println("" + e.getMessage() + " -- " + e.getErrorCode());
            return false;

        }

    }

    public List<TareasEntities> listar(int estado) {
        List<TareasEntities> rows = new ArrayList<TareasEntities>();
        
        try {
            Conexion c = new Conexion();
            Connection conexion = c.getConexion();
            if (conexion != null) {
                Statement st;
                st = conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM tareas where estado = " + estado);
                while (rs.next()) {
                    TareasEntities row = new TareasEntities();
                    row.setId(Integer.parseInt(rs.getString("id")));
                    row.setDescripcion(rs.getString("nombre"));
                    row.setDescripcion(rs.getString("descripcion"));
                    row.setEstado(Integer.parseInt(rs.getString("estado")));
                    row.setInicio(rs.getString("inicio"));
                    row.setFin(rs.getString("fin"));
                    row.setResponsable(rs.getString("responsable"));
                    rows.add(row);
                }
                return rows;
          
            }
            return null;

        } catch (SQLException e) {
            System.out.println("" + e.getMessage() + " -- " + e.getErrorCode());
            return null;
        }

    }
}
