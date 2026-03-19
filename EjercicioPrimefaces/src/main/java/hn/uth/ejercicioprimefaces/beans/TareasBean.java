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
    private String saveActionText;

    public TareasBean() {
        this.taskList = new ListadoTareas();
        this.newTask = new Tarea();
        this.selectedTask = null;
        this.saveActionText="Crear";
    }

    public void guardar() {
        if(newTask.getNombre() == null|| newTask.getNombre().isEmpty() || newTask.getNombre().length() < 3) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al crear la tarea",
                            "Debes de ingresar un nombre valido"));
            return;
        }
        String mensajeExito = "El registro se ha creado exitosamente!";
        if(this.selectedTask == null){
            this.taskList.agregarTarea(newTask.copiar());
        }else{

            this.taskList.modificarTarea(newTask.copiar());
            mensajeExito="El registro se ha modificado exitosamente!";
        }

        this.newTask = new Tarea();

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Operación exitosa",
                        mensajeExito));
        this.saveActionText="Crear";
    }

    public void editTask(){
        if(selectedTask != null){
            this.newTask = selectedTask;
            this.saveActionText = "Modificar";
        }
    }

    public void cancelar(){
        this.newTask = new Tarea();
        this.selectedTask = null;
        this.saveActionText="Crear";
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

    public String getSaveActionText() {
        return saveActionText;
    }

    public void setSaveActionText(String saveActionText) {
        this.saveActionText = saveActionText;
    }
}
