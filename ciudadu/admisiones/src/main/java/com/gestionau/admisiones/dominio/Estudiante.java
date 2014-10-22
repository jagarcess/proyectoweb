package com.gestionau.admisiones.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@Table(name="estudiante") 
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="estudiante_idestudiante_seq")
   // @SequenceGenerator(name="estudiante_idestudiante_seq", sequenceName="estudiante_idestudiante_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idestudiante")
	private Long idestudiante;

	@Size(min = 5, max = 8)
	@Column(name="documento")
	private String documento;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;


	public Estudiante(String documento, String tipodoc) {
		super();
		this.documento = documento;
		this.tipodoc = tipodoc;
	}

	@Column(name="tipodoc")
	private String tipodoc;

	public Estudiante() {
	}

	public Long getIdestudiante() {
		return this.idestudiante;
	}

	public void setIdestudiante(Long idestudiante) {
		this.idestudiante = idestudiante;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Date getFecha() {
		return this.fecha;
	}
/*
	@Override
	public String toString() {
		return "Estudiante [idestudiante=" + idestudiante + ", documento="
				+ documento + ", fecha=" + fecha + ", tipodoc=" + tipodoc + "]";
	}
*/
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipodoc() {
		return this.tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

}