package hn.uth.ejercicioprimefaces.database;

import hn.uth.ejercicioprimefaces.data.Tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    private Connection conexion;


    public BaseDeDatos(){
        this.conexion = null;
    }

    private PreparedStatement conectar(String operacionSQL){
        PreparedStatement operacion = null;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            if(conexion != null){
                conexion.close();
            }
            conexion = DriverManager.getConnection("jdbc:ucanaccess://C:/projects/progweb2/ProgWeb2_2026_01/bd/bdTareas.accdb");
            operacion = conexion.prepareStatement(operacionSQL);
        }catch(Exception error){
            System.err.println("Error al conectarse a la base de datos");
            System.err.println(error.getMessage());
        }

        return operacion;
    }

    public List<Tarea> consultarTareas(){
        List<Tarea> tareas = new ArrayList<Tarea>();
        try{
            PreparedStatement operacion = conectar("SELECT * FROM tareas");
            ResultSet re = operacion.executeQuery();
            Tarea nueva;
            while(re.next()){
                nueva = new Tarea(
                        re.getString("nombre"),
                        re.getString("notas"),
                        re.getBoolean("completada")
                );
                nueva.setId(re.getInt("id"));
                tareas.add(nueva);
            }

        }catch (Exception error){
            System.err.println("Error al consultar tareas en la base de datos");
            System.err.println(error.getMessage());
        }
        return tareas;
    }

    public void crearTarea(Tarea nueva){
        try{
            PreparedStatement operacion = conectar("INSERT INTO tareas (nombre, notas, completada) VALUES (?,?,?)");
            operacion.setString(1, nueva.getNombre());
            operacion.setString(2, nueva.getNotas());
            operacion.setBoolean(3, nueva.isCompletada());
            //EJECUTA LOS CAMBIOS EN LA BASE DE DATOS
            operacion.executeUpdate();
            //GUARDE LOS CAMBIOS
            conexion.commit();
            //CIERRE LA BASE DE DATOS
            conexion.close();
        }catch(Exception error){
            System.err.println("Error al guardar una nueva tarea en la base de datos");
            System.err.println(error.getMessage());
        }
    }

    public void actualizarTarea(Tarea existente){
        try{
            PreparedStatement operacion = conectar("UPDATE tareas SET nombre = ?, notas = ?, completada = ? WHERE id = ?");
            operacion.setString(1, existente.getNombre());
            operacion.setString(2, existente.getNotas());
            operacion.setBoolean(3, existente.isCompletada());
            operacion.setInt(4, existente.getId());
            //EJECUTA LOS CAMBIOS EN LA BASE DE DATOS
            operacion.executeUpdate();
            //GUARDE LOS CAMBIOS
            conexion.commit();
            //CIERRE LA BASE DE DATOS
            conexion.close();
        }catch(Exception error){
            System.err.println("Error al guardar la tarea a modificar en la base de datos");
            System.err.println(error.getMessage());
        }
    }

    public void eliminarTarea(Tarea existente){
        try{
            PreparedStatement operacion = conectar("DELETE FROM tareas WHERE id = ?");
            operacion.setInt(1, existente.getId());
            //EJECUTA LOS CAMBIOS EN LA BASE DE DATOS
            operacion.executeUpdate();
            //GUARDE LOS CAMBIOS
            conexion.commit();
            //CIERRE LA BASE DE DATOS
            conexion.close();
        }catch(Exception error){
            System.err.println("Error al borrar la tarea en la base de datos");
            System.err.println(error.getMessage());
        }
    }
}

