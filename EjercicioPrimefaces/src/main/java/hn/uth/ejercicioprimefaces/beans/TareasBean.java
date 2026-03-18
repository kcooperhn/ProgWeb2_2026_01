package hn.uth.ejercicioprimefaces.beans;

import hn.uth.ejercicioprimefaces.data.ListadoTareas;
import hn.uth.ejercicioprimefaces.data.Tarea;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("TareasBean")
@ViewScoped
public class TareasBean implements Serializable {
    private ListadoTareas taskList;
    private Tarea newTask;
    private Tarea selectedTask;

    public TareasBean() {
        this.taskList = new ListadoTareas();
        this.newTask = new Tarea();

        this.selectedTask = null;
    }

    public void guardar() {
        if(newTask.getNombre() == null|| newTask.getNombre().isEmpty() || newTask.getNombre().length() < 3) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al crear la tarea",
                            "Debes de ingresar un nombre valido"));
            return;
        }
        this.taskList.agregarTarea(newTask.copiar());
        this.newTask = new Tarea();

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Operación exitosa",
                        "El registro se ha guardado exitosamente!"));
    }

    public void deleteTask(){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Operación pendiente",
                        "El registro se ha enviado a borrar"));
    }

    public ListadoTareas getTaskList() {
        return taskList;
    }

    public void setTaskList(ListadoTareas taskList) {
        this.taskList = taskList;
    }

    public Tarea getNewTask() {
        return newTask;
    }

    public void setNewTask(Tarea newTask) {
        this.newTask = newTask;
    }

    public Tarea getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Tarea selectedTask) {
        this.selectedTask = selectedTask;
    }
}
