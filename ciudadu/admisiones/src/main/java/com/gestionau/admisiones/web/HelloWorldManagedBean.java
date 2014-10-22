package com.gestionau.admisiones.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gestionau.admisiones.dominio.Estudiante;

// Anotación para indicar que la clase es un componente de jsf,
// el valor de "bean" es como se va a llamar la clase en la página 
@ManagedBean(name="bean")
// Anotación que indica que el bean y sus valores van a vivir
// durante todo el ciclo de vida de la sesión
@SessionScoped
public class HelloWorldManagedBean {
	
	private Estudiante estudiante = new Estudiante();

	//Propiedad que se va a mostrar en la página
	private String saludo = "Hola Mundo";

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public String submit() {
		return "estudiante";
	}
}
