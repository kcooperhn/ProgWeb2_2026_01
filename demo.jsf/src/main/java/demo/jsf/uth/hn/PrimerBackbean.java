package demo.jsf.uth.hn;

import java.io.IOException;
import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("MiBean")
@RequestScoped	//->	Sirve para guardar los valores solo en esa petición. 
//@ViewScoped 		//->	Sirve para guardar los valores mientras esté en esa pantalla. 
//@SessionScoped 	//->	Sirve para guardar los valores mientras la sesión esté activa (Servidor encendido / Cache del navegador / invalidación de sesión) 
public class PrimerBackbean implements Serializable {

	private int numero1;
	private int numero2;
	private String nombre;
	private String apellido;
	private int resultado;
	private boolean calculoRealizado;
	private String operacion;
	
	public void calcular() {
		operacion = "Multiplicación";
		calculoRealizado = true;
		resultado = numero1*numero2;
	}
	
	public void ejecutarCalculo() {
		calculoRealizado = true;
		operacion = "Logaritmo";
		resultado = (int) (Math.log1p(numero1)+numero2);
	}
	
	public String navegarADashboard() {
		return "dashboard.xhtml";
	}
	
	public String navegarAMenu() {
		return "menu.xhtml";
	}
	
	public void navegarDeRegreso() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getNumero1() {
		return numero1;
	}
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public int getNumero2() {
		return numero2;
	}
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public boolean isCalculoRealizado() {
		return calculoRealizado;
	}
	public void setCalculoRealizado(boolean calculoRealizado) {
		this.calculoRealizado = calculoRealizado;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
