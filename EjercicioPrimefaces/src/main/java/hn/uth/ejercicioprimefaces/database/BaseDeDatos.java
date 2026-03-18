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
                tareas.add(nueva);
            }

        }catch (Exception error){
            System.err.println("Error al consultar tareas en la base de datos");
            System.err.println(error.getMessage());
        }
        return tareas;
    }


}

