package demo.jsf.uth.hn;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("MiBean")
@RequestScoped
//@RequestScoped	->	Sirve para guardar los valores solo en esa petición. 
//@ViewScoped 		->	Sirve para guardar los valores mientras esté en esa pantalla. 
//@SessionScoped 	->	Sirve para guardar los valores mientras la sesión esté activa (Servidor encendido / Cache del navegador / invalidación de sesión) 
public class PrimerBackbean implements Serializable {

	private int numero1;
	private int numero2;
	private int resultado;
	
	public void calcular() {
		resultado = numero1*numero2;
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
	
}
