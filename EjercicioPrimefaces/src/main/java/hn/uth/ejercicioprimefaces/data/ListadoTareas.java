package hn.uth.ejercicioprimefaces.data;

import hn.uth.ejercicioprimefaces.database.BaseDeDatos;

import java.util.List;
import java.io.Serializable;

public class ListadoTareas implements Serializable {
    private List<Tarea> data;
    private BaseDeDatos bd;

    public ListadoTareas(){
        bd = new BaseDeDatos();
        data = bd.consultarTareas();
    }

    public List<Tarea> getData(){
        return data;
    }

    public void agregarTarea(Tarea tareaNueva){
        this.data.add(tareaNueva);
        //this.bd.agregarTarea(tareaNueva);
    }

    public void eliminarTarea(Tarea tareaEliminar){
        this.data.remove(tareaEliminar);
        //this.bd.eliminarTarea(tareaEliminar);
    }

    public void modificarTarea(Tarea tareaModificar){
        int posicion = 0;
        for (int i = 0; i < this.data.size(); i++){
            if(this.data.get(i).getId() == tareaModificar.getId()){
                posicion = i;
            }
        }
        this.data.remove(posicion);
        this.data.add(tareaModificar);
        this.bd.actualizarTarea(tareaModificar);
    }

}
